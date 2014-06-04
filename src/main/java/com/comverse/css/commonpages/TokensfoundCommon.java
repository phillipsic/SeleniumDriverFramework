package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 *
 * @author gmaroth
 */
public class TokensfoundCommon {

    public WebDriver driver;

    public TokensfoundCommon(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Tokens found";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public UploadTokenCommon clickUpload() throws Exception {

        driver.findElement(By.xpath("//input[@value='Upload']")).click();

        return new UploadTokenCommon(driver);
    }

    
}
