package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoDevice;
import cn.stylefeng.guns.modular.rest.mapper.MiaoDeviceMapper;
import cn.stylefeng.guns.modular.rest.model.params.MiaoDeviceParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoDeviceResult;
import  cn.stylefeng.guns.modular.rest.service.MiaoDeviceService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 设备管理 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
@Service
public class MiaoDeviceServiceImpl extends ServiceImpl<MiaoDeviceMapper, RestMiaoDevice> implements MiaoDeviceService {

    @Override
    public void add(MiaoDeviceParam param){
        RestMiaoDevice entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoDeviceParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoDeviceParam param){
        RestMiaoDevice oldEntity = getOldEntity(param);
        RestMiaoDevice newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoDeviceResult findBySpec(MiaoDeviceParam param){
        return null;
    }

    @Override
    public List<MiaoDeviceResult> findListBySpec(MiaoDeviceParam param){
        return null;
    }

    @Override
    public PageResult<MiaoDeviceResult> findPageBySpec(MiaoDeviceParam param){
        Page pageContext = getPageContext();
        IPage<MiaoDeviceResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(MiaoDeviceParam param){
        return param.getDeviceId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private RestMiaoDevice getOldEntity(MiaoDeviceParam param) {
        return this.getById(getKey(param));
    }

    private RestMiaoDevice getEntity(MiaoDeviceParam param) {
        RestMiaoDevice entity = new RestMiaoDevice();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
