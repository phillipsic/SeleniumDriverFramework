package com.framework.common;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;

public class AutomationTool extends Main {

    public AutomationTool() {
    }

    public boolean checkDisplayedUsingXpath(String xpath) throws Exception {
        return false;
    }

    public boolean checkDisplayedUsingId(String id) throws Exception {
        return false;
    }

    public boolean checkEnabledUsingXpath(String xpath) throws Exception {
        return false;
    }

    public boolean checkEnabledUsingId(String id) throws Exception {
        return false;
    }

    public boolean checkSelectedUsingXpath(String xpath) throws Exception {
        return false;
    }

    public boolean checkSelectedUsingId(String id) throws Exception {
        return false;
    }

    public void clearStringUsingCssSelector(String cssSelector) throws Exception {
    }

    public void clearStringUsingId(String id) throws Exception {
    }

    public void clearStringUsingXPath(String xpath) throws Exception {
    }

    public void clearStringUsingName(String name) throws Exception {
    }

    public void closeCurrentWindow() throws Exception {

    }

    public void pressTABWithID(String id) throws Exception {

    }

    public void pressTABWithXPath(String xpath) throws Exception {

    }

    public void pressENTERWithXPath(String xpath) throws Exception {

    }

    public void pressENTERWithID(String id) throws Exception {

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

    public void enterStringNotTextFieldUsingId(String id, String data) throws Exception {
    }

    public void enterStringUsingName(String name, String data) throws Exception {
    }

    public void enterStringIntoFileUsingName(String name, String data) throws Exception {
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

    public String getSelectedTextByXpath(String xpath) throws Exception {
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

    public String instanciateDriver(AutomationTool tool, TestDetails test) throws Exception {
        return null;
    }

    public boolean isElementPresentByID(String id) throws Exception {
        return false;
    }

    public boolean isElementPresentByLinkText(String text) throws Exception {
        return false;
    }

    public boolean isElementPresentByXPath(String xpath) throws Exception {
        return false;
    }

    public void navigateBack() throws Exception {
    }

    public void navigateRefresh() throws Exception {
    }

    public void parseUserAgent(AutomationTool tool, TestDetails test, String intBrowser) {
    }

    public void updateAttributeById(AutomationTool tool, TestDetails test, String elementId, String attribute, String value) {

    }

    public void updateAttributeByXpath(AutomationTool tool, TestDetails test, String elementId, String attribute, String value) {

    }

    public void performDragAndDrop(WebElement from, WebElement to) throws Exception {
    }

    public void performMoveUsingXPath(String xpath) throws Exception {
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

    public void switchToDefaultContent() throws Exception {
    }

    public void switchToFrame(String webElement) throws Exception {
    }

    public void switchToFrameUsingXpath(String xpath) throws Exception {

    }

    public void switchToWindow(String windowHandle) throws Exception {
    }

    public void switchToAlertAndAccept() throws Exception {
    }

    public String switchToAlertAndGetText() throws Exception {
        return null;
    }

    public void waitForVisibilityOfElementUsingXpath(String xpath, int timeout) throws Exception {

    }

    public void waitForVisibilityOfElementUsingId(String id, int timeout) throws Exception {

    }

    public void waitForElementToBeClickableUsingId(String id, int timeout) throws Exception {

    }

    public void waitForElementToBeClickableUsingXpath(String xpath, int timeout) throws Exception {

    }

    public String takeScreenShot(String reportingPath) throws IOException, Exception {
        return null;
    }

    public void moveCursorSomewhereElse(String xpath) throws Exception {
    }

    public int countRowsInTableUsingClass(String tableClass) throws Exception {
        return 0;
    }

    public void scrollDownUsingClassName(String className) throws Exception {

    }

}
