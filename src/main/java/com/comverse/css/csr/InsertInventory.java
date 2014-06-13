package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class InsertInventory extends CommonMenu {

    public InsertInventory(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Insert Inventory";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectInventoryType(String inventoryType) throws Exception {

        new Select(tool.searchUsingID(tool, "inventoryType")).selectByVisibleText(inventoryType);
        Common.sleepForNumberOfSeconds(10);
    }

    public void setSerialNumber(String serialNumber) throws Exception {

        tool.driver.findElement(By.id("serialNumber")).clear();
        tool.driver.findElement(By.id("serialNumber")).sendKeys(serialNumber);

    }

    public void setPrimaryNumber(String primaryNumber) throws Exception {

        tool.driver.findElement(By.id("primaryNumber")).clear();
        tool.driver.findElement(By.id("primaryNumber")).sendKeys(primaryNumber);

    }

    public void setSecondaryNumber(String secondaryNumber) throws Exception {

        tool.driver.findElement(By.id("secondaryNumber")).clear();
        tool.driver.findElement(By.id("secondaryNumber")).sendKeys(secondaryNumber);

    }

    public void setTertiaryNumber(String tertiaryNumber) throws Exception {

        tool.driver.findElement(By.id("tertiaryNumber")).clear();
        tool.driver.findElement(By.id("tertiaryNumber")).sendKeys(tertiaryNumber);

    }

    public void setServiceNumber(String serviceNumber) throws Exception {

        tool.driver.findElement(By.id("serviceNumber")).clear();
        tool.driver.findElement(By.id("serviceNumber")).sendKeys(serviceNumber);

    }

    public ActionDone clickInsert() throws Exception {

        tool.driver.findElement(By.id("insertbtn")).click();

        return new ActionDone(tool, test, user);
    }
}
