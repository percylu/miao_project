package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.MiaoBanner;
import cn.stylefeng.guns.modular.rest.mapper.MiaoBannerMapper;
import cn.stylefeng.guns.modular.rest.model.params.MiaoBannerParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoBannerResult;
import  cn.stylefeng.guns.modular.rest.service.MiaoBannerService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 广告图管理 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-08
 */
@Service
public class MiaoBannerServiceImpl extends ServiceImpl<MiaoBannerMapper, MiaoBanner> implements MiaoBannerService {

    @Override
    public void add(MiaoBannerParam param){
        MiaoBanner entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoBannerParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoBannerParam param){
        MiaoBanner oldEntity = getOldEntity(param);
        MiaoBanner newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoBannerResult findBySpec(MiaoBannerParam param){
        return null;
    }

    @Override
    public List<MiaoBannerResult> findListBySpec(MiaoBannerParam param){
        return null;
    }

    @Override
    public PageResult<MiaoBannerResult> findPageBySpec(MiaoBannerParam param){
        Page pageContext = getPageContext();
        IPage<MiaoBannerResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(MiaoBannerParam param){
        return param.getBannerId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private MiaoBanner getOldEntity(MiaoBannerParam param) {
        return this.getById(getKey(param));
    }

    private MiaoBanner getEntity(MiaoBannerParam param) {
        MiaoBanner entity = new MiaoBanner();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
