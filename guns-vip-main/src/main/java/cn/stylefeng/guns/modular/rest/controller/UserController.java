package cn.stylefeng.guns.modular.rest.controller;

import cn.javaer.aliyun.sms.SmsClient;
import cn.javaer.aliyun.sms.SmsTemplate;
import cn.stylefeng.guns.core.auth.service.MiaoAuthService;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoUser;
import cn.stylefeng.guns.modular.rest.factory.MiaoUserFactory;
import cn.stylefeng.guns.modular.rest.mapper.PetMapper;
import cn.stylefeng.guns.modular.rest.mapper.RestMiaoUserMapper;
import cn.stylefeng.guns.sys.core.auth.util.StaticUtil;
import cn.stylefeng.guns.sys.core.exception.enums.BizExceptionEnum;
import cn.stylefeng.guns.sys.core.util.SaltUtil;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import cn.stylefeng.roses.kernel.model.response.ErrorResponseData;
import cn.stylefeng.roses.kernel.model.response.SuccessResponseData;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.UserParam;
import cn.stylefeng.guns.modular.rest.model.result.UserResult;
import cn.stylefeng.guns.modular.rest.service.UserService;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * App用户管理控制器
 *
 * @author percylu
 * @Date 2020-08-03 14:25:08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private MiaoAuthService authService;

    @Autowired
    private UserService userService;

    @Autowired(required = false)
    private RestMiaoUserMapper userMapper;


    @Autowired
    private SmsClient smsClient;

    @Autowired
    private RedisTemplate<String,Object> template;
    /**
     * 点击登录执行的动作
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:42 PM
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("登录接口")
    public ResponseData restLogin(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {

        if (ToolUtil.isOneEmpty(username, password)) {
            throw new RequestEmptyException("账号或密码为空！");
        }

        //登录并创建token
        String token = authService.login(username, password);
        RestMiaoUser user=userMapper.getByAccount(username);

        Map<String,Object> result=new HashMap<>();
        result.put("token",token);
        result.put("user", MiaoUserFactory.getMiaoUser(user));
        return new SuccessResponseData(201,"",result);
    }
    /**
     * 第三方登陆账号验证
     *
     * @author percylu
     * @Date 2020/11/21 10:36 PM
     */
    @RequestMapping(value = "/thirdauth", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("第三方登陆")
    public ResponseData thirdAuth(@RequestParam("authuser") String authuser,
                                  @RequestParam("platform") String platform) {

        RestMiaoUser user=null;
        switch (platform){
            case "qq":
                user=userMapper.getByQq(authuser);
                break;
            case "weibo":
                user=userMapper.getByWeibo(authuser);
                break;
            case "weixin":
                user=userMapper.getByWeixin(authuser);
                break;
            case "apple":
                user=userMapper.getByApple(authuser);
                break;
        }
        if(user instanceof RestMiaoUser) {

            //登录并创建token
            String token = authService.login(user.getAccount());

            Map<String, Object> result = new HashMap<>();
            result.put("token", token);
            result.put("user", MiaoUserFactory.getMiaoUser(user));
            return new SuccessResponseData(201, "", result);
        }
        //还没有绑定用户
        return new SuccessResponseData(202,"","");
    }

    /**
     * 点击登录执行的动作
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:42 PM
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("登出接口")
    public ResponseData logout() {
        authService.logout();
        return new SuccessResponseData();
    }
    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ApiOperation("新增")
    public ResponseData add(@RequestBody UserParam param) {
        // 完善账号信息
        String _password= param.getPassword();

        RestMiaoUser user=userMapper.getByAccount(param.getAccount());
        if(user !=null){
            throw new ServiceException(BizExceptionEnum.USER_ALREADY_REG);
        }

        String salt = SaltUtil.getRandomSalt();
        String password = SaltUtil.md5Encrypt(param.getPassword(), salt);
        param.setSalt(salt);
        param.setPassword(password);
        userService.add(param);
        RestMiaoUser miaoUser = userMapper.getByAccount(param.getAccount());
        String token = authService.login(param.getAccount(), _password);
        Map<String,Object> result=new HashMap<>();
        result.put("token",token);
        result.put("user", MiaoUserFactory.getMiaoUser(miaoUser));
        return new SuccessResponseData(201,"",result);
    }
    /**
     * 点击获取验证码
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:42 PM
     */
    @RequestMapping(value = "/verifyCode", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("注册验证码")
    public ResponseData verifyCode(@RequestParam("username") String username,HttpSession httpSession) {
        String verifyCode = String
                .valueOf(new Random().nextInt(899999) + 100000);//生成短信验证码
        RestMiaoUser user=userMapper.getByAccount(username);
        if(user !=null){
            throw new ServiceException(BizExceptionEnum.USER_ALREADY_REG);
        }
        template.boundValueOps("Register"+username).set(verifyCode);
        List<String> phones= new ArrayList();
        phones.add(username);
        SmsTemplate smsTemplate = SmsTemplate.builder()
                .templateCode(StaticUtil.registerTemplates)
                .addTemplateParam("code", verifyCode)
                .signName("喵小小科技")
                .phoneNumbers(phones)
                .build();
        smsClient.send(smsTemplate);
        return new SuccessResponseData();
    }
    /**
     * 点击获取验证码
     *
     * @author percylu
     * @Date 2020/11/22 5:42 PM
     */
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("第三方注册验证码")
    public ResponseData getAuthCode(@RequestParam("username") String username,HttpSession httpSession) {
        String verifyCode = String
                .valueOf(new Random().nextInt(899999) + 100000);//生成短信验证码
//        RestMiaoUser user=userMapper.getByAccount(username);
//        if(user !=null){
//            //如果账号已经存在，直接登陆
//            //登录并创建token
//            String token = authService.login(user.getAccount());
//
//            Map<String, Object> result = new HashMap<>();
//            result.put("token", token);
//            result.put("user", MiaoUserFactory.getMiaoUser(user));
//            return new SuccessResponseData(201, "", result);
//        }
        template.boundValueOps("Register"+username).set(verifyCode);
        List<String> phones= new ArrayList();
        phones.add(username);
        SmsTemplate smsTemplate = SmsTemplate.builder()
                .templateCode(StaticUtil.registerTemplates)
                .addTemplateParam("code", verifyCode)
                .signName("喵小小科技")
                .phoneNumbers(phones)
                .build();
        smsClient.send(smsTemplate);
        return new SuccessResponseData();
    }

    /**
     * 点击登录执行的动作
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:42 PM
     */
    @RequestMapping(value = "/codeAuthVerify", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("第三方注册验证注册验证码")
    public ResponseData codeAuthVerify(@RequestParam("username") String username,@RequestParam("code") String code,@RequestParam("type") String type,@RequestParam("authuser") String authuser,HttpSession httpSession) {
        RestMiaoUser user=userMapper.getByAccount(username);

        String jcode = (String) template.boundValueOps("Register"+username).get();
        if(jcode==null){
            return ResponseData.error("手机号码错误！");
        }
        if(!jcode.contentEquals(code)){
            return ResponseData.error("验证码错误，请重试！");
        }
        if(user !=null){
            //如果账号已经存在，直接登陆
            //登录并创建token
            String token = authService.login(user.getAccount());
            UserParam param=new UserParam();
            param.setUserId(user.getUserId());
            switch (type){
                case "qq":
                    param.setQq(authuser);
                    param.setWeibo(user.getWeibo());
                    param.setWeixin(user.getWeixin());
                    param.setApple(user.getApple());
                    break;
                case "weibo":
                    param.setWeibo(authuser);
                    param.setQq(user.getQq());
                    param.setWeixin(user.getWeixin());
                    param.setApple(user.getApple());
                    break;
                case "weixin":
                    param.setWeixin(authuser);
                    param.setWeibo(user.getWeibo());
                    param.setQq(user.getQq());
                    param.setApple(user.getApple());
                    break;
                case "apple":
                    param.setApple(authuser);
                    param.setWeibo(user.getWeibo());
                    param.setQq(user.getQq());
                    param.setWeixin(user.getWeixin());
                    break;
            }
            userMapper.updateSns(param);
            Map<String, Object> result = new HashMap<>();
            result.put("token", token);
            result.put("user", MiaoUserFactory.getMiaoUser(user));
            return new SuccessResponseData(201, "", result);
        }
        return new SuccessResponseData();
    }
    /**
     *   重置密码
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:42 PM
     */
    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("验证码")
    public ResponseData getVerifyCode(@RequestParam("username") String username,HttpSession httpSession) {
        String verifyCode = String
                .valueOf(new Random().nextInt(899999) + 100000);//生成短信验证码
        RestMiaoUser user=userMapper.getByAccount(username);
        if(user ==null){
            return ResponseData.error("账号不存在！");
        }
        template.boundValueOps("Reset"+username).set(verifyCode);
        List<String> phones= new ArrayList();
        phones.add(username);
        SmsTemplate smsTemplate = SmsTemplate.builder()
                .templateCode(StaticUtil.registerTemplates)
                .addTemplateParam("code", verifyCode)
                .signName("喵小小科技")
                .phoneNumbers(phones)
                .build();
        try{
            smsClient.send(smsTemplate);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ErrorResponseData("获取验证码太频繁，请稍后再试");
        }
        return new SuccessResponseData();
    }

    /**
     * 修改密码
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:42 PM
     */
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("重置密码")
    public ResponseData resetPassword(@RequestParam("username") String username,@RequestParam("code") String code,
                                      @RequestParam("password") String password,HttpSession httpSession) {
        RestMiaoUser user=userMapper.getByAccount(username);
        if(user ==null){
            return ResponseData.error("账号不存在！");
        }
        String jcode = (String) template.boundValueOps("Reset"+username).get();
        if(jcode==null){
            return ResponseData.error("手机号码错误！");
        }
        if(!jcode.contentEquals(code)){
            return ResponseData.error("验证码错误，请重试！");
        }
        String salt = SaltUtil.getRandomSalt();
        String pwd = SaltUtil.md5Encrypt(password, salt);
        UserParam userParam=new UserParam();
        userParam.setAccount(username);
        userParam.setPassword(pwd);
        userParam.setSalt(salt);
        userService.updateByAccount(userParam);
        return new SuccessResponseData();
    }

    /**
     * 修改密码
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:42 PM
     */
    @RequestMapping(value = "/changeAccount", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("修改手机号")
    public ResponseData changeAccount(@RequestParam("userId") String userId,
                                      @RequestParam("username") String username,
                                      @RequestParam("code") String code,
                                      HttpSession httpSession) {
        RestMiaoUser user=userMapper.getByAccount(username);
        if(user !=null){
            return ResponseData.error("手机号已经被注册！");
        }
        String jcode = (String) template.boundValueOps("Register"+username).get();
        if(jcode==null){
            return ResponseData.error("手机号码错误！");
        }
        if(!jcode.contentEquals(code)){
            return ResponseData.error("验证码错误，请重试！");
        }
        UserParam param = new UserParam();
        param.setUserId(Long.parseLong((userId)));
        param.setAccount(username);
        userService.updateAccount(param);
        return new SuccessResponseData();
    }
    /**
     * 点击登录执行的动作
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:42 PM
     */
    @RequestMapping(value = "/codeVerify", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("注册验验证")
    public ResponseData verifyCode(@RequestParam("username") String username,@RequestParam("code") String code,HttpSession httpSession) {
        RestMiaoUser user=userMapper.getByAccount(username);
//        if(user !=null){
//            throw new ServiceException(BizExceptionEnum.USER_ALREADY_REG);
//        }
        String jcode = (String) template.boundValueOps("Register"+username).get();
        if(jcode==null){
            return ResponseData.error("手机号码错误！");
        }
        if(!jcode.contentEquals(code)){
            return ResponseData.error("验证码错误，请重试！");
        }
        return new SuccessResponseData();
    }
    /**
     * 点击登录执行的动作
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:42 PM
     */
    @RequestMapping(value = "/codeVerifyChange", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("注册验验证")
    public ResponseData codeVerifyChange(@RequestParam("username") String username,@RequestParam("code") String code,HttpSession httpSession) {
        RestMiaoUser user=userMapper.getByAccount(username);
//        if(user !=null){
//            throw new ServiceException(BizExceptionEnum.USER_ALREADY_REG);
//        }
        String jcode = (String) template.boundValueOps("Reset"+username).get();
        if(jcode==null){
            return ResponseData.error("手机号码错误！");
        }
        if(!jcode.contentEquals(code)){
            return ResponseData.error("验证码错误，请重试！");
        }
        return new SuccessResponseData();
    }
    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation("修改")
    public ResponseData update(@RequestBody UserParam param) {
        userService.update(param);
        return ResponseData.success();
    }


    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/queryDetail",method = RequestMethod.POST)
    @ApiOperation(value = "查询详情", response = UserResult.class)
    public ResponseData queryDetail(@RequestBody RestMiaoUser param) {
        RestMiaoUser result = userMapper.getByAccount(param.getAccount());
        return ResponseData.success(result);
       // return new SuccessResponseData(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @ApiOperation(value = "查询列表", response = UserResult.class)
    @RequestMapping(value="/queryList",method = RequestMethod.POST)
    public ResponseData queryList(@RequestBody UserParam param) {
        List<UserResult> listBySpec = userService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/queryListPage",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询列表", response = UserResult.class)
    public ResponseData queryListPage(@RequestBody UserParam param) {
        PageResult<UserResult> pageBySpec = userService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
