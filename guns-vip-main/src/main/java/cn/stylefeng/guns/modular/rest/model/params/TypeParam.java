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
 *  宠物品种
 * </p>
 *
 * @author percylu
 * @since 2020-08-23
 */
@Data
@ApiModel
public class TypeParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long typeId;

    /**
     * 品种名称
     */
    @ApiModelProperty("品种名称")
    private String typeName;

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
