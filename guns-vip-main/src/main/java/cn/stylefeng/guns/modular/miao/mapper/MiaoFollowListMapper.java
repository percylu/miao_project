package cn.stylefeng.guns.modular.miao.mapper;

import cn.stylefeng.guns.modular.miao.entity.MiaoFollowList;
import cn.stylefeng.guns.modular.miao.model.params.MiaoFollowListParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoFollowListResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 关注列表
 Mapper 接口
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
public interface MiaoFollowListMapper extends BaseMapper<MiaoFollowList> {

    /**
     * 获取列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<MiaoFollowListResult> customList(@Param("paramCondition") MiaoFollowListParam paramCondition);

    /**
     * 获取map列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoFollowListParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    Page<MiaoFollowListResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoFollowListParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoFollowListParam paramCondition);

}
