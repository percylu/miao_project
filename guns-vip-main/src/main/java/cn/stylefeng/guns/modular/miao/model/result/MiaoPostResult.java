package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 个人动态
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-12
 */
@Data
public class MiaoPostResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long postId;

    /**
     * 动态标题
     */
    private String title;

    /**
     * 关联话题
     */
    private Long topicId;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 动态图片
     */
    private String file;

    /**
     * 城市
     */
    private String city;

    /**
     * 详细位置
     */
    private String location;

    /**
     * 点赞数量
     */
    private Integer likeCount;

    /**
     * 综合热度
     */
    private Integer hotCount;

    /**
     * 评论次数
     */
    private Integer commentCount;

    /**
     * 排序（0最小）
     */
    private Integer seq;

    /**
     * 创建时间
     */
    private Date createTime;

}
