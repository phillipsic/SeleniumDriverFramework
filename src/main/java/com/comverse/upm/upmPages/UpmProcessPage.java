package com.comverse.upm.upmPages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.upm.common.CommonMenu;

public class UpmProcessPage extends CommonMenu {

    public UpmProcessPage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Comverse ONE Unified Platform - Process";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void clickWorkflow() throws Exception {
        tool.clickUsingXPath("//td[contains(text(),'Work Flow')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

    }

    public UpmProcessPage clickCreateTemplate() throws Exception {
        tool.clickUsingXPath("//div/div/div/input[1]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new UpmProcessPage(tool, test, user);

    }

    public void selectWorkflowType(String workflowtype) throws Exception {
        tool.selectVisibleTextByXPath("//select", workflowtype);

    }

    public void enterTemplateName(String templatename) throws Exception {
        tool.enterStringUsingXPath("//tr[1]/td[2]/div/input", templatename);

    }

    public void enterTemplateDescription(String description) throws Exception {
        tool.enterStringUsingXPath("//tr[1]/td[4]/textarea", description);

    }

    public void selectProcess(String process) throws Exception {
        tool.selectVisibleTextByXPath("//tr[3]/td[2]/select", process);

    }

    public void selectNodeType(String nodetype) throws Exception {
        tool.selectVisibleTextByXPath("//tr[2]/td/select", nodetype);

    }

    public void selectQuery(String query) throws Exception {
        tool.selectVisibleTextByXPath("//td[2]/table/tbody/tr/td/select", query);

    }

    public void enterQueryValue(String queryValue) throws Exception {
        tool.enterStringUsingXPath("//td[2]/table/tbody/tr/td[2]/input", queryValue);

    }

    public void enterTaskName(String taskName) throws Exception {
        tool.enterStringUsingXPath("//td[3]/table/tbody/tr/td/input", taskName);

    }

    public void selectTaskMode(String taskMode) throws Exception {
        tool.selectVisibleTextByXPath("//td[4]/table/tbody/tr/td[2]/select", taskMode);

    }

    public void selectServerId(String serverId) throws Exception {
        tool.selectVisibleTextByXPath("//td[5]/table/tbody/tr/td[2]/select", serverId);

    }

    public void clickRun() throws Exception {
        tool.clickUsingXPath("//div[3]/input[2]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

    }

    public void clickCancel() throws Exception {
        tool.clickUsingXPath("//div[3]/input[3]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

    }

    public void clickHistory() throws Exception {
        tool.clickUsingXPath("//td[contains(text(),'History')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

    }

}
