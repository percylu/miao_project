package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 设备类型
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@Data
public class MiaoDeviceTypeResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long typeId;

    /**
     * 设备颜色
     */
    private String color;

    /**
     * 设备型号
     */
    private String type;

    /**
     * 设备图片
     */
    private String imgurl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
