/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;


import com.comverse.css.commonpages.CommonMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author iphilli
 */
public class AddEmployeeRegisterLogin extends CommonMenu {

    public AddEmployeeRegisterLogin(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Add Employee - Register Login";

  
        if (!expectedScreen.equals(driver.getTitle())) {
  
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterLogin(String login) throws Exception {

        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(login);
    }

    public AddEmployeeConfirmation clickSubmit() throws Exception {

        driver.findElement(By.cssSelector("input.submit")).click();
        return new AddEmployeeConfirmation(driver);
    }
    
        public RegisterLogin clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new RegisterLogin(driver);
    }
}
