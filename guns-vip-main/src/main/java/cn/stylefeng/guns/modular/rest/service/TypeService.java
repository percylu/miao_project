package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Type;
import cn.stylefeng.guns.modular.rest.model.params.TypeParam;
import cn.stylefeng.guns.modular.rest.model.result.TypeResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  宠物品种 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-23
 */
public interface TypeService extends IService<Type> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-23
     */
    void add(TypeParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-23
     */
    void delete(TypeParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-23
     */
    void update(TypeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-23
     */
    TypeResult findBySpec(TypeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-23
     */
    List<TypeResult> findListBySpec(TypeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-23
     */
     PageResult<TypeResult> findPageBySpec(TypeParam param);

}
