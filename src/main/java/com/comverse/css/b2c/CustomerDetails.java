package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerDetails extends B2CMenu {

    public CustomerDetails(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Customer Details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckOutBillingAccountInformation clickOk() throws Exception {

        driver.findElement(By.name("prospectok")).click();
        return new CheckOutBillingAccountInformation(driver);
    }
    public CheckOutDeliveryAddress clickOkExpectingCheckOutDeliveryAddress() throws Exception {

        driver.findElement(By.name("prospectok")).click();
        return new CheckOutDeliveryAddress (driver);
    }

    public CheckOutDeliveryAddress clickOkWithDevices() throws Exception {

        driver.findElement(By.name("prospectok")).click();
        return new CheckOutDeliveryAddress(driver);
    }

    public ModifyCustomerDetails clickModify() throws Exception {

        driver.findElement(By.name("modifyprospectinfo")).click();
        return new ModifyCustomerDetails(driver);
    }
}
