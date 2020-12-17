package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Topic;
import cn.stylefeng.guns.modular.rest.model.params.TopicParam;
import cn.stylefeng.guns.modular.rest.model.result.TopicResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 话题维护 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface TopicService extends IService<Topic> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void add(TopicParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void delete(TopicParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void update(TopicParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    TopicResult findBySpec(TopicParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<TopicResult> findListBySpec(TopicParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
     PageResult<TopicResult> findPageBySpec(TopicParam param);

}
