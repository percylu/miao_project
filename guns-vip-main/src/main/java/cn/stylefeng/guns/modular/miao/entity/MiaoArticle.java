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
 * 喵小小文章
 * </p>
 *
 * @author  percylu
 * @since 2020-08-14
 */
@TableName("miao_article")
public class MiaoArticle implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
      @TableId(value = "article_id", type = IdType.ID_WORKER)
    private Long articleId;

    /**
     * 文章标题
     */
    @TableField("article_title")
    private String articleTitle;

    /**
     *  文章封面
     */
    @TableField("article_cover")
    private String articleCover;

    /**
     * 文章内容
     */
    @TableField("article_content")
    private String articleContent;

    /**
     * 作者
     */
    @TableField("article_editor")
    private String articleEditor;

    /**
     * 文章来源
     */
    @TableField("article_from")
    private String articleFrom;

    /**
     * 发布机构
     */
    @TableField("article_company")
    private String articleCompany;

    /**
     * 更新时间
     */
      @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 创建时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleEditor() {
        return articleEditor;
    }

    public void setArticleEditor(String articleEditor) {
        this.articleEditor = articleEditor;
    }

    public String getArticleFrom() {
        return articleFrom;
    }

    public void setArticleFrom(String articleFrom) {
        this.articleFrom = articleFrom;
    }

    public String getArticleCompany() {
        return articleCompany;
    }

    public void setArticleCompany(String articleCompany) {
        this.articleCompany = articleCompany;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MiaoArticle{" +
        "articleId=" + articleId +
        ", articleTitle=" + articleTitle +
        ", articleCover=" + articleCover +
        ", articleContent=" + articleContent +
        ", articleEditor=" + articleEditor +
        ", articleFrom=" + articleFrom +
        ", articleCompany=" + articleCompany +
        ", updateTime=" + updateTime +
        ", createTime=" + createTime +
        "}";
    }
}
