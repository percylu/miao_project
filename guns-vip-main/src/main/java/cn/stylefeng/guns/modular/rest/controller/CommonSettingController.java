package cn.stylefeng.guns.modular.rest.controller;

import cn.stylefeng.guns.modular.rest.entity.CommonSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.CommonSettingParam;
import cn.stylefeng.guns.modular.rest.model.result.CommonSettingResult;
import cn.stylefeng.guns.modular.rest.service.CommonSettingService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * App通用设置控制器
 *
 * @author percylu
 * @Date 2020-08-14 11:57:53
 */
@RestController
@RequestMapping("/commonSetting")
public class CommonSettingController {


    @Autowired
    private CommonSettingService commonSettingService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ApiOperation("新增")
    public ResponseData add(@RequestBody CommonSettingParam param) {
        commonSettingService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation("修改")
    public ResponseData update(@RequestBody CommonSettingParam param) {
        commonSettingService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody CommonSettingParam param) {
        commonSettingService.delete(param);
        return ResponseData.success();
    }

    public CommonSettingController() {
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @RequestMapping(value="/queryDetail",method = RequestMethod.POST)
    @ApiOperation(value = "查询详情", response = CommonSettingResult.class)
    public ResponseData queryDetail(@RequestBody CommonSettingParam param) {
        CommonSetting result = commonSettingService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @ApiOperation(value = "查询列表", response = CommonSettingResult.class)
    @RequestMapping(value="/queryList",method = RequestMethod.POST)
    public ResponseData queryList(@RequestBody CommonSettingParam param) {
        List<CommonSettingResult> listBySpec = commonSettingService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @RequestMapping(value="/queryListPage",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询列表", response = CommonSettingResult.class)
    public ResponseData queryListPage(@RequestBody CommonSettingParam param) {
        PageResult<CommonSettingResult> pageBySpec = commonSettingService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
