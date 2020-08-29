package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoType;
import cn.stylefeng.guns.modular.miao.model.params.MiaoTypeParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoTypeResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  宠物品种 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-20
 */
public interface MiaoTypeService extends IService<MiaoType> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-20
     */
    void add(MiaoTypeParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-20
     */
    void delete(MiaoTypeParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-20
     */
    void update(MiaoTypeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-20
     */
    MiaoTypeResult findBySpec(MiaoTypeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-20
     */
    List<MiaoTypeResult> findListBySpec(MiaoTypeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-20
     */
     LayuiPageInfo findPageBySpec(MiaoTypeParam param);

}
