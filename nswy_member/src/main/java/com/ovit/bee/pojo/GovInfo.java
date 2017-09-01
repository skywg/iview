package com.ovit.bee.pojo;

import java.util.Date;

/**
 * 机关
 */
public class GovInfo {
    private Integer id;

    private String govName;

    private String govCode;

    private String loginAccount;

    private String qrCodeUrl;

    private String organizationCode;

    private Date createTime;

    private String legalPersonCertificateUrl;
    
    private String address;
    
    private String legalPerson;

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGovName() {
        return govName;
    }

    public void setGovName(String govName) {
        this.govName = govName == null ? null : govName.trim();
    }

    public String getGovCode() {
        return govCode;
    }

    public void setGovCode(String govCode) {
        this.govCode = govCode == null ? null : govCode.trim();
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl == null ? null : qrCodeUrl.trim();
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLegalPersonCertificateUrl() {
        return legalPersonCertificateUrl;
    }

    public void setLegalPersonCertificateUrl(String legalPersonCertificateUrl) {
        this.legalPersonCertificateUrl = legalPersonCertificateUrl == null ? null : legalPersonCertificateUrl.trim();
    }

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
    
    
}