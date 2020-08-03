package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.MiaoDeviceParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoDeviceResult;
import cn.stylefeng.guns.modular.rest.service.MiaoDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 设备管理控制器
 *
 * @author percylu
 * @Date 2020-08-02 20:42:43
 */
@RestController
@Api(tags = "设备管理")
public class MiaoDeviceController {


    @Autowired
    private MiaoDeviceService miaoDeviceService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "添加", path = "/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody MiaoDeviceParam param) {
        miaoDeviceService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "修改", path = "/update")
    @ApiOperation("修改")
    public ResponseData update(@RequestBody MiaoDeviceParam param) {
        miaoDeviceService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "删除", path = "/delete")
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody MiaoDeviceParam param) {
        miaoDeviceService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "查询详情", path = "/queryDetail")
    @ApiOperation(value = "查询详情", response = MiaoDeviceResult.class)
    public ResponseData queryDetail(@RequestBody MiaoDeviceParam param) {
        MiaoDeviceResult result = miaoDeviceService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "查询列表", path = "/queryList")
    @ApiOperation(value = "查询列表", response = MiaoDeviceResult.class)
    public ResponseData queryList(@RequestBody MiaoDeviceParam param) {
        List<MiaoDeviceResult> listBySpec = miaoDeviceService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "分页查询列表", path = "/queryListPage")
    @ApiOperation(value = "分页查询列表", response = MiaoDeviceResult.class)
    public ResponseData queryListPage(@RequestBody MiaoDeviceParam param) {
        PageResult<MiaoDeviceResult> pageBySpec = miaoDeviceService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
