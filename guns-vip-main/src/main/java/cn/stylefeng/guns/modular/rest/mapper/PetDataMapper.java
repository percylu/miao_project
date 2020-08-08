package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.PetData;
import cn.stylefeng.guns.modular.rest.model.params.PetDataParam;
import cn.stylefeng.guns.modular.rest.model.result.PetDataResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 宠物数据
 Mapper 接口
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
public interface PetDataMapper extends BaseMapper<PetData> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<PetDataResult> customList(@Param("paramCondition") PetDataParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") PetDataParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    Page<PetDataResult> customPageList(@Param("page") Page page, @Param("paramCondition") PetDataParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") PetDataParam paramCondition);

}
