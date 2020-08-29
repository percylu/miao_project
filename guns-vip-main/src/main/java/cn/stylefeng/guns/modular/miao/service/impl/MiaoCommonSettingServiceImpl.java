package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoCommonSetting;
import cn.stylefeng.guns.modular.miao.mapper.MiaoCommonSettingMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoCommonSettingParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoCommonSettingResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoCommonSettingService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * App 通用设置 服务实现类
 * </p>
 *
 * @author  percylu
 * @since 2020-08-14
 */
@Service
public class MiaoCommonSettingServiceImpl extends ServiceImpl<MiaoCommonSettingMapper, MiaoCommonSetting> implements MiaoCommonSettingService {

    @Override
    public void add(MiaoCommonSettingParam param){
        MiaoCommonSetting entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoCommonSettingParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoCommonSettingParam param){
        MiaoCommonSetting oldEntity = getOldEntity(param);
        MiaoCommonSetting newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoCommonSettingResult findBySpec(MiaoCommonSettingParam param){
        return null;
    }

    @Override
    public List<MiaoCommonSettingResult> findListBySpec(MiaoCommonSettingParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoCommonSettingParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoCommonSettingParam param){
        return param.getSettingId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoCommonSetting getOldEntity(MiaoCommonSettingParam param) {
        return this.getById(getKey(param));
    }

    private MiaoCommonSetting getEntity(MiaoCommonSettingParam param) {
        MiaoCommonSetting entity = new MiaoCommonSetting();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
