package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoUser;
import cn.stylefeng.guns.modular.rest.mapper.RestMiaoUserMapper;
import cn.stylefeng.guns.modular.rest.model.params.UserParam;
import cn.stylefeng.guns.modular.rest.model.result.UserResult;
import  cn.stylefeng.guns.modular.rest.service.UserService;
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
 * @since 2020-08-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<RestMiaoUserMapper, RestMiaoUser> implements UserService {

    @Override
    public void add(UserParam param){
        RestMiaoUser entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(UserParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(UserParam param){
        RestMiaoUser oldEntity = getOldEntity(param);
        RestMiaoUser newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public UserResult findBySpec(UserParam param){
        return null;
    }

    @Override
    public List<UserResult> findListBySpec(UserParam param){
        return null;
    }

    @Override
    public PageResult<UserResult> findPageBySpec(UserParam param){
        Page pageContext = getPageContext();
        IPage<UserResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(UserParam param){
        return param.getUserId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private RestMiaoUser getOldEntity(UserParam param) {
        return this.getById(getKey(param));
    }

    private RestMiaoUser getEntity(UserParam param) {
        RestMiaoUser entity = new RestMiaoUser();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
