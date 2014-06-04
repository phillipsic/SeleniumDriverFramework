/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class SubscriberStatusCommon extends CommonMenu {
    static String expectedScreen = "Subscriber Status";

    public SubscriberStatusCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void checkStatus() throws Exception {
        Common.assertTextOnPage(driver, "active");
    }

}
