package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 宠物数据

 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@Data
public class MiaoPetDataResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long petDataId;

    /**
     * 宠物ID
     */
    private Long petId;

    /**
     * 排泄物重量
     */
    private Long weight;

    /**
     * 创建时间
     */
    private Date createTime;

}
