package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 设备管理
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@Data
public class MiaoDeviceResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long deviceId;

    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 设备编号
     */
    private String deviceSn;

    /**
     * 设备型号
     */
    private Long deviceType;

    /**
     * 状态
     */
    private String status;

    /**
     * 垃圾百分比
     */
    private Integer rubbish;

    /**
     * 猫砂百分比
     */
    private Integer litter;

    /**
     * 如厕次数
     */
    private Integer tims;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
