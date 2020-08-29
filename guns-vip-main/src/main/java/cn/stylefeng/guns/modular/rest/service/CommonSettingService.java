package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.CommonSetting;
import cn.stylefeng.guns.modular.rest.model.params.CommonSettingParam;
import cn.stylefeng.guns.modular.rest.model.result.CommonSettingResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * App 通用设置 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-14
 */
public interface CommonSettingService extends IService<CommonSetting> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-14
     */
    void add(CommonSettingParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-14
     */
    void delete(CommonSettingParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-14
     */
    void update(CommonSettingParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-14
     */
    CommonSetting findBySpec(CommonSettingParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-14
     */
    List<CommonSettingResult> findListBySpec(CommonSettingParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-14
     */
     PageResult<CommonSettingResult> findPageBySpec(CommonSettingParam param);

}
