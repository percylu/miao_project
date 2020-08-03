package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoPetData;
import cn.stylefeng.guns.modular.rest.mapper.MiaoPetDataMapper;
import cn.stylefeng.guns.modular.rest.model.params.MiaoPetDataParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoPetDataResult;
import  cn.stylefeng.guns.modular.rest.service.MiaoPetDataService;
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
 * @since 2020-08-02
 */
@Service
public class MiaoPetDataServiceImpl extends ServiceImpl<MiaoPetDataMapper, RestMiaoPetData> implements MiaoPetDataService {

    @Override
    public void add(MiaoPetDataParam param){
        RestMiaoPetData entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoPetDataParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoPetDataParam param){
        RestMiaoPetData oldEntity = getOldEntity(param);
        RestMiaoPetData newEntity = getEntity(param);
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
    public PageResult<MiaoPetDataResult> findPageBySpec(MiaoPetDataParam param){
        Page pageContext = getPageContext();
        IPage<MiaoPetDataResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(MiaoPetDataParam param){
        return param.getPetDataId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private RestMiaoPetData getOldEntity(MiaoPetDataParam param) {
        return this.getById(getKey(param));
    }

    private RestMiaoPetData getEntity(MiaoPetDataParam param) {
        RestMiaoPetData entity = new RestMiaoPetData();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
