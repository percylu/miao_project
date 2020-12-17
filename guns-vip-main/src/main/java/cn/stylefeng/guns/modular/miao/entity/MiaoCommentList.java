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
 * 评论列表

 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
@TableName("miao_comment_list")
public class MiaoCommentList implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "post_id", type = IdType.ID_WORKER)
    private Long postId;

    /**
     * 用户
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 评论
     */
    @TableField("comment")
    private String comment;

    /**
     * 创建时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MiaoCommentList{" +
        "postId=" + postId +
        ", userId=" + userId +
        ", comment=" + comment +
        ", createTime=" + createTime +
        "}";
    }
}
