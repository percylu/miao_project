package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 话题维护
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-14
 */
@Data
public class MiaoTopicResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long topicId;

    /**
     * 主题名称
     */
    private String title;

    /**
     * 子主题名称
     */
    private String subTitle;

    /**
     * 主题图片
     */
    private String img;

    /**
     * 热度
     */
    private Integer hotCount;

    /**
     * 参与次数
     */
    private Integer joinCount;

    /**
     * 点赞次数
     */
    private Integer likeCount;

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
