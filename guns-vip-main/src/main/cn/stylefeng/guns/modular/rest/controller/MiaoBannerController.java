package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.MiaoBannerParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoBannerResult;
import cn.stylefeng.guns.modular.rest.service.MiaoBannerService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 广告图管理控制器
 *
 * @author percylu
 * @Date 2020-08-08 11:00:03
 */
@RestController
@RequestMapping("/miaoBanner")
public class MiaoBannerController {


    @Autowired
    private MiaoBannerService miaoBannerService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody MiaoBannerParam param) {
        miaoBannerService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping(value="/update")
    @ApiOperation("修改")
    public ResponseData update(@RequestBody MiaoBannerParam param) {
        miaoBannerService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping(value="/delete")
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody MiaoBannerParam param) {
        miaoBannerService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = MiaoBannerResult.class)
    public ResponseData queryDetail(@RequestBody MiaoBannerParam param) {
        MiaoBannerResult result = miaoBannerService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @ApiOperation(value = "查询列表", response = MiaoBannerResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody MiaoBannerParam param) {
        List<MiaoBannerResult> listBySpec = miaoBannerService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = MiaoBannerResult.class)
    public ResponseData queryListPage(@RequestBody MiaoBannerParam param) {
        PageResult<MiaoBannerResult> pageBySpec = miaoBannerService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
