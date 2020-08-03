package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoPet;
import cn.stylefeng.guns.modular.rest.mapper.MiaoPetMapper;
import cn.stylefeng.guns.modular.rest.model.params.MiaoPetParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoPetResult;
import  cn.stylefeng.guns.modular.rest.service.MiaoPetService;
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
 * @since 2020-08-02
 */
@Service
public class MiaoPetServiceImpl extends ServiceImpl<MiaoPetMapper, RestMiaoPet> implements MiaoPetService {

    @Override
    public void add(MiaoPetParam param){
        RestMiaoPet entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoPetParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoPetParam param){
        RestMiaoPet oldEntity = getOldEntity(param);
        RestMiaoPet newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoPetResult findBySpec(MiaoPetParam param){
        return null;
    }

    @Override
    public List<MiaoPetResult> findListBySpec(MiaoPetParam param){
        return null;
    }

    @Override
    public PageResult<MiaoPetResult> findPageBySpec(MiaoPetParam param){
        Page pageContext = getPageContext();
        IPage<MiaoPetResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(MiaoPetParam param){
        return param.getPetId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private RestMiaoPet getOldEntity(MiaoPetParam param) {
        return this.getById(getKey(param));
    }

    private RestMiaoPet getEntity(MiaoPetParam param) {
        RestMiaoPet entity = new RestMiaoPet();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
