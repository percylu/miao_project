package cn.stylefeng.guns.modular.miao.mapper;

import cn.stylefeng.guns.modular.miao.entity.MiaoProduct;
import cn.stylefeng.guns.modular.miao.model.params.MiaoProductParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoProductResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品维护 Mapper 接口
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-05
 */
public interface MiaoProductMapper extends BaseMapper<MiaoProduct> {

    /**
     * 获取列表
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    List<MiaoProductResult> customList(@Param("paramCondition") MiaoProductParam paramCondition);

    /**
     * 获取map列表
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoProductParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    Page<MiaoProductResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoProductParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoProductParam paramCondition);

}
