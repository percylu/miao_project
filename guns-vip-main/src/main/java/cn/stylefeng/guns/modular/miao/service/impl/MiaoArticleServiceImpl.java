package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoArticle;
import cn.stylefeng.guns.modular.miao.mapper.MiaoArticleMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoArticleParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoArticleResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoArticleService;
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
 * 喵小小文章 服务实现类
 * </p>
 *
 * @author  percylu
 * @since 2020-08-14
 */
@Service
public class MiaoArticleServiceImpl extends ServiceImpl<MiaoArticleMapper, MiaoArticle> implements MiaoArticleService {
    @Autowired
    private FileInfoService fileInfoService;
    @Override
    public void add(MiaoArticleParam param){
        MiaoArticle entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoArticleParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoArticleParam param){
        MiaoArticle oldEntity = getOldEntity(param);
        MiaoArticle newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoArticleResult findBySpec(MiaoArticleParam param){
        return null;
    }

    @Override
    public List<MiaoArticleResult> findListBySpec(MiaoArticleParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoArticleParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MiaoArticleParam param){
        return param.getArticleId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoArticle getOldEntity(MiaoArticleParam param) {
        return this.getById(getKey(param));
    }

    private MiaoArticle getEntity(MiaoArticleParam param) {
        MiaoArticle entity = new MiaoArticle();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }
    @Override
    public String updatePic(String fileId) {
        FileInfo file = fileInfoService.getById(fileId);
        String fileName=file.getFinalName();
        String filePath = "/image/"+fileName;
        return filePath;
    }
}
