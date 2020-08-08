package cn.stylefeng.guns.modular.rest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 设备管理
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
@TableName("miao_device")
public class Device implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "device_id", type = IdType.ID_WORKER)
    private Long deviceId;

    /**
     * 所属用户
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 设备编号
     */
    @TableField("device_sn")
    private String deviceSn;

    /**
     * 设备型号
     */
    @TableField("device_type")
    private Long deviceType;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 垃圾百分比
     */
    @TableField("rubbish")
    private Integer rubbish;

    /**
     * 猫砂百分比
     */
    @TableField("litter")
    private Integer litter;

    /**
     * 如厕次数
     */
    @TableField("tims")
    private Integer tims;

    /**
     * 创建时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
      @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;


    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public Long getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Long deviceType) {
        this.deviceType = deviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRubbish() {
        return rubbish;
    }

    public void setRubbish(Integer rubbish) {
        this.rubbish = rubbish;
    }

    public Integer getLitter() {
        return litter;
    }

    public void setLitter(Integer litter) {
        this.litter = litter;
    }

    public Integer getTims() {
        return tims;
    }

    public void setTims(Integer tims) {
        this.tims = tims;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Device{" +
        "deviceId=" + deviceId +
        ", userId=" + userId +
        ", deviceSn=" + deviceSn +
        ", deviceType=" + deviceType +
        ", status=" + status +
        ", rubbish=" + rubbish +
        ", litter=" + litter +
        ", tims=" + tims +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
