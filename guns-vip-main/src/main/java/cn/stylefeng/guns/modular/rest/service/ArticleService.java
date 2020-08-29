package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Article;
import cn.stylefeng.guns.modular.rest.model.params.ArticleParam;
import cn.stylefeng.guns.modular.rest.model.result.ArticleResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 喵小小文章 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-14
 */
public interface ArticleService extends IService<Article> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-14
     */
    void add(ArticleParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-14
     */
    void delete(ArticleParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-14
     */
    void update(ArticleParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-14
     */
    ArticleResult findBySpec(ArticleParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-14
     */
    List<ArticleResult> findListBySpec(ArticleParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-14
     */
     PageResult<ArticleResult> findPageBySpec(ArticleParam param);

}
