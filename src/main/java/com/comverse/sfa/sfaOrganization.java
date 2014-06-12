package com.comverse.sfa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaOrganization extends SFAMenu {

    public sfaOrganization(AutomationTool tool, Test test, User user) {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Comverse ONE Billing and Active Customer Management";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setOrganizationName(String value) throws Exception {

        tool.driver.findElement(By.id("Ixr0ht5")).clear();
        tool.driver.findElement(By.id("Ixr0ht5")).sendKeys(value);
    }

    public void clickNewOrganization() throws Exception {
        tool.driver.findElement(By.xpath("//td[contains(text(), 'New')]")).click();
        Common.sleepForNumberOfSeconds(3);
    }

    public void selectStatus(String value) throws Exception {
        new Select(tool.driver.findElement(By.id("Iyoe69h"))).selectByVisibleText(value);
    }

    public void selectCustomerCategory(String value) throws Exception {
        new Select(tool.driver.findElement(By.id("Iomthof"))).selectByVisibleText(value);
    }

    public void selectResellerId(String value) throws Exception {
        new Select(tool.driver.findElement(By.id("Igtpzy6"))).selectByVisibleText(value);
    }

    public void clickSaveOrganization() throws Exception {
        tool.driver.findElement(By.xpath("//td[contains(text(), 'Save')]")).click();

        Common.sleepForNumberOfSeconds(3);
    }

    public String getOrganizationName() throws Exception {

        return tool.driver.findElement(By.id("Ixr0ht5")).getAttribute("value");
    }

    public String getResellerId() throws Exception {

        return new Select(tool.driver.findElement(By.id("Igtpzy6"))).getFirstSelectedOption().getText();
    }

    public String getStatus() throws Exception {
        return new Select(tool.driver.findElement(By.id("Iyoe69h"))).getFirstSelectedOption().getText();
    }

    public String getCustomerCategory() throws Exception {
        return new Select(tool.driver.findElement(By.id("Iomthof"))).getFirstSelectedOption().getText();
    }

    public sfaContact clickNewContact(String mainWindow) throws Exception {
        tool.driver.findElement(By.id("tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_1")).click(); // click
                                                                                                          // contact
                                                                                                          // tab
        tool.driver.findElement(By.id("Ab2u66_label")).click(); // click New

        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, mainWindow);

        return new sfaContact(tool, test, user);
    }

    public void checkPrimaryContact() {
        if (!driver.findElement(By.id("Idrfpsj")).isSelected()) {
            tool.driver.findElement(By.id("Idrfpsj")).click();
        }

    }

    public sfaOrganization findOrganization(String orgName) throws Exception {

        tool.driver.findElement(By.id("Ih246r")).clear();
        tool.driver.findElement(By.id("Ih246r")).sendKeys(orgName); // Set
                                                                    // organization
                                                                    // name
        tool.driver.findElement(By.id("$2bdpj3_filterbutton")).click(); // Click
                                                                        // Search
        Common.sleepForNumberOfSeconds(2);
        tool.driver.findElement(By.id("$2bdpj3_cell_0_0_Img")).click(); // Click
                                                                        // View
                                                                        // detail

        return new sfaOrganization(tool, test, user);
    }

    public sfaB2BLead findAndSelectOrganizationForB2BLead(String orgName) throws Exception {
        String currentWindow = Common.getCurrentWindowHandle(tool);
        tool.driver.findElement(By.id("Isildl1")).clear();
        tool.driver.findElement(By.id("Isildl1")).sendKeys(orgName); // Set
                                                                     // organization
                                                                     // name
        tool.driver.findElement(By.id("$1pcspz_filterbutton")).click(); // Click
                                                                        // Search
        Common.sleepForNumberOfSeconds(2);
        tool.driver.findElement(By.id("$1pcspz_singleSelectImage_0")).click(); // Select
                                                                               // the
                                                                               // organization

        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, currentWindow);

        return new sfaB2BLead(tool, test, user);
    }

    sfaOpportunity findAndSelectOrganizationForOpportunity(String orgName) throws Exception {
        String currentWindow = Common.getCurrentWindowHandle(tool);
        tool.driver.findElement(By.id("Iypr9j2")).clear();
        tool.driver.findElement(By.id("Iypr9j2")).sendKeys(orgName); // Set
                                                                     // organization
                                                                     // name
        tool.driver.findElement(By.id("$flh26m_filterbutton")).click(); // Click
                                                                        // Search
        Common.sleepForNumberOfSeconds(2);
        tool.driver.findElement(By.id("$flh26m_singleSelectImage_0")).click(); // Select
                                                                               // the
                                                                               // organization

        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, currentWindow);

        return new sfaOpportunity(tool, test, user);
    }

}
