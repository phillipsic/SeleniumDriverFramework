package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkSpace extends B2CMenu {

    public WorkSpace(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Welcome to Your Personalized Workspace";


        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public String getWelcomeMessage() throws Exception {

        return driver.findElement(By.xpath("//div[@id='headerLogoutContainer']/ul/li")).getText();
    }

    public String getMyLinesText() throws Exception {

        return driver.findElement(By.cssSelector("div.dashboardLineName")).getText();
    }

    public PrimaryOfferDetails clickOnOfferLink(String offerNamer) throws Exception {

        driver.findElement(By.linkText(offerNamer)).click();
        return new PrimaryOfferDetails(driver);
    }

   
}
