package cn.stylefeng.guns.modular.rest.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * App 通用设置
 * </p>
 *
 * @author percylu
 * @since 2020-08-14
 */
@Data
@ApiModel
public class CommonSettingParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long settingId;

    /**
     * 设置类型
     */
    @ApiModelProperty("设置类型")
    private String settingTitle;

    /**
     * 设置内容
     */
    @ApiModelProperty("设置内容")
    private String settingContent;

    /**
     * 更新时间
     */
    @ApiModelProperty(hidden = true)
    private Date updateTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date createTime;

    @Override
    public String checkParam() {
        return null;
    }

}
