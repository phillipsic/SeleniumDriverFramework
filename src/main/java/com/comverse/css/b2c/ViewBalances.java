package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author iphilli
 */
public class ViewBalances extends B2CMenu {

    public ViewBalances(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "View Balances";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public double getBalanceValue(String balanceName) throws Exception {

        String balanceValue = driver.findElement(By.xpath("//a[contains(text(),'" + balanceName + "')]/../../td[2]")).getText();

        double balanceValueDouble = Common.removeCurrencyAndConvertToDouble(balanceValue);
        return balanceValueDouble;
    }

    public void clickRefreshButton() throws Exception {
        driver.findElement(By.xpath("//img[@id='refreshCacheImg']")).click();
    }
    public ConfigureBalance clickConfigure() throws Exception {
        driver.findElement(By.linkText("Configure")).click();
        return new ConfigureBalance(driver);
    }
    
     public BalanceDetails clickBalanceDetails(String balanceName) throws Exception {
        driver.findElement(By.xpath("//tr[td/a[contains(text(),'" + balanceName + "')]]/td/a[contains(text(),'Details')]")).click();
        return new BalanceDetails(driver);
    }
     
     public SubscriberDetail clickBack() throws Exception {
        driver.findElement(By.id("youcan_ON_BACK")).click();
        return new SubscriberDetail(driver);
    }
}
