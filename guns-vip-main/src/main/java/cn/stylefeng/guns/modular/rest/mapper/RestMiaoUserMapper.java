package cn.stylefeng.guns.modular.rest.mapper;

import cn.stylefeng.guns.core.auth.model.MiaoLoginUser;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoUser;
import cn.stylefeng.guns.modular.rest.model.params.UserParam;
import cn.stylefeng.guns.modular.rest.model.result.UserResult;
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
 * @since 2020-08-03
 */
public interface RestMiaoUserMapper extends BaseMapper<RestMiaoUser> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<UserResult> customList(@Param("paramCondition") UserParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") UserParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    Page<UserResult> customPageList(@Param("page") Page page, @Param("paramCondition") UserParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-03
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") UserParam paramCondition);
    /**
     * 通过账号获取用户
     */
    RestMiaoUser getByAccount(@Param("account") String account);

}
