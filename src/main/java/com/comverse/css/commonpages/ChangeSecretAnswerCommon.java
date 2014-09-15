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
        String currentScreen = tool.getTitle();
        String expectedScreen = "Change secret question and answer";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setPassword(String password) throws Exception {  test.writeInLog(Common.getMethodName());

        
        tool.enterStringUsingId("password_old", password);
    }

    public void setSecretAnswer(String answer) throws Exception {  test.writeInLog(Common.getMethodName());

        
        tool.enterStringUsingId("secretAnswer", answer);
    }

    public String getSecretAnswer() throws Exception {  test.writeInLog(Common.getMethodName());

        return tool.getAttributeUsingId("secretAnswer", "value");
    }

    public void setSecretQuestion(String question) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.selectVisibleTextByID("secretQuestionId", question);
    }

    public ConfirmNewSecretAnswerCommon clickChangeSecretAnswer() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Confirm']");
        return new ConfirmNewSecretAnswerCommon(tool, test, user);
    }

}
