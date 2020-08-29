package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoType;
import cn.stylefeng.guns.modular.miao.mapper.MiaoTypeMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoTypeParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoTypeResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoTypeService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  宠物品种 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-20
 */
@Service
public class MiaoTypeServiceImpl extends ServiceImpl<MiaoTypeMapper, MiaoType> implements MiaoTypeService {

    @Override
    public void add(MiaoTypeParam param){
        MiaoType entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoTypeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoTypeParam param){
        MiaoType oldEntity = getOldEntity(param);
        MiaoType newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoTypeResult findBySpec(MiaoTypeParam param){
        return null;
    }

    @Override
    public List<MiaoTypeResult> findListBySpec(MiaoTypeParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoTypeParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoTypeParam param){
        return param.getTypeId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoType getOldEntity(MiaoTypeParam param) {
        return this.getById(getKey(param));
    }

    private MiaoType getEntity(MiaoTypeParam param) {
        MiaoType entity = new MiaoType();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
