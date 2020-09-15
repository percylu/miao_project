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
 * 第三方ID
 * </p>
 *
 * @author percylu
 * @since 2020-08-30
 */
@Data
@ApiModel
public class ThirdParam implements Serializable, BaseValidatingParam {

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
    private String jpushRegId;

    /**
     * MobID
     */
    @ApiModelProperty("MobID")
    private String mobRegId;

    @Override
    public String checkParam() {
        return null;
    }

}
