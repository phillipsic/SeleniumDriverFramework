package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class Shopping extends B2CMenu {

    public Shopping(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectScreen = "Shopping";

        if (!expectScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectScreen + " , but got: " + currentScreen);
        }
    }

    public ChooseYourPrimaryOffer clickGSMMobileLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[contains(.,'Welcome to a new world of convergence')]/img")).click();
        tool.driver.findElement(By.linkText("GSM Mobile")).click();

        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public ChooseYourPrimaryOffer clickNetworkTVLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[contains(.,'Welcome to a new world of convergence')]/img")).click();
        tool.driver.findElement(By.linkText("Network TV")).click();

        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public ChooseYourHandset clickVoiceDevicesLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[contains(.,'Voice Items')]/img")).click();
        tool.driver.findElement(By.linkText("Voice Devices")).click();

        return new ChooseYourHandset(tool, test, user);
    }

    public ChooseYourHandset clickDataDevicesLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[contains(.,'Data Items')]/img")).click();
        tool.driver.findElement(By.linkText("Data Devices")).click();

        return new ChooseYourHandset(tool, test, user);
    }

    public ChooseAccessories clickPhoneAccessoriesLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[starts-with(.,'Accessories')]/img")).click();
        tool.driver.findElement(By.linkText("Phone Accessories")).click();
        return new ChooseAccessories(tool, test, user);

    }

    public ChooseYourPrimaryOfferInThisAccountBundle clickFamilyPackLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[contains(.,'Keep in touch with your family')]/img")).click();
        tool.driver.findElement(By.linkText("Family Pack")).click();

        return new ChooseYourPrimaryOfferInThisAccountBundle(tool, test, user);
    }

    public SubscriberDetail clickMyAccount() throws Exception {
        tool.driver.findElement(By.linkText("My Account")).click();
        return new SubscriberDetail(tool, test, user);
    }
}
