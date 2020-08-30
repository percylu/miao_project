package cn.stylefeng.guns.modular.rest.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 第三方ID
 * </p>
 *
 * @author percylu
 * @since 2020-08-30
 */
@Data
@ApiModel
public class ThirdResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long thirdId;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 极光推送ID
     */
    @ApiModelProperty("极光推送ID")
    private Long jpushRegId;

    /**
     * MobID
     */
    @ApiModelProperty("MobID")
    private Long mobRegId;

}
