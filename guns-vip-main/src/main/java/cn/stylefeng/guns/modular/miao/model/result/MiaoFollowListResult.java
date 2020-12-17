package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 关注列表

 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
@Data
public class MiaoFollowListResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long followId;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 关注人
     */
    private Long followUserId;

    /**
     * 创建时间
     */
    private Date createTime;

}
