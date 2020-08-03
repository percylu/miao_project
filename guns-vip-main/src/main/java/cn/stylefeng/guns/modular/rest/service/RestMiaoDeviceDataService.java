package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoDeviceData;
import cn.stylefeng.guns.modular.rest.model.params.MiaoDeviceDataParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoDeviceDataResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备数据 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
public interface MiaoDeviceDataService extends IService<RestMiaoDeviceData> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void add(MiaoDeviceDataParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void delete(MiaoDeviceDataParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void update(MiaoDeviceDataParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    MiaoDeviceDataResult findBySpec(MiaoDeviceDataParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    List<MiaoDeviceDataResult> findListBySpec(MiaoDeviceDataParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
     PageResult<MiaoDeviceDataResult> findPageBySpec(MiaoDeviceDataParam param);

}
