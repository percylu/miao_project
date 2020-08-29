package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoNotice;
import cn.stylefeng.guns.modular.miao.model.params.MiaoNoticeParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoNoticeResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通知表 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-28
 */
public interface MiaoNoticeService extends IService<MiaoNotice> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-28
     */
    void add(MiaoNoticeParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-28
     */
    void delete(MiaoNoticeParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-28
     */
    void update(MiaoNoticeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-28
     */
    MiaoNoticeResult findBySpec(MiaoNoticeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-28
     */
    List<MiaoNoticeResult> findListBySpec(MiaoNoticeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-28
     */
    Page<Map<String, Object>> findPageBySpec(MiaoNoticeParam param);

}
