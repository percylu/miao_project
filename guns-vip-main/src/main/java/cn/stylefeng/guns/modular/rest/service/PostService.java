package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Post;
import cn.stylefeng.guns.modular.rest.model.params.PostParam;
import cn.stylefeng.guns.modular.rest.model.result.PostResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 个人动态 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface PostService extends IService<Post> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void add(PostParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void delete(PostParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void update(PostParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    PostResult findBySpec(PostParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<PostResult> findListBySpec(PostParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
     PageResult<PostResult> findPageBySpec(PostParam param);

}
