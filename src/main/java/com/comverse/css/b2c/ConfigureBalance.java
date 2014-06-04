package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.common.Common;

public class ConfigureBalance extends B2CMenu {

    public ConfigureBalance(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Configure Balance";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void configureBalance(String balanceName, String balanceValue) throws Exception {

        driver.findElement(By.id(balanceName + "_limit")).clear();
        driver.findElement(By.id(balanceName + "_limit")).sendKeys(balanceValue);
    }

    public void setSpendingLimit(String spendingLimit) throws Exception {

        driver.findElement(By.id("configuredLimit")).clear();
        driver.findElement(By.id("configuredLimit")).sendKeys(spendingLimit);
    }

    public void selectTargetAccount(String targetBalance) throws Exception {
        new Select(driver.findElement(By.id("targetBalance"))).selectByVisibleText(targetBalance);
    }

    public ChooseAccessories clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ChooseAccessories(driver);
    }

    public MyBasket clickContinueExpectingMyBasket() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyBasket(driver);
    }

    public ConfigureServiceConnectionDetails clickContinueExpectingConfigureServiceConnectionDetails() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ConfigureServiceConnectionDetails(driver);
    }

    public ConfigureBalanceReview clickConfigureBalance() throws Exception {
        driver.findElement(By.xpath("//input[@value= 'Reconfigure Balance']")).click();
        return new ConfigureBalanceReview(driver);

    }

}
