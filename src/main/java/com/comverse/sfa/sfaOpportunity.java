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
        tool.driver.findElement(By.id("Ad9fbg6_label")).click();
        Common.sleepForNumberOfSeconds(3);
    }

    void setOpportunityName(String opportunityName) {
        tool.driver.findElement(By.id("Iasykb7")).clear();
        tool.driver.findElement(By.id("Iasykb7")).sendKeys(opportunityName);
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
        tool.driver.findElement(By.id("Iq6k9xi_img")).click();
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
        tool.driver.findElement(By.id("Ajmprcu_label")).click();
        Common.sleepForNumberOfSeconds(3);
    }

    void openProductList() {
        tool.driver.findElement(By.id("tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_1")).click();
    }

    sfaProduct addExistingProduct() throws Exception {
        String currentWindow = Common.getCurrentWindowHandle(tool);
        tool.driver.findElement(By.id("Ahur980_label")).click();
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, currentWindow);

        return new sfaProduct(tool, test, user);
    }

    void findAndOpenOpportunityByName(String opportunityName) throws Exception {
        tool.driver.findElement(By.id("Ia9cw75")).clear();
        tool.driver.findElement(By.id("Ia9cw75")).sendKeys(opportunityName);
        tool.driver.findElement(By.id("$xlphc4_filterbutton")).click(); // Click
                                                                        // Search
        Common.sleepForNumberOfSeconds(2);
        tool.driver.findElement(By.id("$xlphc4_cell_0_0_Img")).click(); // Open
                                                                        // the
                                                                        // opportunity
        Common.sleepForNumberOfSeconds(3);
    }

    String getOpportunityName() {
        return tool.driver.findElement(By.id("Iasykb7")).getAttribute("value");
    }

    String getPriceList() throws Exception {
        return new Select(tool.searchUsingID(tool, "I4nxoi8")).getFirstSelectedOption().getText();
    }

    String getFirstProductName() {
        return tool.driver.findElement(By.id("$5rwlai_cell_0_1_span")).getText();
    }

    void openSalesProcess() {
        tool.driver.findElement(By.id("tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_0")).click();
    }

    String getCurrentSalesStage() {
        return tool.driver.findElement(By.id("If7o2b9")).getAttribute("value");
    }

    String getFirstTaskName() {
        return tool.driver.findElement(By.id("$35tloe_cell_0_2_span")).getText();
    }

}
