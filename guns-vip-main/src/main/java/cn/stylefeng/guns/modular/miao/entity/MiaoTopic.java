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
 * 话题维护
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-14
 */
@TableName("miao_topic")
public class MiaoTopic implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "topic_id", type = IdType.ID_WORKER)
    private Long topicId;

    /**
     * 主题名称
     */
    @TableField("title")
    private String title;

    /**
     * 子主题名称
     */
    @TableField("sub_title")
    private String subTitle;

    /**
     * 主题图片
     */
    @TableField("img")
    private String img;

    /**
     * 热度
     */
    @TableField("hot_count")
    private Integer hotCount;

    /**
     * 参与次数
     */
    @TableField("join_count")
    private Integer joinCount;

    /**
     * 点赞次数
     */
    @TableField("like_count")
    private Integer likeCount;

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


    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getHotCount() {
        return hotCount;
    }

    public void setHotCount(Integer hotCount) {
        this.hotCount = hotCount;
    }

    public Integer getJoinCount() {
        return joinCount;
    }

    public void setJoinCount(Integer joinCount) {
        this.joinCount = joinCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
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
        return "MiaoTopic{" +
        "topicId=" + topicId +
        ", title=" + title +
        ", subTitle=" + subTitle +
        ", img=" + img +
        ", hotCount=" + hotCount +
        ", joinCount=" + joinCount +
        ", likeCount=" + likeCount +
        ", commentCount=" + commentCount +
        ", seq=" + seq +
        ", createTime=" + createTime +
        "}";
    }
}
