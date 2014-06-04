package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class PersonMergeCommon extends CommonMenu {
    static String expectedScreen = "Person Merge";

    public PersonMergeCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setLastName(String LN) throws Exception {
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys(LN);
    }

    public void clickPersonSearch() throws Exception {
        driver.findElement(By.xpath("//input[@id='searchPerson']")).click();
    }

    public void clickSelect() throws Exception {
        Common.sleepForNumberOfSeconds(5);
        driver.findElement(By.cssSelector("input[value='Select'][type='button']")).click();
    }

    public void clickOKFromMerge() throws Exception {
        driver.findElement(By.xpath("(//input[@value='OK'])[2]")).click();
    }

}