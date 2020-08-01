package cn.stylefeng.guns.modular.miao.mapper;

import cn.stylefeng.guns.modular.miao.entity.MiaoDevice;
import cn.stylefeng.guns.modular.miao.model.params.MiaoDeviceParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoDeviceResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备管理 Mapper 接口
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
public interface MiaoDeviceMapper extends BaseMapper<MiaoDevice> {

    /**
     * 获取列表
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    List<MiaoDeviceResult> customList(@Param("paramCondition") MiaoDeviceParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoDeviceParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    Page<MiaoDeviceResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoDeviceParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoDeviceParam paramCondition);

}
