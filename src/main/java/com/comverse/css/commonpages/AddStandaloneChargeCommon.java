package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddStandaloneChargeCommon extends CommonMenu {

    static String expectedScreen = "Add Standalone Charge";
    static String selectedValue = null;

    public AddStandaloneChargeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectEventTypeDispatch() throws Exception {

        Select select = new Select(tool.searchUsingID(tool, "eventType"));
        select.selectByVisibleText("Dispatch");
        selectedValue = tool.driver.findElement(By.xpath("//option[@selected='selected']")).getText();
        System.out.println(selectedValue);

    }

    public void selectNRCTypeDispatchFee() throws Exception {

        Select select = new Select(tool.searchUsingID(tool, "charge"));
        select.selectByVisibleText("Dispatch Fee");

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();

        boolean successfullyDisplayed = false;

        int loopCounter = 0;

        while (!successfullyDisplayed) {
            try {

                loopCounter++;

                System.out.println("Loop: " + loopCounter + " of 20");
                if (loopCounter >= 20) {
                    successfullyDisplayed = true;
                }

                String pageTitle = tool.driver.getTitle();

                if (pageTitle.equals("Add Standalone Charge - Confirmation")) {
                    successfullyDisplayed = true;
                } else {

                    tool.driver.navigate().refresh();
                }
            } catch (Exception e) {
                System.out.println("Menu item not selectable");
            }
        }
    }

    public void confirmStandaloneCharge() throws Exception {
        boolean successfullyDisplayed = false;
        int loopCounter = 0;

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();

        while (!successfullyDisplayed) {
            try {

                loopCounter++;

                System.out.println("Loop: " + loopCounter + " of 20");
                if (loopCounter >= 20) {
                    successfullyDisplayed = true;
                }

                String pageTitle = tool.driver.getTitle();

                if (pageTitle.equals("Action Done")) {
                    successfullyDisplayed = true;
                } else {

                    tool.driver.navigate().refresh();
                }
            } catch (Exception e) {
                System.out.println("Menu item not selectable");
            }
        }

        Common.assertTextOnPage(tool, "The Charge has been successfully provisioned .");

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();

    }

    public void verifyNRCInUnbilledTransaction() {
        /*
         * ToDo when CBS00155062 gets resolved.
         */

    }

}
