/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.sfa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaOpportunity extends SFAMenu {

    public sfaOpportunity(AutomationTool tool, Test test, User user) {

        super(tool, test, user);

        if (!tool.driver.findElement(By.xpath("//div[contains(text(), 'Opportunities')]")).isDisplayed()) {
            throw new IllegalStateException("Expected Opportunities screen doesn't show");

        }
    }

    void clickNewOpportunity() throws Exception {
        tool.clickUsingID(tool, "Ad9fbg6_label");
        Common.sleepForNumberOfSeconds(3);
    }

    void setOpportunityName(String opportunityName) throws Exception {

        tool.enterStringUsingId(tool, "Iasykb7", opportunityName);
        System.out.println("New Opportunity Name: " + opportunityName);
    }

    void selectSalesProcess(String salesProcess) throws Exception {
        new Select(tool.searchUsingID(tool, "Iat2w3m")).selectByVisibleText(salesProcess);
    }

    void selectPriority(String priority) throws Exception {
        new Select(tool.searchUsingID(tool, "Ix779fi")).selectByVisibleText(priority);
    }

    sfaOrganization clickOrganization() throws Exception {
        String mainWindow = Common.getCurrentWindowHandle(tool);
        tool.clickUsingID(tool, "Iq6k9xi_img");
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, mainWindow);

        return new sfaOrganization(tool, test, user);
    }

    void selectCurrency(String currency) throws Exception {
        new Select(tool.searchUsingID(tool, "Iqovuoj")).selectByVisibleText(currency);
    }

    void selectPriceList(String priceList) throws Exception {
        new Select(tool.searchUsingID(tool, "I4nxoi8")).selectByVisibleText(priceList);
    }

    void saveOpportunity() throws Exception {
        tool.clickUsingID(tool, "Ajmprcu_label");
        Common.sleepForNumberOfSeconds(3);
    }

    void openProductList() throws Exception {
        tool.clickUsingID(tool, "tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_1");
    }

    sfaProduct addExistingProduct() throws Exception {
        String currentWindow = Common.getCurrentWindowHandle(tool);
        tool.clickUsingID(tool, "Ahur980_label");
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, currentWindow);

        return new sfaProduct(tool, test, user);
    }

    void findAndOpenOpportunityByName(String opportunityName) throws Exception {

        tool.enterStringUsingId(tool, "Ia9cw75", opportunityName);
        tool.clickUsingID(tool, "$xlphc4_filterbutton"); // Click
                                                         // Search
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingID(tool, "$xlphc4_cell_0_0_Img"); // Open
                                                         // the
                                                         // opportunity
        Common.sleepForNumberOfSeconds(3);
    }

    String getOpportunityName() throws Exception {
        return tool.getAttributeUsingId(tool, "Iasykb7", "value");
    }

    String getPriceList() throws Exception {
        return new Select(tool.searchUsingID(tool, "I4nxoi8")).getFirstSelectedOption().getText();
    }

    String getFirstProductName() throws Exception {
        return tool.getTextUsingId(tool, "$5rwlai_cell_0_1_span");
    }

    void openSalesProcess() throws Exception {
        tool.clickUsingID(tool, "tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_0");
    }

    String getCurrentSalesStage() throws Exception {
        return tool.getAttributeUsingId(tool, "If7o2b9", "value");
    }

    String getFirstTaskName() throws Exception {
        return tool.getTextUsingId(tool, "$35tloe_cell_0_2_span");
    }

}
