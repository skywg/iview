package com.ovit.bee.pojo;

import java.util.Date;

/**
 * 工作经历
 * @author Administrator
 *
 */
public class UserWorkExperience {
    private Integer id;

    private String account;

    private String organazationName;

    private Date startDate;

    private Date endDate;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getOrganazationName() {
        return organazationName;
    }

    public void setOrganazationName(String organazationName) {
        this.organazationName = organazationName == null ? null : organazationName.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}