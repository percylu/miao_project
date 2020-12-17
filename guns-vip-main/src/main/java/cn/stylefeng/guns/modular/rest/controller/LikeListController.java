package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.LikeListParam;
import cn.stylefeng.guns.modular.rest.model.result.LikeListResult;
import cn.stylefeng.guns.modular.rest.service.LikeListService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 点赞列表控制器
 *
 * @author byteEngine
 * @Date 2020-12-15 14:00:07
 */
@RestController
@RequestMapping("/likeList")
public class LikeListController {


    @Autowired
    private LikeListService likeListService;

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody LikeListParam param) {
        likeListService.add(param);
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
    public ResponseData update(@RequestBody LikeListParam param) {
        likeListService.update(param);
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
    public ResponseData delete(@RequestBody LikeListParam param) {
        likeListService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = LikeListResult.class)
    public ResponseData queryDetail(@RequestBody LikeListParam param) {
        LikeListResult result = likeListService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @ApiOperation(value = "查询列表", response = LikeListResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody LikeListParam param) {
        List<LikeListResult> listBySpec = likeListService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = LikeListResult.class)
    public ResponseData queryListPage(@RequestBody LikeListParam param) {
        PageResult<LikeListResult> pageBySpec = likeListService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
