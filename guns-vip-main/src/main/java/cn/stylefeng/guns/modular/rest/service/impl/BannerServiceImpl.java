package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Banner;
import cn.stylefeng.guns.modular.rest.mapper.BannerMapper;
import cn.stylefeng.guns.modular.rest.model.params.BannerParam;
import cn.stylefeng.guns.modular.rest.model.result.BannerResult;
import  cn.stylefeng.guns.modular.rest.service.BannerService;
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
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {

    @Override
    public void add(BannerParam param){
        Banner entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(BannerParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(BannerParam param){
        Banner oldEntity = getOldEntity(param);
        Banner newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public BannerResult findBySpec(BannerParam param){
        return null;
    }

    @Override
    public List<BannerResult> findListBySpec(BannerParam param){
        return null;
    }

    @Override
    public PageResult<BannerResult> findPageBySpec(BannerParam param){
        Page pageContext = getPageContext();
        IPage<BannerResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    @Override
    public List<BannerResult> customerList() {
        return this.baseMapper.customList();
    }

    private Serializable getKey(BannerParam param){
        return param.getBannerId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private Banner getOldEntity(BannerParam param) {
        return this.getById(getKey(param));
    }

    private Banner getEntity(BannerParam param) {
        Banner entity = new Banner();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
