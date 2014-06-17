/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ChangeSecretAnswerCommon extends CommonMenu {

    public ChangeSecretAnswerCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Change secret question and answer";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

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

        return tool.getAttributeUsingId(tool, "secretAnswer", "value");
    }

    public void setSecretQuestion(String question) throws Exception {

        tool.selectVisibleTextByID(tool, "secretQuestionId", question);
    }

    public ConfirmNewSecretAnswerCommon clickChangeSecretAnswer() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Confirm']");
        return new ConfirmNewSecretAnswerCommon(tool, test, user);
    }

}
