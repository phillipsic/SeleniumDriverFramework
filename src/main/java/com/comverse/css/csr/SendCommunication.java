/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.SendCommunicationCommon;

/**
 * 
 * @author gmaroth
 */
public class SendCommunication extends SendCommunicationCommon {

    public SendCommunication(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public OutboundCommunication clickSendCommunication() throws Exception {

        super.clickSendCommunication();
        return new OutboundCommunication(driver);
    }
}
