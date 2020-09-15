package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.ThirdParam;
import cn.stylefeng.guns.modular.rest.model.result.ThirdResult;
import cn.stylefeng.guns.modular.rest.service.ThirdService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 第三方ID控制器
 *
 * @author percylu
 * @Date 2020-08-30 21:39:05
 */
@RestController
@RequestMapping("/third")
public class ThirdController {


    @Autowired
    private ThirdService thirdService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-30
     */
    @RequestMapping(value="/checkJpush",method = RequestMethod.POST)
    @ApiOperation("新增")
    public ResponseData checkJpush(@RequestBody ThirdParam param) {
        ThirdResult result=thirdService.findBySpec(param);
        if(result instanceof ThirdResult){
            param.setThirdId(result.getThirdId());
            thirdService.update(param);
        }else{
            thirdService.add(param);
        }
        return ResponseData.success();
    }

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-30
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ApiOperation("新增")
    public ResponseData add(@RequestBody ThirdParam param) {
        thirdService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-30
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation("修改")
    public ResponseData update(@RequestBody ThirdParam param) {
        thirdService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-30
     */
    @RequestMapping(value="/delete")
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody ThirdParam param) {
        thirdService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-30
     */
    @RequestMapping(value="/queryDetail",method = RequestMethod.POST)
    @ApiOperation(value = "查询详情", response = ThirdResult.class)
    public ResponseData queryDetail(@RequestBody ThirdParam param) {
        ThirdResult result = thirdService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-30
     */
    @ApiOperation(value = "查询列表", response = ThirdResult.class)
    @RequestMapping(value="/queryList",method = RequestMethod.POST)
    public ResponseData queryList(@RequestBody ThirdParam param) {
        List<ThirdResult> listBySpec = thirdService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-30
     */
    @RequestMapping(value="/queryListPage",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询列表", response = ThirdResult.class)
    public ResponseData queryListPage(@RequestBody ThirdParam param) {
        PageResult<ThirdResult> pageBySpec = thirdService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
