package com.example.mybatisplus.model.dto;
public class BatchDTO {
    private String batchName;
    private String batchCreatedTime;
    private String regStartTime;
    private String regEndTime;
    private String batchInfo;
    private String batchStartTime;
    private String batchEndTime;
    private int batchDuration;
    private int expectNum;

    // Getters and setters
    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBatchCreatedTime() {
        return batchCreatedTime;
    }

    public void setBatchCreatedTime(String batchCreatedTime) {
        this.batchCreatedTime = batchCreatedTime;
    }

    public String getRegStartTime() {
        return regStartTime;
    }

    public void setRegStartTime(String regStartTime) {
        this.regStartTime = regStartTime;
    }

    public String getRegEndTime() {
        return regEndTime;
    }

    public void setRegEndTime(String regEndTime) {
        this.regEndTime = regEndTime;
    }

    public String getBatchInfo() {
        return batchInfo;
    }

    public void setBatchInfo(String batchInfo) {
        this.batchInfo = batchInfo;
    }

    public String getBatchStartTime() {
        return batchStartTime;
    }

    public void setBatchStartTime(String batchStartTime) {
        this.batchStartTime = batchStartTime;
    }

    public String getBatchEndTime() {
        return batchEndTime;
    }

    public void setBatchEndTime(String batchEndTime) {
        this.batchEndTime = batchEndTime;
    }

    public int getBatchDuration() {
        return batchDuration;
    }

    public void setBatchDuration(int batchDuration) {
        this.batchDuration = batchDuration;
    }


    public int getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(int expectNum) {
        this.expectNum = expectNum;
    }
}


