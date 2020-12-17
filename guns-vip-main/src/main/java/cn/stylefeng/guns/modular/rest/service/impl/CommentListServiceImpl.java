package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.CommentList;
import cn.stylefeng.guns.modular.rest.mapper.CommentListMapper;
import cn.stylefeng.guns.modular.rest.model.params.CommentListParam;
import cn.stylefeng.guns.modular.rest.model.result.CommentListResult;
import  cn.stylefeng.guns.modular.rest.service.CommentListService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 评论列表
 服务实现类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@Service
public class CommentListServiceImpl extends ServiceImpl<CommentListMapper, CommentList> implements CommentListService {

    @Override
    public void add(CommentListParam param){
        CommentList entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(CommentListParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(CommentListParam param){
        CommentList oldEntity = getOldEntity(param);
        CommentList newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public CommentListResult findBySpec(CommentListParam param){
        return null;
    }

    @Override
    public List<CommentListResult> findListBySpec(CommentListParam param){
        return null;
    }

    @Override
    public PageResult<CommentListResult> findPageBySpec(CommentListParam param){
        Page pageContext = getPageContext();
        IPage<CommentListResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(CommentListParam param){
        return param.getPostId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private CommentList getOldEntity(CommentListParam param) {
        return this.getById(getKey(param));
    }

    private CommentList getEntity(CommentListParam param) {
        CommentList entity = new CommentList();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
