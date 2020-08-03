package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.MiaoPetDataParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoPetDataResult;
import cn.stylefeng.guns.modular.rest.service.MiaoPetDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 宠物数据控制器
 *
 * @author percylu
 * @Date 2020-08-02 20:42:43
 */
@RestController
@Api(tags = "宠物数据")
public class MiaoPetDataController {


    @Autowired
    private MiaoPetDataService miaoPetDataService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增")
    public ResponseData add(@RequestBody MiaoPetDataParam param) {
        miaoPetDataService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @RequestMapping(method=RequestMethod.POST, value = "/update")
    @ApiOperation("修改")
    public ResponseData update(@RequestBody MiaoPetDataParam param) {
        miaoPetDataService.update(param);
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
    public ResponseData delete(@RequestBody MiaoPetDataParam param) {
        miaoPetDataService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "查询详情", path = "/queryDetail")
    @ApiOperation(value = "查询详情", response = MiaoPetDataResult.class)
    public ResponseData queryDetail(@RequestBody MiaoPetDataParam param) {
        MiaoPetDataResult result = miaoPetDataService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "查询列表", path = "/queryList")
    @ApiOperation(value = "查询列表", response = MiaoPetDataResult.class)
    public ResponseData queryList(@RequestBody MiaoPetDataParam param) {
        List<MiaoPetDataResult> listBySpec = miaoPetDataService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "分页查询列表", path = "/queryListPage")
    @ApiOperation(value = "分页查询列表", response = MiaoPetDataResult.class)
    public ResponseData queryListPage(@RequestBody MiaoPetDataParam param) {
        PageResult<MiaoPetDataResult> pageBySpec = miaoPetDataService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
