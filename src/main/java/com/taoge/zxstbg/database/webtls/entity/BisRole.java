package com.taoge.zxstbg.database.webtls.entity;

public class BisRole {
    private String id;

    private String name;

    private String isOpenProcess;

    private String stationId;

    private String createTime;

    private String modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIsOpenProcess() {
        return isOpenProcess;
    }

    public void setIsOpenProcess(String isOpenProcess) {
        this.isOpenProcess = isOpenProcess == null ? null : isOpenProcess.trim();
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}