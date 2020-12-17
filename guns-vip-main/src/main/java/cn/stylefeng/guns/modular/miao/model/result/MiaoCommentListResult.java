package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 评论列表

 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
@Data
public class MiaoCommentListResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long postId;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 评论
     */
    private String comment;

    /**
     * 创建时间
     */
    private Date createTime;

}
