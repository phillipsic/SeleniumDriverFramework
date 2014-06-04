package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class ViewCase extends B2CMenu {

    public ViewCase(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "View Case";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getCategory() throws Exception {

        String caseID = driver.findElement(By.xpath("//tr[7]/td/span[2]")).getText();

        return caseID;
    }

    public String getSubCategory() throws Exception {

        String caseID = driver.findElement(By.xpath("//tr[7]/td/span[2]")).getText();

        return caseID;
    }

    public String getDescription() throws Exception {

        String caseID = driver.findElement(By.xpath("//tr[7]/td/span[2]")).getText();

        return caseID;
    }

    public String getSubscriber() throws Exception {
        String caseID = driver.findElement(By.xpath("//tr[7]/td/span[2]")).getText();

        return caseID;
    }
}
