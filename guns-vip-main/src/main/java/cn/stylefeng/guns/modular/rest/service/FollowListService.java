package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.FollowList;
import cn.stylefeng.guns.modular.rest.model.params.FollowListParam;
import cn.stylefeng.guns.modular.rest.model.result.FollowListResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 关注列表
 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface FollowListService extends IService<FollowList> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void add(FollowListParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void delete(FollowListParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void update(FollowListParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    FollowListResult findBySpec(FollowListParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<FollowListResult> findListBySpec(FollowListParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
     PageResult<FollowListResult> findPageBySpec(FollowListParam param);

}
