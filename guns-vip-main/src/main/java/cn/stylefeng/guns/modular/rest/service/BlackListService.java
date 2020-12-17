package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.BlackList;
import cn.stylefeng.guns.modular.rest.model.params.BlackListParam;
import cn.stylefeng.guns.modular.rest.model.result.BlackListResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 黑名单列表
 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
public interface BlackListService extends IService<BlackList> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void add(BlackListParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void delete(BlackListParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    void update(BlackListParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    BlackListResult findBySpec(BlackListParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
    List<BlackListResult> findListBySpec(BlackListParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-15
     */
     PageResult<BlackListResult> findPageBySpec(BlackListParam param);

}
