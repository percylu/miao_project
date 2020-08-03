package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.RestMiaoDeviceType;
import cn.stylefeng.guns.modular.rest.model.params.MiaoDeviceTypeParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoDeviceTypeResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备类型 Mapper 接口
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
public interface MiaoDeviceTypeMapper extends BaseMapper<RestMiaoDeviceType> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    List<MiaoDeviceTypeResult> customList(@Param("paramCondition") MiaoDeviceTypeParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoDeviceTypeParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    Page<MiaoDeviceTypeResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoDeviceTypeParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoDeviceTypeParam paramCondition);

}
