package cn.stylefeng.guns.modular.miao.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoPet;
import cn.stylefeng.guns.modular.miao.model.params.MiaoPetParam;
import cn.stylefeng.guns.modular.miao.service.MiaoPetService;
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
 * 宠物管理控制器
 *
 * @author 卢水柏
 * @Date 2020-07-31 10:28:30
 */
@Controller
@RequestMapping("/miaoPet")
public class MiaoPetController extends BaseController {

    private String PREFIX = "/miaoPet";

    @Autowired
    private MiaoPetService miaoPetService;

    /**
     * 跳转到主页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoPet.html";
    }

    /**
     * 新增页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoPet_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoPet_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoPetParam miaoPetParam) {
        this.miaoPetService.add(miaoPetParam);
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
    public ResponseData editItem(MiaoPetParam miaoPetParam) {
        this.miaoPetService.update(miaoPetParam);
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
    public ResponseData delete(MiaoPetParam miaoPetParam) {
        this.miaoPetService.delete(miaoPetParam);
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
    public ResponseData detail(MiaoPetParam miaoPetParam) {
        MiaoPet detail = this.miaoPetService.getById(miaoPetParam.getPetId());
        Map<String, Object> map = BeanUtil.beanToMap(detail);
        map.put("birthday", DateUtil.formatDate(detail.getBirthday()));


//        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
//
//        detail.setBirthday(sdf.format(detail.getBirthday()));
        return ResponseData.success(map);
    }

    /**
     * 查询列表
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoPetParam miaoPetParam) {
        return this.miaoPetService.findPageBySpec(miaoPetParam);
    }

    @RequestMapping("/updatePic")
    @ResponseBody
    public ResponseData updatePic(@RequestParam("fileId") String fileId){
        if (ToolUtil.isEmpty(fileId)){
            throw new RequestEmptyException("请求图片为空");
        }
        String filePath=miaoPetService.updatePic(fileId);
        Map<String,String> map=new HashMap<>();
        map.put("filePath",filePath);
        return ResponseData.success(0, "上传成功", map);
    }
}


