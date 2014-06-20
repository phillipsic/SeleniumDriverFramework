package com.comverse.upm.upmPages;

import com.comverse.common.AutomationTool;

public class UpmHomePage {

    public UpmHomePage(AutomationTool tool) throws Exception {
        String currentScreen = tool.getTitle();
        String expectedScreen = "Comverse ONE Unified Platform";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }
}
