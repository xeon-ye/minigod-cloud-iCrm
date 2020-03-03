package com.minigod.persist.po;
import com.minigod.persist.tables.TOpenUserImg;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TOpenUserImg.class)
public class OpenUserImg implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;
	private Integer userId;//用户id
	private Date createTime;//创建时间
	private String imageLocation;//图片位置[0=未知 1=身份证正面照坐标 2=身份证反面照片坐标 3=指定动作1照坐标 4=指定动作2照坐标 5=指定动作3照坐标 6=电子签名照坐标]
	private String imageLocationType;//图片类型[0=未知 1=身份证正面照 2=身份证反面照片 3=左手竖起1个指头 4=右手竖起1个指头 5=左手竖起2个指头 6=右手竖起2个指头 7=左手竖起3个指头 8=右手竖起3个指头 9=正面照 10=电子签名照]
	private String imgPath;
	private Long errorStatus;//表示错误图片

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public String getImageLocation () {
        return imageLocation;
    }

    public void setImageLocation (String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getImageLocationType () {
        return imageLocationType;
    }

    public void setImageLocationType (String imageLocationType) {
        this.imageLocationType = imageLocationType;
    }

    public String getImgPath () {
        return imgPath;
    }

    public void setImgPath (String imgPath) {
        this.imgPath = imgPath;
    }

    public Long getErrorStatus () {
        return errorStatus;
    }

    public void setErrorStatus (Long errorStatus) {
        this.errorStatus = errorStatus;
    }
}