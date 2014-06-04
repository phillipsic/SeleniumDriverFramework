/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 *
 * @author gmaroth
 */
public class OutboundCommunicationTemplateCommon {

    public WebDriver driver;

    public OutboundCommunicationTemplateCommon(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Outbound Communication Template";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddOutboundCommunicationTemplateCommon clickAdd() throws Exception {

        driver.findElement(By.xpath("//input[@value='Add']")).click();

        return new AddOutboundCommunicationTemplateCommon(driver);
    }
}
