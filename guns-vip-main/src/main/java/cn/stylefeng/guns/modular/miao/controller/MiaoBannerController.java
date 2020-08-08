package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoBanner;
import cn.stylefeng.guns.modular.miao.model.params.MiaoBannerParam;
import cn.stylefeng.guns.modular.miao.service.MiaoBannerService;
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
 * 广告图管理控制器
 *
 * @author percylu
 * @Date 2020-08-08 08:12:57
 */
@Controller
@RequestMapping("/miaoBanner")
public class MiaoBannerController extends BaseController {

    private String PREFIX = "/miaoBanner";

    @Autowired
    private MiaoBannerService miaoBannerService;

    /**
     * 跳转到主页面
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoBanner.html";
    }

    /**
     * 新增页面
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoBanner_add.html";
    }

    /**
     * 编辑页面
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoBanner_edit.html";
    }

    /**
     * 新增接口
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoBannerParam miaoBannerParam) {
        this.miaoBannerService.add(miaoBannerParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MiaoBannerParam miaoBannerParam) {
        this.miaoBannerService.update(miaoBannerParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MiaoBannerParam miaoBannerParam) {
        this.miaoBannerService.delete(miaoBannerParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MiaoBannerParam miaoBannerParam) {
        MiaoBanner detail = this.miaoBannerService.getById(miaoBannerParam.getBannerId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoBannerParam miaoBannerParam) {
        return this.miaoBannerService.findPageBySpec(miaoBannerParam);
    }
    @RequestMapping("/updateImg")
    @ResponseBody
    public ResponseData updateImg(@RequestParam("fileId") String fileId){
        if (ToolUtil.isEmpty(fileId)){
            throw new RequestEmptyException("请求图片为空");
        }
        String filePath=miaoBannerService.updateImg(fileId);
        Map<String,String> map=new HashMap<>();
        map.put("filePath",filePath);
        return ResponseData.success(0, "上传成功", map);
    }
}


