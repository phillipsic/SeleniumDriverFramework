package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;
import com.comverse.css.common.Subscriber;

public class ServiceConnectionDetailsCommon extends CommonMenu {

    public ServiceConnectionDetailsCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Service Connection Details";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickOk() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new MyBasketCommon(driver);
    }

    public SwapImpactCommon clickOkExpectingSwapImpact() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new SwapImpactCommon(driver);
    }

    public void SetEmailInventory(String email) throws Exception {
        driver.findElement(By.id("inputFields1414")).clear();
        driver.findElement(By.id("inputFields1414")).sendKeys(email);

    }

    public MyBasketCommon clickOkAfterSetEmailInventory() throws Exception {
        driver.findElement(By.id("display_line_submit_button")).click();
        return new MyBasketCommon(driver);
    }

    public void clickSetSIMInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "SIM type:";

        this.clickSetButton(inventoryString);
        String SIM = driver.findElement(By.xpath("//p[span[contains(text(),\"SIM reference:\")]]/span[2]")).getText();
        subscriber.setSubscriberSIMProperty(SIM);
    }

    public void clickSetIMSIInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "IMSI type:";

        this.clickSetButton(inventoryString);
        String IMSI = driver.findElement(By.xpath("//p[span[contains(text(),\"IMSI reference:\")]]/span[2]")).getText();
        subscriber.setSubscriberIMSIProperty(IMSI);
    }

    public void clickSetMSISDNInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "MSISDN type:";

        this.clickSetButton(inventoryString);
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        String MSISDN = driver.findElement(By.xpath("//p[span[contains(text(),\"MSISDN reference:\")]]/span[2]")).getText();
        subscriber.setSubscriberMSISDNProperty(MSISDN);
    }

    public void clickSetTVQualityInventory(Subscriber subscriber) throws Exception {
        String inventoryString = "TVQuality type:";

        this.clickSetButton(inventoryString);
        String TVQuality = driver.findElement(By.xpath("//p[span[contains(text(),\"TVQuality reference:\")]]/span[2]")).getText();
        subscriber.setSubscriberTVQualityProperty(TVQuality);
    }

    public void clickSetButton(String inventoryString) throws Exception {
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        driver.findElement(By.xpath("//span[contains(.,'" + inventoryString + "')]/../../following-sibling::div[1]/div/div/span/input")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }
}
