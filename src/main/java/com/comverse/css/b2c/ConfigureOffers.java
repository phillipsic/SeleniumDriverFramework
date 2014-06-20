/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfigureOffers extends B2CMenu {

    public ConfigureOffers(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Configure Offers";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ChooseAccessories clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new ChooseAccessories(tool, test, user);
    }

    public ConfigureBalance clickContinueExpectingConfigureBalance() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new ConfigureBalance(tool, test, user);
    }

    public AddSO clickContinueExpectingOfferConfirmation() throws Exception {
        tool.clickUsingXPath("//input[@type='submit' and @name='continue_button']");

        return new AddSO(tool, test, user);
    }

    public MyBasket clickContinueExpectingMyBasket() throws Exception {
        tool.clickUsingXPath("//input[@type='submit' and @name='continue_button']");

        return new MyBasket(tool, test, user);
    }

    public SwapImpact clickContinueExpectingSwapImpact() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new SwapImpact(tool, test, user);
    }

}
