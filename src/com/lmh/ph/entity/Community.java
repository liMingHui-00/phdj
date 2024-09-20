package com.lmh.ph.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Community {
        private int communityId;
        private String communityName;
        private String communityProvince;
        private String communityCity;
        private String communityDistrict;
        private String communityAddress;
        private String communityLatitude;
        private String communityLongitude;
        @JSONField(format = "yyyy-MM-dd")
        private Date createTime;
        private int communityShopCount;
        private int communityAreaCode;
        private String communityCoordinates;
        private int communityStatus;
        private int communityUserCount;
        private String distance;

        public Community() {
        }

    public Community(int communityId, String communityName, String communityProvince, String communityCity, String communityDistrict, String communityAddress, String communityLatitude, String communityLongitude, int communityAreaCode, String communityCoordinates) {
        this.communityId = communityId;
        this.communityName = communityName;
        this.communityProvince = communityProvince;
        this.communityCity = communityCity;
        this.communityDistrict = communityDistrict;
        this.communityAddress = communityAddress;
        this.communityLatitude = communityLatitude;
        this.communityLongitude = communityLongitude;
        this.communityAreaCode = communityAreaCode;
        this.communityCoordinates = communityCoordinates;
    }

    public Community(int communityId, String communityName, String communityProvince, String communityCity, String communityDistrict, String communityAddress, String communityLatitude, String communityLongitude, Date createTime, int communityShopCount, int communityAreaCode, String communityCoordinates, int communityStatus, int communityUserCount, String distance) {
            this.communityId = communityId;
            this.communityName = communityName;
            this.communityProvince = communityProvince;
            this.communityCity = communityCity;
            this.communityDistrict = communityDistrict;
            this.communityAddress = communityAddress;
            this.communityLatitude = communityLatitude;
            this.communityLongitude = communityLongitude;
            this.createTime = createTime;
            this.communityShopCount = communityShopCount;
            this.communityAreaCode = communityAreaCode;
            this.communityCoordinates = communityCoordinates;
            this.communityStatus = communityStatus;
            this.communityUserCount = communityUserCount;
            this.distance = distance;
        }

        public int getCommunityId() {
            return communityId;
        }

        public void setCommunityId(int communityId) {
            this.communityId = communityId;
        }

        public String getCommunityName() {
            return communityName;
        }

        public void setCommunityName(String communityName) {
            this.communityName = communityName;
        }

        public String getCommunityProvince() {
            return communityProvince;
        }

        public void setCommunityProvince(String communityProvince) {
            this.communityProvince = communityProvince;
        }

        public String getCommunityCity() {
            return communityCity;
        }

        public void setCommunityCity(String communityCity) {
            this.communityCity = communityCity;
        }

        public String getCommunityDistrict() {
            return communityDistrict;
        }

        public void setCommunityDistrict(String communityDistrict) {
            this.communityDistrict = communityDistrict;
        }

        public String getCommunityAddress() {
            return communityAddress;
        }

        public void setCommunityAddress(String communityAddress) {
            this.communityAddress = communityAddress;
        }

        public String getCommunityLatitude() {
            return communityLatitude;
        }

        public void setCommunityLatitude(String communityLatitude) {
            this.communityLatitude = communityLatitude;
        }

        public String getCommunityLongitude() {
            return communityLongitude;
        }

        public void setCommunityLongitude(String communityLongitude) {
            this.communityLongitude = communityLongitude;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public int getCommunityShopCount() {
            return communityShopCount;
        }

        public void setCommunityShopCount(int communityShopCount) {
            this.communityShopCount = communityShopCount;
        }

        public int getCommunityAreaCode() {
            return communityAreaCode;
        }

        public void setCommunityAreaCode(int communityAreaCode) {
            this.communityAreaCode = communityAreaCode;
        }

        public String getCommunityCoordinates() {
            return communityCoordinates;
        }

        public void setCommunityCoordinates(String communityCoordinates) {
            this.communityCoordinates = communityCoordinates;
        }

        public int getCommunityStatus() {
            return communityStatus;
        }

        public void setCommunityStatus(int communityStatus) {
            this.communityStatus = communityStatus;
        }

        public int getCommunityUserCount() {
            return communityUserCount;
        }

        public void setCommunityUserCount(int communityUserCount) {
            this.communityUserCount = communityUserCount;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }
}
