/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.MyshapeCommon;

public class MyshapeCSRPortal extends MyshapeCommon {

    public MyshapeCSRPortal(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "Myshape CSR Portal";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public WorkSpace clickChange() throws Exception {
        driver.findElement(By.xpath("//input[@value='Change']")).click();
        return new WorkSpace(driver);
    }

    public HomePageBackOffice clickChangePassword() throws Exception {
        driver.findElement(By.xpath("//input[@value='Change']")).click();
        return new HomePageBackOffice(driver);
    }

    @Override
    public WorkSpace clickContinue() throws Exception {
        super.clickContinue();
        return new WorkSpace(driver);
    }

}
