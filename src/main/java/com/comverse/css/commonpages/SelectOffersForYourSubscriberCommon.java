/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectOffersForYourSubscriberCommon extends CommonMenu {

    static String expectedScreen = "Select offers for your Subscriber";

    public SelectOffersForYourSubscriberCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectOffersForSubscriber(String... SOTable) throws Exception {
        if (SOTable != null) {
            for (String SOName : SOTable) {
                driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../../td/input")).click();
            }
        }
    }

    public SupplementaryOfferDetailsCommon clickOfferDetail(String SOName) throws Exception {
        driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../a")).click();
        return new SupplementaryOfferDetailsCommon(driver);
    }

    public ConfigureOffersCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ConfigureOffersCommon(driver);
    }

    public MyBasketCommon clickContinueExpectingMyBasket() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new MyBasketCommon(driver);
    }

    public SwapImpactCommon clickContinueExpectingSwapImpact() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new SwapImpactCommon(driver);
    }

    public ServiceConnectionDetailsCommon clickContinueExpectingServiceConnectionDetails() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ServiceConnectionDetailsCommon(driver);
    }

    public MyBasketCommon clickPrevious() throws Exception {
        driver.findElement(By.xpath("//input[@value='< Previous'")).click();
        return new MyBasketCommon(driver);
    }

    public MyBasketCommon clickCancel() throws Exception {
        driver.findElement(By.xpath("//input[@value='Cancel'")).click();
        return new MyBasketCommon(driver);
    }

    public void clickOfferDetailOnPopUp(String SOName) throws Exception {
        driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + SOName + "')]/../a")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

    public void clickClose() throws Exception {
        driver.findElement(By.xpath("//input[@value='Close']")).click();

    }

}
