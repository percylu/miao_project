package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.Third;
import cn.stylefeng.guns.modular.rest.model.params.ThirdParam;
import cn.stylefeng.guns.modular.rest.model.result.ThirdResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 第三方ID Mapper 接口
 * </p>
 *
 * @author percylu
 * @since 2020-08-30
 */
public interface ThirdMapper extends BaseMapper<Third> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-30
     */
    List<ThirdResult> customList(@Param("paramCondition") ThirdParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-30
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ThirdParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-30
     */
    Page<ThirdResult> customPageList(@Param("page") Page page, @Param("paramCondition") ThirdParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-30
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ThirdParam paramCondition);

}
