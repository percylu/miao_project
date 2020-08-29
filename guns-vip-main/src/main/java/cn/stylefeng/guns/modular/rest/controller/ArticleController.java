package cn.stylefeng.guns.modular.rest.controller;

import cn.stylefeng.guns.modular.rest.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.ArticleParam;
import cn.stylefeng.guns.modular.rest.model.result.ArticleResult;
import cn.stylefeng.guns.modular.rest.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 喵小小文章控制器
 *
 * @author percylu
 * @Date 2020-08-14 11:57:53
 */
@RestController
@RequestMapping("/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ApiOperation("新增")
    public ResponseData add(@RequestBody ArticleParam param) {
        articleService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation("修改")
    public ResponseData update(@RequestBody ArticleParam param) {
        articleService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody ArticleParam param) {
        articleService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @RequestMapping(value="/queryDetail",method = RequestMethod.POST)
    @ApiOperation(value = "查询详情", response = ArticleResult.class)
    public ResponseData queryDetail(@RequestBody ArticleParam param) {
        ArticleResult result = articleService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @ApiOperation(value = "查询列表", response = ArticleResult.class)
    @RequestMapping(value="/queryList",method = RequestMethod.POST)
    public ResponseData queryList(@RequestBody ArticleParam param) {
        List<ArticleResult> listBySpec = articleService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    @RequestMapping(value="/queryListPage",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询列表", response = ArticleResult.class)
    public ResponseData queryListPage(@RequestBody ArticleParam param) {
        PageResult<ArticleResult> pageBySpec = articleService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
