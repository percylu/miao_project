package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoUser;
import cn.stylefeng.guns.modular.rest.mapper.MiaoUserMapper;
import cn.stylefeng.guns.modular.rest.model.params.MiaoUserParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoUserResult;
import  cn.stylefeng.guns.modular.rest.service.MiaoUserService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * App用户管理 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
@Service
public class MiaoUserServiceImpl extends ServiceImpl<MiaoUserMapper, RestMiaoUser> implements MiaoUserService {

    @Override
    public void add(MiaoUserParam param){
        RestMiaoUser entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoUserParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoUserParam param){
        RestMiaoUser oldEntity = getOldEntity(param);
        RestMiaoUser newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoUserResult findBySpec(MiaoUserParam param){
        return null;
    }

    @Override
    public List<MiaoUserResult> findListBySpec(MiaoUserParam param){
        return null;
    }

    @Override
    public PageResult<MiaoUserResult> findPageBySpec(MiaoUserParam param){
        Page pageContext = getPageContext();
        IPage<MiaoUserResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(MiaoUserParam param){
        return param.getUserId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private RestMiaoUser getOldEntity(MiaoUserParam param) {
        return this.getById(getKey(param));
    }

    private RestMiaoUser getEntity(MiaoUserParam param) {
        RestMiaoUser entity = new RestMiaoUser();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
