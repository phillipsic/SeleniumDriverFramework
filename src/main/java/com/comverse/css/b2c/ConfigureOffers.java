/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfigureOffers extends B2CMenu {

    public ConfigureOffers(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Configure Offers";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public ChooseAccessories clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        return new ChooseAccessories(tool, test, user);
    }

    public ConfigureBalance clickContinueExpectingConfigureBalance() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        return new ConfigureBalance(tool, test, user);
    }

    public AddSupplementaryOffers clickContinueExpectingOfferConfirmation() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@type='submit' and @name='continue_button']");
        return new AddSupplementaryOffers(tool, test, user);
    }

    public MyBasket clickContinueExpectingMyBasket() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@type='submit' and @name='continue_button']");
        return new MyBasket(tool, test, user);
    }

    public SwapImpact clickContinueExpectingSwapImpact() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        return new SwapImpact(tool, test, user);
    }

}
