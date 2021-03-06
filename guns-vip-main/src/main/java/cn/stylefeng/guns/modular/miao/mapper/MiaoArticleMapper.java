package cn.stylefeng.guns.modular.miao.mapper;

import cn.stylefeng.guns.modular.miao.entity.MiaoArticle;
import cn.stylefeng.guns.modular.miao.model.params.MiaoArticleParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoArticleResult;
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
 * @author  percylu
 * @since 2020-08-14
 */
public interface MiaoArticleMapper extends BaseMapper<MiaoArticle> {

    /**
     * 获取列表
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    List<MiaoArticleResult> customList(@Param("paramCondition") MiaoArticleParam paramCondition);

    /**
     * 获取map列表
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoArticleParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    Page<MiaoArticleResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoArticleParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoArticleParam paramCondition);

}
