package com.comverse.css.b2c;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class MyBasket extends B2CMenu {

    public MyBasket(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "My Basket";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public CheckoutRegister clickCheckOut() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Checkout']");
        return new CheckoutRegister(tool, test, user);
    }

    public TermsAndConditions clickCheckOutExpectingTermsAndConditions() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Checkout']");
        return new TermsAndConditions(tool, test, user);
    }

    public CheckOutBillingAccountInformation clickCheckOutExpectingCheckOutBillingAccountInformation() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Checkout']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public SelectOffersForYourSubscriber clickAddSupplementaryOffers() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("add_srv_0");
        return new SelectOffersForYourSubscriber(tool, test, user);
    }

    public TermsAndConditions clickCheckOutWithDevices() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Checkout']");
        return new TermsAndConditions(tool, test, user);
    }

    public ConfirmOffersSelection clickModifyOnSO(String SO) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + SO + ")");
        List<WebElement> Cols = (List<WebElement>) tool.searchListUsingTagName("td");
        for (WebElement eachCol : Cols) {
            if (eachCol.getText().contains(SO)) {
                eachCol.findElement(By.linkText("Modify...")).click();
                break;
            }

        }
        return new ConfirmOffersSelection(tool, test, user);
    }

    public RemoveSupplementaryOffer clickRemoveOnSO(String SO) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + SO + ")");
        List<WebElement> Cols = (List<WebElement>) tool.searchListUsingTagName("td");
        int cnter = 0;
        for (WebElement eachCol : Cols) {
            cnter++;
            if (eachCol.getText().contains(SO)) {
                break;
            }

        }
        Cols.get(cnter + 4).getText();
        Cols.get(cnter + 4).findElement(By.linkText("Remove")).click();
        return new RemoveSupplementaryOffer(tool, test, user);
    }

    public Shopping clickContinueShopping() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue Shopping']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new Shopping(tool, test, user);
    }

    public ChooseAccessories clickAddAccessory() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingLinkText("Add Accessory");
        return new ChooseAccessories(tool, test, user);
    }

    public ChooseYourHandset clickChangeDevice() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingLinkText("Change Device");
        return new ChooseYourHandset(tool, test, user);
    }

    public ChooseYourPrimaryOffer clickChangePO() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingLinkText("Change Primary Offer");
        return new ChooseYourPrimaryOffer(tool, test, user);
    }
}
