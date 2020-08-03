package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.modular.rest.entity.RestMiaoUser;
import cn.stylefeng.guns.modular.rest.model.params.MiaoUserParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoUserResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * App用户管理 Mapper 接口
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
public interface MiaoUserMapper extends BaseMapper<RestMiaoUser> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    List<MiaoUserResult> customList(@Param("paramCondition") MiaoUserParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoUserParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    Page<MiaoUserResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoUserParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-02
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoUserParam paramCondition);

}
