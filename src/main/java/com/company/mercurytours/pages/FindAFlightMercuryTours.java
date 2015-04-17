package com.company.mercurytours.pages;

import com.framework.common.AutomationTool;
import com.framework.common.TestDetails;
import com.framework.common.User;

/**
 *
 * @author Ian Phillips
 */
public class FindAFlightMercuryTours extends MercuryToursMenu {

    public FindAFlightMercuryTours(AutomationTool tool, TestDetails test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Find a Flight: Mercury Tours:";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

}
