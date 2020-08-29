package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.Pet;
import cn.stylefeng.guns.modular.rest.model.params.PetParam;
import cn.stylefeng.guns.modular.rest.model.result.PetResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 宠物管理 Mapper 接口
 * </p>
 *
 * @author percylu
 * @since 2020-08-21
 */
public interface PetMapper extends BaseMapper<Pet> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-21
     */
    List<PetResult> customList(@Param("paramCondition") PetParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-21
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") PetParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-21
     */
    Page<PetResult> customPageList(@Param("page") Page page, @Param("paramCondition") PetParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-21
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") PetParam paramCondition);

}
