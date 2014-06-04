package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class CustomerSearchResultCommon extends CommonMenu {

    public CustomerSearchResultCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Customer search result";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon clickPersonNameLink(String lastName) throws Exception {

        driver.findElement(By.partialLinkText(lastName)).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public AccountDetailsCommon clickAccountLink(String accountNumber) throws Exception {

        driver.findElement(By.partialLinkText(accountNumber)).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public AccountDetailsCommon clickFirstPersonLink() throws Exception {

        driver.findElement(By.id("value_person_0_0")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public AccountDetailsCommon clickFirstAccountLink() throws Exception {

        driver.findElement(By.xpath("//td[3]/a")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDetailsCommon(driver);
    }

    public SubscriberDetailsCommon clickSubscriberLink(String MSISDN) throws Exception {

        driver.findElement(By.partialLinkText(MSISDN)).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(driver);
    }
}
