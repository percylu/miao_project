package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoDevice;
import cn.stylefeng.guns.modular.miao.model.params.MiaoDeviceParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoDeviceResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备管理 服务类
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
public interface MiaoDeviceService extends IService<MiaoDevice> {

    /**
     * 新增
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void add(MiaoDeviceParam param);

    /**
     * 删除
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void delete(MiaoDeviceParam param);

    /**
     * 更新
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void update(MiaoDeviceParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    MiaoDeviceResult findBySpec(MiaoDeviceParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    List<MiaoDeviceResult> findListBySpec(MiaoDeviceParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
     LayuiPageInfo findPageBySpec(MiaoDeviceParam param);

}
