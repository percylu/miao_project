package cn.stylefeng.guns.modular.rest.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 评论列表

 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@Data
@ApiModel
public class CommentListResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long postId;

    /**
     * 用户
     */
    @ApiModelProperty("用户")
    private Long userId;

    /**
     * 评论
     */
    @ApiModelProperty("评论")
    private String comment;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date createTime;

}
