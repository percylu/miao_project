package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.LikeList;
import cn.stylefeng.guns.modular.rest.mapper.LikeListMapper;
import cn.stylefeng.guns.modular.rest.model.params.LikeListParam;
import cn.stylefeng.guns.modular.rest.model.result.LikeListResult;
import  cn.stylefeng.guns.modular.rest.service.LikeListService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 点赞列表
 服务实现类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@Service
public class LikeListServiceImpl extends ServiceImpl<LikeListMapper, LikeList> implements LikeListService {

    @Override
    public void add(LikeListParam param){
        LikeList entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(LikeListParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(LikeListParam param){
        LikeList oldEntity = getOldEntity(param);
        LikeList newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public LikeListResult findBySpec(LikeListParam param){
        return null;
    }

    @Override
    public List<LikeListResult> findListBySpec(LikeListParam param){
        return null;
    }

    @Override
    public PageResult<LikeListResult> findPageBySpec(LikeListParam param){
        Page pageContext = getPageContext();
        IPage<LikeListResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(LikeListParam param){
        return param.getPostId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private LikeList getOldEntity(LikeListParam param) {
        return this.getById(getKey(param));
    }

    private LikeList getEntity(LikeListParam param) {
        LikeList entity = new LikeList();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
