package com.company.css.data;

public abstract class Device extends C1Data {

    private String deviceName;
    private String devicePriceinDollar;
    private String devicePriceinEuro;
    private String deviceStock;
    private String deviceDescription;
    private String deviceTermsAndConditions;

    protected Device() {
        setDeviceName(null);
        setDevicePriceinDollar(null);
        setDevicePriceinEuro(null);
        setDeviceStock(null);
        setDeviceDescription(null);
        setDeviceTermsAndConditions(null);
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setDevicePriceinDollar(String devicePrice) {
        this.devicePriceinDollar = devicePrice;
    }

    public void setDevicePriceinEuro(String devicePrice) {
        this.devicePriceinEuro = devicePrice;
    }

    public void setDeviceStock(String deviceStock) {
        this.deviceStock = deviceStock;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDevicePriceinDollar() {
        return devicePriceinDollar;
    }

    public String getDevicePriceinEuro() {
        return devicePriceinEuro;
    }

    public String getDeviceStock() {
        return deviceStock;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceTermsAndConditions(String deviceTermsAndConditions) {
        this.deviceTermsAndConditions = deviceTermsAndConditions;
    }

    public String getDeviceTermsAndConditions() {
        return deviceTermsAndConditions;
    }
}
