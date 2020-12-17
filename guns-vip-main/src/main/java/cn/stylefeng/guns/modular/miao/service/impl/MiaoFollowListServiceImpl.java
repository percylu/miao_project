package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoFollowList;
import cn.stylefeng.guns.modular.miao.mapper.MiaoFollowListMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoFollowListParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoFollowListResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoFollowListService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 关注列表
 服务实现类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
@Service
public class MiaoFollowListServiceImpl extends ServiceImpl<MiaoFollowListMapper, MiaoFollowList> implements MiaoFollowListService {

    @Override
    public void add(MiaoFollowListParam param){
        MiaoFollowList entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoFollowListParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoFollowListParam param){
        MiaoFollowList oldEntity = getOldEntity(param);
        MiaoFollowList newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoFollowListResult findBySpec(MiaoFollowListParam param){
        return null;
    }

    @Override
    public List<MiaoFollowListResult> findListBySpec(MiaoFollowListParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoFollowListParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoFollowListParam param){
        return param.getFollowId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoFollowList getOldEntity(MiaoFollowListParam param) {
        return this.getById(getKey(param));
    }

    private MiaoFollowList getEntity(MiaoFollowListParam param) {
        MiaoFollowList entity = new MiaoFollowList();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
