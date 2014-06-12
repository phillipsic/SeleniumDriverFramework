package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

/**
 * 
 * @author iphilli
 */
public class RemoveSelectionCommon extends CommonMenu {

    public RemoveSelectionCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Remove Selection";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickYes() throws Exception {

        tool.driver.findElement(By.xpath("//form[@id='form_YES']/div/input")).click();
        return new MyBasketCommon(tool, test, user);
    }

    public RemoveLevelCommon clickRemoveSelectionByYes() throws Exception {

        tool.driver.findElement(By.xpath("//form[@id='form_YES']/div/input")).click();
        return new RemoveLevelCommon(tool, test, user);
    }
}
