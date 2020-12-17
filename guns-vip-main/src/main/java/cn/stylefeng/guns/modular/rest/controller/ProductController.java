package cn.stylefeng.guns.modular.rest.controller;

import cn.stylefeng.guns.modular.rest.entity.Product;
import cn.stylefeng.guns.modular.rest.model.result.PetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import cn.stylefeng.guns.modular.rest.model.params.ProductParam;
import cn.stylefeng.guns.modular.rest.model.result.ProductResult;
import cn.stylefeng.guns.modular.rest.service.ProductService;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 商品维护控制器
 *
 * @author byteEngine
 * @Date 2020-12-07 14:36:26
 */
@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ApiOperation("新增")
    public ResponseData add(@RequestBody ProductParam param) {
        productService.add(param);
        return ResponseData.success();
    }

    /**
     * 修改
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    @RequestMapping(value="/update",method = RequestMethod.POST)
    @ApiOperation("更新")
    public ResponseData update(@RequestBody ProductParam param) {
        productService.update(param);
        return ResponseData.success();
    }

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    @ApiOperation("删除")
    public ResponseData delete(@RequestBody ProductParam param) {
        productService.delete(param);
        return ResponseData.success();
    }

    /**
     * 查询单条详情
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    @RequestMapping(value="/queryDetail",method = RequestMethod.POST)
    @ApiOperation(value="详情", response = ProductResult.class)
    public ResponseData queryDetail(@RequestBody ProductParam param) {
        Product result = productService.findBySpec(param);
        return ResponseData.success(result);
    }

    /**
     * 查询列表
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    @RequestMapping(value="/queryList",method = RequestMethod.POST)
    @ApiOperation(value="查询列表",response = ProductResult.class)
    public ResponseData queryList(@RequestBody ProductParam param) {
        List<ProductResult> listBySpec = productService.findListBySpec(param);
        return ResponseData.success(listBySpec);
    }

    /**
     * 分页查询列表
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    @RequestMapping(value="/queryListPage",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询列表", response = ProductResult.class)
    public ResponseData queryListPage(@RequestBody ProductParam param) {
        PageResult<ProductResult> pageBySpec = productService.findPageBySpec(param);
        return ResponseData.success(pageBySpec);
    }

}
