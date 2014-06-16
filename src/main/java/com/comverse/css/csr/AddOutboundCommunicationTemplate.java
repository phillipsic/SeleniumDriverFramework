package com.comverse.css.csr;

import java.io.File;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddOutboundCommunicationTemplateCommon;

public class AddOutboundCommunicationTemplate extends AddOutboundCommunicationTemplateCommon {

    public AddOutboundCommunicationTemplate(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Add Outbound Communication Template";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    @Override
	public void selectTemplate(String filename) throws Exception {

        File file = new File(filename);
        // 
        tool.enterStringUsingId(tool, "templateFile", file.getAbsolutePath());

    }

    @Override
	public void selectLanguage(String language) throws Exception {

        new Select(tool.searchUsingID(tool, "languageCode")).selectByVisibleText(language);

    }

    @Override
	public void selectChannel(String channel) throws Exception {

        new Select(tool.searchUsingID(tool, "channel")).selectByVisibleText(channel);

    }

    @Override
	public void selectEventType(String eventType) throws Exception {

        new Select(tool.searchUsingID(tool, "eventType")).selectByVisibleText(eventType);

    }

    @Override
	public void selectCaseType(String caseType) throws Exception {

        new Select(tool.searchUsingID(tool, "caseType")).selectByVisibleText(caseType);

    }

    @Override
	public void selectProblemArea(String problemArea) throws Exception {

        new Select(tool.searchUsingID(tool, "problemArea")).selectByVisibleText(problemArea);

    }

    @Override
	public void setDescription(String description) throws Exception {

        
        tool.enterStringUsingId(tool, "description", description);
    }

    @Override
	public OutboundCommunicationTemplate clickOK() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Ok']");

        return new OutboundCommunicationTemplate(tool, test, user);
    }

}
