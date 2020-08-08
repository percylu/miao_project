package cn.stylefeng.guns.modular.miao.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 广告图管理
 * </p>
 *
 * @author percylu
 * @since 2020-08-08
 */
@Data
public class MiaoBannerParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    private Long bannerId;

    /**
     * 广告图
     */
    private String bannerImg;

    /**
     * 广告URL
     */
    private String bannerUrl;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 创建时间
     */
    private Date createtime;

    @Override
    public String checkParam() {
        return null;
    }

}
