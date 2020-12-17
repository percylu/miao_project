package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 黑名单列表

 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
@Data
public class MiaoBlackListResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long userId;

    /**
     * 用户
     */
    private Long blackUserId;

    /**
     * 创建时间
     */
    private Date createTime;

}
