package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResumeAParkedBasketCommon extends CommonMenu {

    public ResumeAParkedBasketCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Resume a Parked Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getMessage() throws Exception {

        return driver.findElement(By.xpath("//span")).getText();
    }

    public ResumeBasketConfirmCommon resumeParkedBasket(String value) throws Exception {

        driver.findElement(By.linkText(value)).click();
        return new ResumeBasketConfirmCommon(driver);
    }

    public DeleteBasketConfirmCommon deleteParkedBasket(String basketName) throws Exception {
        //
        //        String pageSource = driver.getPageSource();
        //        String temp[];
        //        String basketID;
        //
        //        temp = pageSource.split(basketName);
        //        temp = temp[1].split("id=");
        //        temp = temp[1].split("type=");
        //        basketID = Common.cleanStringOfIllegalChars(temp[0]);
        //        basketID = Common.removeHTMLTags(basketID);
        //
        //        driver.findElement(By.id(basketID)).click();
        //        
        //        driver.findElement(By.xpath("//input[@td='checkbox']")).click();
        //        
        driver.findElement(By.xpath("//td[contains(.,'" + basketName + "')]/../td[2]/span/input")).click();

        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        return new DeleteBasketConfirmCommon(driver);
    }
}
