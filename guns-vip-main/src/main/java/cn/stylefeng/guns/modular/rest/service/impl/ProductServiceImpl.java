package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Product;
import cn.stylefeng.guns.modular.rest.mapper.ProductMapper;
import cn.stylefeng.guns.modular.rest.model.params.ProductParam;
import cn.stylefeng.guns.modular.rest.model.result.ProductResult;
import  cn.stylefeng.guns.modular.rest.service.ProductService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 商品维护 服务实现类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-07
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public void add(ProductParam param){
        Product entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ProductParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ProductParam param){
        Product oldEntity = getOldEntity(param);
        Product newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public Product findBySpec(ProductParam param){
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("promotion", param.getPromotion());
        return this.baseMapper.selectOne(queryWrapper);
    }

    @Override
    public List<ProductResult> findListBySpec(ProductParam param){
        return null;
    }

    @Override
    public PageResult<ProductResult> findPageBySpec(ProductParam param){
        Page pageContext = getPageContext();
        pageContext.setCurrent(param.getPage());
        pageContext.setSize(5);
        IPage<ProductResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(ProductParam param){
        return param.getProductId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private Product getOldEntity(ProductParam param) {
        return this.getById(getKey(param));
    }

    private Product getEntity(ProductParam param) {
        Product entity = new Product();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
