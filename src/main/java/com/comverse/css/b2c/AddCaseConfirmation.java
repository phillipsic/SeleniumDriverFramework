package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class AddCaseConfirmation extends B2CMenu {

    public AddCaseConfirmation(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Add case - confirmation";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddCase clickOk() throws Exception {

        driver.findElement(By.cssSelector("input.submit")).click();
        return new AddCase(driver);
    }

    public String getCaseID() throws Exception {

        String caseID = driver.findElement(By.xpath("//span")).getText();

        caseID = caseID.replaceAll("[a-zA-Z \\.]", "");
        System.out.println("New Case ID : " + caseID);
        return caseID;
    }
}
