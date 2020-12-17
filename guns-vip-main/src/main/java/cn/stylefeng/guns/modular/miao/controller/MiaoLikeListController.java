package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoLikeList;
import cn.stylefeng.guns.modular.miao.model.params.MiaoLikeListParam;
import cn.stylefeng.guns.modular.miao.service.MiaoLikeListService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 点赞列表控制器
 *
 * @author byteEngine
 * @Date 2020-12-12 09:52:48
 */
@Controller
@RequestMapping("/miaoLikeList")
public class MiaoLikeListController extends BaseController {

    private String PREFIX = "/miaoLikeList";

    @Autowired
    private MiaoLikeListService miaoLikeListService;

    /**
     * 跳转到主页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoLikeList.html";
    }

    /**
     * 新增页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoLikeList_add.html";
    }

    /**
     * 编辑页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoLikeList_edit.html";
    }

    /**
     * 新增接口
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoLikeListParam miaoLikeListParam) {
        this.miaoLikeListService.add(miaoLikeListParam);
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
    public ResponseData editItem(MiaoLikeListParam miaoLikeListParam) {
        this.miaoLikeListService.update(miaoLikeListParam);
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
    public ResponseData delete(MiaoLikeListParam miaoLikeListParam) {
        this.miaoLikeListService.delete(miaoLikeListParam);
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
    public ResponseData detail(MiaoLikeListParam miaoLikeListParam) {
        MiaoLikeList detail = this.miaoLikeListService.getById(miaoLikeListParam.getPostId());
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
    public LayuiPageInfo list(MiaoLikeListParam miaoLikeListParam) {
        return this.miaoLikeListService.findPageBySpec(miaoLikeListParam);
    }

}


