package cn.stylefeng.guns.modular.rest.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.wrapper.PetWrapper;
import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.guns.modular.rest.entity.Pet;
import cn.stylefeng.guns.modular.rest.mapper.PetMapper;
import cn.stylefeng.guns.modular.rest.model.params.PetParam;
import cn.stylefeng.guns.modular.rest.model.result.PetResult;
import cn.stylefeng.guns.modular.rest.service.PetService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 宠物管理 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-21
 */
@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements PetService {

    @Override
    public void add(PetParam param) {
        Pet entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(PetParam param) {
        this.removeById(getKey(param));
    }

    @Override
    public void update(PetParam param) {
        Pet oldEntity = getOldEntity(param);
        Pet newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public void updateDate(PetParam param) {
        Pet oldEntity = getOldEntity(param);
        Pet newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        newEntity.setUpdateTime(DateTime.now());
        this.updateById(newEntity);
    }


    @Override
    public Pet findBySpec(PetParam param) {
        return this.baseMapper.selectById(param.getPetId());
    }

    @Override
    public List<PetResult> findListBySpec(PetParam param) {
        List<PetResult> list = this.baseMapper.customList(param);
        List<Map<String,Object>> mapList=new ArrayList<>();
        for (PetResult item : list
        ) {
            Map map = BeanUtil.beanToMap(item);
            mapList.add(map);

        }
        return new PetWrapper(mapList).wrap();
    }

    @Override
    public LayuiPageInfo findPageBySpec(PetParam param) {
        Page pageContext = getPageContext();
        Page<Map<String, Object>> page = this.baseMapper.customPageMapList(pageContext, param);
        Page wrap = new PetWrapper(page).wrap();

        return LayuiPageFactory.createPageInfo(wrap);
    }

    private Serializable getKey(PetParam param) {
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
