package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoNotice;
import cn.stylefeng.guns.modular.miao.mapper.MiaoNoticeMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoNoticeParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoNoticeResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoNoticeService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通知表 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-28
 */
@Service
public class MiaoNoticeServiceImpl extends ServiceImpl<MiaoNoticeMapper, MiaoNotice> implements MiaoNoticeService {

    @Override
    public void add(MiaoNoticeParam param){
        MiaoNotice entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoNoticeParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoNoticeParam param){
        MiaoNotice oldEntity = getOldEntity(param);
        MiaoNotice newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoNoticeResult findBySpec(MiaoNoticeParam param){
        return null;
    }

    @Override
    public List<MiaoNoticeResult> findListBySpec(MiaoNoticeParam param){
        return null;
    }

    @Override
    public Page<Map<String, Object>> findPageBySpec(MiaoNoticeParam param){
        Page pageContext = getPageContext();
        Page<Map<String, Object>> page = this.baseMapper.customPageMapList(pageContext,param);
        return page;
    }

    private Serializable getKey(MiaoNoticeParam param){
        return param.getNoticeId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoNotice getOldEntity(MiaoNoticeParam param) {
        return this.getById(getKey(param));
    }

    private MiaoNotice getEntity(MiaoNoticeParam param) {
        MiaoNotice entity = new MiaoNotice();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
