package com.ruoyi.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;

import java.util.Date;

/**
 * 企业申请项目对象 ky_enterprise_project_declaration
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
public class KyEnterpriseProjectDeclarationVo
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    @Excel(name = "申报项目编号")
    private Long id;

    /** 申请项目表id */
    private Long projectDeclarationId;

    /** 企业id */
    @Excel(name = "企业id")
    private Long enterpriseId;
    /**政策原文id */
    @Excel(name = "政策原文id")
    private  Long  originalPolicyId;
    /** 审核状态：1初审，2复审
 */
    private Long auditStatus;
    @Excel(name = "审核状态")
    private String auditStatusStr;

    /** 申报文件地址 */
   // @Excel(name = "申报文件地址")
    private String declaredFileUrl;

    /** 申报公司 */
    //@Excel(name = "申报公司")
    private String reportingCompany;

    /** 申报联系人 */
    @Excel(name = "申报联系人")
    private String declarationContact;

    /** 申报联系电话 */
    @Excel(name = "申报联系电话")
    private String contactNumber;
    /** 审核人*/
    @Excel(name = "审核人")
    private String  reviewer;
    /** 审核人电话 */
    @Excel(name = "审核人电话")
    private String  reviewerPhone;
    /** 政策发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "政策发布时间", dateFormat = "yyyy-MM-dd")
    private Date publishTime;
    /** 政策截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date validDate;
    /** 政策发布人 */
    @Excel(name = "政策发布人")
    private String publisher;
    /**企业名称 */
    @Excel(name = "企业名称")
    private String name;
    /** 政策级别：1国家，2湖北省，3宜昌市，4县/区 */
    @Excel(name = "政策级别")
    private String policyLevel;
    /** 政策标题 */
    @Excel(name = "政策标题",width = 50)
    private String tittle;
    /** 企业评价 */
    @Excel(name = "企业评价")
    private String appraise;
    /** 部门评价回复 */
    @Excel(name = "部门评价回复")
    private String appraiseAnswer;

    /** 企业联系人 */
    @Excel(name = "企业联系人")
    private String linkman;
    /** 企业联系人电话 */
    @Excel(name = "企业联系人电话")
    private String linkmanPhone;
    /**部门id */
    private Long publishingDepartment;
    /**申报企业数 */
    private  Integer declaredAmount;
    /**产业分类 */
    private String applicableIndustries;
    /**项目状态：0默认项目（进行中），1已结束 */
    private String itemStatus;
    /**展示状态：1置顶，2焦点，3推荐*/
    private String state;
    /**政策原文内容推荐*/
    private String content;
    /**解读标题*/
    private String interpretationTittle;
    /**解读内容*/
    private String interpretationContent;
    /** 评价时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date  appraiseTime;
    /** 部门回复时间时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date appraiseAnswerTime;
    /** 是否已评价：默认0未评价，1已评价*/
    private  Integer isAppraise;
    /**身份证上传地址*/
    private String identityCardUrl;
    /**营业执照文件地址*/
    private String businessLicenseUrl;
    /**驳回原因*/
    private String failureReason;

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getIdentityCardUrl() {
        return identityCardUrl;
    }

    public void setIdentityCardUrl(String identityCardUrl) {
        this.identityCardUrl = identityCardUrl;
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }
    public Integer getIsAppraise() {
        return isAppraise;
    }

    public void setIsAppraise(Integer isAppraise) {
        this.isAppraise = isAppraise;
    }

    public Date getAppraiseTime() {
        return appraiseTime;
    }

    public void setAppraiseTime(Date appraiseTime) {
        this.appraiseTime = appraiseTime;
    }

    public Date getAppraiseAnswerTime() {
        return appraiseAnswerTime;
    }

    public void setAppraiseAnswerTime(Date appraiseAnswerTime) {
        this.appraiseAnswerTime = appraiseAnswerTime;
    }

    public String getInterpretationContent() {
        return interpretationContent;
    }

    public void setInterpretationContent(String interpretationContent) {
        this.interpretationContent = interpretationContent;
    }

    public String getInterpretationTittle() {
        return interpretationTittle;
    }

    public void setInterpretationTittle(String interpretationTittle) {
        this.interpretationTittle = interpretationTittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getApplicableIndustries() {
        return applicableIndustries;
    }

    public void setApplicableIndustries(String applicableIndustries) {
        this.applicableIndustries = applicableIndustries;
    }

    public Integer getDeclaredAmount() {
        return declaredAmount;
    }

    public void setDeclaredAmount(Integer declaredAmount) {
        this.declaredAmount = declaredAmount;
    }

    public String getReviewerPhone() {
        return reviewerPhone;
    }

    public void setReviewerPhone(String reviewerPhone) {
        this.reviewerPhone = reviewerPhone;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    public String getAuditStatusStr() {
        return auditStatusStr;
    }

    public void setAuditStatusStr(String auditStatusStr) {
        this.auditStatusStr = auditStatusStr;
    }

    private Long limit;
    /** 政策资料 */
    private String  meansUrl;

    public String getMeansUrl() {
        return meansUrl;
    }

    public void setMeansUrl(String meansUrl) {
        this.meansUrl = meansUrl;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOriginalPolicyId() {
        return originalPolicyId;
    }

    public void setOriginalPolicyId(Long originalPolicyId) {
        this.originalPolicyId = originalPolicyId;
    }

    public Long getPublishingDepartment() {
        return publishingDepartment;
    }

    public void setPublishingDepartment(Long publishingDepartment) {
        this.publishingDepartment = publishingDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectDeclarationId() {
        return projectDeclarationId;
    }

    public void setProjectDeclarationId(Long projectDeclarationId) {
        this.projectDeclarationId = projectDeclarationId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Long auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getDeclaredFileUrl() {
        return declaredFileUrl;
    }

    public void setDeclaredFileUrl(String declaredFileUrl) {
        this.declaredFileUrl = declaredFileUrl;
    }

    public String getReportingCompany() {
        return reportingCompany;
    }

    public void setReportingCompany(String reportingCompany) {
        this.reportingCompany = reportingCompany;
    }

    public String getDeclarationContact() {
        return declarationContact;
    }

    public void setDeclarationContact(String declarationContact) {
        this.declarationContact = declarationContact;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPolicyLevel() {
        return policyLevel;
    }

    public void setPolicyLevel(String policyLevel) {
        this.policyLevel = policyLevel;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }

    public String getAppraiseAnswer() {
        return appraiseAnswer;
    }

    public void setAppraiseAnswer(String appraiseAnswer) {
        this.appraiseAnswer = appraiseAnswer;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    @Override
    public String toString() {
        return "KyEnterpriseProjectDeclarationVo{" +
                "id=" + id +
                ", projectDeclarationId=" + projectDeclarationId +
                ", enterpriseId=" + enterpriseId +
                ", auditStatus=" + auditStatus +
                ", declaredFileUrl='" + declaredFileUrl + '\'' +
                ", reportingCompany='" + reportingCompany + '\'' +
                ", declarationContact='" + declarationContact + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", publishTime=" + publishTime +
                ", publisher='" + publisher + '\'' +
                ", name='" + name + '\'' +
                ", policyLevel='" + policyLevel + '\'' +
                ", tittle='" + tittle + '\'' +
                ", appraise='" + appraise + '\'' +
                ", appraiseAnswer='" + appraiseAnswer + '\'' +
                ", linkman='" + linkman + '\'' +
                ", linkmanPhone='" + linkmanPhone + '\'' +
                '}';
    }

}
