package cn.stylefeng.guns.modular.miao.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 通知表
 * </p>
 *
 * @author percylu
 * @since 2020-08-28
 */
@Data
public class MiaoNoticeResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Long noticeId;

    /**
     * 标题
     */
    private String title;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 内容
     */
    private String content;

    /**
     * 接收人
     */
    private String toList;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Long updateUser;

}
