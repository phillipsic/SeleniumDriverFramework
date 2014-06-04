/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ConfigureBalanceCommon;

/**
 *
 * @author iphilli
 */
public class ConfigureBalance extends ConfigureBalanceCommon {

    public ConfigureBalance(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ServiceConnectionDetails clickContinueExpectingServiceConnectionDetails() throws Exception {
        super.clickContinue();
        return new ServiceConnectionDetails(driver);
    }

    @Override
    public MyBasket clickContinueExpectingMyBasket() throws Exception {

        super.clickContinueExpectingMyBasket();
        return new MyBasket(driver);
    }

    @Override
    public void setSpendingLimit(String limitName, String limitAmount) throws Exception {

        super.setSpendingLimit(limitName, limitAmount);
    }

    public void configureBalance(String balanceName, String balanceValue) throws Exception {

        driver.findElement(By.id(balanceName + "_limit")).clear();
        driver.findElement(By.id(balanceName + "_limit")).sendKeys(balanceValue);
    }

    @Override
    public ConfigureContractDetails clickContinueExpectingConfigureContractDetails() throws Exception {
        super.clickContinueExpectingConfigureContractDetails();
        return new ConfigureContractDetails(driver);
    }

}
