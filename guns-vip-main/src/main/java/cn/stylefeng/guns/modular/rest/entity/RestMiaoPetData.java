package cn.stylefeng.guns.modular.rest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 宠物数据

 * </p>
 *
 * @author percylu
 * @since 2020-08-02
 */
@TableName("miao_pet_data")
public class MiaoPetData implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "pet_data_id", type = IdType.ID_WORKER)
    private Long petDataId;

    /**
     * 宠物ID
     */
    @TableField("pet_id")
    private Long petId;

    /**
     * 排泄物重量
     */
    @TableField("weight")
    private Long weight;

    /**
     * 创建时间
     */
      @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;


    public Long getPetDataId() {
        return petDataId;
    }

    public void setPetDataId(Long petDataId) {
        this.petDataId = petDataId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MiaoPetData{" +
        "petDataId=" + petDataId +
        ", petId=" + petId +
        ", weight=" + weight +
        ", createTime=" + createTime +
        "}";
    }
}
