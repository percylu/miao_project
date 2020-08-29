package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoArticle;
import cn.stylefeng.guns.modular.miao.model.params.MiaoArticleParam;
import cn.stylefeng.guns.modular.miao.service.MiaoArticleService;
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
 * 喵小小文章控制器
 *
 * @author  percylu
 * @Date 2020-08-14 09:29:43
 */
@Controller
@RequestMapping("/miaoArticle")
public class MiaoArticleController extends BaseController {

    private String PREFIX = "/miaoArticle";

    @Autowired
    private MiaoArticleService miaoArticleService;

    /**
     * 跳转到主页面
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoArticle.html";
    }

    /**
     * 新增页面
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoArticle_add.html";
    }

    /**
     * 编辑页面
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoArticle_edit.html";
    }

    /**
     * 新增接口
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoArticleParam miaoArticleParam) {
        this.miaoArticleService.add(miaoArticleParam);
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
    public ResponseData editItem(MiaoArticleParam miaoArticleParam) {
        this.miaoArticleService.update(miaoArticleParam);
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
    public ResponseData delete(MiaoArticleParam miaoArticleParam) {
        this.miaoArticleService.delete(miaoArticleParam);
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
    public ResponseData detail(MiaoArticleParam miaoArticleParam) {
        MiaoArticle detail = this.miaoArticleService.getById(miaoArticleParam.getArticleId());
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
    public LayuiPageInfo list(MiaoArticleParam miaoArticleParam) {
        return this.miaoArticleService.findPageBySpec(miaoArticleParam);
    }

    @RequestMapping("/updatePic")
    @ResponseBody
    public ResponseData updatePic(@RequestParam("fileId") String fileId){
        if (ToolUtil.isEmpty(fileId)){
            throw new RequestEmptyException("请求图片为空");
        }
        String filePath=miaoArticleService.updatePic(fileId);
        Map<String,String> map=new HashMap<>();
        map.put("filePath",filePath);
        return ResponseData.success(0, "上传成功", map);
    }
}


