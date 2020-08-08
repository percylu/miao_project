package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.PetData;
import cn.stylefeng.guns.modular.rest.mapper.PetDataMapper;
import cn.stylefeng.guns.modular.rest.model.params.PetDataParam;
import cn.stylefeng.guns.modular.rest.model.result.PetDataResult;
import  cn.stylefeng.guns.modular.rest.service.PetDataService;
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
 * @author percylu
 * @since 2020-08-03
 */
@Service
public class PetDataServiceImpl extends ServiceImpl<PetDataMapper, PetData> implements PetDataService {

    @Override
    public void add(PetDataParam param){
        PetData entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(PetDataParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(PetDataParam param){
        PetData oldEntity = getOldEntity(param);
        PetData newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public PetDataResult findBySpec(PetDataParam param){
        return null;
    }

    @Override
    public List<PetDataResult> findListBySpec(PetDataParam param){
        return null;
    }

    @Override
    public PageResult<PetDataResult> findPageBySpec(PetDataParam param){
        Page pageContext = getPageContext();
        IPage<PetDataResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(PetDataParam param){
        return param.getPetDataId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private PetData getOldEntity(PetDataParam param) {
        return this.getById(getKey(param));
    }

    private PetData getEntity(PetDataParam param) {
        PetData entity = new PetData();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
