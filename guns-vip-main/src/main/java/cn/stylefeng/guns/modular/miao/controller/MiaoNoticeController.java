package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.jpush.model.PushBean;
import cn.stylefeng.guns.modular.jpush.service.JiGuangPushService;
import cn.stylefeng.guns.modular.miao.entity.MiaoNotice;
import cn.stylefeng.guns.modular.miao.model.params.MiaoNoticeParam;
import cn.stylefeng.guns.modular.miao.service.MiaoNoticeService;
import cn.stylefeng.guns.modular.miao.wrapper.NoticeWrapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * 通知表控制器
 *
 * @author percylu
 * @Date 2020-08-28 12:08:05
 */
@Controller
@RequestMapping("/miaoNotice")
public class MiaoNoticeController extends BaseController {

    private String PREFIX = "/miaoNotice";

    @Autowired
    private MiaoNoticeService miaoNoticeService;
    @Autowired
    JiGuangPushService jiGuangPushService;
    /**
     * 跳转到主页面
     *
     * @author percylu
     * @Date 2020-08-28
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoNotice.html";
    }

    /**
     * 新增页面
     *
     * @author percylu
     * @Date 2020-08-28
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoNotice_add.html";
    }

    /**
     * 编辑页面
     *
     * @author percylu
     * @Date 2020-08-28
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoNotice_edit.html";
    }

    /**
     * 新增接口
     *
     * @author percylu
     * @Date 2020-08-28
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoNoticeParam miaoNoticeParam) {
        this.miaoNoticeService.add(miaoNoticeParam);
        PushBean pushBean = new PushBean();
        if(miaoNoticeParam.getType()=="SYS"){
            pushBean.setTitle("系统消息");
        }
        if(miaoNoticeParam.getType()=="DEVICE"){
            pushBean.setTitle("故障消息");
        }
        if(miaoNoticeParam.getType()=="PUSH"){
            pushBean.setTitle("推送消息");
        }
        pushBean.setAlert(miaoNoticeParam.getTitle());
        jiGuangPushService.pushAndroid(pushBean);
        jiGuangPushService.pushIos(pushBean);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author percylu
     * @Date 2020-08-28
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MiaoNoticeParam miaoNoticeParam) {
        this.miaoNoticeService.update(miaoNoticeParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author percylu
     * @Date 2020-08-28
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MiaoNoticeParam miaoNoticeParam) {
        this.miaoNoticeService.delete(miaoNoticeParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author percylu
     * @Date 2020-08-28
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MiaoNoticeParam miaoNoticeParam) {
        MiaoNotice detail = this.miaoNoticeService.getById(miaoNoticeParam.getNoticeId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author percylu
     * @Date 2020-08-28
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoNoticeParam miaoNoticeParam) {
        Page<Map<String, Object>> list = this.miaoNoticeService.findPageBySpec(miaoNoticeParam);

        Page<Map<String, Object>> wrap = new NoticeWrapper(list).wrap();
        return LayuiPageFactory.createPageInfo(wrap);

    }

}


