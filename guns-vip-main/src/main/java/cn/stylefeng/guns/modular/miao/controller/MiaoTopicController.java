package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoTopic;
import cn.stylefeng.guns.modular.miao.model.params.MiaoTopicParam;
import cn.stylefeng.guns.modular.miao.service.MiaoTopicService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 话题维护控制器
 *
 * @author byteEngine
 * @Date 2020-12-14 15:31:47
 */
@Controller
@RequestMapping("/miaoTopic")
public class MiaoTopicController extends BaseController {

    private String PREFIX = "/miaoTopic";

    @Autowired
    private MiaoTopicService miaoTopicService;

    /**
     * 跳转到主页面
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoTopic.html";
    }

    /**
     * 新增页面
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoTopic_add.html";
    }

    /**
     * 编辑页面
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoTopic_edit.html";
    }

    /**
     * 新增接口
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoTopicParam miaoTopicParam) {
        this.miaoTopicService.add(miaoTopicParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MiaoTopicParam miaoTopicParam) {
        this.miaoTopicService.update(miaoTopicParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MiaoTopicParam miaoTopicParam) {
        this.miaoTopicService.delete(miaoTopicParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MiaoTopicParam miaoTopicParam) {
        MiaoTopic detail = this.miaoTopicService.getById(miaoTopicParam.getTopicId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoTopicParam miaoTopicParam) {
        return this.miaoTopicService.findPageBySpec(miaoTopicParam);
    }

}


