package com.comverse.css.commonpages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SearchEmployeeCommon extends CommonMenu {

    public SearchEmployeeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Search Employee";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SearchEmployeeCommon searchEmployeeByLastName(String ln) throws Exception {

        tool.enterStringUsingId(tool, "p-L2:10-L3:1470", ln);
        tool.clickUsingXPath(tool, "//form[@id='form_SEARCH_MEMBERS_RESULT_0']//input[@value='Search']");

        return new SearchEmployeeCommon(tool, test, user);
        // sends keys to the last name field in the searchpage and clicks Search
        // button of the same section. Expects the same page when completed.
    }

    public SearchEmployeeCommon searchEmployeeByLogin(String lg) throws Exception {

        tool.enterStringUsingId(tool, "p-L4:1014-L3:1640", lg);
        tool.clickUsingXPath(tool, "//form[@id='form_SEARCH_MEMBERS_RESULT_1']//input[@value='Search']");

        return new SearchEmployeeCommon(tool, test, user);
        // sends keys to the login field in the searchpage and clicks Search
        // button of the same section. Expects the same page when completed.
    }

    public SearchEmployeeCommon checkIfResultIsCorrect(String numberOfCustomersDisplayed) throws Exception {

        assertTrue(tool.driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + numberOfCustomersDisplayed + " employee\\(s\\) found[\\s\\S]*$"));

        return new SearchEmployeeCommon(tool, test, user);
        // Asserts that the given numberOfCustomersDisplayd is equal to the
        // Result page header for ex: "20 employee(s) found". Expects the same
        // page.
    }

    public ContactInformationCommon clickEmployeeNameLink(String FirstOrLastName) throws Exception {

        tool.clickUsingPartialLinkText(tool, FirstOrLastName);

        return new ContactInformationCommon(tool, test, user);

    }

}
