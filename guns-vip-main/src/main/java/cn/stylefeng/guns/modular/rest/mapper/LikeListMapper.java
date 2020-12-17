package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.LikeList;
import cn.stylefeng.guns.modular.rest.model.params.LikeListParam;
import cn.stylefeng.guns.modular.rest.model.result.LikeListResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 点赞列表
 Mapper 接口
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface LikeListMapper extends BaseMapper<LikeList> {

    /**
     * 获取列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<LikeListResult> customList(@Param("paramCondition") LikeListParam paramCondition);

    /**
     * 获取map列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") LikeListParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    Page<LikeListResult> customPageList(@Param("page") Page page, @Param("paramCondition") LikeListParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") LikeListParam paramCondition);

}
