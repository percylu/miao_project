package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.CommonSetting;
import cn.stylefeng.guns.modular.rest.mapper.CommonSettingMapper;
import cn.stylefeng.guns.modular.rest.model.params.CommonSettingParam;
import cn.stylefeng.guns.modular.rest.model.result.CommonSettingResult;
import  cn.stylefeng.guns.modular.rest.service.CommonSettingService;
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
 * App 通用设置 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-14
 */
@Service
public class CommonSettingServiceImpl extends ServiceImpl<CommonSettingMapper, CommonSetting> implements CommonSettingService {

    @Override
    public void add(CommonSettingParam param){
        CommonSetting entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(CommonSettingParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(CommonSettingParam param){
        CommonSetting oldEntity = getOldEntity(param);
        CommonSetting newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public CommonSetting findBySpec(CommonSettingParam param){
        Map<String,Object> map= new HashMap<>();
        map.put("setting_title",param.getSettingTitle());
        List<CommonSetting> list=this.baseMapper.selectByMap(map);
        return list instanceof List?list.get(0):null;
    }

    @Override
    public List<CommonSettingResult> findListBySpec(CommonSettingParam param){
        return null;
    }

    @Override
    public PageResult<CommonSettingResult> findPageBySpec(CommonSettingParam param){
        Page pageContext = getPageContext();
        IPage<CommonSettingResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(CommonSettingParam param){
        return param.getSettingId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private CommonSetting getOldEntity(CommonSettingParam param) {
        return this.getById(getKey(param));
    }

    private CommonSetting getEntity(CommonSettingParam param) {
        CommonSetting entity = new CommonSetting();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
