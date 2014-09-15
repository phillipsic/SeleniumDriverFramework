/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ChooseYourHandset extends B2CMenu {

    public ChooseYourHandset(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Choose Your Handset";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public ChooseYourPrimaryOffer selectHandset(String Handset) throws Exception {
        tool.clickUsingXPath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='Select']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public EnterYourSubscriptionDetails selectHandsetExpectingSubscriptionDetails(String Handset) throws Exception {
        tool.clickUsingXPath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='Select']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public MyBasket selectHandsetExpectingMyBasket(String Handset) throws Exception {
        tool.clickUsingXPath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='Select']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public void selectManufacturer1() throws Exception {
        if (!(tool.searchUsingCssSelector("input[value='Manufacturer 1']").isSelected()))
            tool.searchUsingCssSelector("input[value='Manufacturer 1']").click();
    }

    public void unSelectManufacturer1() throws Exception {
        if (tool.searchUsingCssSelector("input[value='Manufacturer 1']").isSelected())
            tool.searchUsingCssSelector("input[value='Manufacturer 1']").click();
    }

    public void selectManufacturer2() throws Exception {
        if (!(tool.searchUsingCssSelector("input[value='Manufacturer 2']").isSelected()))
            tool.searchUsingCssSelector("input[value='Manufacturer 2']").click();
    }

    public void unSelectManufacturer2() throws Exception {
        if (tool.searchUsingCssSelector("input[value='Manufacturer 2']").isSelected())
            tool.searchUsingCssSelector("input[value='Manufacturer 2']").click();
    }

    public void setSearchAttribute(String searchString) throws Exception {
        tool.enterStringUsingCssSelector("input[type='text'][name='searchString']", searchString);
    }

    public void clickFilter() throws Exception {
        tool.clickUsingCssSelector("input[type='submit'][value='Filter']");
    }

    public MyBasket clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public void clickAdvanceFilterLink() throws Exception {
        tool.clickUsingLinkText("Advanced Filter");
    }

    public HandsetDetails viewDetailsOfHandset(String Handset) throws Exception {

        tool.clickUsingXPath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='View Details']");
        return new HandsetDetails(tool, test, user);
    }

    public ChooseYourHandset clickAddToCompare(String Handset) throws Exception {

        tool.clickUsingXPath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='Add to Compare']");
        return new ChooseYourHandset(tool, test, user);
    }

    public String comparableDevice1() throws Exception {
        String temp = tool.getTextUsingXPath(".//div[@class='comparisonItem' and starts-with(.,'1.')]");
        String[] compareDevice = temp.split(":");
        return compareDevice[1].trim();

    }

    public CompareDevices clickCompare() throws Exception {
        tool.clickUsingCssSelector("input[type='submit'][value='Compare']");
        return new CompareDevices(tool, test, user);
    }

    public String comparableDevice2() throws Exception {
        String temp = tool.getTextUsingXPath(".//div[@class='comparisonItem' and starts-with(.,'2.')]");
        String[] compareDevice = temp.split(":");
        return compareDevice[1].trim();

    }

}
