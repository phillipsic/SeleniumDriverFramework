package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class RemoveSelectionCommon extends CommonMenu {

    public RemoveSelectionCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Remove Selection";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickYes() throws Exception {

        driver.findElement(By.xpath("//form[@id='form_YES']/div/input")).click();
        return new MyBasketCommon(driver);
    }

    public RemoveLevelCommon clickRemoveSelectionByYes() throws Exception {

        driver.findElement(By.xpath("//form[@id='form_YES']/div/input")).click();
        return new RemoveLevelCommon(driver);
    }
}
