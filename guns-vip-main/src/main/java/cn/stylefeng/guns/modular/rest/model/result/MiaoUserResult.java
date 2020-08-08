package cn.stylefeng.guns.modular.rest.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * App用户管理
 * </p>
 *
 * @author percylu
 * @since 2020-08-03
 */
@Data
@ApiModel
public class MiaoUserResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long userId;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String account;

    /**
     * 名字
     */
    @ApiModelProperty("名字")
    private String name;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Integer sex;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private String status;

    /**
     * QQ
     */
    @ApiModelProperty("QQ")
    private String qq;

    /**
     * 微信
     */
    @ApiModelProperty("微信")
    private String weixin;

    /**
     * 微博
     */
    @ApiModelProperty("微博")
    private String weibo;


}
