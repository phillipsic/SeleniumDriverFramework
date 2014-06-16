package com.comverse.css.commonpages;

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

        String currentScreen = tool.getTitle(tool);

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectEventTypeDispatch() throws Exception {

        Select select = new Select(tool.searchUsingID(tool, "eventType"));
        select.selectByVisibleText("Dispatch");
        selectedValue = tool.getTextUsingXPath(tool, "//option[@selected='selected']");
        System.out.println(selectedValue);

    }

    public void selectNRCTypeDispatchFee() throws Exception {

        Select select = new Select(tool.searchUsingID(tool, "charge"));
        select.selectByVisibleText("Dispatch Fee");

        tool.clickUsingXPath(tool, "//input[@value='Confirm']");

        boolean successfullyDisplayed = false;

        int loopCounter = 0;

        while (!successfullyDisplayed) {
            try {

                loopCounter++;

                System.out.println("Loop: " + loopCounter + " of 20");
                if (loopCounter >= 20) {
                    successfullyDisplayed = true;
                }

                String pageTitle = tool.getTitle(tool);

                if (pageTitle.equals("Add Standalone Charge - Confirmation")) {
                    successfullyDisplayed = true;
                } else {

                    tool.navigateRefresh(tool);
                }
            } catch (Exception e) {
                System.out.println("Menu item not selectable");
            }
        }
    }

    public void confirmStandaloneCharge() throws Exception {
        boolean successfullyDisplayed = false;
        int loopCounter = 0;

        tool.clickUsingXPath(tool, "//input[@value='Confirm']");

        while (!successfullyDisplayed) {
            try {

                loopCounter++;

                System.out.println("Loop: " + loopCounter + " of 20");
                if (loopCounter >= 20) {
                    successfullyDisplayed = true;
                }

                String pageTitle = tool.getTitle(tool);

                if (pageTitle.equals("Action Done")) {
                    successfullyDisplayed = true;
                } else {

                    tool.navigateRefresh(tool);
                }
            } catch (Exception e) {
                System.out.println("Menu item not selectable");
            }
        }

        Common.assertTextOnPage(tool, "The Charge has been successfully provisioned .");

        tool.clickUsingXPath(tool, "//input[@value='OK']");

    }

    public void verifyNRCInUnbilledTransaction() {
        /*
         * ToDo when CBS00155062 gets resolved.
         */

    }

}
