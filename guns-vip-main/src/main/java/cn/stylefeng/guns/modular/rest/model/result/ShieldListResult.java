package cn.stylefeng.guns.modular.rest.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 屏蔽列表

 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@Data
@ApiModel
public class ShieldListResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long userId;

    /**
     * 用户
     */
    @ApiModelProperty("用户")
    private Long shieldId;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date createTime;

}
