package com.comverse.css.b2b;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RemoveBasketCommon;

public class RemoveBasket extends RemoveBasketCommon {

    public RemoveBasket(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    public AccountDetails clickYes() throws Exception {

        tool.driver.findElement(By.xpath("//form[@id='form_YES']/div/input")).click();
        return new AccountDetails(tool, test, user);
    }
}
