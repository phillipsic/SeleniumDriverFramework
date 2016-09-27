package com.framework.common;

import io.github.bonigarcia.wdm.ChromeDriverManager;
////import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import java.net.InetAddress;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.SessionId;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium extends AutomationTool {

    private WebDriver driver;
    private Actions action;
    PropertyHelper propsHelper = new PropertyHelper();
//    JavascriptExecutor jse = (JavascriptExecutor) driver;

    public Selenium() throws Exception {
    }

    @Override
    public boolean checkDisplayedUsingXpath(String xpath) throws Exception {
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    @Override
    public boolean checkDisplayedUsingId(String id) throws Exception {
        return driver.findElement(By.id(id)).isDisplayed();
    }

    @Override
    public boolean checkSelectedUsingXpath(String xpath) throws Exception {
        return driver.findElement(By.xpath(xpath)).isSelected();
    }

    @Override
    public boolean checkSelectedUsingId(String id) throws Exception {
        return driver.findElement(By.id(id)).isSelected();
    }

    @Override
    public boolean checkEnabledUsingXpath(String xpath) throws Exception {
        return driver.findElement(By.xpath(xpath)).isEnabled();
    }

    @Override
    public boolean checkEnabledUsingId(String id) throws Exception {
        return driver.findElement(By.id(id)).isEnabled();
    }

    @Override
    public void clickListUsingName(String name) throws Exception {
        driver.findElements(By.name(name)).get(0).click();
    }

    @Override
    public void clickPerformUsingXPath(String xpath) throws Exception {
        action = new Actions(driver);
        this.action.moveToElement(driver.findElement(By.xpath(xpath))).click().perform();
    }

    @Override
    public void clickUsingCssSelector(String cssSelector) throws Exception {
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    @Override
    public void clickUsingID(String id) throws Exception {
        driver.findElement(By.id(id)).click();
    }

    @Override
    public void clickUsingLinkText(String linkText) throws Exception {
        driver.findElement(By.linkText(linkText)).click();
    }

    @Override
    public void clickUsingName(String name) throws Exception {
        driver.findElement(By.name(name)).click();
    }

    @Override
    public void clickUsingPartialLinkText(String partialLinkText) throws Exception {
        driver.findElement(By.partialLinkText(partialLinkText)).click();
    }

    @Override
    public void clickUsingTagName(String tagName) throws Exception {
        driver.findElement(By.tagName(tagName)).click();
    }

    @Override
    public void clickUsingXPath(String xpath) throws Exception {
        driver.findElement(By.xpath(xpath)).click();
    }

    @Override
    public void closeCurrentWindow() throws Exception {
        driver.close();
    }

    @Override
    public void deselectVisibleTextByID(String id, String visibleText) throws Exception {
        new Select(driver.findElement(By.id(id))).deselectByVisibleText(visibleText);
    }

    @Override
    public void enterStringUsingCssSelector(String cssSelector, String data) throws Exception {
        driver.findElement(By.cssSelector(cssSelector)).clear();
        driver.findElement(By.cssSelector(cssSelector)).sendKeys(data);
    }

    @Override
    public void enterStringUsingId(String id, String data) throws Exception {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(data);
    }

    @Override
    public void clearStringUsingCssSelector(String cssSelector) throws Exception {
        driver.findElement(By.cssSelector(cssSelector)).clear();

    }

    @Override
    public void clearStringUsingId(String id) throws Exception {
        driver.findElement(By.id(id)).clear();

    }

    @Override
    public void clearStringUsingXPath(String xpath) throws Exception {
        driver.findElement(By.xpath(xpath)).clear();
    }

    @Override
    public void clearStringUsingName(String name) throws Exception {
        driver.findElement(By.name(name)).clear();

    }

    @Override
    public void enterStringNotTextFieldUsingId(String id, String data) throws Exception {
        driver.findElement(By.id(id)).sendKeys(data);
    }

    @Override
    public void enterStringUsingName(String name, String data) throws Exception {
        driver.findElement(By.name(name)).clear();
        driver.findElement(By.name(name)).sendKeys(data);
    }

    @Override
    public void enterStringIntoFileUsingName(String name, String data) throws Exception {
        // driver.findElement(By.name(name)).clear();
        driver.findElement(By.name(name)).sendKeys(data);
    }

    @Override
    public void enterStringUsingXPath(String xpath, String data) throws Exception {
        driver.findElement(By.xpath(xpath)).clear();
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    @Override
    public void get(String URL) throws Exception {
        driver.get(URL);
    }

    @Override
    public String getAttributeUsingId(String id, String attribute) throws Exception {
        return driver.findElement(By.id(id)).getAttribute(attribute);
    }

    @Override
    public String getAttributeUsingXpath(String xpath, String attribute) throws Exception {
        return driver.findElement(By.xpath(xpath)).getAttribute(attribute);
    }

    @Override
    public String getCurrentUrl() throws Exception {
        return driver.getCurrentUrl();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public String getPageSource() throws Exception {
        return driver.getPageSource();
    }

    @Override
    public String getSelectedTextByID(String id) throws Exception {
        return new Select(driver.findElement(By.id(id))).getFirstSelectedOption().getText();
    }

    @Override
    public String getSelectedTextByXpath(String xpath) throws Exception {
        return new Select(driver.findElement(By.xpath(xpath))).getFirstSelectedOption().getText();
    }

    @Override
    public String getTextUsingClassName(String className) throws Exception {
        return driver.findElement(By.className(className)).getText();
    }

    @Override
    public String getTextUsingCssSelector(String cssSelector) throws Exception {
        return driver.findElement(By.cssSelector(cssSelector)).getText();
    }

    @Override
    public String getTextUsingId(String Id) throws Exception {
        return driver.findElement(By.id(Id)).getText();
    }

    @Override
    public String getTextUsingName(String name) throws Exception {
        return driver.findElement(By.name(name)).getText();
    }

    @Override
    public String getTextUsingXPath(String xpath) throws Exception {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    @Override
    public String getTitle() throws Exception {
        return driver.getTitle();
    }

    @Override
    public String getWindowHandle() throws Exception {
        return driver.getWindowHandle();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String instanciateDriver(AutomationTool tool, TestDetails test) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();

        tool.platform.setOsOfTestPlatform();

        tool.platform.setComputerName(System.getenv("computername"));
        if (tool.platform.getComputerName() == null) {
            tool.platform.setComputerName(InetAddress.getLocalHost().getHostName());
        }
        System.out.println("computerName : " + tool.platform.getComputerName());

        if (System.getProperty("selenium_browser") == null) {
            tool.platform.setBrowser(propsHelper.readInitProperties("BROWSER.type"));
            System.out.println("Browser set in property file: " + tool.platform.getBrowser());
        } else {
            tool.platform.setBrowser(System.getProperty("selenium_browser"));
            System.out.println("Browser found by Jenkins " + tool.platform.getBrowser());
        }

        if (System.getProperty("selenium_os") != null) {
            tool.platform.setOS(System.getProperty("selenium_os"));
            System.out.println("OS set to " + tool.platform.getOS());
        }

        String useGRID = propsHelper.readInitProperties("USE.GRID");
        String gridHubIP = propsHelper.readInitProperties("GRID.HUB.IP");
        String gridHubPort = propsHelper.readInitProperties("GRID.HUB.PORT");
        String gridOS = propsHelper.readInitProperties("GRID.OS");
        String jenkinsServer = System.getProperty("jenkins_server");

        System.out.println("Use GRID set to " + useGRID);

        if (jenkinsServer == null) {
            jenkinsServer = "false";
        }
        System.out.println("Jenkins Server " + jenkinsServer);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        System.out.println("Actual machine name   [" + tool.platform.getComputerName() + "]");

        if (jenkinsServer.equalsIgnoreCase("true") || useGRID.equalsIgnoreCase("true")) {

            String gridBrowser = propsHelper.readInitProperties("GRID.BROWSER");
            System.out.println("Running on Jenkins and using GRID ");

            if (jenkinsServer.equalsIgnoreCase("true")) {
                // Running from Jenkins
                // Pick up the properties from system properties

                if (System.getProperty("selenium_browser").equalsIgnoreCase("IE")) {
                    tool.platform.IE(capabilities);
                }

                if (System.getProperty("selenium_browser").equalsIgnoreCase("FF")) {
                    tool.platform.FF(capabilities);
                }

                if (System.getProperty("selenium_browser").equalsIgnoreCase("CH")) {
                    tool.platform.CH(capabilities);
                }

                if (System.getProperty("selenium_browser").equalsIgnoreCase("BS")) {

                    System.out.println("Setting up BrowserStack properties");
                    /*
                    If we are running from browser stack then pickup different properties
                     */
                    capabilities.setCapability("browser", System.getProperty("browserstack_browser"));

                    if (System.getProperty("selenium_browserversion").equalsIgnoreCase("latest")) {
                        capabilities.setCapability("browser_version", "");
                    } else {
                        capabilities.setCapability("browser_version", System.getProperty("selenium_browserversion"));
                    }

                    capabilities.setCapability("os", System.getProperty("selenium_os"));

                    if (System.getProperty("selenium_osversion").equalsIgnoreCase("latest")) {
                        capabilities.setCapability("os_version", "");
                    } else {
                        capabilities.setCapability("os_version", System.getProperty("selenium_osversion"));
                    }

                    capabilities.setCapability("browserstack.debug", "false");
                    capabilities.setCapability("project", propsHelper.readInitProperties("BROWSERSTACK.project"));
                    capabilities.setCapability("build", test.getName());

                    System.out.println("Completed Setting up BrowserStack properties");
                }

                // Turn off debugging if we are running from jenkins
                test.setDebug(false);
                System.out.println("Running on Jenkins so debug set to " + test.getDebug());

                if (useGRID.equalsIgnoreCase("true")) {
                    System.out.println(" - - > Setting up GRID properties");

                    capabilities.setCapability("tool.platform", gridOS);
                    tool.platform.setBrowser(gridBrowser);
                    capabilities.setCapability("tool.platform", tool.platform.getOS());

                    ping("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub", 5000);

                    driver = new RemoteWebDriver(new URL("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub"), capabilities);
                } else if (tool.platform.getBrowser().equalsIgnoreCase("BS")) {

                    System.out.println(" - - > Setting up BrowserStack properties");
                    tool.platform.setBrowserFullNameAndVersion(propsHelper.readInitProperties("BROWSERSTACK.browser") + " - " + propsHelper.readInitProperties("BROWSERSTACK.os_version"));
                    tool.platform.setOSFullNameAndVersion(propsHelper.readInitProperties("BROWSERSTACK.os") + " - " + propsHelper.readInitProperties("BROWSERSTACK.os_version"));

                    String USERNAME = propsHelper.readInitProperties("BROWSERSTACK.username");
                    String AUTOMATEKEY = propsHelper.readInitProperties("BROWSERSTACK.automatekey");
                    String URL = "http://" + USERNAME + ":" + AUTOMATEKEY + "@hub.browserstack.com/wd/hub";
                    //tool.platform.BS(capabilities);
                    driver = new RemoteWebDriver(new URL(URL), capabilities);

                    SessionId session_Id = ((RemoteWebDriver) driver).getSessionId();
                    System.out.println("BrowserStack Session ID" + session_Id);

                    Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
                    String browsername = cap.getBrowserName();
                    String browserversion = cap.getVersion();
                    System.out.println("Browser: " + browsername);
                    System.out.println("Browser Version: " + browserversion);

                    String browserAndVersion = "";
                    if (StringUtils.countMatches(browserversion, ".") > 1) {

                        String[] shortVersion = browserversion.split("\\.", 3);
                        browserAndVersion = shortVersion[0] + "." + shortVersion[1];
                    } else {
                        browserAndVersion = browserversion;
                    }

                    tool.platform.setBrowserFullNameAndVersion(browsername + "/" + browserAndVersion);
                    tool.platform.setOSFullNameAndVersion(propsHelper.readInitProperties("BROWSERSTACK.os") + " - " + propsHelper.readInitProperties("BROWSERSTACK.os_version"));

                }

            } else {

                // Running from a PC and selecting GRID
                // Pick up the propeties from INT file.
                if (gridBrowser.equalsIgnoreCase("IE")) {
                    tool.platform.IE(capabilities);
                }

                if (gridBrowser.equalsIgnoreCase("FF")) {
                    tool.platform.FF(capabilities);
                }

                if (gridBrowser.equalsIgnoreCase("CH")) {
                    tool.platform.CH(capabilities);
                }

                capabilities.setCapability("tool.platform", gridOS);
                tool.platform.setBrowser(gridBrowser);

                System.out.println("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub");

                ping("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub", 5000);
                driver = new RemoteWebDriver(new URL("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub"), capabilities);

            }

        } else {

            if (tool.platform.getBrowser().equalsIgnoreCase("IE")) {
//                tool.platform.IE(capabilities);
//                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
            }

            if (tool.platform.getBrowser().equalsIgnoreCase("FF")) {
                FirefoxProfile profile = tool.platform.FF(capabilities);
                driver = new FirefoxDriver(profile);
            }

            if (tool.platform.getBrowser().equalsIgnoreCase("CH")) {
                tool.platform.CH(capabilities);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver(options);
            }

            // Browser Stack
            if (tool.platform.getBrowser().equalsIgnoreCase("BS")) {

                String USERNAME = propsHelper.readInitProperties("BROWSERSTACK.username");
                String AUTOMATEKEY = propsHelper.readInitProperties("BROWSERSTACK.automatekey");
                String URL = "http://" + USERNAME + ":" + AUTOMATEKEY + "@hub.browserstack.com/wd/hub";
                tool.platform.BS(capabilities);
                capabilities.setCapability("project", propsHelper.readInitProperties("BROWSERSTACK.project"));
                capabilities.setCapability("build", test.getName());

                driver = new RemoteWebDriver(new URL(URL), capabilities);

                SessionId session_Id = ((RemoteWebDriver) driver).getSessionId();
                System.out.println("BrowserStack Session ID: " + session_Id);

                Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
                String browsername = cap.getBrowserName();
                String browserversion = cap.getVersion();
                System.out.println("Browser: " + browsername);
                System.out.println("Browser Version: " + browserversion);

                String browserAndVersion = "";
                if (StringUtils.countMatches(browserversion, ".") > 1) {

                    String[] shortVersion = browserversion.split("\\.", 3);
                    browserAndVersion = shortVersion[0] + "." + shortVersion[1];
                } else {
                    browserAndVersion = browserversion;
                }

                tool.platform.setBrowserFullNameAndVersion(browsername + "/" + browserAndVersion);
                tool.platform.setOSFullNameAndVersion(propsHelper.readInitProperties("BROWSERSTACK.os") + " - " + propsHelper.readInitProperties("BROWSERSTACK.os_version"));
                tool.platform.setBrowserstaacksessionid(session_Id.toString());
            }

            if (tool.platform.getBrowser().equalsIgnoreCase("SF")) {
//                tool.platform.CH(capabilities);
                driver = new SafariDriver();
            }
        }
        if (driver == null) {
            throw new IllegalStateException("Browser not supported. Please use IE, CH, BS or FF");
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return tool.platform.getBrowser();
    }

    public static boolean ping(String url, int timeout) {
        // Otherwise an exception may be thrown on invalid SSL certificates:
        url = url.replaceFirst("^https", "http");

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399);
        } catch (IOException exception) {
            throw new IllegalStateException("GRID HUB does not appear to have been started");
        }
    }

    @Override
    public boolean isElementPresentByID(String id) throws Exception {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        boolean checkResult = false;
        if (driver.findElements(By.id(id)).size() > 0) {
            checkResult = true;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return checkResult;
    }

    @Override
    public boolean isElementPresentByLinkText(String text) throws Exception {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.linkText(text));
        boolean checkResult = false;
        if (driver.findElements(By.linkText(text)).size() > 0) {
            checkResult = true;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return checkResult;

    }

    @Override
    public boolean isElementPresentByXPath(String xpath) throws Exception {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        boolean checkResult = false;
        if (driver.findElements(By.xpath(xpath)).size() > 0) {
            checkResult = true;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return checkResult;
    }

    @Override
    public void navigateBack() throws Exception {
        driver.navigate().back();
    }

    @Override
    public void navigateRefresh() throws Exception {
        driver.navigate().refresh();
    }

    @Override
    public void updateAttributeById(AutomationTool tool, TestDetails test, String elementId, String attribute, String value) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.document.getElementById('" + elementId + "').setAttribute('" + attribute + "', '" + value + "')");
    }

    @Override
    public void updateAttributeByXpath(AutomationTool tool, TestDetails test, String elementId, String attribute, String value) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.document.getElementByXpath('" + elementId + "').setAttribute('" + attribute + "', '" + value + "')");
    }

    @Override
    public void parseUserAgent(AutomationTool tool, TestDetails test, String intBrowser) {
        String userAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");

        if (test.getDebug()) {
            System.out.println("userAgent : " + userAgent);
        }

        if (intBrowser.equalsIgnoreCase("IE")) {
            String delimiter = ";";
            String[] temp = userAgent.split(delimiter);
            tool.platform.setBrowserFullNameAndVersion(temp[1].trim());
            tool.platform.setOSFullNameAndVersion(temp[2].trim());
        }

        if (intBrowser.equalsIgnoreCase("FF")) {
            String[] temp1 = userAgent.split("\\(");
            String[] temp2 = temp1[1].split(";");
            String[] temp3;
            if (temp2.length > 2) {
                temp3 = temp2[2].split(" ");
            } else {
                temp3 = temp2[1].split(" ");
            }
            tool.platform.setBrowserFullNameAndVersion(temp3[3].trim());
            tool.platform.setOSFullNameAndVersion(temp2[0].trim());
        }

        if (intBrowser.equalsIgnoreCase("CH")) {
            String[] temp1 = userAgent.split("\\(");
            String[] temp2 = temp1[1].split("\\)");
            String[] temp3 = temp1[2].split(" ");
            tool.platform.setBrowserFullNameAndVersion(temp3[3].substring(0, 11).trim());
            tool.platform.setOSFullNameAndVersion(temp2[0].trim());
        }

        if (test.getDebug()) {
            System.out.println("UserAgent => Browser : " + tool.platform.getBrowserFullNameAndVersion());
            System.out.println("UserAgent => OS : " + tool.platform.getOSFullNameAndVersion());
        }
    }

    @Override
    public void performDragAndDrop(WebElement from, WebElement to) throws Exception {
        action = new Actions(driver);
        this.action.dragAndDrop(from, to).perform();
    }

    @Override
    public void performMoveUsingXPath(String xpath) throws Exception {
        action = new Actions(driver);
        this.action.moveToElement(driver.findElement(By.xpath(xpath))).perform();
    }

    @Override
    public void quit() throws Exception {

        try {
            driver.quit();
        } catch (Exception ex) {

            // do something
            System.out.println("Quit Exception");
        }
    }

    @Override
    public boolean searchListUsingLinkTextIsEmpty(String linkText) throws Exception {
        return driver.findElements(By.linkText(linkText)).isEmpty();
    }

    @Override
    public List<WebElement> searchListUsingTagName(String tagName) throws Exception {
        return driver.findElements(By.tagName(tagName));
    }

    @Override
    public List<WebElement> searchListUsingXPath(String xpath) throws Exception {
        return driver.findElements(By.xpath(xpath));
    }

    @Override
    public WebElement searchUsingCssSelector(String cssSelector) throws Exception {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    @Override
    public WebElement searchUsingID(String id) throws Exception {
        return driver.findElement(By.id(id));
    }

    @Override
    public String searchUsingIDandGetTextUsingXpath(String id, String Xpath) throws Exception {
        return driver.findElement(By.id(id)).findElement(By.xpath(Xpath)).getText();
    }

    @Override
    public WebElement searchUsingName(String name) throws Exception {
        return driver.findElement(By.name(name));
    }

    @Override
    public WebElement searchUsingXpath(String xpath) throws Exception {
        return driver.findElement(By.xpath(xpath));
    }

    @Override
    public void selectByIndexByID(String id, int index) throws Exception {
        new Select(driver.findElement(By.id(id))).selectByIndex(index);
    }

    @Override
    public void selectVisibleTextByID(String id, String visibleText) throws Exception {
        new Select(driver.findElement(By.id(id))).selectByVisibleText(visibleText);
    }

    @Override
    public void selectVisibleTextByName(String name, String visibleText) throws Exception {
        new Select(driver.findElement(By.name(name))).selectByVisibleText(visibleText);
    }

    @Override
    public void selectVisibleTextByXPath(String xpath, String visibleText) throws Exception {
        new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(visibleText);
    }

    @Override
    public void selectImage(String id, String data) throws Exception {
        driver.findElement(By.id(id)).sendKeys(data);
    }

    @Override
    public void pressTABWithID(String id) throws Exception {
        driver.findElement(By.id(id)).sendKeys(Keys.TAB);
    }

    @Override
    public void pressTABWithXPath(String xpath) throws Exception {
        driver.findElement(By.xpath(xpath)).sendKeys(Keys.TAB);
    }

    @Override
    public void pressENTERWithXPath(String xpath) throws Exception {
        driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
    }

    @Override
    public void pressENTERWithID(String id) throws Exception {
        driver.findElement(By.id(id)).sendKeys(Keys.ENTER);
    }

    @Override
    public void switchToDefaultContent() throws Exception {
        driver.switchTo().defaultContent();
    }

    @Override
    public void switchToFrame(String webElement) throws Exception {
        driver.switchTo().frame(webElement);
    }

    @Override
    public void switchToFrameUsingXpath(String xpath) throws Exception {
        driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
    }

    @Override
    public void switchToWindow(String windowHandle) throws Exception {
        driver.switchTo().window(windowHandle);

    }

    @Override
    public void switchToAlertAndAccept() throws Exception {

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Override
    public String switchToAlertAndGetText() throws Exception {

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
//        alert.accept();
        return alertText;
    }

    @Override
    public void waitForVisibilityOfElementUsingXpath(String xpath, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    @Override
    public void waitForVisibilityOfElementUsingId(String id, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    @Override
    public void waitForElementToBeClickableUsingId(String id, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    @Override
    public void waitForElementToBeClickableUsingXpath(String xpath, int timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    @Override
    public String takeScreenShot(String reportingPath) throws IOException, Exception {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imageName = reportingPath + "/" + Common.generateTimeStamp() + ".png";
        FileUtils.copyFile(scrFile, new File(imageName));
        return imageName;
    }

    @Override
    public void moveCursorSomewhereElse(String xpath) throws Exception {

        WebElement element = driver.findElement(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0," + element.getLocation().x + ")");
        element.click();
    }

    @Override
    public int countRowsInTableUsingClass(String tableClass) throws Exception {
        return driver.findElements(By.xpath("//table[@class='" + tableClass + "']/tbody/tr")).size();
    }

    @Override
    public void scrollDownUsingClassName(String className) throws Exception {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("document.getElementsByClassName('" + className + "')[0].scrollTop += 1000", "");
    }

}
