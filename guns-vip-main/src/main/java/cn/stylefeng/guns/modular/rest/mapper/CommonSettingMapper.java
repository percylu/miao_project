package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.CommonSetting;
import cn.stylefeng.guns.modular.rest.model.params.CommonSettingParam;
import cn.stylefeng.guns.modular.rest.model.result.CommonSettingResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * App 通用设置 Mapper 接口
 * </p>
 *
 * @author percylu
 * @since 2020-08-14
 */
public interface CommonSettingMapper extends BaseMapper<CommonSetting> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    List<CommonSettingResult> customList(@Param("paramCondition") CommonSettingParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") CommonSettingParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    Page<CommonSettingResult> customPageList(@Param("page") Page page, @Param("paramCondition") CommonSettingParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-14
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") CommonSettingParam paramCondition);

}
