/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.OutboundCommunicationTemplateCommon;

public class OutboundCommunicationTemplate extends OutboundCommunicationTemplateCommon {

    public OutboundCommunicationTemplate(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Outbound Communication Template";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void doAddTemplates() throws Exception {
        clickSearch();
    }

    private void clickSearch() throws Exception {

        tool.clickUsingXPath(tool, ".//*[@id='OutboundCommTemplateSearchForm']/fieldset[2]/input[3]");
    }

    @Override
    public AddOutboundCommunicationTemplate clickAdd() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Add']");
        return new AddOutboundCommunicationTemplate(tool, test, user);
    }

    public void clickBack() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Back']");
    }

}
