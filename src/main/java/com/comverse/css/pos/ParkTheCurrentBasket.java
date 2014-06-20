package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ParkTheCurrentBasketCommon;

public class ParkTheCurrentBasket extends ParkTheCurrentBasketCommon {

    public ParkTheCurrentBasket(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Park the Current Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public ResumeAParkedBasket clickBasket() throws Exception {
        super.clickBasket();
        return new ResumeAParkedBasket(tool, test, user);
    }
}
