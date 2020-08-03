package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.MiaoPetParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoPetResult;
import cn.stylefeng.guns.modular.rest.service.MiaoPetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 宠物管理控制器
 *
 * @author percylu
 * @Date 2020-08-02 20:42:43
 */
@RestController
@Api(tags = "宠物管理")
public class MiaoPetController {


    @Autowired
    private MiaoPetService miaoPetService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "添加", path = "/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody MiaoPetParam param) {
        miaoPetService.add(param);
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
    public ResponseData update(@RequestBody MiaoPetParam param) {
        miaoPetService.update(param);
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
    public ResponseData delete(@RequestBody MiaoPetParam param) {
        miaoPetService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "查询详情", path = "/queryDetail")
    @ApiOperation(value = "查询详情", response = MiaoPetResult.class)
    public ResponseData queryDetail(@RequestBody MiaoPetParam param) {
        MiaoPetResult result = miaoPetService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "查询列表", path = "/queryList")
    @ApiOperation(value = "查询列表", response = MiaoPetResult.class)
    public ResponseData queryList(@RequestBody MiaoPetParam param) {
        List<MiaoPetResult> listBySpec = miaoPetService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "分页查询列表", path = "/queryListPage")
    @ApiOperation(value = "分页查询列表", response = MiaoPetResult.class)
    public ResponseData queryListPage(@RequestBody MiaoPetParam param) {
        PageResult<MiaoPetResult> pageBySpec = miaoPetService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
