package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoUser;
import cn.stylefeng.guns.modular.rest.model.params.UserParam;
import cn.stylefeng.guns.modular.rest.model.result.UserResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * App用户管理 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
public interface UserService extends IService<RestMiaoUser> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void add(UserParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void delete(UserParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void update(UserParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    UserResult findBySpec(UserParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<UserResult> findListBySpec(UserParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
     PageResult<UserResult> findPageBySpec(UserParam param);



}
