package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewRechargeDetailsCommon extends CommonMenu {

    public ViewRechargeDetailsCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "View Recharge Details";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }

    }

    public ViewUnbilledRechargeCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewUnbilledRechargeCommon(driver);
    }

    public ViewBilledRechargesCommon clickBackToBiledRecharges() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewBilledRechargesCommon(driver);
    }

}
