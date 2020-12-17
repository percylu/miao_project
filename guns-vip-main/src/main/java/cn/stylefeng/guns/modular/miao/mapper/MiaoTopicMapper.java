package cn.stylefeng.guns.modular.miao.mapper;

import cn.stylefeng.guns.modular.miao.entity.MiaoTopic;
import cn.stylefeng.guns.modular.miao.model.params.MiaoTopicParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoTopicResult;
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
 * @since 2020-12-14
 */
public interface MiaoTopicMapper extends BaseMapper<MiaoTopic> {

    /**
     * 获取列表
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    List<MiaoTopicResult> customList(@Param("paramCondition") MiaoTopicParam paramCondition);

    /**
     * 获取map列表
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoTopicParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    Page<MiaoTopicResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoTopicParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoTopicParam paramCondition);

}
