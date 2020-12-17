package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoTopic;
import cn.stylefeng.guns.modular.miao.mapper.MiaoTopicMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoTopicParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoTopicResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoTopicService;
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
 * @since 2020-12-14
 */
@Service
public class MiaoTopicServiceImpl extends ServiceImpl<MiaoTopicMapper, MiaoTopic> implements MiaoTopicService {

    @Override
    public void add(MiaoTopicParam param){
        MiaoTopic entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoTopicParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoTopicParam param){
        MiaoTopic oldEntity = getOldEntity(param);
        MiaoTopic newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoTopicResult findBySpec(MiaoTopicParam param){
        return null;
    }

    @Override
    public List<MiaoTopicResult> findListBySpec(MiaoTopicParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoTopicParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoTopicParam param){
        return param.getTopicId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoTopic getOldEntity(MiaoTopicParam param) {
        return this.getById(getKey(param));
    }

    private MiaoTopic getEntity(MiaoTopicParam param) {
        MiaoTopic entity = new MiaoTopic();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
