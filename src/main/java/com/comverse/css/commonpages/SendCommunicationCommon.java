/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SendCommunicationCommon extends CommonMenu {
    static String expectedScreen = "Send communication";

    public SendCommunicationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public boolean IsTemplatePresent() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        System.out.println(tool.searchUsingCssSelector("BODY"));
        if (tool.getTextUsingCssSelector("span").equals("No templates found.")) {
            System.out.println("Please upload the desired template");
            return false;
        }
        return true;

    }

    public SendCommunicationCommon clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");
        return new SendCommunicationCommon(tool, test, user);
    }

    public void clickSearchTemplate() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Search template']");
    }

    public void selectTemplateEventType(String value) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.selectVisibleTextByID("eventType", value);

    }

    public void selectTemplateCaseType(String value) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("caseType", value);
    }

    public void selectTemplateProblemArea(String value) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("problemArea", value);
    }

    public void selectAvailableCommunicationChannel(String value) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("preferredChannelId", value);
    }

    public void selectTemplateName(String value) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("templateList", value);
    }

    public void selectMessageFormat(String value) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("formatList", value);
    }

    public void clickReviewCommunication() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingName("ok");

    }

    public OutboundCommunicationCommon clickSendCommunication() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Send communication']");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new OutboundCommunicationCommon(tool, test, user);
    }

    public void enterEmailTo(String value) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("emailTo", value);

    }

    public void clickClosePopUp() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingLinkText("Close");

    }
}
