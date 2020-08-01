package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoDevice;
import cn.stylefeng.guns.modular.miao.mapper.MiaoDeviceMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoDeviceParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoDeviceResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoDeviceService;
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
 * @author 卢水柏
 * @since 2020-07-31
 */
@Service
public class MiaoDeviceServiceImpl extends ServiceImpl<MiaoDeviceMapper, MiaoDevice> implements MiaoDeviceService {

    @Override
    public void add(MiaoDeviceParam param){
        MiaoDevice entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoDeviceParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoDeviceParam param){
        MiaoDevice oldEntity = getOldEntity(param);
        MiaoDevice newEntity = getEntity(param);
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
    public LayuiPageInfo findPageBySpec(MiaoDeviceParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoDeviceParam param){
        return param.getDeviceId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoDevice getOldEntity(MiaoDeviceParam param) {
        return this.getById(getKey(param));
    }

    private MiaoDevice getEntity(MiaoDeviceParam param) {
        MiaoDevice entity = new MiaoDevice();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
