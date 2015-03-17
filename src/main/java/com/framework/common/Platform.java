package com.framework.common;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Platform extends Main {

    private String computerName;
    private String OS;
    private String OSFullNameAndVersion;
    private String browser;
    private String browserFullNameAndVersion;

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

    public void IE(DesiredCapabilities capabilities) throws Exception {
        capabilities.setBrowserName("internet explorer");
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
        capabilities.setBrowserName("chrome");
        File file = new File("CHDriverServer/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    }
}
