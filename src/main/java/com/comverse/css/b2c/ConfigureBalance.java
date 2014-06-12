package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfigureBalance extends B2CMenu {

    public ConfigureBalance(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Configure Balance";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void configureBalance(String balanceName, String balanceValue) throws Exception {

        tool.driver.findElement(By.id(balanceName + "_limit")).clear();
        tool.driver.findElement(By.id(balanceName + "_limit")).sendKeys(balanceValue);
    }

    public void setSpendingLimit(String spendingLimit) throws Exception {

        tool.driver.findElement(By.id("configuredLimit")).clear();
        tool.driver.findElement(By.id("configuredLimit")).sendKeys(spendingLimit);
    }

    public void selectTargetAccount(String targetBalance) throws Exception {
        new Select(tool.driver.findElement(By.id("targetBalance"))).selectByVisibleText(targetBalance);
    }

    public ChooseAccessories clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseAccessories(tool, test, user);
    }

    public MyBasket clickContinueExpectingMyBasket() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public ConfigureServiceConnectionDetails clickContinueExpectingConfigureServiceConnectionDetails() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ConfigureServiceConnectionDetails(tool, test, user);
    }

    public ConfigureBalanceReview clickConfigureBalance() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value= 'Reconfigure Balance']")).click();
        return new ConfigureBalanceReview(tool, test, user);

    }

}
