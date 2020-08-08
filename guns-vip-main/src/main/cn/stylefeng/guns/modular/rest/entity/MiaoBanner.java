package cn.stylefeng.guns.modular.rest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 广告图管理
 * </p>
 *
 * @author percylu
 * @since 2020-08-08
 */
@TableName("miao_banner")
public class MiaoBanner implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
      @TableId(value = "banner_id", type = IdType.ID_WORKER)
    private Long bannerId;

    /**
     * 广告图
     */
    @TableField("banner_img")
    private String bannerImg;

    /**
     * 广告URL
     */
    @TableField("banner_url")
    private String bannerUrl;

    /**
     * 更新时间
     */
    @TableField("updatetime")
    private Date updatetime;

    /**
     * 创建时间
     */
    @TableField("createtime")
    private Date createtime;


    public Long getBannerId() {
        return bannerId;
    }

    public void setBannerId(Long bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "MiaoBanner{" +
        "bannerId=" + bannerId +
        ", bannerImg=" + bannerImg +
        ", bannerUrl=" + bannerUrl +
        ", updatetime=" + updatetime +
        ", createtime=" + createtime +
        "}";
    }
}
