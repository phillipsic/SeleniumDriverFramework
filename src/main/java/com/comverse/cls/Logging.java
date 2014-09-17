package com.comverse.cls;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class Logging extends CLSMenu {

    public Logging(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "logging";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void clickTodayFilter() throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.switchToFrame(tool.searchUsingID("_ddajaxtabsiframe-loggingTabContent"));
        tool.clickUsingID("useCustomTimeframe_period");
        tool.switchTo();
    }

    public void setDisplayUserName(String name) throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.switchToFrame(tool.searchUsingID("_ddajaxtabsiframe-loggingTabContent"));
        tool.enterStringUsingId("displayUserName", name);
        tool.switchTo();
    }

    public void clickSearch() throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.switchToFrame(tool.searchUsingID("_ddajaxtabsiframe-loggingTabContent"));
        tool.clickUsingXPath("//input[@value='Submit']");
        tool.switchTo();
    }

    public void clickLogut() throws Exception {  test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//img[@alt='Logout']");

    }

    public void waitForLoadingToDisappear() throws Exception {  test.writeInLogFile(Common.getMethodName());

        int maxIterations = 90;
        boolean foundElement = false;
        for (int iteration = 0;; iteration++) {
            System.out.println(" Iteration " + iteration + " of " + maxIterations);
            if (iteration >= maxIterations) {
                throw new Exception("Timeout");
            }
            try {
                tool.switchToFrame(tool.searchUsingID("_ddajaxtabsiframe-loggingTabContent"));
                String pageSource = tool.getPageSource();
                if (pageSource.contains("Rows per page")) {
                    foundElement = true;
                    System.out.println("FoundElement =  ..." + foundElement);
                    tool.switchTo();
                    break;
                }
                tool.switchTo();
                System.out.println("FoundElement =  ..." + foundElement);
                Common.sleepForNumberOfSeconds(1);

            } catch (Exception e) {
            }
        }
    }

    public void assertClusterNameDropDownContains(String value) throws Exception {  test.writeInLogFile(Common.getMethodName());
        assertEquals(true, this.checkDropDownForValue("clusterNameFilter", value));
    }

    public void selectRecordPerPage(String value) throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.switchToFrame(tool.searchUsingID("_ddajaxtabsiframe-loggingTabContent"));
        tool.selectVisibleTextByID("yui-pg0-0-rpp81", value);
        tool.switchTo();
        Common.sleepForNumberOfSeconds(10);
    }

    private boolean checkDropDownForValue(String dropDownID, String value) throws Exception {  test.writeInLogFile(Common.getMethodName());
        boolean optionFound = false;
        tool.switchToFrame(tool.searchUsingID("_ddajaxtabsiframe-loggingTabContent"));

        List<WebElement> options = ((AutomationTool) tool.searchUsingID("clusterNameFilter")).searchListUsingTagName("option");

        for (WebElement el : options) {
            System.out.println(el.getText());

            if (value.equals(el.getText())) {
                optionFound = true;
            }
        }
        tool.switchTo();

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
