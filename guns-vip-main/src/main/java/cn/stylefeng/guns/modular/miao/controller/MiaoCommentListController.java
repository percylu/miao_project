package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoCommentList;
import cn.stylefeng.guns.modular.miao.model.params.MiaoCommentListParam;
import cn.stylefeng.guns.modular.miao.service.MiaoCommentListService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 评论列表控制器
 *
 * @author byteEngine
 * @Date 2020-12-12 09:52:48
 */
@Controller
@RequestMapping("/miaoCommentList")
public class MiaoCommentListController extends BaseController {

    private String PREFIX = "/miaoCommentList";

    @Autowired
    private MiaoCommentListService miaoCommentListService;

    /**
     * 跳转到主页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoCommentList.html";
    }

    /**
     * 新增页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoCommentList_add.html";
    }

    /**
     * 编辑页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoCommentList_edit.html";
    }

    /**
     * 新增接口
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoCommentListParam miaoCommentListParam) {
        this.miaoCommentListService.add(miaoCommentListParam);
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
    public ResponseData editItem(MiaoCommentListParam miaoCommentListParam) {
        this.miaoCommentListService.update(miaoCommentListParam);
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
    public ResponseData delete(MiaoCommentListParam miaoCommentListParam) {
        this.miaoCommentListService.delete(miaoCommentListParam);
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
    public ResponseData detail(MiaoCommentListParam miaoCommentListParam) {
        MiaoCommentList detail = this.miaoCommentListService.getById(miaoCommentListParam.getPostId());
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
    public LayuiPageInfo list(MiaoCommentListParam miaoCommentListParam) {
        return this.miaoCommentListService.findPageBySpec(miaoCommentListParam);
    }

}


