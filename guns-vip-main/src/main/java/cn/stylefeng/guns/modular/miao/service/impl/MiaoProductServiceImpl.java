package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoProduct;
import cn.stylefeng.guns.modular.miao.mapper.MiaoProductMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoProductParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoProductResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoProductService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 商品维护 服务实现类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-05
 */
@Service
public class MiaoProductServiceImpl extends ServiceImpl<MiaoProductMapper, MiaoProduct> implements MiaoProductService {

    @Override
    public void add(MiaoProductParam param){
        MiaoProduct entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoProductParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoProductParam param){
        MiaoProduct oldEntity = getOldEntity(param);
        MiaoProduct newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoProductResult findBySpec(MiaoProductParam param){
        return null;
    }

    @Override
    public List<MiaoProductResult> findListBySpec(MiaoProductParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoProductParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoProductParam param){
        return param.getProductId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoProduct getOldEntity(MiaoProductParam param) {
        return this.getById(getKey(param));
    }

    private MiaoProduct getEntity(MiaoProductParam param) {
        MiaoProduct entity = new MiaoProduct();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
