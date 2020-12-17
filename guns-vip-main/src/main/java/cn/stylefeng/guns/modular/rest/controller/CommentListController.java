package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.CommentListParam;
import cn.stylefeng.guns.modular.rest.model.result.CommentListResult;
import cn.stylefeng.guns.modular.rest.service.CommentListService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 评论列表控制器
 *
 * @author byteEngine
 * @Date 2020-12-15 14:00:07
 */
@RestController
@RequestMapping("/commentList")
public class CommentListController {


    @Autowired
    private CommentListService commentListService;

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody CommentListParam param) {
        commentListService.add(param);
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
    public ResponseData update(@RequestBody CommentListParam param) {
        commentListService.update(param);
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
    public ResponseData delete(@RequestBody CommentListParam param) {
        commentListService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = CommentListResult.class)
    public ResponseData queryDetail(@RequestBody CommentListParam param) {
        CommentListResult result = commentListService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @ApiOperation(value = "查询列表", response = CommentListResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody CommentListParam param) {
        List<CommentListResult> listBySpec = commentListService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = CommentListResult.class)
    public ResponseData queryListPage(@RequestBody CommentListParam param) {
        PageResult<CommentListResult> pageBySpec = commentListService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
