package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author iphilli
 */
public class AddCaseReview extends B2CMenu {
    
    public AddCaseReview(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Add case - review";
        
        
        if (!expectedScreen.equals(driver.getTitle())) {
            
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }
    
    public AddCaseConfirmation clickCreateCase() throws Exception {
        
        driver.findElement(By.xpath("//input[@value='Create case']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AddCaseConfirmation(driver);
    }
}
