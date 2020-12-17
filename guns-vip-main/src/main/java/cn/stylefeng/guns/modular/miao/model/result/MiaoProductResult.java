package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商品维护
 * </p>
 *
 * @author byteEngine
 * @since 2020-12-05
 */
@Data
public class MiaoProductResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品原价
     */
    private BigDecimal originalPrice;

    /**
     * 销售价格
     */
    private BigDecimal salePrice;

    /**
     * 首页促销
     */
    private Integer promotion;

    /**
     * 商品图片
     */
    private String img;

    /**
     * 平台来源
     */
    private String platform;

    /**
     * 跳转链接
     */
    private String link;

    /**
     * 创建时间
     */
    private Date createTime;

}
