package com.comverse.sfa;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.sfa.common.SFATest;

public class SFAMenu extends SFATest {

    public SFAMenu(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }

    public void clickSalesOpportunities() throws Exception {

        tool.clickUsingXPath("//div[10]/div/table/tbody/tr/td[2]/div");
        tool.clickUsingXPath("//div[@id='$bicusp']/div/table/tbody/tr/td[2]/div");
        // return new sfaOpportunities(tool, test, user);
    }

    public sfaOrganization clickNavigationOrganization() throws Exception {

        tool.clickUsingXPath("//div[contains(text(), 'Organizations')]");
        return new sfaOrganization(tool, test, user);
    }

    public sfaB2BLead clickNavigationB2BLead() throws Exception {

        if (!tool.checkDisplayedUsingXpath("//div[contains(text(), 'B2B Leads')]")) {
            tool.clickUsingID("toggle_$20ee6m_image");
        }
        tool.clickUsingXPath("//div[contains(text(), 'B2B Leads')]");
        return new sfaB2BLead(tool, test, user);
    }

    public sfaB2CLead clickNavigationB2CLead() throws Exception {

        if (!tool.checkDisplayedUsingXpath("//div[contains(text(), 'B2C Leads')]")) {
            tool.clickUsingID("toggle_$20ee6m_image");
        }
        tool.clickUsingXPath("//div[contains(text(), 'B2C Leads')]");
        return new sfaB2CLead(tool, test, user);
    }

    public sfaAdminJobList clickNavigationJobList() throws Exception {

        if (!tool.checkDisplayedUsingXpath("//div[contains(text(), 'Job List')]")) {
            tool.clickUsingID("toggle_$dkat0h_image");
        }
        tool.clickUsingXPath("//div[contains(text(), 'Job List')]");
        return new sfaAdminJobList(tool, test, user);
    }

    public sfaOpportunity clickNavigationOpportunity() throws Exception {
        if (!tool.checkDisplayedUsingXpath("//div[contains(text(), 'Opportunities')]")) {
            tool.clickUsingID("toggle_$20ee6m_image");
        }
        tool.clickUsingXPath("//div[contains(text(), 'Opportunities')]");
        return new sfaOpportunity(tool, test, user);
    }

    public void enterFindText(String OrgName) throws Exception {
        String htmlSource = tool.getPageSource();
        String temp[];

        temp = htmlSource.split("Enter text");
        temp = temp[1].split("epnywidgetname");
        temp = temp[0].split("id");

        String textFieldID = temp[1].replaceAll("=", "");
        textFieldID = Common.cleanStringOfIllegalChars(textFieldID);

        tool.enterStringUsingId(textFieldID, OrgName);
    }

    public void selectFindType(String value) throws Exception {

        String htmlSource = tool.getPageSource();
        String temp[];

        temp = htmlSource.split("Select One");
        temp = temp[1].split("epnywidgetname");
        temp = temp[0].split("id");

        String dropDownID = temp[1].replaceAll("=", "");
        dropDownID = Common.cleanStringOfIllegalChars(dropDownID);

        tool.selectVisibleTextByID(dropDownID, value);
    }

    public void clickFindGo() throws Exception {
        tool.clickUsingXPath("//input[@value='Go']");
    }

}
