package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.DeviceType;
import cn.stylefeng.guns.modular.rest.mapper.DeviceTypeMapper;
import cn.stylefeng.guns.modular.rest.model.params.DeviceTypeParam;
import cn.stylefeng.guns.modular.rest.model.result.DeviceTypeResult;
import  cn.stylefeng.guns.modular.rest.service.DeviceTypeService;
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
 * @since 2020-08-03
 */
@Service
public class DeviceTypeServiceImpl extends ServiceImpl<DeviceTypeMapper, DeviceType> implements DeviceTypeService {

    @Override
    public void add(DeviceTypeParam param){
        DeviceType entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DeviceTypeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DeviceTypeParam param){
        DeviceType oldEntity = getOldEntity(param);
        DeviceType newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DeviceTypeResult findBySpec(DeviceTypeParam param){
        return null;
    }

    @Override
    public List<DeviceTypeResult> findListBySpec(DeviceTypeParam param){
        return null;
    }

    @Override
    public PageResult<DeviceTypeResult> findPageBySpec(DeviceTypeParam param){
        Page pageContext = getPageContext();
        IPage<DeviceTypeResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(DeviceTypeParam param){
        return param.getTypeId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private DeviceType getOldEntity(DeviceTypeParam param) {
        return this.getById(getKey(param));
    }

    private DeviceType getEntity(DeviceTypeParam param) {
        DeviceType entity = new DeviceType();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
