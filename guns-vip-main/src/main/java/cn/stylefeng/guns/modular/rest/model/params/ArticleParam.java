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
 * 喵小小文章
 * </p>
 *
 * @author percylu
 * @since 2020-08-14
 */
@Data
@ApiModel
public class ArticleParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long articleId;

    /**
     * 文章标题
     */
    @ApiModelProperty("文章标题")
    private String articleTitle;

    /**
     *  文章封面
     */
    @ApiModelProperty(" 文章封面")
    private String articleCover;

    /**
     * 文章内容
     */
    @ApiModelProperty("文章内容")
    private String articleContent;

    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private String articleEditor;

    /**
     * 文章来源
     */
    @ApiModelProperty("文章来源")
    private String articleFrom;

    /**
     * 发布机构
     */
    @ApiModelProperty("发布机构")
    private String articleCompany;

    /**
     * 更新时间
     */
    @ApiModelProperty(hidden = true)
    private Date updateTime;

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
