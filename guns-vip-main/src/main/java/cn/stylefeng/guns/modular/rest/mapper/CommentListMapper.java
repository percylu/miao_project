package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.CommentList;
import cn.stylefeng.guns.modular.rest.model.params.CommentListParam;
import cn.stylefeng.guns.modular.rest.model.result.CommentListResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论列表
 Mapper 接口
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface CommentListMapper extends BaseMapper<CommentList> {

    /**
     * 获取列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<CommentListResult> customList(@Param("paramCondition") CommentListParam paramCondition);

    /**
     * 获取map列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") CommentListParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    Page<CommentListResult> customPageList(@Param("page") Page page, @Param("paramCondition") CommentListParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") CommentListParam paramCondition);

}
