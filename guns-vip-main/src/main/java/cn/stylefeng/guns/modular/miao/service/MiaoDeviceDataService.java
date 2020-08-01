package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoDeviceData;
import cn.stylefeng.guns.modular.miao.model.params.MiaoDeviceDataParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoDeviceDataResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备数据 服务类
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
public interface MiaoDeviceDataService extends IService<MiaoDeviceData> {

    /**
     * 新增
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void add(MiaoDeviceDataParam param);

    /**
     * 删除
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void delete(MiaoDeviceDataParam param);

    /**
     * 更新
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void update(MiaoDeviceDataParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    MiaoDeviceDataResult findBySpec(MiaoDeviceDataParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    List<MiaoDeviceDataResult> findListBySpec(MiaoDeviceDataParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
     LayuiPageInfo findPageBySpec(MiaoDeviceDataParam param);

}
