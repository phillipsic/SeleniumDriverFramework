package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Shopping extends B2CMenu {

    public Shopping(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectScreen = "Shopping";

        if (!expectScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectScreen + " , but got: " + currentScreen);
        }
    }

    public ChooseYourPrimaryOffer clickGSMMobileLink() throws Exception {

        driver.findElement(By.xpath("//li[contains(.,'Welcome to a new world of convergence')]/img")).click();
        driver.findElement(By.linkText("GSM Mobile")).click();

        return new ChooseYourPrimaryOffer(driver);
    }

    public ChooseYourPrimaryOffer clickNetworkTVLink() throws Exception {

        driver.findElement(By.xpath("//li[contains(.,'Welcome to a new world of convergence')]/img")).click();
        driver.findElement(By.linkText("Network TV")).click();

        return new ChooseYourPrimaryOffer(driver);
    }

    public ChooseYourHandset clickVoiceDevicesLink() throws Exception {

        driver.findElement(By.xpath("//li[contains(.,'Voice Items')]/img")).click();
        driver.findElement(By.linkText("Voice Devices")).click();

        return new ChooseYourHandset(driver);
    }

    public ChooseYourHandset clickDataDevicesLink() throws Exception {

        driver.findElement(By.xpath("//li[contains(.,'Data Items')]/img")).click();
        driver.findElement(By.linkText("Data Devices")).click();

        return new ChooseYourHandset(driver);
    }

    public ChooseAccessories clickPhoneAccessoriesLink() throws Exception {

        driver.findElement(By.xpath("//li[starts-with(.,'Accessories')]/img")).click();
        driver.findElement(By.linkText("Phone Accessories")).click();
        return new ChooseAccessories(driver);

    }

    public ChooseYourPrimaryOfferInThisAccountBundle clickFamilyPackLink() throws Exception {

        driver.findElement(By.xpath("//li[contains(.,'Keep in touch with your family')]/img")).click();
        driver.findElement(By.linkText("Family Pack")).click();

        return new ChooseYourPrimaryOfferInThisAccountBundle(driver);
    }

    public SubscriberDetail clickMyAccount() throws Exception {
        driver.findElement(By.linkText("My Account")).click();
        return new SubscriberDetail(driver);
    }
}
