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
        String currentScreen = tool.getTitle(tool);

        if (!expectedScreen.equals(tool.getTitle(tool))) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public boolean IsTemplatePresent() throws Exception {
        System.out.println(tool.searchUsingCssSelector(tool, "BODY"));
        if (tool.getTextUsingCssSelector(tool, "span").equals("No templates found.")) {
            System.out.println("Please upload the desired template");
            return false;
        }
        return true;

    }

    public SendCommunicationCommon clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        return new SendCommunicationCommon(tool, test, user);
    }

    public void clickSearchTemplate() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Search template']");
    }

    public void selectTemplateEventType(String value) throws Exception {
        tool.selectVisibleTextByID(tool, "eventType", value);

    }

    public void selectTemplateCaseType(String value) throws Exception {

        tool.selectVisibleTextByID(tool, "caseType", value);
    }

    public void selectTemplateProblemArea(String value) throws Exception {

        tool.selectVisibleTextByID(tool, "problemArea", value);
    }

    public void selectAvailableCommunicationChannel(String value) throws Exception {

        tool.selectVisibleTextByID(tool, "preferredChannelId", value);
    }

    public void selectTemplateName(String value) throws Exception {

        tool.selectVisibleTextByID(tool, "templateList", value);
    }

    public void selectMessageFormat(String value) throws Exception {

        tool.selectVisibleTextByID(tool, "formatList", value);
    }

    public void clickReviewCommunication() throws Exception {

        tool.clickUsingName(tool, "ok");

    }

    public OutboundCommunicationCommon clickSendCommunication() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Send communication']");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new OutboundCommunicationCommon(tool, test, user);
    }

    public void enterEmailTo(String value) throws Exception {

        tool.enterStringUsingId(tool, "emailTo", value);

    }

    public void clickClosePopUp() throws Exception {

        tool.clickUsingLinkText(tool, "Close");

    }
}
