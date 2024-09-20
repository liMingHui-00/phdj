package com.lmh.ph.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Stations {
    private int courierStationId;
    private String courierStationName;
    private String courierStationImage;
    private int courierStationOrderCount;
    private int courierStationStatus;
    @JSONField(format = "yyyy-MM-dd")
    private Date addTime;
    private String courierStationProvince;
    private String courierStationCity;
    private String courierStationDistrict;
    private String courierStationAddress;
    private int courierStationCommunityId;
    private String courierStationCommunityName;
    private int courierStationSort;

    public Stations() {
    }

    public Stations(int courierStationId, String courierStationName, String courierStationImage, int courierStationOrderCount, int courierStationStatus, Date addTime, String courierStationProvince, String courierStationCity, String courierStationDistrict, String courierStationAddress, int courierStationCommunityId, String courierStationCommunityName, int courierStationSort) {
        this.courierStationId = courierStationId;
        this.courierStationName = courierStationName;
        this.courierStationImage = courierStationImage;
        this.courierStationOrderCount = courierStationOrderCount;
        this.courierStationStatus = courierStationStatus;
        this.addTime = addTime;
        this.courierStationProvince = courierStationProvince;
        this.courierStationCity = courierStationCity;
        this.courierStationDistrict = courierStationDistrict;
        this.courierStationAddress = courierStationAddress;
        this.courierStationCommunityId = courierStationCommunityId;
        this.courierStationCommunityName = courierStationCommunityName;
        this.courierStationSort = courierStationSort;
    }


    /**
     * 获取
     * @return courierStationId
     */
    public int getCourierStationId() {
        return courierStationId;
    }

    /**
     * 设置
     * @param courierStationId
     */
    public void setCourierStationId(int courierStationId) {
        this.courierStationId = courierStationId;
    }

    /**
     * 获取
     * @return courierStationName
     */
    public String getCourierStationName() {
        return courierStationName;
    }

    /**
     * 设置
     * @param courierStationName
     */
    public void setCourierStationName(String courierStationName) {
        this.courierStationName = courierStationName;
    }

    /**
     * 获取
     * @return courierStationImage
     */
    public String getCourierStationImage() {
        return courierStationImage;
    }

    /**
     * 设置
     * @param courierStationImage
     */
    public void setCourierStationImage(String courierStationImage) {
        this.courierStationImage = courierStationImage;
    }

    /**
     * 获取
     * @return courierStationOrderCount
     */
    public int getCourierStationOrderCount() {
        return courierStationOrderCount;
    }

    /**
     * 设置
     * @param courierStationOrderCount
     */
    public void setCourierStationOrderCount(int courierStationOrderCount) {
        this.courierStationOrderCount = courierStationOrderCount;
    }

    /**
     * 获取
     * @return courierStationStatus
     */
    public int getCourierStationStatus() {
        return courierStationStatus;
    }

    /**
     * 设置
     * @param courierStationStatus
     */
    public void setCourierStationStatus(int courierStationStatus) {
        this.courierStationStatus = courierStationStatus;
    }

    /**
     * 获取
     * @return addTime
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置
     * @param addTime
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取
     * @return courierStationProvince
     */
    public String getCourierStationProvince() {
        return courierStationProvince;
    }

    /**
     * 设置
     * @param courierStationProvince
     */
    public void setCourierStationProvince(String courierStationProvince) {
        this.courierStationProvince = courierStationProvince;
    }

    /**
     * 获取
     * @return courierStationCity
     */
    public String getCourierStationCity() {
        return courierStationCity;
    }

    /**
     * 设置
     * @param courierStationCity
     */
    public void setCourierStationCity(String courierStationCity) {
        this.courierStationCity = courierStationCity;
    }

    /**
     * 获取
     * @return courierStationDistrict
     */
    public String getCourierStationDistrict() {
        return courierStationDistrict;
    }

    /**
     * 设置
     * @param courierStationDistrict
     */
    public void setCourierStationDistrict(String courierStationDistrict) {
        this.courierStationDistrict = courierStationDistrict;
    }

    /**
     * 获取
     * @return courierStationAddress
     */
    public String getCourierStationAddress() {
        return courierStationAddress;
    }

    /**
     * 设置
     * @param courierStationAddress
     */
    public void setCourierStationAddress(String courierStationAddress) {
        this.courierStationAddress = courierStationAddress;
    }

    /**
     * 获取
     * @return courierStationCommunityId
     */
    public int getCourierStationCommunityId() {
        return courierStationCommunityId;
    }

    /**
     * 设置
     * @param courierStationCommunityId
     */
    public void setCourierStationCommunityId(int courierStationCommunityId) {
        this.courierStationCommunityId = courierStationCommunityId;
    }

    /**
     * 获取
     * @return courierStationCommunityName
     */
    public String getCourierStationCommunityName() {
        return courierStationCommunityName;
    }

    /**
     * 设置
     * @param courierStationCommunityName
     */
    public void setCourierStationCommunityName(String courierStationCommunityName) {
        this.courierStationCommunityName = courierStationCommunityName;
    }

    /**
     * 获取
     * @return courierStationSort
     */
    public int getCourierStationSort() {
        return courierStationSort;
    }

    /**
     * 设置
     * @param courierStationSort
     */
    public void setCourierStationSort(int courierStationSort) {
        this.courierStationSort = courierStationSort;
    }

    public String toString() {
        return "Stations{courierStationId = " + courierStationId + ", courierStationName = " + courierStationName + ", courierStationImage = " + courierStationImage + ", courierStationOrderCount = " + courierStationOrderCount + ", courierStationStatus = " + courierStationStatus + ", addTime = " + addTime + ", courierStationProvince = " + courierStationProvince + ", courierStationCity = " + courierStationCity + ", courierStationDistrict = " + courierStationDistrict + ", courierStationAddress = " + courierStationAddress + ", courierStationCommunityId = " + courierStationCommunityId + ", courierStationCommunityName = " + courierStationCommunityName + ", courierStationSort = " + courierStationSort + "}";
    }
}
