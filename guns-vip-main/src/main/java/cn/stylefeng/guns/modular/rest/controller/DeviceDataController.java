package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.DeviceDataParam;
import cn.stylefeng.guns.modular.rest.model.result.DeviceDataResult;
import cn.stylefeng.guns.modular.rest.service.DeviceDataService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 设备数据控制器
 *
 * @author percylu
 * @Date 2020-08-03 14:25:08
 */
@RestController
@RequestMapping("/deviceData")
public class DeviceDataController {


    @Autowired
    private DeviceDataService deviceDataService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody DeviceDataParam param) {
        deviceDataService.add(param);
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
    public ResponseData update(@RequestBody DeviceDataParam param) {
        deviceDataService.update(param);
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
    public ResponseData delete(@RequestBody DeviceDataParam param) {
        deviceDataService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = DeviceDataResult.class)
    public ResponseData queryDetail(@RequestBody DeviceDataParam param) {
        DeviceDataResult result = deviceDataService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @ApiOperation(value = "查询列表", response = DeviceDataResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody DeviceDataParam param) {
        List<DeviceDataResult> listBySpec = deviceDataService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = DeviceDataResult.class)
    public ResponseData queryListPage(@RequestBody DeviceDataParam param) {
        PageResult<DeviceDataResult> pageBySpec = deviceDataService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
