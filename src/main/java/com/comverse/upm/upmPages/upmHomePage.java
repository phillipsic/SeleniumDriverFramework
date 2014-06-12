package com.comverse.upm.upmPages;

import com.comverse.common.AutomationTool;

public class upmHomePage {

    public upmHomePage(AutomationTool tool) {
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Comverse ONE Unified Platform";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }
}
