package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Third;
import cn.stylefeng.guns.modular.rest.model.params.ThirdParam;
import cn.stylefeng.guns.modular.rest.model.result.ThirdResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 第三方ID 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-30
 */
public interface ThirdService extends IService<Third> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-30
     */
    void add(ThirdParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-30
     */
    void delete(ThirdParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-30
     */
    void update(ThirdParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-30
     */
    ThirdResult findBySpec(ThirdParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-30
     */
    List<ThirdResult> findListBySpec(ThirdParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-30
     */
     PageResult<ThirdResult> findPageBySpec(ThirdParam param);

}
