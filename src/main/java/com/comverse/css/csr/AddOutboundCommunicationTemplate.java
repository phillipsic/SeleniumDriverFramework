package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AddOutboundCommunicationTemplateCommon;
import java.io.File;

public class AddOutboundCommunicationTemplate extends AddOutboundCommunicationTemplateCommon {

    public AddOutboundCommunicationTemplate(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Add Outbound Communication Template";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    @Override
    public void selectTemplate(String filename) throws Exception {  test.writeInLogFile(Common.getMethodName());
        File file = new File(filename);
        tool.enterStringNotTextFieldUsingId("templateFile", file.getAbsolutePath());
    }

    @Override
    public void selectLanguage(String language) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("languageCode", language);

    }

    @Override
    public void selectChannel(String channel) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("channel", channel);

    }

    @Override
    public void selectEventType(String eventType) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("eventType", eventType);

    }

    @Override
    public void selectCaseType(String caseType) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("caseType", caseType);

    }

    @Override
    public void selectProblemArea(String problemArea) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("problemArea", problemArea);

    }

    @Override
    public void setDescription(String description) throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("description", description);
    }

    @Override
    public OutboundCommunicationTemplate clickOK() throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Ok']");

        return new OutboundCommunicationTemplate(tool, test, user);
    }

}
