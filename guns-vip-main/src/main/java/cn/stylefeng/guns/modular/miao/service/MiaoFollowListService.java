package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoFollowList;
import cn.stylefeng.guns.modular.miao.model.params.MiaoFollowListParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoFollowListResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 关注列表
 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
public interface MiaoFollowListService extends IService<MiaoFollowList> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void add(MiaoFollowListParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void delete(MiaoFollowListParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void update(MiaoFollowListParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    MiaoFollowListResult findBySpec(MiaoFollowListParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<MiaoFollowListResult> findListBySpec(MiaoFollowListParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
     LayuiPageInfo findPageBySpec(MiaoFollowListParam param);

}
