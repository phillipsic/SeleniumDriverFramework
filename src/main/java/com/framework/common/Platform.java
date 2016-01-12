package com.framework.common;

import java.io.File;
import org.apache.commons.lang3.SystemUtils;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Platform extends Main {

    private String computerName;
    private String OS;
    private String OSFullNameAndVersion;
    private String browser;
    private String browserFullNameAndVersion;
    private String platformOs;

    public void setPlatformOs(String platformOs) {
        this.platformOs = platformOs;
    }

    public String getPlatformOs() {
        return platformOs;
    }

    public Platform() throws Exception {
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String oS) {
        OS = oS;
    }

    public String getOSFullNameAndVersion() {
        return OSFullNameAndVersion;
    }

    public void setOSFullNameAndVersion(String oSFullNameAndVersion) {
        OSFullNameAndVersion = oSFullNameAndVersion;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserFullNameAndVersion() {
        return browserFullNameAndVersion;
    }

    public void setBrowserFullNameAndVersion(String browserFullNameAndVersion) {
        this.browserFullNameAndVersion = browserFullNameAndVersion;
    }

    public String getOsOfTestPlatform() {
        return platformOs;
    }

    public void setOsOfTestPlatform() {

        this.platformOs = getCurrentPlatformOs();
    }

    private String getCurrentPlatformOs() {

        String testOS = "N/A";

        if (SystemUtils.IS_OS_MAC_OSX) {
            testOS = "MAC";
        }
        if (SystemUtils.IS_OS_WINDOWS) {
            testOS = "WIN";
        }

        return testOS;
    }

    public void IE(DesiredCapabilities capabilities) throws Exception {
        capabilities.setBrowserName("internet explorer");
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability("nativeEvents", false);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        File file = new File("IEDriverServer/IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
    }

    public FirefoxProfile FF(DesiredCapabilities capabilities) throws Exception {
        FirefoxProfile profile = new FirefoxProfile();
        capabilities.setBrowserName("firefox");
        System.out.println("Staring FF Driver");
        return profile;
    }

    public void CH(DesiredCapabilities capabilities) throws Exception {

        String filePath = "";
        capabilities.setBrowserName("chrome");

        if (this.platformOs.equalsIgnoreCase("mac")) {

            filePath = "CHDriverServer/chromedriver";
        }

        if (this.platformOs.equalsIgnoreCase("win")) {
            filePath = "CHDriverServer/chromedriver.exe";
        }

        File file = new File(filePath);

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    }
}
