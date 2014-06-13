package com.comverse.css.pos;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class SearchRetailer extends CommonMenu {

    public SearchRetailer(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Search Retailer";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setDealerName(String dealerName) throws Exception {

        
        tool.enterStringUsingId(tool, "p-L1:2-L3:1480", dealerName);
    }

    public void clickSearchDealerName() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Search']")).click();

    }

    public ViewHierarchy clickDealerLink(String dealerName) throws Exception {

        tool.clickUsingLinkText(tool, dealerName);

        return new ViewHierarchy(tool, test, user);
    }

}
