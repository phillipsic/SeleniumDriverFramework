/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.OutboundCommunicationTemplateCommon;

public class OutboundCommunicationTemplate extends OutboundCommunicationTemplateCommon {

    public OutboundCommunicationTemplate(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Outbound Communication Template";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    @Override
	public AddOutboundCommunicationTemplate clickAdd() throws Exception {

        tool.clickUsingXPath("//input[@value='Add']");

        return new AddOutboundCommunicationTemplate(tool, test, user);
    }
}
