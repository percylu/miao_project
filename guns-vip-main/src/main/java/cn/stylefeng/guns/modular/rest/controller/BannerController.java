package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.BannerParam;
import cn.stylefeng.guns.modular.rest.model.result.BannerResult;
import cn.stylefeng.guns.modular.rest.service.BannerService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 广告图管理控制器
 *
 * @author percylu
 * @Date 2020-08-08 11:14:05
 */
@RestController
@RequestMapping("/banner")
public class BannerController {


    @Autowired
    private BannerService bannerService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody BannerParam param) {
        bannerService.add(param);
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
    public ResponseData update(@RequestBody BannerParam param) {
        bannerService.update(param);
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
    public ResponseData delete(@RequestBody BannerParam param) {
        bannerService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = BannerResult.class)
    public ResponseData queryDetail(@RequestBody BannerParam param) {
        BannerResult result = bannerService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @ApiOperation(value = "查询列表", response = BannerResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody BannerParam param) {
        List<BannerResult> listBySpec = bannerService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = BannerResult.class)
    public ResponseData queryListPage(@RequestBody BannerParam param) {
        PageResult<BannerResult> pageBySpec = bannerService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
