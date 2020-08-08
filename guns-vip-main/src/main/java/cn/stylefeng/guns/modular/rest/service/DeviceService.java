package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Device;
import cn.stylefeng.guns.modular.rest.model.params.DeviceParam;
import cn.stylefeng.guns.modular.rest.model.result.DeviceResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备管理 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
public interface DeviceService extends IService<Device> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void add(DeviceParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void delete(DeviceParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void update(DeviceParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    DeviceResult findBySpec(DeviceParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<DeviceResult> findListBySpec(DeviceParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
     PageResult<DeviceResult> findPageBySpec(DeviceParam param);

}
