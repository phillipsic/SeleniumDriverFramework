package com.comverse.sfa;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaOrganization extends SFAMenu {

    public sfaOrganization(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Comverse ONE Billing and Active Customer Management";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setOrganizationName(String value) throws Exception {

        tool.enterStringUsingId("Ixr0ht5", value);
    }

    public void clickNewOrganization() throws Exception {
        tool.clickUsingXPath("//td[contains(text(), 'New')]");
        Common.sleepForNumberOfSeconds(3);
    }

    public void selectStatus(String value) throws Exception {
        tool.selectVisibleTextByID("Iyoe69h", value);
    }

    public void selectCustomerCategory(String value) throws Exception {
        tool.selectVisibleTextByID("Iomthof", value);
    }

    public void selectResellerId(String value) throws Exception {
        tool.selectVisibleTextByID("Igtpzy6", value);
    }

    public void clickSaveOrganization() throws Exception {
        tool.clickUsingXPath("//td[contains(text(), 'Save')]");

        Common.sleepForNumberOfSeconds(3);
    }

    public String getOrganizationName() throws Exception {

        return tool.getAttributeUsingId("Ixr0ht5", "value");
    }

    public String getResellerId() throws Exception {
        return tool.getSelectedTextByID("Igtpzy6");
    }

    public String getStatus() throws Exception {
        return tool.getSelectedTextByID("Iyoe69h");
    }

    public String getCustomerCategory() throws Exception {
        return tool.getSelectedTextByID("Iomthof");
    }

    public sfaContact clickNewContact(String mainWindow) throws Exception {
        tool.clickUsingID("tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_1"); // click
        // contact
        // tab
        tool.clickUsingID("Ab2u66_label"); // click New

        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, mainWindow);

        return new sfaContact(tool, test, user);
    }

    public void checkPrimaryContact() throws Exception {
        if (!tool.searchUsingID("Idrfpsj").isSelected()) {
            tool.clickUsingID("Idrfpsj");
        }

    }

    public sfaOrganization findOrganization(String orgName) throws Exception {

        tool.enterStringUsingId("Ih246r", orgName); // Set
        // organization
        // name
        tool.clickUsingID("$2bdpj3_filterbutton"); // Click
        // Search
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingID("$2bdpj3_cell_0_0_Img"); // Click
        // View
        // detail

        return new sfaOrganization(tool, test, user);
    }

    public sfaB2BLead findAndSelectOrganizationForB2BLead(String orgName) throws Exception {
        String currentWindow = Common.getCurrentWindowHandle(tool);

        tool.enterStringUsingId("Isildl1", orgName); // Set
        // organization
        // name
        tool.clickUsingID("$1pcspz_filterbutton"); // Click
        // Search
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingID("$1pcspz_singleSelectImage_0"); // Select
        // the
        // organization

        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, currentWindow);

        return new sfaB2BLead(tool, test, user);
    }

    sfaOpportunity findAndSelectOrganizationForOpportunity(String orgName) throws Exception {
        String currentWindow = Common.getCurrentWindowHandle(tool);

        tool.enterStringUsingId("Iypr9j2", orgName); // Set
        // organization
        // name
        tool.clickUsingID("$flh26m_filterbutton"); // Click
        // Search
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingID("$flh26m_singleSelectImage_0"); // Select
        // the
        // organization

        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, currentWindow);

        return new sfaOpportunity(tool, test, user);
    }

}
