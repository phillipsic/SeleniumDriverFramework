package com.comverse.css.commonpages;

import java.io.File;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AddOutboundCommunicationTemplateCommon extends CommonMenu {
    static String expectedScreen = "Add Outbound Communication Template";

    public AddOutboundCommunicationTemplateCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectTemplate(String filename) throws Exception {
        File file = new File(filename);
        tool.enterStringUsingId("templateFile", file.getAbsolutePath());
    }

    public void selectLanguage(String language) throws Exception {
        tool.selectVisibleTextByID("languageCode", language);
    }

    public void selectChannel(String channel) throws Exception {
        tool.selectVisibleTextByID("channel", channel);
    }

    public void selectEventType(String eventType) throws Exception {
        tool.selectVisibleTextByID("eventType", eventType);
    }

    public void selectCaseType(String caseType) throws Exception {
        tool.selectVisibleTextByID("caseType", caseType);
    }

    public void selectProblemArea(String problemArea) throws Exception {
        tool.selectVisibleTextByID("problemArea", problemArea);
    }

    public void setDescription(String description) throws Exception {
        tool.enterStringUsingId("description", description);
    }

    public OutboundCommunicationTemplateCommon clickOK() throws Exception {
        tool.clickUsingXPath("//input[@value='Ok']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new OutboundCommunicationTemplateCommon(tool, test, user);
    }

}
