package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoDeviceType;
import cn.stylefeng.guns.modular.miao.mapper.MiaoDeviceTypeMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoDeviceTypeParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoDeviceTypeResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoDeviceTypeService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 设备类型 服务实现类
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@Service
public class MiaoDeviceTypeServiceImpl extends ServiceImpl<MiaoDeviceTypeMapper, MiaoDeviceType> implements MiaoDeviceTypeService {

    @Override
    public void add(MiaoDeviceTypeParam param){
        MiaoDeviceType entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoDeviceTypeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoDeviceTypeParam param){
        MiaoDeviceType oldEntity = getOldEntity(param);
        MiaoDeviceType newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoDeviceTypeResult findBySpec(MiaoDeviceTypeParam param){
        return null;
    }

    @Override
    public List<MiaoDeviceTypeResult> findListBySpec(MiaoDeviceTypeParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoDeviceTypeParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoDeviceTypeParam param){
        return param.getTypeId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoDeviceType getOldEntity(MiaoDeviceTypeParam param) {
        return this.getById(getKey(param));
    }

    private MiaoDeviceType getEntity(MiaoDeviceTypeParam param) {
        MiaoDeviceType entity = new MiaoDeviceType();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
