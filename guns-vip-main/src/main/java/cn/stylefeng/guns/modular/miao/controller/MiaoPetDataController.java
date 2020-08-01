package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoPetData;
import cn.stylefeng.guns.modular.miao.model.params.MiaoPetDataParam;
import cn.stylefeng.guns.modular.miao.service.MiaoPetDataService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 宠物数据控制器
 *
 * @author 卢水柏
 * @Date 2020-07-31 10:28:30
 */
@Controller
@RequestMapping("/miaoPetData")
public class MiaoPetDataController extends BaseController {

    private String PREFIX = "/miaoPetData";

    @Autowired
    private MiaoPetDataService miaoPetDataService;

    /**
     * 跳转到主页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoPetData.html";
    }

    /**
     * 新增页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoPetData_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoPetData_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoPetDataParam miaoPetDataParam) {
        this.miaoPetDataService.add(miaoPetDataParam);
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
    public ResponseData editItem(MiaoPetDataParam miaoPetDataParam) {
        this.miaoPetDataService.update(miaoPetDataParam);
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
    public ResponseData delete(MiaoPetDataParam miaoPetDataParam) {
        this.miaoPetDataService.delete(miaoPetDataParam);
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
    public ResponseData detail(MiaoPetDataParam miaoPetDataParam) {
        MiaoPetData detail = this.miaoPetDataService.getById(miaoPetDataParam.getPetDataId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoPetDataParam miaoPetDataParam) {
        return this.miaoPetDataService.findPageBySpec(miaoPetDataParam);
    }

}


