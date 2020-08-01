package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoUser;
import cn.stylefeng.guns.modular.miao.model.params.MiaoUserParam;
import cn.stylefeng.guns.modular.miao.service.MiaoUserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * App用户管理控制器
 *
 * @author 卢水柏
 * @Date 2020-07-31 10:28:30
 */
@Controller
@RequestMapping("/miaoUser")
public class MiaoUserController extends BaseController {

    private String PREFIX = "/miaoUser";

    @Autowired
    private MiaoUserService miaoUserService;

    /**
     * 跳转到主页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoUser.html";
    }

    /**
     * 新增页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoUser_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoUser_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoUserParam miaoUserParam) {
        this.miaoUserService.add(miaoUserParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MiaoUserParam miaoUserParam) {
        this.miaoUserService.update(miaoUserParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MiaoUserParam miaoUserParam) {
        this.miaoUserService.delete(miaoUserParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MiaoUserParam miaoUserParam) {
        MiaoUser detail = this.miaoUserService.getById(miaoUserParam.getUserId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoUserParam miaoUserParam) {
        return this.miaoUserService.findPageBySpec(miaoUserParam);
    }

}


