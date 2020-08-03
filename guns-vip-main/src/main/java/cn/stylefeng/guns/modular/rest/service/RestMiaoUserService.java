package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoUser;
import cn.stylefeng.guns.modular.rest.model.params.MiaoUserParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoUserResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * App用户管理 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
public interface MiaoUserService extends IService<RestMiaoUser> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void add(MiaoUserParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void delete(MiaoUserParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void update(MiaoUserParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    MiaoUserResult findBySpec(MiaoUserParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    List<MiaoUserResult> findListBySpec(MiaoUserParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
     PageResult<MiaoUserResult> findPageBySpec(MiaoUserParam param);

}
