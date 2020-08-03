package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoDeviceData;
import cn.stylefeng.guns.modular.rest.mapper.MiaoDeviceDataMapper;
import cn.stylefeng.guns.modular.rest.model.params.MiaoDeviceDataParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoDeviceDataResult;
import  cn.stylefeng.guns.modular.rest.service.MiaoDeviceDataService;
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
 * @since 2020-08-02
 */
@Service
public class MiaoDeviceDataServiceImpl extends ServiceImpl<MiaoDeviceDataMapper, RestMiaoDeviceData> implements MiaoDeviceDataService {

    @Override
    public void add(MiaoDeviceDataParam param){
        RestMiaoDeviceData entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoDeviceDataParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoDeviceDataParam param){
        RestMiaoDeviceData oldEntity = getOldEntity(param);
        RestMiaoDeviceData newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoDeviceDataResult findBySpec(MiaoDeviceDataParam param){
        return null;
    }

    @Override
    public List<MiaoDeviceDataResult> findListBySpec(MiaoDeviceDataParam param){
        return null;
    }

    @Override
    public PageResult<MiaoDeviceDataResult> findPageBySpec(MiaoDeviceDataParam param){
        Page pageContext = getPageContext();
        IPage<MiaoDeviceDataResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(MiaoDeviceDataParam param){
        return param.getDeviceDataId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private RestMiaoDeviceData getOldEntity(MiaoDeviceDataParam param) {
        return this.getById(getKey(param));
    }

    private RestMiaoDeviceData getEntity(MiaoDeviceDataParam param) {
        RestMiaoDeviceData entity = new RestMiaoDeviceData();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
