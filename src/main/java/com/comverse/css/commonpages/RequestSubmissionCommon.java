/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RequestSubmissionCommon extends CommonMenu {

    public RequestSubmissionCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Request Submission";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public ViewHierarchyCommon clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

        return new ViewHierarchyCommon(tool, test, user);
    }

    public AccountDetailsCommon clickOkModifyRequestGoTOAccountDashboard() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");
        return new AccountDetailsCommon(tool, test, user);
    }

    public ContactInformationCommon clickOkToSubmit() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

        return new ContactInformationCommon(tool, test, user);
    }

    public SubscriberDetailsCommon clickOkModifyRequestGoTOSubscriberDashboard() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");
        return new SubscriberDetailsCommon(tool, test, user);
    }

    public ProfileInformationCommon clickOkToSubmitRequest() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

        return new ProfileInformationCommon(tool, test, user);
    }

}
