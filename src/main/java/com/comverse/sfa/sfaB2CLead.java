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

public class sfaB2CLead extends SFAMenu {

    sfaB2CLead(AutomationTool tool, Test test, User user) {
        super(tool, test, user);

        if (!tool.driver.findElement(By.xpath("//div[contains(text(), 'B2C Lead')]")).isDisplayed()) {
            throw new IllegalStateException("Expected B2C Lead screen doesn't show");

        }
    }

    void findAndOpenB2CLeadByNameAndCreatedDate(String b2cLeadName, String createdDate) throws Exception {
        // Set B2C Lead Name
        tool.driver.findElement(By.id("Iny33ei")).clear();
        tool.driver.findElement(By.id("Iny33ei")).sendKeys(b2cLeadName);

        // Set Created Date
        tool.driver.findElement(By.xpath("//nobr[contains(text(), 'More Fields')]")).click();
        if (createdDate.equals("Today")) {
            tool.driver.findElement(By.id("Imcusxj")).clear();
            tool.driver.findElement(By.id("Imcusxj")).sendKeys(Common.getSysdateDDMMYYYY());
        } else {
            tool.driver.findElement(By.id("Imcusxj")).clear();
            tool.driver.findElement(By.id("Imcusxj")).sendKeys(createdDate);
        }

        // Click Search
        tool.driver.findElement(By.id("$ff0jf0_filterbutton")).click();

        // Open B2C Lead
        tool.driver.findElement(By.id("$ff0jf0_cell_0_0_Img")).click();
    }

    String getB2CLeadName() {
        return tool.driver.findElement(By.id("Ix18yor")).getAttribute("value");

    }

    String getB2CLeadType() throws Exception {
        return new Select(tool.searchUsingID(tool, "Ircc1q4")).getFirstSelectedOption().getText();
    }

    String getNewProspectFlag() {
        return tool.driver.findElement(By.id("Ib356er")).getAttribute("oldvalue");
    }

    String getPriority() throws Exception {
        return new Select(tool.searchUsingID(tool, "Ifn7a0g")).getFirstSelectedOption().getText();
    }

    String getStatus() throws Exception {
        return new Select(tool.searchUsingID(tool, "I5nq7j6")).getFirstSelectedOption().getText();
    }

    void openOfferList() {
        tool.driver.findElement(By.id("tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_13")).click();
    }

    String getFirstOfferId() {
        return tool.driver.findElement(By.id("$l9ifba_cell_0_1_span")).getText();
    }

    String getFirstOfferName() {
        return tool.driver.findElement(By.id("$l9ifba_cell_0_3_span")).getText();
    }
}
