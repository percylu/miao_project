package cn.stylefeng.guns.modular.rest.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 话题维护
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-15
 */
@Data
@ApiModel
public class TopicParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long topicId;

    /**
     * 主题名称
     */
    @ApiModelProperty("主题名称")
    private String title;

    /**
     * 子主题名称
     */
    @ApiModelProperty("子主题名称")
    private String subTitle;

    /**
     * 主题图片
     */
    @ApiModelProperty("主题图片")
    private String img;

    /**
     * 热度
     */
    @ApiModelProperty("热度")
    private Integer hotCount;

    /**
     * 参与次数
     */
    @ApiModelProperty("参与次数")
    private Integer joinCount;

    /**
     * 点赞次数
     */
    @ApiModelProperty("点赞次数")
    private Integer likeCount;

    /**
     * 评论次数
     */
    @ApiModelProperty("评论次数")
    private Integer commentCount;

    /**
     * 排序（0最小）
     */
    @ApiModelProperty("排序（0最小）")
    private Integer seq;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date createTime;

    @Override
    public String checkParam() {
        return null;
    }

}
