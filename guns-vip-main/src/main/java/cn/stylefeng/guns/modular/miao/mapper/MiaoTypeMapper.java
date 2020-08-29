package cn.stylefeng.guns.modular.miao.mapper;

import cn.stylefeng.guns.modular.miao.entity.MiaoType;
import cn.stylefeng.guns.modular.miao.model.params.MiaoTypeParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoTypeResult;
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
 * @since 2020-08-20
 */
public interface MiaoTypeMapper extends BaseMapper<MiaoType> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-20
     */
    List<MiaoTypeResult> customList(@Param("paramCondition") MiaoTypeParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-20
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoTypeParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-20
     */
    Page<MiaoTypeResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoTypeParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-20
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoTypeParam paramCondition);

}
