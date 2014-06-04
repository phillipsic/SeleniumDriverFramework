package com.comverse.css.commonpages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchEmployeeCommon extends CommonMenu {

    public SearchEmployeeCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Search Employee";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SearchEmployeeCommon searchEmployeeByLastName(String ln) throws Exception {

        driver.findElement(By.id("p-L2:10-L3:1470")).clear();
        driver.findElement(By.id("p-L2:10-L3:1470")).sendKeys(ln);
        driver.findElement(By.xpath("//form[@id='form_SEARCH_MEMBERS_RESULT_0']//input[@value='Search']")).click();

        return new SearchEmployeeCommon(driver);
        // sends keys to the last name field in the searchpage and clicks Search button of the same section. Expects the same page when completed.
    }

    public SearchEmployeeCommon searchEmployeeByLogin(String lg) throws Exception {

        driver.findElement(By.id("p-L4:1014-L3:1640")).sendKeys(lg);
        driver.findElement(By.xpath("//form[@id='form_SEARCH_MEMBERS_RESULT_1']//input[@value='Search']")).click();

        return new SearchEmployeeCommon(driver);
        // sends keys to the login field in the searchpage and clicks Search button of the same section. Expects the same page when completed.
    }

    public SearchEmployeeCommon checkIfResultIsCorrect(String numberOfCustomersDisplayed) throws Exception {

        assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
                         .matches("^[\\s\\S]*" + numberOfCustomersDisplayed + " employee\\(s\\) found[\\s\\S]*$"));

        return new SearchEmployeeCommon(driver);
        // Asserts that the given numberOfCustomersDisplayd is equal to the Result page header for ex: "20 employee(s) found". Expects the same page.
    }

    public ContactInformationCommon clickEmployeeNameLink(String FirstOrLastName) throws Exception {

        driver.findElement(By.partialLinkText(FirstOrLastName)).click();

        return new ContactInformationCommon(driver);

    }

}
