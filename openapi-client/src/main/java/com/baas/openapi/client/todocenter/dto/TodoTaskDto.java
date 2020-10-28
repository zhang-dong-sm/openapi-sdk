package com.baas.openapi.client.todocenter.dto;

import java.util.List;

/**
 * @author dongzj
 * @date 2020/10/9 11:41
 */
public class TodoTaskDto {
    /**
     * 标题
     */
    private String title;

    /**
     * 详情url
     */
    private String detailUrl;

    /**
     * pc端详情url
     */
    private String webDetailUrl;

    /**
     * 封面图片url
     */
    private String coverUrl;

    /**
     * 图标url
     */
    private String iconUrl;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 自定义字段
     */
    private List<KeyValEntry> customField;

    /**
     * 发起人id
     */
    private Long sponsorId;

    /**
     * 发起人账号
     */
    private String sponsorAccount;

    /**
     * 发起人单位id
     */
    private Long sponsorUnitId;

    /**
     * 发起人部门id
     */
    private Long sponsorDepId;

    /**
     * 发起时间 (yyyy-MM-dd HH:mm:ss)
     */
    private String sponsorTime;

    /**
     * 业务类型(0-其他，1-流程，2-任务)
     */
    private Integer businessType;

    /**
     * 业务状态
     */
    private String businessStatus;

    /**
     * 任务id
     */
    private String appTaskId;

    /**
     * 处理人和处理类型列表
     */
    private List<HandleEntry> handleEntry;

    /**
     * 待办事项关联的处理人id列表
     */
    private List<String> handlerIds;

    /**
     *  待办事项关联的处理人的account(IAM)
     */
    private List<String> handlerAccounts;

    public static class KeyValEntry {
        public KeyValEntry() {
        }

        public KeyValEntry(String key, String val) {
            this.key = key;
            this.val = val;
        }

        /**
         * 字段名
         */
        private String key;
        /**
         * 字段值
         */
        private String val;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }

    public static class HandleEntry {
        public HandleEntry() {
        }

        public HandleEntry(Long handlerId, Integer handleType) {
            this.handlerId = handlerId;
            this.handleType = handleType;
        }

        public HandleEntry(String handlerAccount, Integer handleType) {
            this.handlerAccount = handlerAccount;
            this.handleType = handleType;
        }

        /**
         * 处理人id
         */
        private Long handlerId;

        /**
         * 处理人账号
         */
        private String handlerAccount;

        /**
         * 处理类型(1-待处理，2-待查阅)
         */
        private Integer handleType;

        public Long getHandlerId() {
            return handlerId;
        }

        public void setHandlerId(Long handlerId) {
            this.handlerId = handlerId;
        }

        public String getHandlerAccount() {
            return handlerAccount;
        }

        public void setHandlerAccount(String handlerAccount) {
            this.handlerAccount = handlerAccount;
        }

        public Integer getHandleType() {
            return handleType;
        }

        public void setHandleType(Integer handleType) {
            this.handleType = handleType;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getWebDetailUrl() {
        return webDetailUrl;
    }

    public void setWebDetailUrl(String webDetailUrl) {
        this.webDetailUrl = webDetailUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<KeyValEntry> getCustomField() {
        return customField;
    }

    public void setCustomField(List<KeyValEntry> customField) {
        this.customField = customField;
    }

    public Long getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Long sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getSponsorAccount() {
        return sponsorAccount;
    }

    public void setSponsorAccount(String sponsorAccount) {
        this.sponsorAccount = sponsorAccount;
    }

    public Long getSponsorUnitId() {
        return sponsorUnitId;
    }

    public void setSponsorUnitId(Long sponsorUnitId) {
        this.sponsorUnitId = sponsorUnitId;
    }

    public Long getSponsorDepId() {
        return sponsorDepId;
    }

    public void setSponsorDepId(Long sponsorDepId) {
        this.sponsorDepId = sponsorDepId;
    }

    public String getSponsorTime() {
        return sponsorTime;
    }

    public void setSponsorTime(String sponsorTime) {
        this.sponsorTime = sponsorTime;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getAppTaskId() {
        return appTaskId;
    }

    public void setAppTaskId(String appTaskId) {
        this.appTaskId = appTaskId;
    }

    public List<HandleEntry> getHandleEntry() {
        return handleEntry;
    }

    public void setHandleEntry(List<HandleEntry> handleEntry) {
        this.handleEntry = handleEntry;
    }

    public List<String> getHandlerIds() {
        return handlerIds;
    }

    public void setHandlerIds(List<String> handlerIds) {
        this.handlerIds = handlerIds;
    }

    public List<String> getHandlerAccounts() {
        return handlerAccounts;
    }

    public void setHandlerAccounts(List<String> handlerAccounts) {
        this.handlerAccounts = handlerAccounts;
    }
}
