package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.BlackList;
import cn.stylefeng.guns.modular.rest.model.params.BlackListParam;
import cn.stylefeng.guns.modular.rest.model.result.BlackListResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 黑名单列表
 Mapper 接口
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface BlackListMapper extends BaseMapper<BlackList> {

    /**
     * 获取列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<BlackListResult> customList(@Param("paramCondition") BlackListParam paramCondition);

    /**
     * 获取map列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") BlackListParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    Page<BlackListResult> customPageList(@Param("page") Page page, @Param("paramCondition") BlackListParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") BlackListParam paramCondition);

}
