package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoCommentList;
import cn.stylefeng.guns.modular.miao.model.params.MiaoCommentListParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoCommentListResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 评论列表
 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
public interface MiaoCommentListService extends IService<MiaoCommentList> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void add(MiaoCommentListParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void delete(MiaoCommentListParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void update(MiaoCommentListParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    MiaoCommentListResult findBySpec(MiaoCommentListParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<MiaoCommentListResult> findListBySpec(MiaoCommentListParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
     LayuiPageInfo findPageBySpec(MiaoCommentListParam param);

}
