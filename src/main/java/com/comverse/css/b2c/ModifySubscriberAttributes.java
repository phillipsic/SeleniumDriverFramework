/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ModifySubscriberAttributes extends B2CMenu {

    public ModifySubscriberAttributes(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Modify Subscriber Attributes";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public RequestSubmission clickModifyAttributes() throws Exception {

        driver.findElement(By.xpath("//input[@value= 'Modify Attributes']")).click();
        return new RequestSubmission(driver);
    }

    public void selectLanguage(String language) throws Exception {

        new Select(driver.findElement(By.id("p-param-L4:80000"))).selectByVisibleText(language);

    }

    public String getLanguage() throws Exception {

        String language = new Select(driver.findElement(By.id("p-param-L4:80000"))).getFirstSelectedOption().getText();
        return language;
    }

    public SubscriberDetail clickCancel() throws Exception {

        driver.findElement(By.xpath("//input[@value= 'Cancel']")).click();
        return new SubscriberDetail(driver);
    }

}
