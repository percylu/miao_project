package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Topic;
import cn.stylefeng.guns.modular.rest.mapper.TopicMapper;
import cn.stylefeng.guns.modular.rest.model.params.TopicParam;
import cn.stylefeng.guns.modular.rest.model.result.TopicResult;
import  cn.stylefeng.guns.modular.rest.service.TopicService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 话题维护 服务实现类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

    @Override
    public void add(TopicParam param){
        Topic entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(TopicParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(TopicParam param){
        Topic oldEntity = getOldEntity(param);
        Topic newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public TopicResult findBySpec(TopicParam param){
        return null;
    }

    @Override
    public List<TopicResult> findListBySpec(TopicParam param){
        return null;
    }

    @Override
    public PageResult<TopicResult> findPageBySpec(TopicParam param){
        Page pageContext = getPageContext();
        IPage<TopicResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(TopicParam param){
        return param.getTopicId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private Topic getOldEntity(TopicParam param) {
        return this.getById(getKey(param));
    }

    private Topic getEntity(TopicParam param) {
        Topic entity = new Topic();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
