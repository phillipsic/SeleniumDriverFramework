package com.comverse.cls;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CLSMenu extends Main {

    public CLSMenu(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;
    }

    public void clickSignOut() {
        tool.driver.findElement(By.id("$azn666_label")).click();

    }
}
