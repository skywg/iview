package com.ovit.bee.pojo;

import java.util.Date;

/**
 * 资讯表
 * @author Administrator
 *
 */
public class InForMation {
    private Integer id;

    private Integer informationDetailId;

    private String businessInformation;

    private String allRange;

    private String businessNature;

    private String allBusiness;

    private String title;

    private String imageAdd;

    private Date createTime;

    private Integer commentNum;

    private String label;
    
    private String day;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInformationDetailId() {
        return informationDetailId;
    }

    public void setInformationDetailId(Integer informationDetailId) {
        this.informationDetailId = informationDetailId;
    }

    public String getBusinessInformation() {
        return businessInformation;
    }

    public void setBusinessInformation(String businessInformation) {
        this.businessInformation = businessInformation == null ? null : businessInformation.trim();
    }

    public String getAllRange() {
        return allRange;
    }

    public void setAllRange(String allRange) {
        this.allRange = allRange == null ? null : allRange.trim();
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature == null ? null : businessNature.trim();
    }

    public String getAllBusiness() {
        return allBusiness;
    }

    public void setAllBusiness(String allBusiness) {
        this.allBusiness = allBusiness == null ? null : allBusiness.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImageAdd() {
        return imageAdd;
    }

    public void setImageAdd(String imageAdd) {
        this.imageAdd = imageAdd == null ? null : imageAdd.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
    
    
}