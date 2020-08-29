package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoDeviceType;
import cn.stylefeng.guns.modular.miao.model.params.MiaoDeviceTypeParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoDeviceTypeResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备类型 服务类
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
public interface MiaoDeviceTypeService extends IService<MiaoDeviceType> {

    /**
     * 新增
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void add(MiaoDeviceTypeParam param);

    /**
     * 删除
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void delete(MiaoDeviceTypeParam param);

    /**
     * 更新
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void update(MiaoDeviceTypeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    MiaoDeviceTypeResult findBySpec(MiaoDeviceTypeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    List<MiaoDeviceTypeResult> findListBySpec(MiaoDeviceTypeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
     LayuiPageInfo findPageBySpec(MiaoDeviceTypeParam param);

    /**
     * 上传设备图片
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
     String updatePic(String fileId);


}
