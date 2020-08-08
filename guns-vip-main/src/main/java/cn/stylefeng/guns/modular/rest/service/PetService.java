package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.roses.kernel.model.page.PageResult;
import cn.stylefeng.guns.modular.rest.entity.Pet;
import cn.stylefeng.guns.modular.rest.model.params.PetParam;
import cn.stylefeng.guns.modular.rest.model.result.PetResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宠物管理 服务类
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
public interface PetService extends IService<Pet> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void add(PetParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void delete(PetParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-03
     */
    void update(PetParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    PetResult findBySpec(PetParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
    List<PetResult> findListBySpec(PetParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-03
     */
     PageResult<PetResult> findPageBySpec(PetParam param);

}
