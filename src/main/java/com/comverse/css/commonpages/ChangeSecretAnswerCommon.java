/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author iphilli
 */
public class ChangeSecretAnswerCommon extends CommonMenu {

    public ChangeSecretAnswerCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Change secret question and answer";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setPassword(String password) throws Exception {

        driver.findElement(By.id("password_old")).clear();
        driver.findElement(By.id("password_old")).sendKeys(password);
    }

    public void setSecretAnswer(String answer) throws Exception {

        driver.findElement(By.id("secretAnswer")).clear();
        driver.findElement(By.id("secretAnswer")).sendKeys(answer);
    }

    public String getSecretAnswer() throws Exception {

        return driver.findElement(By.id("secretAnswer")).getAttribute("value");
    }

    public void setSecretQuestion(String question) throws Exception {

        new Select(driver.findElement(By.id("secretQuestionId"))).selectByVisibleText(question);
    }

    public ConfirmNewSecretAnswerCommon clickChangeSecretAnswer() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new ConfirmNewSecretAnswerCommon(driver);
    }

}
