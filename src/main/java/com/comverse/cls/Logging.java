package com.comverse.cls;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class Logging extends CLSMenu {

    public Logging(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "logging";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickTodayFilter() throws Exception {
        tool.driver.switchTo().frame(tool.driver.findElement(By.id("_ddajaxtabsiframe-loggingTabContent")));
        tool.driver.findElement(By.id("useCustomTimeframe_period")).click();
        tool.driver.switchTo().defaultContent();
    }

    public void setDisplayUserName(String name) throws Exception {
        tool.driver.switchTo().frame(tool.driver.findElement(By.id("_ddajaxtabsiframe-loggingTabContent")));
        tool.driver.findElement(By.id("displayUserName")).clear();
        tool.driver.findElement(By.id("displayUserName")).sendKeys(name);
        tool.driver.switchTo().defaultContent();
    }

    public void clickSearch() throws Exception {
        tool.driver.switchTo().frame(tool.driver.findElement(By.id("_ddajaxtabsiframe-loggingTabContent")));
        tool.driver.findElement(By.xpath("//input[@value='Submit']")).click();
        tool.driver.switchTo().defaultContent();
    }

    public void clickLogut() throws Exception {

        tool.driver.findElement(By.xpath("//img[@alt='Logout']")).click();

    }

    public void waitForLoadingToDisappear() throws Exception {

        int maxIterations = 90;
        boolean foundElement = false;
        for (int iteration = 0;; iteration++) {
            System.out.println(" Iteration " + iteration + " of " + maxIterations);
            if (iteration >= maxIterations) {
                throw new Exception("Timeout");
            }
            try {
                tool.driver.switchTo().frame(tool.driver.findElement(By.id("_ddajaxtabsiframe-loggingTabContent")));
                String pageSource = tool.driver.getPageSource();
                if (pageSource.contains("Rows per page")) {
                    foundElement = true;
                    System.out.println("FoundElement =  ..." + foundElement);
                    tool.driver.switchTo().defaultContent();
                    break;
                }
                tool.driver.switchTo().defaultContent();
                System.out.println("FoundElement =  ..." + foundElement);
                Common.sleepForNumberOfSeconds(1);

            } catch (Exception e) {
            }
        }
    }

    public void assertClusterNameDropDownContains(String value) throws Exception {

        assertEquals(true, this.checkDropDownForValue("clusterNameFilter", value));
    }

    public void selectRecordPerPage(String value) throws Exception {

        tool.driver.switchTo().frame(tool.driver.findElement(By.id("_ddajaxtabsiframe-loggingTabContent")));
        new Select(tool.searchUsingID(tool, "yui-pg0-0-rpp81")).selectByVisibleText(value);
        tool.driver.switchTo().defaultContent();
        Common.sleepForNumberOfSeconds(10);
    }

    private boolean checkDropDownForValue(String dropDownID, String value) throws Exception {

        boolean optionFound = false;
        tool.driver.switchTo().frame(tool.driver.findElement(By.id("_ddajaxtabsiframe-loggingTabContent")));

        WebElement dropDown = tool.driver.findElement(By.id("clusterNameFilter"));
        List<WebElement> options = dropDown.findElements(By.tagName("option"));

        for (WebElement el : options) {
            System.out.println(el.getText());

            if (value.equals(el.getText())) {
                optionFound = true;
            }
        }

        tool.driver.switchTo().defaultContent();

        return optionFound;
    }

    /*
     * clusterNameFilter
     * 
     * 
     * <option id="yui-gen553" value="ALL">ALL</option> <option id="yui-gen554"
     * value="WUIP_APP">WUIP_APP</option> <option
     * value="WUIP_INT">WUIP_INT</option>
     */
}
