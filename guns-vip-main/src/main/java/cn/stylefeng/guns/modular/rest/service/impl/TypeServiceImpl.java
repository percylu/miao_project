package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Type;
import cn.stylefeng.guns.modular.rest.mapper.TypeMapper;
import cn.stylefeng.guns.modular.rest.model.params.TypeParam;
import cn.stylefeng.guns.modular.rest.model.result.TypeResult;
import  cn.stylefeng.guns.modular.rest.service.TypeService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  宠物品种 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-23
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Override
    public void add(TypeParam param){
        Type entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(TypeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(TypeParam param){
        Type oldEntity = getOldEntity(param);
        Type newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public TypeResult findBySpec(TypeParam param){
        return null;
    }

    @Override
    public List<TypeResult> findListBySpec(TypeParam param){
        return this.baseMapper.customList(param);
    }

    @Override
    public PageResult<TypeResult> findPageBySpec(TypeParam param){
        Page pageContext = getPageContext();
        IPage<TypeResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(TypeParam param){
        return param.getTypeId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private Type getOldEntity(TypeParam param) {
        return this.getById(getKey(param));
    }

    private Type getEntity(TypeParam param) {
        Type entity = new Type();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
