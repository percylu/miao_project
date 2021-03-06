package cn.stylefeng.guns.modular.rest.controller;

import cn.stylefeng.guns.modular.rest.entity.Device;
import cn.stylefeng.guns.modular.rest.entity.DeviceType;
import cn.stylefeng.guns.modular.rest.service.DeviceTypeService;
import cn.stylefeng.guns.sys.modular.rest.entity.RestDictType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.DeviceParam;
import cn.stylefeng.guns.modular.rest.model.result.DeviceResult;
import cn.stylefeng.guns.modular.rest.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * 设备管理控制器
 *
 * @author percylu
 * @Date 2020-08-03 14:25:08
 */
@RestController
@RequestMapping("/device")
public class DeviceController {


    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DeviceTypeService deviceTypeService;
    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ApiOperation("新增")
    public ResponseData add(@RequestBody DeviceParam param) {
        List<Device> device=deviceService.findbyDeviceSn(param.getDeviceSn());
        if(device.size()==0){
            List<DeviceType> deviceType=deviceTypeService.list();
            if(deviceType.size()>0){
                param.setDeviceType(deviceType.get(0).getTypeId());
            }
            param.setStatus("ENABLE");
            deviceService.add(param);
        }
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
    public ResponseData update(@RequestBody DeviceParam param) {
        deviceService.update(param);
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
    public ResponseData delete(@RequestBody DeviceParam param) {
        deviceService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = DeviceResult.class)
    public ResponseData queryDetail(@RequestBody DeviceParam param) {
        DeviceResult result = deviceService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @ApiOperation(value = "查询列表", response = DeviceResult.class)
    @RequestMapping(value="/queryList",method = RequestMethod.POST)
    public ResponseData queryList(@RequestBody DeviceParam param) {
        List<Map<String,Object>> listBySpec = deviceService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = DeviceResult.class)
    public ResponseData queryListPage(@RequestBody DeviceParam param) {
        PageResult<DeviceResult> pageBySpec = deviceService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
