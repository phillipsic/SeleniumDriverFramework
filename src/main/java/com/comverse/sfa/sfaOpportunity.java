/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.sfa;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaOpportunity extends SFAMenu {

    public sfaOpportunity(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

        if (!tool.checkDisplayedUsingXpath("//div[contains(text(), 'Opportunities')]")) {
            throw new IllegalStateException("Expected Opportunities screen doesn't show");

        }
    }

    void clickNewOpportunity() throws Exception {
        tool.clickUsingID("Ad9fbg6_label");
        Common.sleepForNumberOfSeconds(3);
    }

    void setOpportunityName(String opportunityName) throws Exception {

        tool.enterStringUsingId("Iasykb7", opportunityName);
        System.out.println("New Opportunity Name: " + opportunityName);
    }

    void selectSalesProcess(String salesProcess) throws Exception {
        tool.selectVisibleTextByID("Iat2w3m", salesProcess);
    }

    void selectPriority(String priority) throws Exception {
        tool.selectVisibleTextByID("Ix779fi", priority);
    }

    sfaOrganization clickOrganization() throws Exception {
        String mainWindow = Common.getCurrentWindowHandle(tool);
        tool.clickUsingID("Iq6k9xi_img");
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, mainWindow);

        return new sfaOrganization(tool, test, user);
    }

    void selectCurrency(String currency) throws Exception {
        tool.selectVisibleTextByID("Iqovuoj", currency);
    }

    void selectPriceList(String priceList) throws Exception {
        tool.selectVisibleTextByID("I4nxoi8", priceList);
    }

    void saveOpportunity() throws Exception {
        tool.clickUsingID("Ajmprcu_label");
        Common.sleepForNumberOfSeconds(3);
    }

    void openProductList() throws Exception {
        tool.clickUsingID("tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_1");
    }

    sfaProduct addExistingProduct() throws Exception {
        String currentWindow = Common.getCurrentWindowHandle(tool);
        tool.clickUsingID("Ahur980_label");
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, currentWindow);

        return new sfaProduct(tool, test, user);
    }

    void findAndOpenOpportunityByName(String opportunityName) throws Exception {

        tool.enterStringUsingId("Ia9cw75", opportunityName);
        tool.clickUsingID("$xlphc4_filterbutton"); // Click
        // Search
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingID("$xlphc4_cell_0_0_Img"); // Open
        // the
        // opportunity
        Common.sleepForNumberOfSeconds(3);
    }

    String getOpportunityName() throws Exception {
        return tool.getAttributeUsingId("Iasykb7", "value");
    }

    String getPriceList() throws Exception {
        return tool.getSelectedTextByID("I4nxoi8");
    }

    String getFirstProductName() throws Exception {
        return tool.getTextUsingId("$5rwlai_cell_0_1_span");
    }

    void openSalesProcess() throws Exception {
        tool.clickUsingID("tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_0");
    }

    String getCurrentSalesStage() throws Exception {
        return tool.getAttributeUsingId("If7o2b9", "value");
    }

    String getFirstTaskName() throws Exception {
        return tool.getTextUsingId("$35tloe_cell_0_2_span");
    }

}
