package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.LikeList;
import cn.stylefeng.guns.modular.rest.model.params.LikeListParam;
import cn.stylefeng.guns.modular.rest.model.result.LikeListResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 点赞列表
 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface LikeListService extends IService<LikeList> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void add(LikeListParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void delete(LikeListParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void update(LikeListParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    LikeListResult findBySpec(LikeListParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<LikeListResult> findListBySpec(LikeListParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
     PageResult<LikeListResult> findPageBySpec(LikeListParam param);

}
