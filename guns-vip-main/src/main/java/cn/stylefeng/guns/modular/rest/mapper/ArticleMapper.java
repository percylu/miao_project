package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.Article;
import cn.stylefeng.guns.modular.rest.model.params.ArticleParam;
import cn.stylefeng.guns.modular.rest.model.result.ArticleResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 喵小小文章 Mapper 接口
 * </p>
 *
 * @author percylu
 * @since 2020-08-14
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    List<ArticleResult> customList(@Param("paramCondition") ArticleParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ArticleParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    Page<ArticleResult> customPageList(@Param("page") Page page, @Param("paramCondition") ArticleParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ArticleParam paramCondition);

}
