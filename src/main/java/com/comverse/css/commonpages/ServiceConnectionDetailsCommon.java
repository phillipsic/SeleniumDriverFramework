package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Subscriber;

public class ServiceConnectionDetailsCommon extends CommonMenu {

    public ServiceConnectionDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Service Connection Details";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public MyBasketCommon clickOk() throws Exception {
        tool.clickUsingXPath("//input[@value='OK']");
        return new MyBasketCommon(tool, test, user);
    }

    public SwapImpactCommon clickOkExpectingSwapImpact() throws Exception {
        tool.clickUsingXPath("//input[@value='OK']");
        return new SwapImpactCommon(tool, test, user);
    }

    public void SetEmailInventory(String email) throws Exception {
        
        tool.enterStringUsingId("inputFields1414", email);

    }

    public MyBasketCommon clickOkAfterSetEmailInventory() throws Exception {
        tool.clickUsingID("display_line_submit_button");
        return new MyBasketCommon(tool, test, user);
    }

    public void clickSetSIMInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "SIM type:";

        this.clickSetButton(inventoryString);
        String SIM = tool.getTextUsingXPath("//p[span[contains(text(),\"SIM reference:\")]]/span[2]");
        subscriber.setSubscriberSIMProperty(SIM);
    }

    public void clickSetIMSIInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "IMSI type:";

        this.clickSetButton(inventoryString);
        String IMSI = tool.getTextUsingXPath("//p[span[contains(text(),\"IMSI reference:\")]]/span[2]");
        subscriber.setSubscriberIMSIProperty(IMSI);
    }

    public void clickSetMSISDNInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "MSISDN type:";

        this.clickSetButton(inventoryString);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        String MSISDN = tool.getTextUsingXPath("//p[span[contains(text(),\"MSISDN reference:\")]]/span[2]");
        subscriber.setSubscriberMSISDNProperty(MSISDN);
    }

    public void clickSetTVQualityInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "TVQuality type:";

        this.clickSetButton(inventoryString);
        String TVQuality = tool.getTextUsingXPath("//p[span[contains(text(),\"TVQuality reference:\")]]/span[2]");
        subscriber.setSubscriberTVQualityProperty(TVQuality);
    }

    public void clickSetButton(String inventoryString) throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        tool.clickUsingXPath("//span[contains(.,'" + inventoryString + "')]/../../following-sibling::div[1]/div/div/span/input");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }
}
