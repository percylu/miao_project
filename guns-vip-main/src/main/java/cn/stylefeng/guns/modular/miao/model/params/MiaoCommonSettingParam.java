package cn.stylefeng.guns.modular.miao.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * App 通用设置
 * </p>
 *
 * @author  percylu
 * @since 2020-08-14
 */
@Data
public class MiaoCommonSettingParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long settingId;

    /**
     * 设置类型
     */
    private String settingTitle;

    /**
     * 设置内容
     */
    private String settingContent;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    @Override
    public String checkParam() {
        return null;
    }

}
