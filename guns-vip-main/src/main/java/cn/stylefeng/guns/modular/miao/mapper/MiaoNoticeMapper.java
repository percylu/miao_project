package cn.stylefeng.guns.modular.miao.mapper;

import cn.stylefeng.guns.modular.miao.entity.MiaoNotice;
import cn.stylefeng.guns.modular.miao.model.params.MiaoNoticeParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoNoticeResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 通知表 Mapper 接口
 * </p>
 *
 * @author percylu
 * @since 2020-08-28
 */
public interface MiaoNoticeMapper extends BaseMapper<MiaoNotice> {

    /**
     * 获取列表
     *
     * @author percylu
     * @Date 2020-08-28
     */
    List<MiaoNoticeResult> customList(@Param("paramCondition") MiaoNoticeParam paramCondition);

    /**
     * 获取map列表
     *
     * @author percylu
     * @Date 2020-08-28
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") MiaoNoticeParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author percylu
     * @Date 2020-08-28
     */
    Page<MiaoNoticeResult> customPageList(@Param("page") Page page, @Param("paramCondition") MiaoNoticeParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author percylu
     * @Date 2020-08-28
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") MiaoNoticeParam paramCondition);

}
