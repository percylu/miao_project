package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoBlackList;
import cn.stylefeng.guns.modular.miao.mapper.MiaoBlackListMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoBlackListParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoBlackListResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoBlackListService;
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
 * @since 2020-12-12
 */
@Service
public class MiaoBlackListServiceImpl extends ServiceImpl<MiaoBlackListMapper, MiaoBlackList> implements MiaoBlackListService {

    @Override
    public void add(MiaoBlackListParam param){
        MiaoBlackList entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoBlackListParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoBlackListParam param){
        MiaoBlackList oldEntity = getOldEntity(param);
        MiaoBlackList newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoBlackListResult findBySpec(MiaoBlackListParam param){
        return null;
    }

    @Override
    public List<MiaoBlackListResult> findListBySpec(MiaoBlackListParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoBlackListParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoBlackListParam param){
        return param.getUserId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoBlackList getOldEntity(MiaoBlackListParam param) {
        return this.getById(getKey(param));
    }

    private MiaoBlackList getEntity(MiaoBlackListParam param) {
        MiaoBlackList entity = new MiaoBlackList();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
