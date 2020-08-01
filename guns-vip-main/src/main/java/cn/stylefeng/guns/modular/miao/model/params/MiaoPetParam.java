package cn.stylefeng.guns.modular.miao.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 宠物管理
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@Data
public class MiaoPetParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long petId;

    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 名字
     */
    private String name;

    /**
     * 品种
     */
    private Long type;

    /**
     * 性别
     */
    private Integer sexy;

    /**
     * 重量
     */
    private BigDecimal weight;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * RFID
     */
    private String rdid;

    /**
     * 图片
     */
    private String imgurls;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @Override
    public String checkParam() {
        return null;
    }

}
