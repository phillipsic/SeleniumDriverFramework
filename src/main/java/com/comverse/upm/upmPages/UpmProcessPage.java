package com.comverse.upm.upmPages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.upm.common.CommonMenu;

public class UpmProcessPage extends CommonMenu{

    public UpmProcessPage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Comverse ONE Unified Platform - Process";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }
    
    public void clickWorkflow() throws Exception {
        tool.clickUsingXPath("//td[contains(text(),'Work Flow')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        
    }
    
    
    public void selectWorkflowType(String workflowtype) throws Exception {
        tool.selectVisibleTextByXPath("//select", workflowtype);
        
    }
}
