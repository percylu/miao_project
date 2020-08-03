package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoPetData;
import cn.stylefeng.guns.modular.rest.model.params.MiaoPetDataParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoPetDataResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宠物数据
 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
public interface MiaoPetDataService extends IService<RestMiaoPetData> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void add(MiaoPetDataParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void delete(MiaoPetDataParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void update(MiaoPetDataParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    MiaoPetDataResult findBySpec(MiaoPetDataParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    List<MiaoPetDataResult> findListBySpec(MiaoPetDataParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
     PageResult<MiaoPetDataResult> findPageBySpec(MiaoPetDataParam param);

}
