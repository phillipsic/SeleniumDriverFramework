package com.comverse.css.csr;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author gmaroth
 */
public class UploadToken {

    public WebDriver driver;

    public UploadToken(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Upload Token";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectFile(String filename) throws Exception {

        File file = new File(filename);
        // driver.findElement(By.id("fileUpload")).clear();
        driver.findElement(By.id("fileUpload")).sendKeys(file.getAbsolutePath());

    }

    public TokenAdministration clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='Ok']")).click();

        return new TokenAdministration(driver);
    }
}
