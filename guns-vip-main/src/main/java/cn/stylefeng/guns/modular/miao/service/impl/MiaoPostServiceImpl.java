package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoPost;
import cn.stylefeng.guns.modular.miao.mapper.MiaoPostMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoPostParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoPostResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoPostService;
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
 * @since 2020-12-12
 */
@Service
public class MiaoPostServiceImpl extends ServiceImpl<MiaoPostMapper, MiaoPost> implements MiaoPostService {

    @Override
    public void add(MiaoPostParam param){
        MiaoPost entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoPostParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoPostParam param){
        MiaoPost oldEntity = getOldEntity(param);
        MiaoPost newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoPostResult findBySpec(MiaoPostParam param){
        return null;
    }

    @Override
    public List<MiaoPostResult> findListBySpec(MiaoPostParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoPostParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoPostParam param){
        return param.getPostId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoPost getOldEntity(MiaoPostParam param) {
        return this.getById(getKey(param));
    }

    private MiaoPost getEntity(MiaoPostParam param) {
        MiaoPost entity = new MiaoPost();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
