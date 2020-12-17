package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.CommentList;
import cn.stylefeng.guns.modular.rest.model.params.CommentListParam;
import cn.stylefeng.guns.modular.rest.model.result.CommentListResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 评论列表
 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface CommentListService extends IService<CommentList> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void add(CommentListParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void delete(CommentListParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void update(CommentListParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    CommentListResult findBySpec(CommentListParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<CommentListResult> findListBySpec(CommentListParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
     PageResult<CommentListResult> findPageBySpec(CommentListParam param);

}
