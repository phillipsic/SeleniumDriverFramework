package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.b2c.ConfirmModifyProfileInformation;

public class ModifyProfileInformation extends B2CMenu {

    public ModifyProfileInformation(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Modify Profile Information";


        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectApprovalSequencing(String choice) throws Exception {

        new Select(driver.findElement(By.id("approval_sequencing_field"))).selectByVisibleText(choice);

    }

    public ConfirmModifyProfileInformation clickOK() throws Exception {

        driver.findElement(By.id("okButton")).click();
        return new ConfirmModifyProfileInformation(driver);

    }
}
