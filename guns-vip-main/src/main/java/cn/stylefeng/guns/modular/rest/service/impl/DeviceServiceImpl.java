package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Device;
import cn.stylefeng.guns.modular.rest.mapper.DeviceMapper;
import cn.stylefeng.guns.modular.rest.model.params.DeviceParam;
import cn.stylefeng.guns.modular.rest.model.result.DeviceResult;
import  cn.stylefeng.guns.modular.rest.service.DeviceService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备管理 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

    @Override
    public void add(DeviceParam param){
        Device entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(DeviceParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(DeviceParam param){
        Device oldEntity = getOldEntity(param);
        Device newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public DeviceResult findBySpec(DeviceParam param){
        return null;
    }

    @Override
    public List<Map<String,Object>> findListBySpec(DeviceParam param){
        param.setStatus("ENABLE");
        List<Map<String,Object>> list=this.baseMapper.customMapList(param);
        return list;
    }

    @Override
    public PageResult<DeviceResult> findPageBySpec(DeviceParam param){
        Page pageContext = getPageContext();
        IPage<DeviceResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    @Override
    public List<Device> findbyDeviceSn(String deviceSn) {
        Map<String,Object> map = new HashMap<>();
        map.put("device_sn",deviceSn);
        return this.baseMapper.selectByMap(map);
    }

    private Serializable getKey(DeviceParam param){
        return param.getDeviceId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private Device getOldEntity(DeviceParam param) {
        return this.getById(getKey(param));
    }

    private Device getEntity(DeviceParam param) {
        Device entity = new Device();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
