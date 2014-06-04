package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.common.Common;

public class ConfigureContractDetailsCommon extends CommonMenu {

    public ConfigureContractDetailsCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Configure Contract Details";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyBasketCommon(driver);
    }

    public void setSpendingLimit(String limitName, String limitAmount) throws Exception {
        driver.findElement(By.id(limitName + "_limit")).clear();
        driver.findElement(By.id(limitName + "_limit")).sendKeys(limitAmount);
    }

    public void setLang(String lang) throws Exception {
        new Select(driver.findElement(By.id("p-param-L4:80000"))).selectByVisibleText(lang);
    }
    
    public ConfigureBalanceCommon clickContinueExpectingConfigureBalance() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ConfigureBalanceCommon(driver);
    }

}
