package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 喵小小文章
 * </p>
 *
 * @author  percylu
 * @since 2020-08-14
 */
@Data
public class MiaoArticleResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     *  文章封面
     */
    private String articleCover;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 作者
     */
    private String articleEditor;

    /**
     * 文章来源
     */
    private String articleFrom;

    /**
     * 发布机构
     */
    private String articleCompany;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

}
