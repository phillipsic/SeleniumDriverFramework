package com.framework.data;

public abstract class GoogleSheetConnectionDetails {

    private String spreadSheetName;
    private String client_id;
    private String client_secret;
    private String accessToken;
    private String refreshToken;
    private String workSheetName;
    private String addonURL;

    public String getAddonURL() {
        return addonURL;
    }

    public void setAddonURL(String addonURL) {
        this.addonURL = addonURL;
    }
    


    public String getWorkSheetName() {
        return workSheetName;
    }

    public void setWorkSheetName(String workSheetName) {
        this.workSheetName = workSheetName;
    }

    public String getSpreadSheetName() {
        return spreadSheetName;
    }

    public void setSpreadSheetName(String sheetName) {
        this.spreadSheetName = sheetName;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
