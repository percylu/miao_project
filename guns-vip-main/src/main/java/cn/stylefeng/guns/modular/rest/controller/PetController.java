package cn.stylefeng.guns.modular.rest.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.rest.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.PetParam;
import cn.stylefeng.guns.modular.rest.model.result.PetResult;
import cn.stylefeng.guns.modular.rest.service.PetService;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 宠物管理控制器
 *
 * @author percylu
 * @Date 2020-08-21 01:09:12
 */
@RestController
@RequestMapping("/pet")
public class PetController {


    @Autowired
    private PetService petService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-21
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ApiOperation("新增")
    public ResponseData add(@RequestBody PetParam param) {
        petService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-21
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation("修改")
    public ResponseData update(@RequestBody PetParam param) {
        petService.update(param);
        return ResponseData.success();
    }
    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-21
     */
    @RequestMapping(value="/updateDate",method = RequestMethod.POST)
    @ApiOperation("修改时间改变排序")
    public ResponseData updateDate(@RequestBody PetParam param) {
        petService.updateDate(param);
        return ResponseData.success();
    }
    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-21
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody PetParam param) {
        petService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-21
     */
    @RequestMapping(value="/queryDetail",method = RequestMethod.POST)
    @ApiOperation(value = "查询详情", response = PetResult.class)
    public ResponseData queryDetail(@RequestBody PetParam param) {
        Pet result = petService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-21
     */
    @ApiOperation(value = "查询列表", response = PetResult.class)
    @RequestMapping(value="/queryList",method = RequestMethod.POST)
    public ResponseData queryList(@RequestBody PetParam param) {
        List<PetResult> listBySpec = petService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-21
     */
    @RequestMapping(value="/queryListPage",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询列表", response = PetResult.class)
    public ResponseData queryListPage(@RequestBody PetParam param) {
        LayuiPageInfo pageBySpec = petService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
