package cn.stylefeng.guns.modular.miao.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
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
public class MiaoBlackListParam implements Serializable, BaseValidatingParam {

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

    @Override
    public String checkParam() {
        return null;
    }

}
