package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoFollowList;
import cn.stylefeng.guns.modular.miao.model.params.MiaoFollowListParam;
import cn.stylefeng.guns.modular.miao.service.MiaoFollowListService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 关注列表控制器
 *
 * @author byteEngine
 * @Date 2020-12-12 09:52:48
 */
@Controller
@RequestMapping("/miaoFollowList")
public class MiaoFollowListController extends BaseController {

    private String PREFIX = "/miaoFollowList";

    @Autowired
    private MiaoFollowListService miaoFollowListService;

    /**
     * 跳转到主页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoFollowList.html";
    }

    /**
     * 新增页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoFollowList_add.html";
    }

    /**
     * 编辑页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoFollowList_edit.html";
    }

    /**
     * 新增接口
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoFollowListParam miaoFollowListParam) {
        this.miaoFollowListService.add(miaoFollowListParam);
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
    public ResponseData editItem(MiaoFollowListParam miaoFollowListParam) {
        this.miaoFollowListService.update(miaoFollowListParam);
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
    public ResponseData delete(MiaoFollowListParam miaoFollowListParam) {
        this.miaoFollowListService.delete(miaoFollowListParam);
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
    public ResponseData detail(MiaoFollowListParam miaoFollowListParam) {
        MiaoFollowList detail = this.miaoFollowListService.getById(miaoFollowListParam.getFollowId());
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
    public LayuiPageInfo list(MiaoFollowListParam miaoFollowListParam) {
        return this.miaoFollowListService.findPageBySpec(miaoFollowListParam);
    }

}


