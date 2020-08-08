package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.PetDataParam;
import cn.stylefeng.guns.modular.rest.model.result.PetDataResult;
import cn.stylefeng.guns.modular.rest.service.PetDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * 宠物数据控制器
 *
 * @author percylu
 * @Date 2020-08-03 14:25:08
 */
@RestController
@RequestMapping("/petData")
public class PetDataController {


    @Autowired
    private PetDataService petDataService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody PetDataParam param) {
        petDataService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/update")
    @ApiOperation("修改")
    public ResponseData update(@RequestBody PetDataParam param) {
        petDataService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/delete")
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody PetDataParam param) {
        petDataService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/queryDetail")
    @ApiOperation(value = "查询详情", response = PetDataResult.class)
    public ResponseData queryDetail(@RequestBody PetDataParam param) {
        PetDataResult result = petDataService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @ApiOperation(value = "查询列表", response = PetDataResult.class)
    @RequestMapping(value="/queryList")
    public ResponseData queryList(@RequestBody PetDataParam param) {
        List<PetDataResult> listBySpec = petDataService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    @RequestMapping(value="/queryListPage")
    @ApiOperation(value = "分页查询列表", response = PetDataResult.class)
    public ResponseData queryListPage(@RequestBody PetDataParam param) {
        PageResult<PetDataResult> pageBySpec = petDataService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
