package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoCommonSetting;
import cn.stylefeng.guns.modular.miao.model.params.MiaoCommonSettingParam;
import cn.stylefeng.guns.modular.miao.service.MiaoCommonSettingService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * App通用设置控制器
 *
 * @author  percylu
 * @Date 2020-08-14 09:29:43
 */
@Controller
@RequestMapping("/miaoCommonSetting")
public class MiaoCommonSettingController extends BaseController {

    private String PREFIX = "/miaoCommonSetting";

    @Autowired
    private MiaoCommonSettingService miaoCommonSettingService;

    /**
     * 跳转到主页面
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoCommonSetting.html";
    }

    /**
     * 新增页面
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoCommonSetting_add.html";
    }

    /**
     * 编辑页面
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoCommonSetting_edit.html";
    }

    /**
     * 新增接口
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoCommonSettingParam miaoCommonSettingParam) {
        this.miaoCommonSettingService.add(miaoCommonSettingParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MiaoCommonSettingParam miaoCommonSettingParam) {
        this.miaoCommonSettingService.update(miaoCommonSettingParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MiaoCommonSettingParam miaoCommonSettingParam) {
        this.miaoCommonSettingService.delete(miaoCommonSettingParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MiaoCommonSettingParam miaoCommonSettingParam) {
        MiaoCommonSetting detail = this.miaoCommonSettingService.getById(miaoCommonSettingParam.getSettingId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoCommonSettingParam miaoCommonSettingParam) {
        return this.miaoCommonSettingService.findPageBySpec(miaoCommonSettingParam);
    }

}


