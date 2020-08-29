package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoCommonSetting;
import cn.stylefeng.guns.modular.miao.model.params.MiaoCommonSettingParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoCommonSettingResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * App 通用设置 服务类
 * </p>
 *
 * @author  percylu
 * @since 2020-08-14
 */
public interface MiaoCommonSettingService extends IService<MiaoCommonSetting> {

    /**
     * 新增
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    void add(MiaoCommonSettingParam param);

    /**
     * 删除
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    void delete(MiaoCommonSettingParam param);

    /**
     * 更新
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    void update(MiaoCommonSettingParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    MiaoCommonSettingResult findBySpec(MiaoCommonSettingParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    List<MiaoCommonSettingResult> findListBySpec(MiaoCommonSettingParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author  percylu
     * @Date 2020-08-14
     */
     LayuiPageInfo findPageBySpec(MiaoCommonSettingParam param);

}
