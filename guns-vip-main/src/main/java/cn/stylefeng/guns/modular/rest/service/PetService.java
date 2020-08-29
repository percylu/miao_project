package cn.stylefeng.guns.modular.rest.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
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
 * @since 2020-08-21
 */
public interface PetService extends IService<Pet> {

    /**
     * 新增
     *
     * @author percylu
     * @Date 2020-08-21
     */
    void add(PetParam param);

    /**
     * 删除
     *
     * @author percylu
     * @Date 2020-08-21
     */
    void delete(PetParam param);

    /**
     * 更新
     *
     * @author percylu
     * @Date 2020-08-21
     */
    void update(PetParam param);

    /**
     * 更新时间，根据时间排序
     *
     * @author percylu
     * @Date 2020-08-21
     */
    void updateDate(PetParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-21
     */
    Pet findBySpec(PetParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author percylu
     * @Date 2020-08-21
     */
    List<PetResult> findListBySpec(PetParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author percylu
     * @Date 2020-08-21
     */
    LayuiPageInfo findPageBySpec(PetParam param);

}
