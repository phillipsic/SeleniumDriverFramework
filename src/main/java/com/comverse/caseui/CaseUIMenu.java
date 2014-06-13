package com.comverse.caseui;

import com.comverse.caseui.common.CaseUITest;
import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.PropertyHelper;

public class CaseUIMenu extends CaseUITest {

    public CaseUIMenu(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }

    public void clickCaseManagement() throws Exception {
        tool.clickUsingXPath(tool, "//div[contains(text(), 'Case Management')]");
    }

    public CaseUICases clickCases() throws Exception {
        tool.clickUsingXPath(tool, "//div[contains(text(), 'Cases')]");
        return new CaseUICases(tool, test, user);
    }

    public void clickAccounts() throws Exception {
        tool.clickUsingXPath(tool, "//div[contains(text(), 'Accounts')]");
    }

    public CaseUIAccounts clickAccountsSub() throws Exception {
        tool.clickUsingXPath(tool, "//div[8]/div[2]/div/table/tbody/tr/td[2]/div");

        return new CaseUIAccounts(tool, test, user);
    }

    public long getWaitTime() {
        PropertyHelper propsHelper = new PropertyHelper();
        long waitSec = Long.valueOf(propsHelper.getInitProperties("sfa_wait"));
        return waitSec;
    }

    public void clickActivities() throws Exception {
        tool.clickUsingXPath(tool, "//div[contains(text(), 'Activities')]");
    }

    public void clickTasks() throws Exception {
        tool.clickUsingXPath(tool, "//div[contains(text(), 'Tasks')]");
    }

    public void clickSignOut() throws Exception {
        tool.clickUsingID(tool, "$azn666_label");

    }
}
