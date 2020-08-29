package cn.stylefeng.guns.modular.miao.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 宠物管理
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@TableName("miao_pet")
public class MiaoPet implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "pet_id", type = IdType.ID_WORKER)
    private Long petId;

    /**
     * 所属用户
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 名字
     */
    @TableField("name")
    private String name;

    /**
     * 品种
     */
    @TableField("type")
    private Long type;

    /**
     * 性别
     */
    @TableField("sexy")
    private Integer sexy;

    /**
     * 重量
     */
    @TableField("weight")
    private BigDecimal weight;

    /**
     * 生日
     */
    @TableField("birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * RFID
     */
    @TableField("rdid")
    private String rdid;

    /**
     * 图片
     */
    @TableField("imgurls")
    private String imgurls;

    /**
     * 创建时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
      @TableField(value = "update_time", fill = FieldFill.INSERT)
    private Date updateTime;


    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Integer getSexy() {
        return sexy;
    }

    public void setSexy(Integer sexy) {
        this.sexy = sexy;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRdid() {
        return rdid;
    }

    public void setRdid(String rdid) {
        this.rdid = rdid;
    }

    public String getImgurls() {
        return imgurls;
    }

    public void setImgurls(String imgurls) {
        this.imgurls = imgurls;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "MiaoPet{" +
        "petId=" + petId +
        ", userId=" + userId +
        ", name=" + name +
        ", type=" + type +
        ", sexy=" + sexy +
        ", weight=" + weight +
        ", birthday=" + birthday +
        ", rdid=" + rdid +
        ", imgurls=" + imgurls +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
