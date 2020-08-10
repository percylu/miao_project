package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.Banner;
import cn.stylefeng.guns.modular.rest.model.params.BannerParam;
import cn.stylefeng.guns.modular.rest.model.result.BannerResult;
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
public interface BannerMapper extends BaseMapper<Banner> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    List<BannerResult> customList();

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") BannerParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    Page<BannerResult> customPageList(@Param("page") Page page, @Param("paramCondition") BannerParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-08
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") BannerParam paramCondition);

}
