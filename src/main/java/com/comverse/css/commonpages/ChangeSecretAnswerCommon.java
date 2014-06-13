/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ChangeSecretAnswerCommon extends CommonMenu {

    public ChangeSecretAnswerCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Change secret question and answer";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "password_old", password);
    }

    public void setSecretAnswer(String answer) throws Exception {

        
        tool.enterStringUsingId(tool, "secretAnswer", answer);
    }

    public String getSecretAnswer() throws Exception {

        return tool.driver.findElement(By.id("secretAnswer")).getAttribute("value");
    }

    public void setSecretQuestion(String question) throws Exception {

        new Select(tool.searchUsingID(tool, "secretQuestionId")).selectByVisibleText(question);
    }

    public ConfirmNewSecretAnswerCommon clickChangeSecretAnswer() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new ConfirmNewSecretAnswerCommon(tool, test, user);
    }

}
