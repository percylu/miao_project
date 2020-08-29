package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *  宠物品种
 * </p>
 *
 * @author percylu
 * @since 2020-08-20
 */
@Data
public class MiaoTypeResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long typeId;

    /**
     * 品种名称
     */
    private String typeName;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

}
