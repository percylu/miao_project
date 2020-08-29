package cn.stylefeng.guns.modular.rest.service.impl;

import cn.stylefeng.guns.modular.rest.entity.CommonSetting;
import cn.stylefeng.roses.core.page.PageFactory;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Article;
import cn.stylefeng.guns.modular.rest.mapper.ArticleMapper;
import cn.stylefeng.guns.modular.rest.model.params.ArticleParam;
import cn.stylefeng.guns.modular.rest.model.result.ArticleResult;
import  cn.stylefeng.guns.modular.rest.service.ArticleService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 喵小小文章 服务实现类
 * </p>
 *
 * @author percylu
 * @since 2020-08-14
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public void add(ArticleParam param){
        Article entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ArticleParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ArticleParam param){
        Article oldEntity = getOldEntity(param);
        Article newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ArticleResult findBySpec(ArticleParam param){
        Map<String,Object> map= new HashMap<>();
        List<ArticleResult> list=this.baseMapper.customList(param);
        return list instanceof List?list.get(0):null;
    }

    @Override
    public List<ArticleResult> findListBySpec(ArticleParam param){
        return null;
    }

    @Override
    public PageResult<ArticleResult> findPageBySpec(ArticleParam param){
        Page pageContext = getPageContext();
        IPage<ArticleResult> page = this.baseMapper.customPageList(pageContext, param);
        return new PageResult<>(page);
    }

    private Serializable getKey(ArticleParam param){
        return param.getArticleId();
    }

    private Page getPageContext() {
        return PageFactory.defaultPage();
    }

    private Article getOldEntity(ArticleParam param) {
        return this.getById(getKey(param));
    }

    private Article getEntity(ArticleParam param) {
        Article entity = new Article();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
