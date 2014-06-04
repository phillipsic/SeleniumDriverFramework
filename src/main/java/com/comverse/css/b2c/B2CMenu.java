package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author iphilli
 */
public class B2CMenu {

    public WebDriver driver;

    public B2CMenu(WebDriver driver) {
        this.driver = driver;

    }

    public SearchOrders clickRequests() throws Exception {

        driver.findElement(By.id("mnu_REQUESTS")).click();
        return new SearchOrders(driver);
    }

    public HomePage clickLogout() throws Exception {

        driver.findElement(By.id("mnu_LOGOUT")).click();
        return new HomePage(driver);
    }

    public SearchMember clickFamilyMemeber() throws Exception {

        driver.findElement(By.id("mnu_MEMBERS")).click();
        return new SearchMember(driver);
    }

    public SubscriberDetail clickDashbaord() throws Exception {

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
        driver.findElement(By.id("mnu_HOME")).click();
        return new SubscriberDetail(driver);
    }

    public WorkSpace clickDashbaordWithNoSubscriber() throws Exception {

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
        driver.findElement(By.id("mnu_HOME")).click();
        return new WorkSpace(driver);
    }

    public SearchCustomer clickSearchCustomer() throws Exception {

        driver.findElement(By.id("mnu_SEARCH_CUSTOMER")).click();
        return new SearchCustomer(driver);
    }

    public SearchMember clickMyInformation() throws Exception {

        driver.findElement(By.id("mnu_CUST_INFO")).click();
        return new SearchMember(driver);
    }

    public SearchOrders clickMyOrders() throws Exception {

        driver.findElement(By.linkText("My Orders")).click();
        return new SearchOrders(driver);
    }

    public ListCases clickSupport() throws Exception {

        driver.findElement(By.id("mnu_PROBLEMS")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ListCases(driver);
    }

    public SubscriberDetail clickMyAccount() throws Exception {

        driver.findElement(By.linkText("My Account")).click();
        return new SubscriberDetail(driver);
    }

    public Shopping clickShopping() throws Exception {
        driver.findElement(By.linkText("Shopping")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new Shopping(driver);
    }
}
