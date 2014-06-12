package com.comverse.upm.upmPages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.sfa.sfaHomePage;

public class upmLoginPage extends Main {

    public upmLoginPage(AutomationTool tool) {
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Comverse ONE Unified Platform";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setUserId(String login) throws Exception {

        tool.driver.findElement(By.id("Iujgbo2")).clear();
        tool.driver.findElement(By.id("Iujgbo2")).sendKeys(login);
    }

    public void setPassword(String password) throws Exception {

        tool.driver.findElement(By.id("I604i25")).clear();
        tool.driver.findElement(By.id("I604i25")).sendKeys(password);
    }

    public sfaHomePage clickSignIn() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='SIGN IN']")).click();
        return new sfaHomePage(tool, test, user);
    }

    public String getMessage() throws Exception {

        return tool.driver.findElement(By.xpath("//span")).getText();
    }

}
