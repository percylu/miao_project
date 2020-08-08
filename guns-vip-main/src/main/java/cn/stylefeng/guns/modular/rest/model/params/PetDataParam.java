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
 * 宠物数据

 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
@Data
@ApiModel
public class PetDataParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long petDataId;

    /**
     * 宠物ID
     */
    @ApiModelProperty("宠物ID")
    private Long petId;

    /**
     * 排泄物重量
     */
    @ApiModelProperty("排泄物重量")
    private Long weight;

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
