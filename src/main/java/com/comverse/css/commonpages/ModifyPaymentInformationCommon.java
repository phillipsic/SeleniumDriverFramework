/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyPaymentInformationCommon extends CommonMenu {

    public ModifyPaymentInformationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Payment Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setPaymentMethodDirectDebit() throws Exception {

        tool.clickUsingName(tool, "method");
    }

    public void setBankCode(String value) throws Exception {

        
        tool.enterStringUsingId(tool, "p-L1:1-L3:1360", value);
    }

    public void setBankAgencyCode(String value) throws Exception {

        
        tool.enterStringUsingId(tool, "p-L1:1-L3:1370", value);
    }

    public void setBankAccountNumber(String value) throws Exception {

        
        tool.enterStringUsingId(tool, "p-L1:1-L3:1380", value);
    }

    public void setOwnerlastName(String value) throws Exception {

        
        tool.enterStringUsingId(tool, "p-L1:1-L3:1270", value);
    }

    public ModifyPaymentMethodCommon clickModifyPaymentButton() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Modify Payment Method']")).click();
        return new ModifyPaymentMethodCommon(tool, test, user);
    }

    public String getBankCode() throws Exception {

        return tool.driver.findElement(By.id("p-L1:1-L3:1360")).getAttribute("value");
    }

    public String getBankAgencyCode() throws Exception {

        return tool.driver.findElement(By.id("p-L1:1-L3:1370")).getAttribute("value");
    }

    public String getBankAccountNumber() throws Exception {

        return tool.driver.findElement(By.id("p-L1:1-L3:1380")).getAttribute("value");
    }
}
