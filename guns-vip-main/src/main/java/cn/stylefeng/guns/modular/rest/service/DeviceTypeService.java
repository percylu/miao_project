package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.DeviceType;
import cn.stylefeng.guns.modular.rest.model.params.DeviceTypeParam;
import cn.stylefeng.guns.modular.rest.model.result.DeviceTypeResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备类型 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
public interface DeviceTypeService extends IService<DeviceType> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void add(DeviceTypeParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void delete(DeviceTypeParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void update(DeviceTypeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    DeviceTypeResult findBySpec(DeviceTypeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<DeviceTypeResult> findListBySpec(DeviceTypeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
     PageResult<DeviceTypeResult> findPageBySpec(DeviceTypeParam param);

}
