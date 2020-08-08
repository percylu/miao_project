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
 * 广告图管理
 * </p>
 *
 * @author percylu
 * @since 2020-08-08
 */
@Data
@ApiModel
public class MiaoBannerParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long bannerId;

    /**
     * 广告图
     */
    @ApiModelProperty("广告图")
    private String bannerImg;

    /**
     * 广告URL
     */
    @ApiModelProperty("广告URL")
    private String bannerUrl;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updatetime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createtime;

    @Override
    public String checkParam() {
        return null;
    }

}
