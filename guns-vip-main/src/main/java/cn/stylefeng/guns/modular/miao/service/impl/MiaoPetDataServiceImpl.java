package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoPetData;
import cn.stylefeng.guns.modular.miao.mapper.MiaoPetDataMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoPetDataParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoPetDataResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoPetDataService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 宠物数据
 服务实现类
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@Service
public class MiaoPetDataServiceImpl extends ServiceImpl<MiaoPetDataMapper, MiaoPetData> implements MiaoPetDataService {

    @Override
    public void add(MiaoPetDataParam param){
        MiaoPetData entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoPetDataParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoPetDataParam param){
        MiaoPetData oldEntity = getOldEntity(param);
        MiaoPetData newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoPetDataResult findBySpec(MiaoPetDataParam param){
        return null;
    }

    @Override
    public List<MiaoPetDataResult> findListBySpec(MiaoPetDataParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoPetDataParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoPetDataParam param){
        return param.getPetDataId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoPetData getOldEntity(MiaoPetDataParam param) {
        return this.getById(getKey(param));
    }

    private MiaoPetData getEntity(MiaoPetDataParam param) {
        MiaoPetData entity = new MiaoPetData();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
