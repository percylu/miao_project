package cn.stylefeng.guns.modular.rest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 第三方ID
 * </p>
 *
 * @author percylu
 * @since 2020-08-30
 */
@TableName("miao_third")
public class Third implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
      @TableId(value = "third_id", type = IdType.AUTO)
    private Long thirdId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 极光推送ID
     */
    @TableField("jpush_reg_id")
    private String jpushRegId;

    /**
     * MobID
     */
    @TableField("mob_reg_id")
    private String mobRegId;


    public Long getThirdId() {
        return thirdId;
    }

    public void setThirdId(Long thirdId) {
        this.thirdId = thirdId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getJpushRegId() {
        return jpushRegId;
    }

    public void setJpushRegId(String jpushRegId) {
        this.jpushRegId = jpushRegId;
    }

    public String getMobRegId() {
        return mobRegId;
    }

    public void setMobRegId(String mobRegId) {
        this.mobRegId = mobRegId;
    }

    @Override
    public String toString() {
        return "Third{" +
        "thirdId=" + thirdId +
        ", userId=" + userId +
        ", jpushRegId=" + jpushRegId +
        ", mobRegId=" + mobRegId +
        "}";
    }
}
