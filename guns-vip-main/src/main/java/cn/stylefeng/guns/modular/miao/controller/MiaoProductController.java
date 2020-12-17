package cn.stylefeng.guns.modular.miao.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoProduct;
import cn.stylefeng.guns.modular.miao.model.params.MiaoProductParam;
import cn.stylefeng.guns.modular.miao.service.MiaoProductService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 商品维护控制器
 *
 * @author byteEngine
 * @Date 2020-12-05 09:42:25
 */
@Controller
@RequestMapping("/miaoProduct")
public class MiaoProductController extends BaseController {

    private String PREFIX = "/miaoProduct";

    @Autowired
    private MiaoProductService miaoProductService;

    /**
     * 跳转到主页面
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/miaoProduct.html";
    }

    /**
     * 新增页面
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/miaoProduct_add.html";
    }

    /**
     * 编辑页面
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/miaoProduct_edit.html";
    }

    /**
     * 新增接口
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(MiaoProductParam miaoProductParam) {
        this.miaoProductService.add(miaoProductParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(MiaoProductParam miaoProductParam) {
        this.miaoProductService.update(miaoProductParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(MiaoProductParam miaoProductParam) {
        this.miaoProductService.delete(miaoProductParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(MiaoProductParam miaoProductParam) {
        MiaoProduct detail = this.miaoProductService.getById(miaoProductParam.getProductId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(MiaoProductParam miaoProductParam) {
        return this.miaoProductService.findPageBySpec(miaoProductParam);
    }

}


