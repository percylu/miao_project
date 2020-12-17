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
 * 屏蔽列表

 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@TableName("miao_shield_list")
public class ShieldList implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "user_id", type = IdType.ID_WORKER)
    private Long userId;

    /**
     * 用户
     */
    @TableField("shield_id")
    private Long shieldId;

    /**
     * 创建时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShieldId() {
        return shieldId;
    }

    public void setShieldId(Long shieldId) {
        this.shieldId = shieldId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShieldList{" +
        "userId=" + userId +
        ", shieldId=" + shieldId +
        ", createTime=" + createTime +
        "}";
    }
}
