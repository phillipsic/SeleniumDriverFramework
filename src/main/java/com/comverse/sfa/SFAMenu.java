package com.comverse.sfa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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

        tool.clickUsingXPath(tool, "//div[10]/div/table/tbody/tr/td[2]/div");
        tool.clickUsingXPath(tool, "//div[@id='$bicusp']/div/table/tbody/tr/td[2]/div");
        // return new sfaOpportunities(tool, test, user);
    }

    public sfaOrganization clickNavigationOrganization() throws Exception {

        tool.clickUsingXPath(tool, "//div[contains(text(), 'Organizations')]");
        return new sfaOrganization(tool, test, user);
    }

    public sfaB2BLead clickNavigationB2BLead() throws Exception {

        if (!driver.findElement(By.xpath("//div[contains(text(), 'B2B Leads')]")).isDisplayed()) {
            tool.driver.findElement(By.id("toggle_$20ee6m_image")).click();
        }
        tool.clickUsingXPath(tool, "//div[contains(text(), 'B2B Leads')]");
        return new sfaB2BLead(tool, test, user);
    }

    public sfaB2CLead clickNavigationB2CLead() throws Exception {

        if (!driver.findElement(By.xpath("//div[contains(text(), 'B2C Leads')]")).isDisplayed()) {
            tool.driver.findElement(By.id("toggle_$20ee6m_image")).click();
        }
        tool.clickUsingXPath(tool, "//div[contains(text(), 'B2C Leads')]");
        return new sfaB2CLead(tool, test, user);
    }

    public sfaAdminJobList clickNavigationJobList() throws Exception {

        if (!driver.findElement(By.xpath("//div[contains(text(), 'Job List')]")).isDisplayed()) {
            tool.driver.findElement(By.id("toggle_$dkat0h_image")).click();
        }
        tool.clickUsingXPath(tool, "//div[contains(text(), 'Job List')]");
        return new sfaAdminJobList(tool, test, user);
    }

    public sfaOpportunity clickNavigationOpportunity() throws Exception {
        if (!driver.findElement(By.xpath("//div[contains(text(), 'Opportunities')]")).isDisplayed()) {
            tool.driver.findElement(By.id("toggle_$20ee6m_image")).click();
        }
        tool.clickUsingXPath(tool, "//div[contains(text(), 'Opportunities')]");
        return new sfaOpportunity(tool, test, user);
    }

    public void enterFindText(String OrgName) throws Exception {
        String htmlSource = tool.driver.getPageSource();
        String temp[];

        temp = htmlSource.split("Enter text");
        temp = temp[1].split("epnywidgetname");
        temp = temp[0].split("id");

        String textFieldID = temp[1].replaceAll("=", "");
        textFieldID = Common.cleanStringOfIllegalChars(textFieldID);

        tool.enterStringUsingId(tool, textFieldID, OrgName);
    }

    public void selectFindType(String value) throws Exception {

        String htmlSource = tool.driver.getPageSource();
        String temp[];

        temp = htmlSource.split("Select One");
        temp = temp[1].split("epnywidgetname");
        temp = temp[0].split("id");

        String dropDownID = temp[1].replaceAll("=", "");
        dropDownID = Common.cleanStringOfIllegalChars(dropDownID);

        new Select(tool.searchUsingID(tool, dropDownID)).selectByVisibleText(value);
    }

    public void clickFindGo() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Go']");
    }

}
