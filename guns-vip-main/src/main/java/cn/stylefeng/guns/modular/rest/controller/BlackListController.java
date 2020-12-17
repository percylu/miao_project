package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.BlackListParam;
import cn.stylefeng.guns.modular.rest.model.result.BlackListResult;
import cn.stylefeng.guns.modular.rest.service.BlackListService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 黑名单列表控制器
 *
 * @author byteEngine
 * @Date 2020-12-15 14:00:07
 */
@RestController
@RequestMapping("/blackList")
public class BlackListController {


    @Autowired
    private BlackListService blackListService;

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody BlackListParam param) {
        blackListService.add(param);
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
    public ResponseData update(@RequestBody BlackListParam param) {
        blackListService.update(param);
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
    public ResponseData delete(@RequestBody BlackListParam param) {
        blackListService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = BlackListResult.class)
    public ResponseData queryDetail(@RequestBody BlackListParam param) {
        BlackListResult result = blackListService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @ApiOperation(value = "查询列表", response = BlackListResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody BlackListParam param) {
        List<BlackListResult> listBySpec = blackListService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = BlackListResult.class)
    public ResponseData queryListPage(@RequestBody BlackListParam param) {
        PageResult<BlackListResult> pageBySpec = blackListService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
