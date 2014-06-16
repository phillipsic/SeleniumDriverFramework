package com.comverse.sfa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaOrganization extends SFAMenu {

    public sfaOrganization(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Comverse ONE Billing and Active Customer Management";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setOrganizationName(String value) throws Exception {

        tool.enterStringUsingId(tool, "Ixr0ht5", value);
    }

    public void clickNewOrganization() throws Exception {
        tool.clickUsingXPath(tool, "//td[contains(text(), 'New')]");
        Common.sleepForNumberOfSeconds(3);
    }

    public void selectStatus(String value) throws Exception {
        new Select(tool.searchUsingID(tool, "Iyoe69h")).selectByVisibleText(value);
    }

    public void selectCustomerCategory(String value) throws Exception {
        new Select(tool.searchUsingID(tool, "Iomthof")).selectByVisibleText(value);
    }

    public void selectResellerId(String value) throws Exception {
        new Select(tool.searchUsingID(tool, "Igtpzy6")).selectByVisibleText(value);
    }

    public void clickSaveOrganization() throws Exception {
        tool.clickUsingXPath(tool, "//td[contains(text(), 'Save')]");

        Common.sleepForNumberOfSeconds(3);
    }

    public String getOrganizationName() throws Exception {

        return tool.getAttributeUsingId(tool, "Ixr0ht5", "value");
    }

    public String getResellerId() throws Exception {

        return new Select(tool.searchUsingID(tool, "Igtpzy6")).getFirstSelectedOption().getText();
    }

    public String getStatus() throws Exception {
        return new Select(tool.searchUsingID(tool, "Iyoe69h")).getFirstSelectedOption().getText();
    }

    public String getCustomerCategory() throws Exception {
        return new Select(tool.searchUsingID(tool, "Iomthof")).getFirstSelectedOption().getText();
    }

    public sfaContact clickNewContact(String mainWindow) throws Exception {
        tool.clickUsingID(tool, "tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_1"); // click
                                                                                           // contact
                                                                                           // tab
        tool.clickUsingID(tool, "Ab2u66_label"); // click New

        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, mainWindow);

        return new sfaContact(tool, test, user);
    }

    public void checkPrimaryContact() throws Exception {
        if (!tool.driver.findElement(By.id("Idrfpsj")).isSelected()) {
            tool.clickUsingID(tool, "Idrfpsj");
        }

    }

    public sfaOrganization findOrganization(String orgName) throws Exception {

        tool.enterStringUsingId(tool, "Ih246r", orgName); // Set
                                                          // organization
                                                          // name
        tool.clickUsingID(tool, "$2bdpj3_filterbutton"); // Click
                                                         // Search
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingID(tool, "$2bdpj3_cell_0_0_Img"); // Click
                                                         // View
                                                         // detail

        return new sfaOrganization(tool, test, user);
    }

    public sfaB2BLead findAndSelectOrganizationForB2BLead(String orgName) throws Exception {
        String currentWindow = Common.getCurrentWindowHandle(tool);

        tool.enterStringUsingId(tool, "Isildl1", orgName); // Set
                                                           // organization
                                                           // name
        tool.clickUsingID(tool, "$1pcspz_filterbutton"); // Click
                                                         // Search
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingID(tool, "$1pcspz_singleSelectImage_0"); // Select
                                                                // the
                                                                // organization

        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, currentWindow);

        return new sfaB2BLead(tool, test, user);
    }

    sfaOpportunity findAndSelectOrganizationForOpportunity(String orgName) throws Exception {
        String currentWindow = Common.getCurrentWindowHandle(tool);

        tool.enterStringUsingId(tool, "Iypr9j2", orgName); // Set
                                                           // organization
                                                           // name
        tool.clickUsingID(tool, "$flh26m_filterbutton"); // Click
                                                         // Search
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingID(tool, "$flh26m_singleSelectImage_0"); // Select
                                                                // the
                                                                // organization

        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, currentWindow);

        return new sfaOpportunity(tool, test, user);
    }

}
