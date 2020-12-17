package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.ShieldListParam;
import cn.stylefeng.guns.modular.rest.model.result.ShieldListResult;
import cn.stylefeng.guns.modular.rest.service.ShieldListService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 屏蔽列表控制器
 *
 * @author byteEngine
 * @Date 2020-12-15 14:00:07
 */
@RestController
@RequestMapping("/shieldList")
public class ShieldListController {


    @Autowired
    private ShieldListService shieldListService;

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody ShieldListParam param) {
        shieldListService.add(param);
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
    public ResponseData update(@RequestBody ShieldListParam param) {
        shieldListService.update(param);
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
    public ResponseData delete(@RequestBody ShieldListParam param) {
        shieldListService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = ShieldListResult.class)
    public ResponseData queryDetail(@RequestBody ShieldListParam param) {
        ShieldListResult result = shieldListService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @ApiOperation(value = "查询列表", response = ShieldListResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody ShieldListParam param) {
        List<ShieldListResult> listBySpec = shieldListService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = ShieldListResult.class)
    public ResponseData queryListPage(@RequestBody ShieldListParam param) {
        PageResult<ShieldListResult> pageBySpec = shieldListService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
