/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SelectOffersForYourSubscriberCommon extends CommonMenu {

    static String expectedScreen = "Select offers for your Subscriber";

    public SelectOffersForYourSubscriberCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void selectOffersForSubscriber(String... SOTable) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        if (SOTable != null) {
            for (String SOName : SOTable) {
                tool.clickUsingXPath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../../td/input");
            }
        }
    }

    public SupplementaryOfferDetailsCommon clickOfferDetail(String SOName) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../a");
        return new SupplementaryOfferDetailsCommon(tool, test, user);
    }

    public ConfigureOffersCommon clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        return new ConfigureOffersCommon(tool, test, user);
    }

    public MyBasketCommon clickContinueExpectingMyBasket() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new MyBasketCommon(tool, test, user);
    }

    public SwapImpactCommon clickContinueExpectingSwapImpact() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new SwapImpactCommon(tool, test, user);
    }

    public ServiceConnectionDetailsCommon clickContinueExpectingServiceConnectionDetails() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public MyBasketCommon clickPrevious() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='< Previous'");
        return new MyBasketCommon(tool, test, user);
    }

    public MyBasketCommon clickCancel() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Cancel'");
        return new MyBasketCommon(tool, test, user);
    }

    public void clickOfferDetailOnPopUp(String SOName) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../a");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void clickClose() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Close']");

    }

}
