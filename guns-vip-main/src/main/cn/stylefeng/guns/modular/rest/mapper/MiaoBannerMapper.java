package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.MiaoBanner;
import cn.stylefeng.guns.modular.rest.model.params.MiaoBannerParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoBannerResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 广告图管理 Mapper 接口
 * </p>
 *
 * @author percylu
 * @since 2020-08-08
 */
public interface MiaoBannerMapper extends BaseMapper<MiaoBanner> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    List<MiaoBannerResult> customList(@Param("paramCondition") MiaoBannerParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoBannerParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    Page<MiaoBannerResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoBannerParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoBannerParam paramCondition);

}
