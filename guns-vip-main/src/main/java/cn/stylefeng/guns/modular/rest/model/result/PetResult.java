package cn.stylefeng.guns.modular.rest.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 宠物管理
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
@Data
@ApiModel
public class PetResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long petId;

    /**
     * 所属用户
     */
    @ApiModelProperty("所属用户")
    private Long userId;

    /**
     * 名字
     */
    @ApiModelProperty("名字")
    private String name;

    /**
     * 品种
     */
    @ApiModelProperty("品种")
    private Long type;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Integer sexy;

    /**
     * 重量
     */
    @ApiModelProperty("重量")
    private BigDecimal weight;

    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private Date birthday;

    /**
     * RFID
     */
    @ApiModelProperty("RFID")
    private String rdid;

    /**
     * 图片
     */
    @ApiModelProperty("图片")
    private String imgurls;

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

}
