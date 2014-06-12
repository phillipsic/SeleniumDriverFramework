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

    public void clickSalesOpportunities() {

        tool.driver.findElement(By.xpath("//div[10]/div/table/tbody/tr/td[2]/div")).click();
        tool.driver.findElement(By.xpath("//div[@id='$bicusp']/div/table/tbody/tr/td[2]/div")).click();
        // return new sfaOpportunities(tool, test, user);
    }

    public sfaOrganization clickNavigationOrganization() {

        tool.driver.findElement(By.xpath("//div[contains(text(), 'Organizations')]")).click();
        return new sfaOrganization(tool, test, user);
    }

    public sfaB2BLead clickNavigationB2BLead() {

        if (!driver.findElement(By.xpath("//div[contains(text(), 'B2B Leads')]")).isDisplayed()) {
            tool.driver.findElement(By.id("toggle_$20ee6m_image")).click();
        }
        tool.driver.findElement(By.xpath("//div[contains(text(), 'B2B Leads')]")).click();
        return new sfaB2BLead(tool, test, user);
    }

    public sfaB2CLead clickNavigationB2CLead() {

        if (!driver.findElement(By.xpath("//div[contains(text(), 'B2C Leads')]")).isDisplayed()) {
            tool.driver.findElement(By.id("toggle_$20ee6m_image")).click();
        }
        tool.driver.findElement(By.xpath("//div[contains(text(), 'B2C Leads')]")).click();
        return new sfaB2CLead(tool, test, user);
    }

    public sfaAdminJobList clickNavigationJobList() {

        if (!driver.findElement(By.xpath("//div[contains(text(), 'Job List')]")).isDisplayed()) {
            tool.driver.findElement(By.id("toggle_$dkat0h_image")).click();
        }
        tool.driver.findElement(By.xpath("//div[contains(text(), 'Job List')]")).click();
        return new sfaAdminJobList(tool, test, user);
    }

    public sfaOpportunity clickNavigationOpportunity() {
        if (!driver.findElement(By.xpath("//div[contains(text(), 'Opportunities')]")).isDisplayed()) {
            tool.driver.findElement(By.id("toggle_$20ee6m_image")).click();
        }
        tool.driver.findElement(By.xpath("//div[contains(text(), 'Opportunities')]")).click();
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

        tool.driver.findElement(By.id(textFieldID)).clear();
        tool.driver.findElement(By.id(textFieldID)).sendKeys(OrgName);
    }

    public void selectFindType(String value) throws Exception {

        String htmlSource = tool.driver.getPageSource();
        String temp[];

        temp = htmlSource.split("Select One");
        temp = temp[1].split("epnywidgetname");
        temp = temp[0].split("id");

        String dropDownID = temp[1].replaceAll("=", "");
        dropDownID = Common.cleanStringOfIllegalChars(dropDownID);

        new Select(tool.driver.findElement(By.id(dropDownID))).selectByVisibleText(value);
    }

    public void clickFindGo() {
        tool.driver.findElement(By.xpath("//input[@value='Go']")).click();
    }

}
