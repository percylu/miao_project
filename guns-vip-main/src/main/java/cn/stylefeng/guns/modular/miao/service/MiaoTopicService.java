package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoTopic;
import cn.stylefeng.guns.modular.miao.model.params.MiaoTopicParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoTopicResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 话题维护 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-14
 */
public interface MiaoTopicService extends IService<MiaoTopic> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    void add(MiaoTopicParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    void delete(MiaoTopicParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    void update(MiaoTopicParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    MiaoTopicResult findBySpec(MiaoTopicParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
    List<MiaoTopicResult> findListBySpec(MiaoTopicParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-14
     */
     LayuiPageInfo findPageBySpec(MiaoTopicParam param);

}
