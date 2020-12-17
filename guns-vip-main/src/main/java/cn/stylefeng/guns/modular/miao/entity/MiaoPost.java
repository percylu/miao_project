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
 * 个人动态
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
@TableName("miao_post")
public class MiaoPost implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "post_id", type = IdType.ID_WORKER)
    private Long postId;

    /**
     * 动态标题
     */
    @TableField("title")
    private String title;

    /**
     * 关联话题
     */
    @TableField("topic_id")
    private Long topicId;

    /**
     * 用户
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 动态图片
     */
    @TableField("file")
    private String file;

    /**
     * 城市
     */
    @TableField("city")
    private String city;

    /**
     * 详细位置
     */
    @TableField("location")
    private String location;

    /**
     * 点赞数量
     */
    @TableField("like_count")
    private Integer likeCount;

    /**
     * 综合热度
     */
    @TableField("hot_count")
    private Integer hotCount;

    /**
     * 评论次数
     */
    @TableField("comment_count")
    private Integer commentCount;

    /**
     * 排序（0最小）
     */
    @TableField("seq")
    private Integer seq;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getHotCount() {
        return hotCount;
    }

    public void setHotCount(Integer hotCount) {
        this.hotCount = hotCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MiaoPost{" +
        "postId=" + postId +
        ", title=" + title +
        ", topicId=" + topicId +
        ", userId=" + userId +
        ", file=" + file +
        ", city=" + city +
        ", location=" + location +
        ", likeCount=" + likeCount +
        ", hotCount=" + hotCount +
        ", commentCount=" + commentCount +
        ", seq=" + seq +
        ", createTime=" + createTime +
        "}";
    }
}
