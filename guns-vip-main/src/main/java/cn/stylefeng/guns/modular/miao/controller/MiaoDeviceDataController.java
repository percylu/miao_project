package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoDeviceData;
import cn.stylefeng.guns.modular.miao.model.params.MiaoDeviceDataParam;
import cn.stylefeng.guns.modular.miao.service.MiaoDeviceDataService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 设备数据控制器
 *
 * @author 卢水柏
 * @Date 2020-07-31 10:28:30
 */
@Controller
@RequestMapping("/miaoDeviceData")
public class MiaoDeviceDataController extends BaseController {

    private String PREFIX = "/miaoDeviceData";

    @Autowired
    private MiaoDeviceDataService miaoDeviceDataService;

    /**
     * 跳转到主页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoDeviceData.html";
    }

    /**
     * 新增页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoDeviceData_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoDeviceData_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoDeviceDataParam miaoDeviceDataParam) {
        this.miaoDeviceDataService.add(miaoDeviceDataParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MiaoDeviceDataParam miaoDeviceDataParam) {
        this.miaoDeviceDataService.update(miaoDeviceDataParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MiaoDeviceDataParam miaoDeviceDataParam) {
        this.miaoDeviceDataService.delete(miaoDeviceDataParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MiaoDeviceDataParam miaoDeviceDataParam) {
        MiaoDeviceData detail = this.miaoDeviceDataService.getById(miaoDeviceDataParam.getDeviceDataId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoDeviceDataParam miaoDeviceDataParam) {
        return this.miaoDeviceDataService.findPageBySpec(miaoDeviceDataParam);
    }

}


