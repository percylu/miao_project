package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoBanner;
import cn.stylefeng.guns.modular.miao.mapper.MiaoBannerMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoBannerParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoBannerResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoBannerService;
import cn.stylefeng.guns.sys.modular.system.entity.FileInfo;
import cn.stylefeng.guns.sys.modular.system.service.FileInfoService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 广告图管理 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-08
 */
@Service
public class MiaoBannerServiceImpl extends ServiceImpl<MiaoBannerMapper, MiaoBanner> implements MiaoBannerService {
    @Autowired
    private FileInfoService fileInfoService;
    @Override
    public void add(MiaoBannerParam param){
        MiaoBanner entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoBannerParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoBannerParam param){
        MiaoBanner oldEntity = getOldEntity(param);
        MiaoBanner newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoBannerResult findBySpec(MiaoBannerParam param){
        return null;
    }

    @Override
    public List<MiaoBannerResult> findListBySpec(MiaoBannerParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoBannerParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoBannerParam param){
        return param.getBannerId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoBanner getOldEntity(MiaoBannerParam param) {
        return this.getById(getKey(param));
    }

    private MiaoBanner getEntity(MiaoBannerParam param) {
        MiaoBanner entity = new MiaoBanner();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }
    @Override
    public String updateImg(String fileId) {
        FileInfo file = fileInfoService.getById(fileId);
        String fileName=file.getFinalName();
        String filePath = "/image/"+fileName;
        return filePath;
    }

}
