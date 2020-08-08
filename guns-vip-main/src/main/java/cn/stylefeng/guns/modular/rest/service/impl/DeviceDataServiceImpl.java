package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.DeviceData;
import cn.stylefeng.guns.modular.rest.mapper.DeviceDataMapper;
import cn.stylefeng.guns.modular.rest.model.params.DeviceDataParam;
import cn.stylefeng.guns.modular.rest.model.result.DeviceDataResult;
import  cn.stylefeng.guns.modular.rest.service.DeviceDataService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 设备数据 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
@Service
public class DeviceDataServiceImpl extends ServiceImpl<DeviceDataMapper, DeviceData> implements DeviceDataService {

    @Override
    public void add(DeviceDataParam param){
        DeviceData entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DeviceDataParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DeviceDataParam param){
        DeviceData oldEntity = getOldEntity(param);
        DeviceData newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DeviceDataResult findBySpec(DeviceDataParam param){
        return null;
    }

    @Override
    public List<DeviceDataResult> findListBySpec(DeviceDataParam param){
        return null;
    }

    @Override
    public PageResult<DeviceDataResult> findPageBySpec(DeviceDataParam param){
        Page pageContext = getPageContext();
        IPage<DeviceDataResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(DeviceDataParam param){
        return param.getDeviceDataId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private DeviceData getOldEntity(DeviceDataParam param) {
        return this.getById(getKey(param));
    }

    private DeviceData getEntity(DeviceDataParam param) {
        DeviceData entity = new DeviceData();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
