package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.ShieldList;
import cn.stylefeng.guns.modular.rest.model.params.ShieldListParam;
import cn.stylefeng.guns.modular.rest.model.result.ShieldListResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 屏蔽列表
 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface ShieldListService extends IService<ShieldList> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void add(ShieldListParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void delete(ShieldListParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void update(ShieldListParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    ShieldListResult findBySpec(ShieldListParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<ShieldListResult> findListBySpec(ShieldListParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
     PageResult<ShieldListResult> findPageBySpec(ShieldListParam param);

}
