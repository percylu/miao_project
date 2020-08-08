package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Banner;
import cn.stylefeng.guns.modular.rest.model.params.BannerParam;
import cn.stylefeng.guns.modular.rest.model.result.BannerResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 广告图管理 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-08
 */
public interface BannerService extends IService<Banner> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-08
     */
    void add(BannerParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-08
     */
    void delete(BannerParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-08
     */
    void update(BannerParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-08
     */
    BannerResult findBySpec(BannerParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-08
     */
    List<BannerResult> findListBySpec(BannerParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-08
     */
     PageResult<BannerResult> findPageBySpec(BannerParam param);

}
