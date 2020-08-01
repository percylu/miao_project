package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoDeviceData;
import cn.stylefeng.guns.modular.miao.mapper.MiaoDeviceDataMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoDeviceDataParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoDeviceDataResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoDeviceDataService;
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
 * @author 卢水柏
 * @since 2020-07-31
 */
@Service
public class MiaoDeviceDataServiceImpl extends ServiceImpl<MiaoDeviceDataMapper, MiaoDeviceData> implements MiaoDeviceDataService {

    @Override
    public void add(MiaoDeviceDataParam param){
        MiaoDeviceData entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoDeviceDataParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoDeviceDataParam param){
        MiaoDeviceData oldEntity = getOldEntity(param);
        MiaoDeviceData newEntity = getEntity(param);
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
    public LayuiPageInfo findPageBySpec(MiaoDeviceDataParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoDeviceDataParam param){
        return param.getDeviceDataId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoDeviceData getOldEntity(MiaoDeviceDataParam param) {
        return this.getById(getKey(param));
    }

    private MiaoDeviceData getEntity(MiaoDeviceDataParam param) {
        MiaoDeviceData entity = new MiaoDeviceData();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
