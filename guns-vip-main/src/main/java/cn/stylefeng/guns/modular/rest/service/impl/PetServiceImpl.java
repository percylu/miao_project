package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Pet;
import cn.stylefeng.guns.modular.rest.mapper.PetMapper;
import cn.stylefeng.guns.modular.rest.model.params.PetParam;
import cn.stylefeng.guns.modular.rest.model.result.PetResult;
import  cn.stylefeng.guns.modular.rest.service.PetService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 宠物管理 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements PetService {

    @Override
    public void add(PetParam param){
        Pet entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(PetParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(PetParam param){
        Pet oldEntity = getOldEntity(param);
        Pet newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public PetResult findBySpec(PetParam param){
        return null;
    }

    @Override
    public List<PetResult> findListBySpec(PetParam param){
        return null;
    }

    @Override
    public PageResult<PetResult> findPageBySpec(PetParam param){
        Page pageContext = getPageContext();
        IPage<PetResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(PetParam param){
        return param.getPetId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private Pet getOldEntity(PetParam param) {
        return this.getById(getKey(param));
    }

    private Pet getEntity(PetParam param) {
        Pet entity = new Pet();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
