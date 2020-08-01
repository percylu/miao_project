package cn.stylefeng.guns.modular.miao.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 设备数据
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@Data
public class MiaoDeviceDataParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long deviceDataId;

    /**
     * 设备ID
     */
    private Long deviceId;

    /**
     * 排泄物重量
     */
    private Long weight;

    /**
     * 创建时间
     */
    private Date createTime;

    @Override
    public String checkParam() {
        return null;
    }

}
