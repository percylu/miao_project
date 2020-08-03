package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoDeviceType;
import cn.stylefeng.guns.modular.rest.mapper.MiaoDeviceTypeMapper;
import cn.stylefeng.guns.modular.rest.model.params.MiaoDeviceTypeParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoDeviceTypeResult;
import  cn.stylefeng.guns.modular.rest.service.MiaoDeviceTypeService;
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
 * @author percylu
 * @since 2020-08-02
 */
@Service
public class MiaoDeviceTypeServiceImpl extends ServiceImpl<MiaoDeviceTypeMapper, RestMiaoDeviceType> implements MiaoDeviceTypeService {

    @Override
    public void add(MiaoDeviceTypeParam param){
        RestMiaoDeviceType entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoDeviceTypeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoDeviceTypeParam param){
        RestMiaoDeviceType oldEntity = getOldEntity(param);
        RestMiaoDeviceType newEntity = getEntity(param);
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
    public PageResult<MiaoDeviceTypeResult> findPageBySpec(MiaoDeviceTypeParam param){
        Page pageContext = getPageContext();
        IPage<MiaoDeviceTypeResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(MiaoDeviceTypeParam param){
        return param.getTypeId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private RestMiaoDeviceType getOldEntity(MiaoDeviceTypeParam param) {
        return this.getById(getKey(param));
    }

    private RestMiaoDeviceType getEntity(MiaoDeviceTypeParam param) {
        RestMiaoDeviceType entity = new RestMiaoDeviceType();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
