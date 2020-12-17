package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.BlackList;
import cn.stylefeng.guns.modular.rest.mapper.BlackListMapper;
import cn.stylefeng.guns.modular.rest.model.params.BlackListParam;
import cn.stylefeng.guns.modular.rest.model.result.BlackListResult;
import  cn.stylefeng.guns.modular.rest.service.BlackListService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 黑名单列表
 服务实现类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@Service
public class BlackListServiceImpl extends ServiceImpl<BlackListMapper, BlackList> implements BlackListService {

    @Override
    public void add(BlackListParam param){
        BlackList entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(BlackListParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(BlackListParam param){
        BlackList oldEntity = getOldEntity(param);
        BlackList newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public BlackListResult findBySpec(BlackListParam param){
        return null;
    }

    @Override
    public List<BlackListResult> findListBySpec(BlackListParam param){
        return null;
    }

    @Override
    public PageResult<BlackListResult> findPageBySpec(BlackListParam param){
        Page pageContext = getPageContext();
        IPage<BlackListResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(BlackListParam param){
        return param.getUserId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private BlackList getOldEntity(BlackListParam param) {
        return this.getById(getKey(param));
    }

    private BlackList getEntity(BlackListParam param) {
        BlackList entity = new BlackList();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
