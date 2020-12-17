package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.FollowListParam;
import cn.stylefeng.guns.modular.rest.model.result.FollowListResult;
import cn.stylefeng.guns.modular.rest.service.FollowListService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 关注列表控制器
 *
 * @author byteEngine
 * @Date 2020-12-15 14:00:07
 */
@RestController
@RequestMapping("/followList")
public class FollowListController {


    @Autowired
    private FollowListService followListService;

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody FollowListParam param) {
        followListService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/update")
    @ApiOperation("修改")
    public ResponseData update(@RequestBody FollowListParam param) {
        followListService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/delete")
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody FollowListParam param) {
        followListService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = FollowListResult.class)
    public ResponseData queryDetail(@RequestBody FollowListParam param) {
        FollowListResult result = followListService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @ApiOperation(value = "查询列表", response = FollowListResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody FollowListParam param) {
        List<FollowListResult> listBySpec = followListService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = FollowListResult.class)
    public ResponseData queryListPage(@RequestBody FollowListParam param) {
        PageResult<FollowListResult> pageBySpec = followListService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
