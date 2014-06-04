package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author iphilli
 */
public class AddCase extends B2CMenu {
    
    public AddCase(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Add Case";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }
    
    public void selectCategory(String value) throws Exception {
        
        new Select(driver.findElement(By.id("categoryId"))).selectByVisibleText(value);
    }
    
    public void selectSubCategory(String value) throws Exception {
        
        new Select(driver.findElement(By.id("subCategoryId"))).selectByVisibleText(value);
    }
    
    public void enterDescription(String value) throws Exception {
        
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys(value);
    }
    
    public void selectSubjectRelativeToProblemSubscriber() throws Exception {
        driver.findElement(By.id("isContract")).click();
    }
    
    public void selectFirstSubscriber() throws Exception {
        
        new Select(driver.findElement(By.id("contract"))).selectByIndex(1);
    }
    
    public AddCaseReview clickSubmit() throws Exception {
        
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        return new AddCaseReview(driver);
    }
    
    public ListCases clickListCases() throws Exception {
        
        driver.findElement(By.id("smnu_CASE_LIST")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ListCases(driver);
    }    
}
