package com.comverse.css.pos;

import java.io.File;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class UploadToken extends CommonMenu {

    public UploadToken(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Upload Token";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectFile(String filename) throws Exception {

        File file = new File(filename);
        // tool.driver.findElement(By.id("fileUpload")).clear();
        tool.driver.findElement(By.id("fileUpload")).sendKeys(file.getAbsolutePath());

    }

    public Tokensfound clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Ok']")).click();

        return new Tokensfound(tool, test, user);
    }
}