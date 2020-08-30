package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Third;
import cn.stylefeng.guns.modular.rest.mapper.ThirdMapper;
import cn.stylefeng.guns.modular.rest.model.params.ThirdParam;
import cn.stylefeng.guns.modular.rest.model.result.ThirdResult;
import  cn.stylefeng.guns.modular.rest.service.ThirdService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 第三方ID 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-30
 */
@Service
public class ThirdServiceImpl extends ServiceImpl<ThirdMapper, Third> implements ThirdService {

    @Override
    public void add(ThirdParam param){
        Third entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ThirdParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ThirdParam param){
        Third oldEntity = getOldEntity(param);
        Third newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ThirdResult findBySpec(ThirdParam param){
        return null;
    }

    @Override
    public List<ThirdResult> findListBySpec(ThirdParam param){
        return null;
    }

    @Override
    public PageResult<ThirdResult> findPageBySpec(ThirdParam param){
        Page pageContext = getPageContext();
        IPage<ThirdResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(ThirdParam param){
        return param.getThirdId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private Third getOldEntity(ThirdParam param) {
        return this.getById(getKey(param));
    }

    private Third getEntity(ThirdParam param) {
        Third entity = new Third();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
