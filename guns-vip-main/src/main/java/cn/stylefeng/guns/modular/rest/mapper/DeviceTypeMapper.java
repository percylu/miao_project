package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.DeviceType;
import cn.stylefeng.guns.modular.rest.model.params.DeviceTypeParam;
import cn.stylefeng.guns.modular.rest.model.result.DeviceTypeResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
 * @since 2020-08-03
 */
public interface DeviceTypeMapper extends BaseMapper<DeviceType> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<DeviceTypeResult> customList(@Param("paramCondition") DeviceTypeParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") DeviceTypeParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    Page<DeviceTypeResult> customPageList(@Param("page") Page page, @Param("paramCondition") DeviceTypeParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") DeviceTypeParam paramCondition);

}
