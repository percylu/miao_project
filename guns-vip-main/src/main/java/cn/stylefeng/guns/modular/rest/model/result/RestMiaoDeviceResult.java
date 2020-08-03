package cn.stylefeng.guns.modular.rest.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 设备管理
 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
@Data
@ApiModel
public class MiaoDeviceResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long deviceId;

    /**
     * 所属用户
     */
    @ApiModelProperty("所属用户")
    private Long userId;

    /**
     * 设备编号
     */
    @ApiModelProperty("设备编号")
    private String deviceSn;

    /**
     * 设备型号
     */
    @ApiModelProperty("设备型号")
    private Long deviceType;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private String status;

    /**
     * 垃圾百分比
     */
    @ApiModelProperty("垃圾百分比")
    private Integer rubbish;

    /**
     * 猫砂百分比
     */
    @ApiModelProperty("猫砂百分比")
    private Integer litter;

    /**
     * 如厕次数
     */
    @ApiModelProperty("如厕次数")
    private Integer tims;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(hidden = true)
    private Date updateTime;

}
