package cn.stylefeng.guns.modular.miao.mapper;

import cn.stylefeng.guns.modular.miao.entity.MiaoPost;
import cn.stylefeng.guns.modular.miao.model.params.MiaoPostParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoPostResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 个人动态 Mapper 接口
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
public interface MiaoPostMapper extends BaseMapper<MiaoPost> {

    /**
     * 获取列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<MiaoPostResult> customList(@Param("paramCondition") MiaoPostParam paramCondition);

    /**
     * 获取map列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoPostParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    Page<MiaoPostResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoPostParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoPostParam paramCondition);

}
