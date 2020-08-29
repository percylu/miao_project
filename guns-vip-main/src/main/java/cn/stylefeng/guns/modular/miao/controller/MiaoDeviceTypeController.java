package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoDeviceType;
import cn.stylefeng.guns.modular.miao.model.params.MiaoDeviceTypeParam;
import cn.stylefeng.guns.modular.miao.service.MiaoDeviceTypeService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * 设备类型控制器
 *
 * @author 卢水柏
 * @Date 2020-07-31 10:28:30
 */
@Controller
@RequestMapping("/miaoDeviceType")
public class MiaoDeviceTypeController extends BaseController {

    private String PREFIX = "/miaoDeviceType";

    @Autowired
    private MiaoDeviceTypeService miaoDeviceTypeService;

    /**
     * 跳转到主页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoDeviceType.html";
    }

    /**
     * 新增页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoDeviceType_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoDeviceType_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoDeviceTypeParam miaoDeviceTypeParam) {
        this.miaoDeviceTypeService.add(miaoDeviceTypeParam);
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
    public ResponseData editItem(MiaoDeviceTypeParam miaoDeviceTypeParam) {
        this.miaoDeviceTypeService.update(miaoDeviceTypeParam);
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
    public ResponseData delete(MiaoDeviceTypeParam miaoDeviceTypeParam) {
        this.miaoDeviceTypeService.delete(miaoDeviceTypeParam);
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
    public ResponseData detail(MiaoDeviceTypeParam miaoDeviceTypeParam) {
        MiaoDeviceType detail = this.miaoDeviceTypeService.getById(miaoDeviceTypeParam.getTypeId());
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
    public LayuiPageInfo list(MiaoDeviceTypeParam miaoDeviceTypeParam) {
        return this.miaoDeviceTypeService.findPageBySpec(miaoDeviceTypeParam);
    }

    @RequestMapping("/updatePic")
    @ResponseBody
    public ResponseData updatePic(@RequestParam("fileId") String fileId){
        if (ToolUtil.isEmpty(fileId)){
            throw new RequestEmptyException("请求图片为空");
        }
        String filePath=miaoDeviceTypeService.updatePic(fileId);
        Map<String,String> map=new HashMap<>();
        map.put("filePath",filePath);
        return ResponseData.success(0, "上传成功", map);
    }



}


