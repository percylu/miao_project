package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoPost;
import cn.stylefeng.guns.modular.miao.model.params.MiaoPostParam;
import cn.stylefeng.guns.modular.miao.service.MiaoPostService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 个人动态控制器
 *
 * @author byteEngine
 * @Date 2020-12-12 09:52:48
 */
@Controller
@RequestMapping("/miaoPost")
public class MiaoPostController extends BaseController {

    private String PREFIX = "/miaoPost";

    @Autowired
    private MiaoPostService miaoPostService;

    /**
     * 跳转到主页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoPost.html";
    }

    /**
     * 新增页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoPost_add.html";
    }

    /**
     * 编辑页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoPost_edit.html";
    }

    /**
     * 新增接口
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoPostParam miaoPostParam) {
        this.miaoPostService.add(miaoPostParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MiaoPostParam miaoPostParam) {
        this.miaoPostService.update(miaoPostParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MiaoPostParam miaoPostParam) {
        this.miaoPostService.delete(miaoPostParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MiaoPostParam miaoPostParam) {
        MiaoPost detail = this.miaoPostService.getById(miaoPostParam.getPostId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoPostParam miaoPostParam) {
        return this.miaoPostService.findPageBySpec(miaoPostParam);
    }

}


