package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoLikeList;
import cn.stylefeng.guns.modular.miao.model.params.MiaoLikeListParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoLikeListResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 点赞列表
 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
public interface MiaoLikeListService extends IService<MiaoLikeList> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void add(MiaoLikeListParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void delete(MiaoLikeListParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void update(MiaoLikeListParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    MiaoLikeListResult findBySpec(MiaoLikeListParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<MiaoLikeListResult> findListBySpec(MiaoLikeListParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
     LayuiPageInfo findPageBySpec(MiaoLikeListParam param);

}
