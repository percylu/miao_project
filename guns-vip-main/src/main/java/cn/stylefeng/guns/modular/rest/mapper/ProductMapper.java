package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.Product;
import cn.stylefeng.guns.modular.rest.model.params.ProductParam;
import cn.stylefeng.guns.modular.rest.model.result.ProductResult;
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
 * @since 2020-12-07
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 获取列表
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    List<ProductResult> customList(@Param("paramCondition") ProductParam paramCondition);

    /**
     * 获取map列表
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ProductParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    Page<ProductResult> customPageList(@Param("page") Page page, @Param("paramCondition") ProductParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author byteEngine
     * @Date 2020-12-07
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ProductParam paramCondition);

}
