package com.company.mercurytours.pages;

import com.framework.app.common.Common;
import com.framework.common.AutomationTool;
import com.framework.common.TestDetails;
import com.framework.common.User;

/**
 *
 * @author Ian Phillips
 */
public class WelcomeMercuryTours extends MercuryToursMenu {

    public WelcomeMercuryTours(AutomationTool tool, TestDetails test, User user) throws Exception {
        super(tool, test, user);

        String expectedScreen = "Welcome: Mercury Tours";
        Common.assertCorrectPageTitle(tool, expectedScreen);
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

}
