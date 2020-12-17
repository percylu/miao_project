package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Product;
import cn.stylefeng.guns.modular.rest.model.params.ProductParam;
import cn.stylefeng.guns.modular.rest.model.result.ProductResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品维护 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-07
 */
public interface ProductService extends IService<Product> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    void add(ProductParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    void delete(ProductParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    void update(ProductParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-07
     * @return
     */
    Product findBySpec(ProductParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    List<ProductResult> findListBySpec(ProductParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
     PageResult<ProductResult> findPageBySpec(ProductParam param);

}
