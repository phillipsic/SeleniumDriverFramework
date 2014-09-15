package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class OutboundCommunicationTemplateCommon extends CommonMenu {

    public OutboundCommunicationTemplateCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Outbound Communication Template";

        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public AddOutboundCommunicationTemplateCommon clickAdd() throws Exception {
        tool.clickUsingXPath("//input[@value='Add']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddOutboundCommunicationTemplateCommon(tool, test, user);
    }
}
