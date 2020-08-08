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
 * 设备类型
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
@Data
@ApiModel
public class DeviceTypeParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long typeId;

    /**
     * 设备颜色
     */
    @ApiModelProperty("设备颜色")
    private String color;

    /**
     * 设备型号
     */
    @ApiModelProperty("设备型号")
    private String type;

    /**
     * 设备图片
     */
    @ApiModelProperty("设备图片")
    private String imgurl;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(hidden = true)
    private Date updateTime;

    @Override
    public String checkParam() {
        return null;
    }

}
