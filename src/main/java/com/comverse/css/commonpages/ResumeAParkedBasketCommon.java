package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ResumeAParkedBasketCommon extends CommonMenu {

    public ResumeAParkedBasketCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Resume a Parked Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getMessage() throws Exception {

        return tool.getTextUsingXPath("//span");
    }

    public ResumeBasketConfirmCommon resumeParkedBasket(String value) throws Exception {

        tool.clickUsingLinkText(value);
        return new ResumeBasketConfirmCommon(tool, test, user);
    }

    public DeleteBasketConfirmCommon deleteParkedBasket(String basketName) throws Exception {
        //
        // String pageSource = tool.getPageSource();
        // String temp[];
        // String basketID;
        //
        // temp = pageSource.split(basketName);
        // temp = temp[1].split("id=");
        // temp = temp[1].split("type=");
        // basketID = Common.cleanStringOfIllegalChars(temp[0]);
        // basketID = Common.removeHTMLTags(basketID);
        //
        // tool.clickUsingID(basketID);
        //
        // tool.clickUsingXPath("//input[@td='checkbox']");
        //
        tool.clickUsingXPath("//td[contains(.,'" + basketName + "')]/../td[2]/span/input");

        tool.clickUsingXPath("//input[@value='Delete']");
        return new DeleteBasketConfirmCommon(tool, test, user);
    }
}
