package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoBlackList;
import cn.stylefeng.guns.modular.miao.model.params.MiaoBlackListParam;
import cn.stylefeng.guns.modular.miao.service.MiaoBlackListService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 黑名单列表控制器
 *
 * @author byteEngine
 * @Date 2020-12-12 09:52:48
 */
@Controller
@RequestMapping("/miaoBlackList")
public class MiaoBlackListController extends BaseController {

    private String PREFIX = "/miaoBlackList";

    @Autowired
    private MiaoBlackListService miaoBlackListService;

    /**
     * 跳转到主页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoBlackList.html";
    }

    /**
     * 新增页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoBlackList_add.html";
    }

    /**
     * 编辑页面
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoBlackList_edit.html";
    }

    /**
     * 新增接口
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoBlackListParam miaoBlackListParam) {
        this.miaoBlackListService.add(miaoBlackListParam);
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
    public ResponseData editItem(MiaoBlackListParam miaoBlackListParam) {
        this.miaoBlackListService.update(miaoBlackListParam);
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
    public ResponseData delete(MiaoBlackListParam miaoBlackListParam) {
        this.miaoBlackListService.delete(miaoBlackListParam);
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
    public ResponseData detail(MiaoBlackListParam miaoBlackListParam) {
        MiaoBlackList detail = this.miaoBlackListService.getById(miaoBlackListParam.getUserId());
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
    public LayuiPageInfo list(MiaoBlackListParam miaoBlackListParam) {
        return this.miaoBlackListService.findPageBySpec(miaoBlackListParam);
    }

}


