package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.FollowList;
import cn.stylefeng.guns.modular.rest.mapper.FollowListMapper;
import cn.stylefeng.guns.modular.rest.model.params.FollowListParam;
import cn.stylefeng.guns.modular.rest.model.result.FollowListResult;
import  cn.stylefeng.guns.modular.rest.service.FollowListService;
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
 * @since 2020-12-15
 */
@Service
public class FollowListServiceImpl extends ServiceImpl<FollowListMapper, FollowList> implements FollowListService {

    @Override
    public void add(FollowListParam param){
        FollowList entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(FollowListParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(FollowListParam param){
        FollowList oldEntity = getOldEntity(param);
        FollowList newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public FollowListResult findBySpec(FollowListParam param){
        return null;
    }

    @Override
    public List<FollowListResult> findListBySpec(FollowListParam param){
        return null;
    }

    @Override
    public PageResult<FollowListResult> findPageBySpec(FollowListParam param){
        Page pageContext = getPageContext();
        IPage<FollowListResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(FollowListParam param){
        return param.getFollowId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private FollowList getOldEntity(FollowListParam param) {
        return this.getById(getKey(param));
    }

    private FollowList getEntity(FollowListParam param) {
        FollowList entity = new FollowList();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
