package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoType;
import cn.stylefeng.guns.modular.miao.model.params.MiaoTypeParam;
import cn.stylefeng.guns.modular.miao.service.MiaoTypeService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 宠物品种控制器
 *
 * @author percylu
 * @Date 2020-08-20 17:07:53
 */
@Controller
@RequestMapping("/miaoType")
public class MiaoTypeController extends BaseController {

    private String PREFIX = "/miaoType";

    @Autowired
    private MiaoTypeService miaoTypeService;

    /**
     * 跳转到主页面
     *
     * @author percylu
     * @Date 2020-08-20
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoType.html";
    }

    /**
     * 新增页面
     *
     * @author percylu
     * @Date 2020-08-20
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoType_add.html";
    }

    /**
     * 编辑页面
     *
     * @author percylu
     * @Date 2020-08-20
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoType_edit.html";
    }

    /**
     * 新增接口
     *
     * @author percylu
     * @Date 2020-08-20
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoTypeParam miaoTypeParam) {
        this.miaoTypeService.add(miaoTypeParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author percylu
     * @Date 2020-08-20
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MiaoTypeParam miaoTypeParam) {
        this.miaoTypeService.update(miaoTypeParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author percylu
     * @Date 2020-08-20
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MiaoTypeParam miaoTypeParam) {
        this.miaoTypeService.delete(miaoTypeParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author percylu
     * @Date 2020-08-20
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MiaoTypeParam miaoTypeParam) {
        MiaoType detail = this.miaoTypeService.getById(miaoTypeParam.getTypeId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-20
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoTypeParam miaoTypeParam) {
        return this.miaoTypeService.findPageBySpec(miaoTypeParam);
    }

}


