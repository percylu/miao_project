package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoBanner;
import cn.stylefeng.guns.modular.miao.model.params.MiaoBannerParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoBannerResult;
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
public interface MiaoBannerService extends IService<MiaoBanner> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-08
     */
    void add(MiaoBannerParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-08
     */
    void delete(MiaoBannerParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-08
     */
    void update(MiaoBannerParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-08
     */
    MiaoBannerResult findBySpec(MiaoBannerParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-08
     */
    List<MiaoBannerResult> findListBySpec(MiaoBannerParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-08
     */
     LayuiPageInfo findPageBySpec(MiaoBannerParam param);

     String updateImg(String fileId);

}
