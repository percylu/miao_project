package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoCommentList;
import cn.stylefeng.guns.modular.miao.mapper.MiaoCommentListMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoCommentListParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoCommentListResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoCommentListService;
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
 * @since 2020-12-12
 */
@Service
public class MiaoCommentListServiceImpl extends ServiceImpl<MiaoCommentListMapper, MiaoCommentList> implements MiaoCommentListService {

    @Override
    public void add(MiaoCommentListParam param){
        MiaoCommentList entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoCommentListParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoCommentListParam param){
        MiaoCommentList oldEntity = getOldEntity(param);
        MiaoCommentList newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoCommentListResult findBySpec(MiaoCommentListParam param){
        return null;
    }

    @Override
    public List<MiaoCommentListResult> findListBySpec(MiaoCommentListParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoCommentListParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoCommentListParam param){
        return param.getPostId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoCommentList getOldEntity(MiaoCommentListParam param) {
        return this.getById(getKey(param));
    }

    private MiaoCommentList getEntity(MiaoCommentListParam param) {
        MiaoCommentList entity = new MiaoCommentList();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
