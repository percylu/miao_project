package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.PostParam;
import cn.stylefeng.guns.modular.rest.model.result.PostResult;
import cn.stylefeng.guns.modular.rest.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 个人动态控制器
 *
 * @author byteEngine
 * @Date 2020-12-15 14:00:07
 */
@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    private PostService postService;

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody PostParam param) {
        postService.add(param);
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
    public ResponseData update(@RequestBody PostParam param) {
        postService.update(param);
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
    public ResponseData delete(@RequestBody PostParam param) {
        postService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = PostResult.class)
    public ResponseData queryDetail(@RequestBody PostParam param) {
        PostResult result = postService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @ApiOperation(value = "查询列表", response = PostResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody PostParam param) {
        List<PostResult> listBySpec = postService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = PostResult.class)
    public ResponseData queryListPage(@RequestBody PostParam param) {
        PageResult<PostResult> pageBySpec = postService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
