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
 * 设备类型
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@TableName("miao_device_type")
public class MiaoDeviceType implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "type_id", type = IdType.ID_WORKER)
    private Long typeId;

    /**
     * 设备颜色
     */
    @TableField("color")
    private String color;

    /**
     * 设备型号
     */
    @TableField("type")
    private String type;

    /**
     * 设备图片
     */
    @TableField("imgurl")
    private String imgurl;

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


    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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
        return "MiaoDeviceType{" +
        "typeId=" + typeId +
        ", color=" + color +
        ", type=" + type +
        ", imgurl=" + imgurl +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
