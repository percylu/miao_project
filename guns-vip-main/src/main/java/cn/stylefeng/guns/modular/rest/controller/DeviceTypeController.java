package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.DeviceTypeParam;
import cn.stylefeng.guns.modular.rest.model.result.DeviceTypeResult;
import cn.stylefeng.guns.modular.rest.service.DeviceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 设备类型控制器
 *
 * @author percylu
 * @Date 2020-08-03 14:25:08
 */
@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController {


    @Autowired
    private DeviceTypeService deviceTypeService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody DeviceTypeParam param) {
        deviceTypeService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/update")
    @ApiOperation("修改")
    public ResponseData update(@RequestBody DeviceTypeParam param) {
        deviceTypeService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/delete")
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody DeviceTypeParam param) {
        deviceTypeService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = DeviceTypeResult.class)
    public ResponseData queryDetail(@RequestBody DeviceTypeParam param) {
        DeviceTypeResult result = deviceTypeService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @ApiOperation(value = "查询列表", response = DeviceTypeResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody DeviceTypeParam param) {
        List<DeviceTypeResult> listBySpec = deviceTypeService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = DeviceTypeResult.class)
    public ResponseData queryListPage(@RequestBody DeviceTypeParam param) {
        PageResult<DeviceTypeResult> pageBySpec = deviceTypeService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
