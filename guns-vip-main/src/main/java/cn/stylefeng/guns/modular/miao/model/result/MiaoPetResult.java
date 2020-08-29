package cn.stylefeng.guns.modular.miao.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
public class MiaoPetResult implements Serializable {

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
    @JsonFormat(pattern = "yyyy-MM-dd")
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

}
