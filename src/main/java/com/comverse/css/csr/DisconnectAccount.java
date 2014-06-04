package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.DisconnectAccountCommon;

public class DisconnectAccount extends DisconnectAccountCommon {

    public DisconnectAccount(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public void clickCheckBoxUnlockNow() throws Exception {

        driver.findElement(By.id("disconnectNow")).click();

    }

    @Override
    public void setAnnotation(String annotation) throws Exception {

        driver.findElement(By.id("annotation")).clear();
        driver.findElement(By.id("annotation")).sendKeys(annotation);
    }

    @Override
    public DisconnectAccount clickContinue() throws Exception {
        super.clickContinue();
        return new DisconnectAccount(driver);
    }

    @Override
    public DisconnectAccount clickContinueOnImpacts() throws Exception {
        super.clickContinueOnImpacts();
        return new DisconnectAccount(driver);
    }

    @Override
    public AccountDetails clickOk() throws Exception {
        super.clickOk();
        return new AccountDetails(driver);
    }
}