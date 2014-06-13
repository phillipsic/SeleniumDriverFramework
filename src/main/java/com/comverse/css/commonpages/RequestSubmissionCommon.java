/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RequestSubmissionCommon extends CommonMenu {

    public RequestSubmissionCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Request Submission";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewHierarchyCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");

        return new ViewHierarchyCommon(tool, test, user);
    }

    public AccountDetailsCommon clickOkModifyRequestGoTOAccountDashboard() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new AccountDetailsCommon(tool, test, user);
    }

    public ContactInformationCommon clickOkToSubmit() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");

        return new ContactInformationCommon(tool, test, user);
    }

    public SubscriberDetailsCommon clickOkModifyRequestGoTOSubscriberDashboard() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new SubscriberDetailsCommon(tool, test, user);
    }

    public ProfileInformationCommon clickOkToSubmitRequest() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");

        return new ProfileInformationCommon(tool, test, user);
    }

}
