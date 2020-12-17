package cn.stylefeng.guns.modular.miao.mapper;

import cn.stylefeng.guns.modular.miao.entity.MiaoBlackList;
import cn.stylefeng.guns.modular.miao.model.params.MiaoBlackListParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoBlackListResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 黑名单列表
 Mapper 接口
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
public interface MiaoBlackListMapper extends BaseMapper<MiaoBlackList> {

    /**
     * 获取列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<MiaoBlackListResult> customList(@Param("paramCondition") MiaoBlackListParam paramCondition);

    /**
     * 获取map列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoBlackListParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    Page<MiaoBlackListResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoBlackListParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoBlackListParam paramCondition);

}
