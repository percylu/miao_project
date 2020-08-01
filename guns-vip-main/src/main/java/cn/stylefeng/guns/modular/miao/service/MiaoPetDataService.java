package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoPetData;
import cn.stylefeng.guns.modular.miao.model.params.MiaoPetDataParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoPetDataResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宠物数据
 服务类
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
public interface MiaoPetDataService extends IService<MiaoPetData> {

    /**
     * 新增
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void add(MiaoPetDataParam param);

    /**
     * 删除
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void delete(MiaoPetDataParam param);

    /**
     * 更新
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void update(MiaoPetDataParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    MiaoPetDataResult findBySpec(MiaoPetDataParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    List<MiaoPetDataResult> findListBySpec(MiaoPetDataParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
     LayuiPageInfo findPageBySpec(MiaoPetDataParam param);

}
