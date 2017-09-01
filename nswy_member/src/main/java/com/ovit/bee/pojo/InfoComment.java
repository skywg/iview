package com.ovit.bee.pojo;

import java.util.Date;
import java.util.List;

public class InfoComment {
    private Integer id;

    private Integer informationDetailId;

    private String userAccount;

    private String userName;

    private Date createTime;

    private Integer thumbUpNum;

    private Integer postId;

    private String content;

    private List<InfoComment> list;
    
    public List<InfoComment> getList() {
		return list;
	}

	public void setList(List<InfoComment> list) {
		this.list = list;
	}

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

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getThumbUpNum() {
        return thumbUpNum;
    }

    public void setThumbUpNum(Integer thumbUpNum) {
        this.thumbUpNum = thumbUpNum;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "InfoComment [id=" + id + ", informationDetailId=" + informationDetailId + ", userAccount=" + userAccount
				+ ", userName=" + userName + ", createTime=" + createTime + ", thumbUpNum=" + thumbUpNum + ", postId="
				+ postId + ", content=" + content + ", list=" + list + "]";
	}
    
}