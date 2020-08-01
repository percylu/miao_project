package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoPet;
import cn.stylefeng.guns.modular.miao.model.params.MiaoPetParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoPetResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宠物管理 服务类
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
public interface MiaoPetService extends IService<MiaoPet> {

    /**
     * 新增
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void add(MiaoPetParam param);

    /**
     * 删除
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void delete(MiaoPetParam param);

    /**
     * 更新
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void update(MiaoPetParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    MiaoPetResult findBySpec(MiaoPetParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    List<MiaoPetResult> findListBySpec(MiaoPetParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
     LayuiPageInfo findPageBySpec(MiaoPetParam param);

}
