/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SendCommunicationCommon;

public class SendCommunication extends SendCommunicationCommon {

    public SendCommunication(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public OutboundCommunication clickSendCommunication() throws Exception {

        super.clickSendCommunication();
        return new OutboundCommunication(tool, test, user);
    }
}
