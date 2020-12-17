package cn.stylefeng.guns.modular.miao.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 商品维护
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-05
 */
@TableName("miao_product")
public class MiaoProduct implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "product_id", type = IdType.ID_WORKER)
    private Long productId;

    /**
     * 商品名称
     */
    @TableField("name")
    private String name;

    /**
     * 商品原价
     */
    @TableField("original_price")
    private BigDecimal originalPrice;

    /**
     * 销售价格
     */
    @TableField("sale_price")
    private BigDecimal salePrice;

    /**
     * 首页促销
     */
    @TableField("promotion")
    private Integer promotion;

    /**
     * 商品图片
     */
    @TableField("img")
    private String img;

    /**
     * 平台来源
     */
    @TableField("platform")
    private String platform;

    /**
     * 跳转链接
     */
    @TableField("link")
    private String link;

    /**
     * 创建时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MiaoProduct{" +
        "productId=" + productId +
        ", name=" + name +
        ", originalPrice=" + originalPrice +
        ", salePrice=" + salePrice +
        ", promotion=" + promotion +
        ", img=" + img +
        ", platform=" + platform +
        ", link=" + link +
        ", createTime=" + createTime +
        "}";
    }
}
