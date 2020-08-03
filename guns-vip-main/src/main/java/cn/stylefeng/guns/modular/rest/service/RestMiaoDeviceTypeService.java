package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoDeviceType;
import cn.stylefeng.guns.modular.rest.model.params.MiaoDeviceTypeParam;
import cn.stylefeng.guns.modular.rest.model.result.MiaoDeviceTypeResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备类型 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
public interface MiaoDeviceTypeService extends IService<RestMiaoDeviceType> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void add(MiaoDeviceTypeParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void delete(MiaoDeviceTypeParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-02
     */
    void update(MiaoDeviceTypeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    MiaoDeviceTypeResult findBySpec(MiaoDeviceTypeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
    List<MiaoDeviceTypeResult> findListBySpec(MiaoDeviceTypeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-02
     */
     PageResult<MiaoDeviceTypeResult> findPageBySpec(MiaoDeviceTypeParam param);

}
