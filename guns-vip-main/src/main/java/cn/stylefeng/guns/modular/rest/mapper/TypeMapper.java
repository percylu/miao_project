package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.Type;
import cn.stylefeng.guns.modular.rest.model.params.TypeParam;
import cn.stylefeng.guns.modular.rest.model.result.TypeResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  宠物品种 Mapper 接口
 * </p>
 *
 * @author percylu
 * @since 2020-08-23
 */
public interface TypeMapper extends BaseMapper<Type> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-23
     */
    List<TypeResult> customList(@Param("paramCondition") TypeParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-23
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") TypeParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-23
     */
    Page<TypeResult> customPageList(@Param("page") Page page, @Param("paramCondition") TypeParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-23
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") TypeParam paramCondition);

}
