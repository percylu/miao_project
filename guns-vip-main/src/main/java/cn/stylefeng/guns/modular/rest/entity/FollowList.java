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
 * 关注列表

 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@TableName("miao_follow_list")
public class FollowList implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "follow_id", type = IdType.ID_WORKER)
    private Long followId;

    /**
     * 用户
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 关注人
     */
    @TableField("follow_user_id")
    private Long followUserId;

    /**
     * 创建时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Long followUserId) {
        this.followUserId = followUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FollowList{" +
        "followId=" + followId +
        ", userId=" + userId +
        ", followUserId=" + followUserId +
        ", createTime=" + createTime +
        "}";
    }
}
