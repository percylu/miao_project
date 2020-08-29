package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.TypeParam;
import cn.stylefeng.guns.modular.rest.model.result.TypeResult;
import cn.stylefeng.guns.modular.rest.service.TypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 宠物品种控制器
 *
 * @author percylu
 * @Date 2020-08-23 19:06:01
 */
@RestController
@RequestMapping("/type")
public class TypeController {


    @Autowired
    private TypeService typeService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-23
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ApiOperation("新增")
    public ResponseData add(@RequestBody TypeParam param) {
        typeService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-23
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation("修改")
    public ResponseData update(@RequestBody TypeParam param) {
        typeService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-23
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody TypeParam param) {
        typeService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-23
     */
    @RequestMapping(value="/queryDetail",method = RequestMethod.POST)
    @ApiOperation(value = "查询详情", response = TypeResult.class)
    public ResponseData queryDetail(@RequestBody TypeParam param) {
        TypeResult result = typeService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-23
     */
    @ApiOperation(value = "查询列表", response = TypeResult.class)
    @RequestMapping(value="/queryList",method = RequestMethod.POST)
    public ResponseData queryList(@RequestBody TypeParam param) {
        List<TypeResult> listBySpec = typeService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-23
     */
    @RequestMapping(value="/queryListPage",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询列表", response = TypeResult.class)
    public ResponseData queryListPage(@RequestBody TypeParam param) {
        PageResult<TypeResult> pageBySpec = typeService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
