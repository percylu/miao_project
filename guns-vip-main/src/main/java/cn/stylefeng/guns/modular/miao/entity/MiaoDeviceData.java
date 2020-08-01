package cn.stylefeng.guns.modular.miao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 设备数据
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@TableName("miao_device_data")
public class MiaoDeviceData implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "device_data_id", type = IdType.ID_WORKER)
    private Long deviceDataId;

    /**
     * 设备ID
     */
    @TableField("device_id")
    private Long deviceId;

    /**
     * 排泄物重量
     */
    @TableField("weight")
    private Long weight;

    /**
     * 创建时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    public Long getDeviceDataId() {
        return deviceDataId;
    }

    public void setDeviceDataId(Long deviceDataId) {
        this.deviceDataId = deviceDataId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MiaoDeviceData{" +
        "deviceDataId=" + deviceDataId +
        ", deviceId=" + deviceId +
        ", weight=" + weight +
        ", createTime=" + createTime +
        "}";
    }
}
