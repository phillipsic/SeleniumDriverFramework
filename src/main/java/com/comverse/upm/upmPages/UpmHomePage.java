package com.comverse.upm.upmPages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.upm.common.CommonMenu;

public class UpmHomePage extends CommonMenu{

    public UpmHomePage(AutomationTool tool,Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Comverse ONE Unified Platform|home";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }
    
    
}
