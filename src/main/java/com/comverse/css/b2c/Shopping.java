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
        tool.clickUsingLinkText(tool, "GSM Mobile");

        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public ChooseYourPrimaryOffer clickNetworkTVLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[contains(.,'Welcome to a new world of convergence')]/img")).click();
        tool.clickUsingLinkText(tool, "Network TV");

        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public ChooseYourHandset clickVoiceDevicesLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[contains(.,'Voice Items')]/img")).click();
        tool.clickUsingLinkText(tool, "Voice Devices");

        return new ChooseYourHandset(tool, test, user);
    }

    public ChooseYourHandset clickDataDevicesLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[contains(.,'Data Items')]/img")).click();
        tool.clickUsingLinkText(tool, "Data Devices");

        return new ChooseYourHandset(tool, test, user);
    }

    public ChooseAccessories clickPhoneAccessoriesLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[starts-with(.,'Accessories')]/img")).click();
        tool.clickUsingLinkText(tool, "Phone Accessories");
        return new ChooseAccessories(tool, test, user);

    }

    public ChooseYourPrimaryOfferInThisAccountBundle clickFamilyPackLink() throws Exception {

        tool.driver.findElement(By.xpath("//li[contains(.,'Keep in touch with your family')]/img")).click();
        tool.clickUsingLinkText(tool, "Family Pack");

        return new ChooseYourPrimaryOfferInThisAccountBundle(tool, test, user);
    }

    @Override
	public SubscriberDetail clickMyAccount() throws Exception {
        tool.clickUsingLinkText(tool, "My Account");
        return new SubscriberDetail(tool, test, user);
    }
}
