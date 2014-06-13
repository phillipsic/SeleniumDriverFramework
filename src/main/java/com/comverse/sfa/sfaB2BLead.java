package com.comverse.sfa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaB2BLead extends SFAMenu {

    public sfaB2BLead(AutomationTool tool, Test test, User user) {
        super(tool, test, user);

        if (!tool.driver.findElement(By.xpath("//div[contains(text(), 'B2B Lead')]")).isDisplayed()) {
            throw new IllegalStateException("Expected B2B Lead screen doesn't show");

        }
    }

    void clickNewB2BLead() throws Exception {
        tool.clickUsingID(tool, "Awrp1y3_label");
        Common.sleepForNumberOfSeconds(3);
    }

    void setB2BLeadName(String b2bLeadName) throws Exception {

        tool.enterStringUsingId(tool, "Ix18yor", b2bLeadName);
        System.out.println("B2B Lead Name: " + b2bLeadName);
    }

    sfaOrganization clickOrganization() throws Exception {
        String mainWindow = Common.getCurrentWindowHandle(tool);
        tool.clickUsingID(tool, "Iqoirs7_img");
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, mainWindow);

        return new sfaOrganization(tool, test, user);
    }

    public void selectPriceList(String priceList) throws Exception {
        new Select(tool.searchUsingID(tool, "I8ea3x9")).selectByVisibleText(priceList);
    }

    public void saveB2BLead() throws Exception {
        tool.clickUsingID(tool, "Awoo4nv_label");
        Common.sleepForNumberOfSeconds(3);
    }

    public void openProductList() throws Exception {
        tool.clickUsingID(tool, "tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_9");
    }

    public sfaProduct addExistingProduct() throws Exception {
        String currentWindow = Common.getCurrentWindowHandle(tool);
        tool.clickUsingID(tool, "A6oej4g_label");
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, currentWindow);

        return new sfaProduct(tool, test, user);
    }

    public void findAndOpenB2BLeadByName(String b2bLeadName) throws Exception {
        tool.clickUsingXPath(tool, "//nobr[contains(text(), 'More Fields')]");

        tool.enterStringUsingId(tool, "Iaw2djm", b2bLeadName);
        tool.clickUsingID(tool, "$2mtu0_filterbutton"); // Click
                                                        // Search
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingID(tool, "$2mtu0_cell_0_0_Img"); // Open
                                                        // B2B
                                                        // Lead
        Common.sleepForNumberOfSeconds(3);
    }

    public String getB2BLeadName() {
        return tool.driver.findElement(By.id("Ix18yor")).getAttribute("value");
    }

    public String getPriceList() throws Exception {
        return new Select(tool.searchUsingID(tool, "I8ea3x9")).getFirstSelectedOption().getText();
    }

    public String getFirstProductName() {
        return tool.driver.findElement(By.id("$5rwlaq_cell_0_1_span")).getText();
    }

}
