package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Post;
import cn.stylefeng.guns.modular.rest.mapper.PostMapper;
import cn.stylefeng.guns.modular.rest.model.params.PostParam;
import cn.stylefeng.guns.modular.rest.model.result.PostResult;
import  cn.stylefeng.guns.modular.rest.service.PostService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 个人动态 服务实现类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Override
    public void add(PostParam param){
        Post entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(PostParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(PostParam param){
        Post oldEntity = getOldEntity(param);
        Post newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public PostResult findBySpec(PostParam param){
        return null;
    }

    @Override
    public List<PostResult> findListBySpec(PostParam param){
        return null;
    }

    @Override
    public PageResult<PostResult> findPageBySpec(PostParam param){
        Page pageContext = getPageContext();
        IPage<PostResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(PostParam param){
        return param.getPostId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private Post getOldEntity(PostParam param) {
        return this.getById(getKey(param));
    }

    private Post getEntity(PostParam param) {
        Post entity = new Post();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
