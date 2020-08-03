package cn.stylefeng.guns.modular.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.MiaoUserParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoUserResult;
import cn.stylefeng.guns.modular.rest.service.MiaoUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * App用户管理控制器
 *
 * @author percylu
 * @Date 2020-08-02 20:42:43
 */
@RestController
@Api(tags = "App用户管理")
public class MiaoUserController {


    @Autowired
    private MiaoUserService miaoUserService;

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "添加", path = "/add")
    @ApiOperation("新增")
    public ResponseData add(@RequestBody MiaoUserParam param) {
        miaoUserService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "修改", path = "/update")
    @ApiOperation("修改")
    public ResponseData update(@RequestBody MiaoUserParam param) {
        miaoUserService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "删除", path = "/delete")
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody MiaoUserParam param) {
        miaoUserService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "查询详情", path = "/queryDetail")
    @ApiOperation(value = "查询详情", response = MiaoUserResult.class)
    public ResponseData queryDetail(@RequestBody MiaoUserParam param) {
        MiaoUserResult result = miaoUserService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "查询列表", path = "/queryList")
    @ApiOperation(value = "查询列表", response = MiaoUserResult.class)
    public ResponseData queryList(@RequestBody MiaoUserParam param) {
        List<MiaoUserResult> listBySpec = miaoUserService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    @PostMapping(name = "分页查询列表", path = "/queryListPage")
    @ApiOperation(value = "分页查询列表", response = MiaoUserResult.class)
    public ResponseData queryListPage(@RequestBody MiaoUserParam param) {
        PageResult<MiaoUserResult> pageBySpec = miaoUserService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
