package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoProduct;
import cn.stylefeng.guns.modular.miao.model.params.MiaoProductParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoProductResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品维护 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-05
 */
public interface MiaoProductService extends IService<MiaoProduct> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    void add(MiaoProductParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    void delete(MiaoProductParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    void update(MiaoProductParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    MiaoProductResult findBySpec(MiaoProductParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
    List<MiaoProductResult> findListBySpec(MiaoProductParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-05
     */
     LayuiPageInfo findPageBySpec(MiaoProductParam param);

}
