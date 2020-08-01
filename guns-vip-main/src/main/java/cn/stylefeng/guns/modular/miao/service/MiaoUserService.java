package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoUser;
import cn.stylefeng.guns.modular.miao.model.params.MiaoUserParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoUserResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * App用户管理 服务类
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
public interface MiaoUserService extends IService<MiaoUser> {

    /**
     * 新增
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void add(MiaoUserParam param);

    /**
     * 删除
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void delete(MiaoUserParam param);

    /**
     * 更新
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    void update(MiaoUserParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    MiaoUserResult findBySpec(MiaoUserParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    List<MiaoUserResult> findListBySpec(MiaoUserParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
     LayuiPageInfo findPageBySpec(MiaoUserParam param);

}
