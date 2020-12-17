package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoLikeList;
import cn.stylefeng.guns.modular.miao.mapper.MiaoLikeListMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoLikeListParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoLikeListResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoLikeListService;
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
 * @since 2020-12-12
 */
@Service
public class MiaoLikeListServiceImpl extends ServiceImpl<MiaoLikeListMapper, MiaoLikeList> implements MiaoLikeListService {

    @Override
    public void add(MiaoLikeListParam param){
        MiaoLikeList entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoLikeListParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoLikeListParam param){
        MiaoLikeList oldEntity = getOldEntity(param);
        MiaoLikeList newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoLikeListResult findBySpec(MiaoLikeListParam param){
        return null;
    }

    @Override
    public List<MiaoLikeListResult> findListBySpec(MiaoLikeListParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoLikeListParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoLikeListParam param){
        return param.getPostId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoLikeList getOldEntity(MiaoLikeListParam param) {
        return this.getById(getKey(param));
    }

    private MiaoLikeList getEntity(MiaoLikeListParam param) {
        MiaoLikeList entity = new MiaoLikeList();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
