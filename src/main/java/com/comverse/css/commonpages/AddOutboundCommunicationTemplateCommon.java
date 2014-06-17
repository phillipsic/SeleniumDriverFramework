package com.comverse.css.commonpages;

import java.io.File;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddOutboundCommunicationTemplateCommon extends CommonMenu {
    static String expectedScreen = "Add Outbound Communication Template";

    public AddOutboundCommunicationTemplateCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectTemplate(String filename) throws Exception {

        File file = new File(filename);
        // 
        tool.enterStringUsingId(tool, "templateFile", file.getAbsolutePath());

    }

    public void selectLanguage(String language) throws Exception {

        tool.selectVisibleTextByID(tool, "languageCode", language);

    }

    public void selectChannel(String channel) throws Exception {

        tool.selectVisibleTextByID(tool, "channel", channel);

    }

    public void selectEventType(String eventType) throws Exception {

        tool.selectVisibleTextByID(tool, "eventType", eventType);

    }

    public void selectCaseType(String caseType) throws Exception {

        tool.selectVisibleTextByID(tool, "caseType", caseType);

    }

    public void selectProblemArea(String problemArea) throws Exception {

        tool.selectVisibleTextByID(tool, "problemArea", problemArea);

    }

    public void setDescription(String description) throws Exception {

        
        tool.enterStringUsingId(tool, "description", description);
    }

    public OutboundCommunicationTemplateCommon clickOK() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Ok']");

        return new OutboundCommunicationTemplateCommon(tool, test, user);
    }

}
