package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoDevice;
import cn.stylefeng.guns.modular.rest.model.params.MiaoDeviceParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoDeviceResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备管理 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
public interface MiaoDeviceService extends IService<RestMiaoDevice> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void add(MiaoDeviceParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void delete(MiaoDeviceParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void update(MiaoDeviceParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    MiaoDeviceResult findBySpec(MiaoDeviceParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    List<MiaoDeviceResult> findListBySpec(MiaoDeviceParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
     PageResult<MiaoDeviceResult> findPageBySpec(MiaoDeviceParam param);

}
