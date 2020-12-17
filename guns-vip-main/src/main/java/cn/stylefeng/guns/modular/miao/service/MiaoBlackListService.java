package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoBlackList;
import cn.stylefeng.guns.modular.miao.model.params.MiaoBlackListParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoBlackListResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 黑名单列表
 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
public interface MiaoBlackListService extends IService<MiaoBlackList> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void add(MiaoBlackListParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void delete(MiaoBlackListParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void update(MiaoBlackListParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    MiaoBlackListResult findBySpec(MiaoBlackListParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<MiaoBlackListResult> findListBySpec(MiaoBlackListParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
     LayuiPageInfo findPageBySpec(MiaoBlackListParam param);

}
