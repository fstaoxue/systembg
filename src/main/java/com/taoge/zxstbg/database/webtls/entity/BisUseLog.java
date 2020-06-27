package com.taoge.zxstbg.database.webtls.entity;

import java.util.Date;

public class BisUseLog {
    private Integer id;

    private String module;

    private String opTime;

    private String opUserId;

    private String opUserName;

    private String opDeptId;

    private String opDeptName;

    private String opType;

    private String clientIp;

    private String caseCode;

    private String targetNumId;

    private String targetNum;

    private String queryBeginTime;

    private String queryEndTime;

    private String parentBusiId;

    private String busiId;

    private String busiUrl;

    private String uploadFlag;

    private Date failTime;

    private String opDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getOpTime() {
        return opTime;
    }

    public void setOpTime(String opTime) {
        this.opTime = opTime == null ? null : opTime.trim();
    }

    public String getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(String opUserId) {
        this.opUserId = opUserId == null ? null : opUserId.trim();
    }

    public String getOpUserName() {
        return opUserName;
    }

    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName == null ? null : opUserName.trim();
    }

    public String getOpDeptId() {
        return opDeptId;
    }

    public void setOpDeptId(String opDeptId) {
        this.opDeptId = opDeptId == null ? null : opDeptId.trim();
    }

    public String getOpDeptName() {
        return opDeptName;
    }

    public void setOpDeptName(String opDeptName) {
        this.opDeptName = opDeptName == null ? null : opDeptName.trim();
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType == null ? null : opType.trim();
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode == null ? null : caseCode.trim();
    }

    public String getTargetNumId() {
        return targetNumId;
    }

    public void setTargetNumId(String targetNumId) {
        this.targetNumId = targetNumId == null ? null : targetNumId.trim();
    }

    public String getTargetNum() {
        return targetNum;
    }

    public void setTargetNum(String targetNum) {
        this.targetNum = targetNum == null ? null : targetNum.trim();
    }

    public String getQueryBeginTime() {
        return queryBeginTime;
    }

    public void setQueryBeginTime(String queryBeginTime) {
        this.queryBeginTime = queryBeginTime == null ? null : queryBeginTime.trim();
    }

    public String getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(String queryEndTime) {
        this.queryEndTime = queryEndTime == null ? null : queryEndTime.trim();
    }

    public String getParentBusiId() {
        return parentBusiId;
    }

    public void setParentBusiId(String parentBusiId) {
        this.parentBusiId = parentBusiId == null ? null : parentBusiId.trim();
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId == null ? null : busiId.trim();
    }

    public String getBusiUrl() {
        return busiUrl;
    }

    public void setBusiUrl(String busiUrl) {
        this.busiUrl = busiUrl == null ? null : busiUrl.trim();
    }

    public String getUploadFlag() {
        return uploadFlag;
    }

    public void setUploadFlag(String uploadFlag) {
        this.uploadFlag = uploadFlag == null ? null : uploadFlag.trim();
    }

    public Date getFailTime() {
        return failTime;
    }

    public void setFailTime(Date failTime) {
        this.failTime = failTime;
    }

    public String getOpDesc() {
        return opDesc;
    }

    public void setOpDesc(String opDesc) {
        this.opDesc = opDesc == null ? null : opDesc.trim();
    }
}