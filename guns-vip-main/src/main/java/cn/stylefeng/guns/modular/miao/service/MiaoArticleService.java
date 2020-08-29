package cn.stylefeng.guns.modular.miao.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoArticle;
import cn.stylefeng.guns.modular.miao.model.params.MiaoArticleParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoArticleResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 喵小小文章 服务类
 * </p>
 *
 * @author  percylu
 * @since 2020-08-14
 */
public interface MiaoArticleService extends IService<MiaoArticle> {

    /**
     * 新增
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    void add(MiaoArticleParam param);

    /**
     * 删除
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    void delete(MiaoArticleParam param);

    /**
     * 更新
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    void update(MiaoArticleParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    MiaoArticleResult findBySpec(MiaoArticleParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author  percylu
     * @Date 2020-08-14
     */
    List<MiaoArticleResult> findListBySpec(MiaoArticleParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author  percylu
     * @Date 2020-08-14
     */
     LayuiPageInfo findPageBySpec(MiaoArticleParam param);
    /**
     * 上传设备图片
     *
     * @author 卢水柏
     * @Date 2020-07-31
     */
    String updatePic(String fileId);
}
