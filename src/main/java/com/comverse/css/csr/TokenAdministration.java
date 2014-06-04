package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 *
 * @author gmaroth
 */
public class TokenAdministration {

    public WebDriver driver;

    public TokenAdministration(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Token Administration";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public UploadToken clickUpload() throws Exception {

        driver.findElement(By.xpath("//input[@value='Upload']")).click();

        return new UploadToken(driver);
    }

    
}
