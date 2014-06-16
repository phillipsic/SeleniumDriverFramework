package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.MyshapeCommon;

public class MyShapeChannel extends MyshapeCommon {

    public MyShapeChannel(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Myshape Channel";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public MyShapeChannel clickLogout() throws Exception {
        super.clickLogout();
        return new MyShapeChannel(tool, test, user);
    }

    public WorkSpace clickAgreeTermsAndConditions() throws Exception {
        tool.clickUsingName(tool, "continue");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.checkForExistingBasketAndDiscard(tool);
        return new WorkSpace(tool, test, user);
    }

    public RestorePreviousBasket clickAgreeTermsAndConditionsWithoutBasketCheck() throws Exception {
        tool.clickUsingName(tool, "continue");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RestorePreviousBasket(tool, test, user);
    }

    public WorkSpace loginToPOS(User user) throws Exception {
        super.successfulLogin(user);

        // Terms and Conditions page for dealer
        if (tool.getPageSource(tool).contains("Welcome to Shape Telecom")) {
            this.clickAgreeTermsAndConditions();
        }
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.checkForExistingBasketAndDiscard(tool);

        return new WorkSpace(tool, test, user);
    }

    public WelcomeToYourWorkspace loginToPOSAsTelcoAdmin(User user) throws Exception {
        successfulLogin(user);
        return new WelcomeToYourWorkspace(tool, test, user);
    }

    public void clickChange() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Change']");
    }

    @Override
	public void clickHomePage() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Home Page']");
    }

    public RestorePreviousBasket loginToChannelAsTelcoAdminWithPreviousBasket() throws Exception {
        successfulLogin(user);
        if (tool.getPageSource(tool).contains("Welcome to Shape Telecom")) {
            this.clickAgreeTermsAndConditionsWithoutBasketCheck();
        }
        return new RestorePreviousBasket(tool, test, user);
    }

    public RestorePreviousBasket loginToChannelAsTelcoUserWithPreviousBasket() throws Exception {
        successfulLogin(user);
        if (tool.getPageSource(tool).contains("Welcome to Shape Telecom")) {
            this.clickAgreeTermsAndConditionsWithoutBasketCheck();
        }
        return new RestorePreviousBasket(tool, test, user);
    }
}
