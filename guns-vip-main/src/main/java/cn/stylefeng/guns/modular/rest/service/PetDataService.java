package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.PetData;
import cn.stylefeng.guns.modular.rest.model.params.PetDataParam;
import cn.stylefeng.guns.modular.rest.model.result.PetDataResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宠物数据
 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
public interface PetDataService extends IService<PetData> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void add(PetDataParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void delete(PetDataParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void update(PetDataParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    PetDataResult findBySpec(PetDataParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<PetDataResult> findListBySpec(PetDataParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
     PageResult<PetDataResult> findPageBySpec(PetDataParam param);

}
