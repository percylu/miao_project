package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoPost;
import cn.stylefeng.guns.modular.miao.model.params.MiaoPostParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoPostResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 个人动态 服务类
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
public interface MiaoPostService extends IService<MiaoPost> {

    /**
     * 新增
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void add(MiaoPostParam param);

    /**
     * 删除
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void delete(MiaoPostParam param);

    /**
     * 更新
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    void update(MiaoPostParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    MiaoPostResult findBySpec(MiaoPostParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
    List<MiaoPostResult> findListBySpec(MiaoPostParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author byteEngine
     * @Date 2020-12-12
     */
     LayuiPageInfo findPageBySpec(MiaoPostParam param);

}
