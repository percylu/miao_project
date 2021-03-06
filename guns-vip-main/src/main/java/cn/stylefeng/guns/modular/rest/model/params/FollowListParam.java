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
 * 关注列表

 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@Data
@ApiModel
public class FollowListParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long followId;

    /**
     * 用户
     */
    @ApiModelProperty("用户")
    private Long userId;

    /**
     * 关注人
     */
    @ApiModelProperty("关注人")
    private Long followUserId;

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
