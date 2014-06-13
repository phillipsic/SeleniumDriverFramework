package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Subscriber;

public class ServiceConnectionDetailsCommon extends CommonMenu {

    public ServiceConnectionDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Service Connection Details";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickOk() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new MyBasketCommon(tool, test, user);
    }

    public SwapImpactCommon clickOkExpectingSwapImpact() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new SwapImpactCommon(tool, test, user);
    }

    public void SetEmailInventory(String email) throws Exception {
        
        tool.enterStringUsingId(tool, "inputFields1414", email);

    }

    public MyBasketCommon clickOkAfterSetEmailInventory() throws Exception {
        tool.driver.findElement(By.id("display_line_submit_button")).click();
        return new MyBasketCommon(tool, test, user);
    }

    public void clickSetSIMInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "SIM type:";

        this.clickSetButton(inventoryString);
        String SIM = tool.driver.findElement(By.xpath("//p[span[contains(text(),\"SIM reference:\")]]/span[2]")).getText();
        subscriber.setSubscriberSIMProperty(SIM);
    }

    public void clickSetIMSIInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "IMSI type:";

        this.clickSetButton(inventoryString);
        String IMSI = tool.driver.findElement(By.xpath("//p[span[contains(text(),\"IMSI reference:\")]]/span[2]")).getText();
        subscriber.setSubscriberIMSIProperty(IMSI);
    }

    public void clickSetMSISDNInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "MSISDN type:";

        this.clickSetButton(inventoryString);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        String MSISDN = tool.driver.findElement(By.xpath("//p[span[contains(text(),\"MSISDN reference:\")]]/span[2]")).getText();
        subscriber.setSubscriberMSISDNProperty(MSISDN);
    }

    public void clickSetTVQualityInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "TVQuality type:";

        this.clickSetButton(inventoryString);
        String TVQuality = tool.driver.findElement(By.xpath("//p[span[contains(text(),\"TVQuality reference:\")]]/span[2]")).getText();
        subscriber.setSubscriberTVQualityProperty(TVQuality);
    }

    public void clickSetButton(String inventoryString) throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        tool.clickUsingXPath(tool, "//span[contains(.,'" + inventoryString + "')]/../../following-sibling::div[1]/div/div/span/input");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }
}
