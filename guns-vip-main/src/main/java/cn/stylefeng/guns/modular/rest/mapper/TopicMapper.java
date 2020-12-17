package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.Topic;
import cn.stylefeng.guns.modular.rest.model.params.TopicParam;
import cn.stylefeng.guns.modular.rest.model.result.TopicResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 话题维护 Mapper 接口
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface TopicMapper extends BaseMapper<Topic> {

    /**
     * 获取列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<TopicResult> customList(@Param("paramCondition") TopicParam paramCondition);

    /**
     * 获取map列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") TopicParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    Page<TopicResult> customPageList(@Param("page") Page page, @Param("paramCondition") TopicParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") TopicParam paramCondition);

}
