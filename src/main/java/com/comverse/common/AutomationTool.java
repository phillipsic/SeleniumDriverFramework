package com.comverse.common;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

public class AutomationTool extends Main {

    public AutomationTool() {
    }

    public boolean checkDisplayedUsingXpath(String xpath) throws Exception {
        return false;
    }

    public boolean checkSelectedUsingXpath(String xpath) throws Exception {
        return false;
    }

    public void clickListUsingName(String name) throws Exception {
    }

    public void clickPerformUsingXPath(String xpath) throws Exception {
    }

    public void clickUsingCssSelector(String cssSelector) throws Exception {
    }

    public void clickUsingID(String id) throws Exception {
    }

    public void clickUsingLinkText(String string) throws Exception {
    }

    public void clickUsingName(String name) throws Exception {
    }

    public void clickUsingPartialLinkText(String partialLinkText) throws Exception {
    }

    public void clickUsingTagName(String tagName) throws Exception {
    }

    public void clickUsingXPath(String xpath) throws Exception {
    }

    public void deselectVisibleTextByID(String id, String visibleText) throws Exception {
    }

    public void enterStringUsingCssSelector(String cssSelector, String data) throws Exception {
    }

    public void enterStringUsingId(String id, String data) throws Exception {
    }

    public void enterStringUsingName(String name, String data) throws Exception {
    }

    public void enterStringUsingXPath(String xpath, String data) throws Exception {
    }

    public void get(String URL) throws Exception {
    }

    public String getAttributeUsingId(String id, String attribute) throws Exception {
        return null;
    }

    public String getAttributeUsingXpath(String xpath, String attribute) throws Exception {
        return null;
    }

    public String getCurrentUrl() throws Exception {
        return null;
    }

    public String getPageSource() throws Exception {
        return null;
    }

    public String getSelectedTextByID(String id) throws Exception {
        return null;
    }

    public String getTextUsingClassName(String className) throws Exception {
        return null;
    }

    public String getTextUsingCssSelector(String cssSelector) throws Exception {
        return null;
    }

    public String getTextUsingId(String Id) throws Exception {
        return null;
    }

    public String getTextUsingName(String name) throws Exception {
        return null;
    }

    public String getTextUsingXPath(String xpath) throws Exception {
        return null;
    }

    public String getTitle() throws Exception {
        return null;
    }

    public String getWindowHandle() throws Exception {
        return null;
    }

    public Set<String> getWindowHandles() {
        return null;
    }

    public String instanciateDriver(AutomationTool tool, Test test) throws Exception {
        return null;
    }

    public boolean isElementPresentByID(String id) throws Exception {
        return false;
    }

    public boolean isElementPresentByXPath(String xpath) throws Exception {
        return false;
    }

    public void navigateBack() throws Exception {
    }

    public void navigateRefresh() throws Exception {
    }

    public void parseUserAgent(AutomationTool tool, Test test, String intBrowser) {
    }

    public void performDragAndDrop(WebElement from, WebElement to) throws Exception {
    }

    public void performUsingXPath(String xpath) throws Exception {
    }

    public void quit() throws Exception {
    }

    public boolean searchListUsingLinkTextIsEmpty(String linkText) throws Exception {
        return false;
    }

    public List<WebElement> searchListUsingTagName(String tagName) throws Exception {
        return null;
    }

    public List<WebElement> searchListUsingXPath(String xpath) throws Exception {
        return null;
    }

    public WebElement searchUsingCssSelector(String cssSelector) throws Exception {
        return null;
    }

    public WebElement searchUsingID(String id) throws Exception {
        return null;
    }

    public String searchUsingIDandGetTextUsingXpath(String id, String Xpath) throws Exception {
        return null;
    }

    public WebElement searchUsingName(String name) throws Exception {
        return null;
    }

    public WebElement searchUsingXpath(String xpath) throws Exception {
        return null;
    }

    public void selectByIndexByID(String id, int index) throws Exception {
    }

    public void selectVisibleTextByID(String id, String visibleText) throws Exception {
    }

    public void selectVisibleTextByName(String name, String visibleText) throws Exception {
    }

    public void selectVisibleTextByXPath(String xpath, String visibleText) throws Exception {
    }

    public void selectImage(String id, String data) throws Exception {
    }

    public void switchTo() throws Exception {
    }

    public void switchToFrame(WebElement webElement) throws Exception {
    }

    public void switchToWindow(String windowHandle) throws Exception {
    }
}
