package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.DeviceData;
import cn.stylefeng.guns.modular.rest.model.params.DeviceDataParam;
import cn.stylefeng.guns.modular.rest.model.result.DeviceDataResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备数据 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
public interface DeviceDataService extends IService<DeviceData> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void add(DeviceDataParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void delete(DeviceDataParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void update(DeviceDataParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    DeviceDataResult findBySpec(DeviceDataParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<DeviceDataResult> findListBySpec(DeviceDataParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
     PageResult<DeviceDataResult> findPageBySpec(DeviceDataParam param);

}
