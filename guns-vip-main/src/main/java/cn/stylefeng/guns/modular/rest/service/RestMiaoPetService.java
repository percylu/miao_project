package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoPet;
import cn.stylefeng.guns.modular.rest.model.params.MiaoPetParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoPetResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宠物管理 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
public interface MiaoPetService extends IService<RestMiaoPet> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void add(MiaoPetParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void delete(MiaoPetParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void update(MiaoPetParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    MiaoPetResult findBySpec(MiaoPetParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    List<MiaoPetResult> findListBySpec(MiaoPetParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
     PageResult<MiaoPetResult> findPageBySpec(MiaoPetParam param);

}
