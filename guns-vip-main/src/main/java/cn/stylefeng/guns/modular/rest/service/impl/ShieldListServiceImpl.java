package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.ShieldList;
import cn.stylefeng.guns.modular.rest.mapper.ShieldListMapper;
import cn.stylefeng.guns.modular.rest.model.params.ShieldListParam;
import cn.stylefeng.guns.modular.rest.model.result.ShieldListResult;
import  cn.stylefeng.guns.modular.rest.service.ShieldListService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 屏蔽列表
 服务实现类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@Service
public class ShieldListServiceImpl extends ServiceImpl<ShieldListMapper, ShieldList> implements ShieldListService {

    @Override
    public void add(ShieldListParam param){
        ShieldList entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ShieldListParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ShieldListParam param){
        ShieldList oldEntity = getOldEntity(param);
        ShieldList newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ShieldListResult findBySpec(ShieldListParam param){
        return null;
    }

    @Override
    public List<ShieldListResult> findListBySpec(ShieldListParam param){
        return null;
    }

    @Override
    public PageResult<ShieldListResult> findPageBySpec(ShieldListParam param){
        Page pageContext = getPageContext();
        IPage<ShieldListResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(ShieldListParam param){
        return param.getUserId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private ShieldList getOldEntity(ShieldListParam param) {
        return this.getById(getKey(param));
    }

    private ShieldList getEntity(ShieldListParam param) {
        ShieldList entity = new ShieldList();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
