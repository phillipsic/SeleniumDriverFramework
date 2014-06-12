package com.comverse.common;

import java.net.InetAddress;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.comverse.css.common.PropertyHelper;

public class Selenium extends AutomationTool {
    private WebDriver driver;

    public Selenium() throws Exception {
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public String instanciateDriver(AutomationTool tool, Test test) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();

        tool.platform.setComputerName(System.getenv("computername"));
        if (tool.platform.getComputerName() == null) {
            tool.platform.setComputerName(InetAddress.getLocalHost().getHostName());
        }
        System.out.println("computerName : " + tool.platform.getComputerName());

        if (System.getProperty("selenium_browser") == null) {
            tool.platform.setBrowser(propsHelper.readInitProperties("BROWSER.type"));
        } else {
            tool.platform.setBrowser(System.getProperty("selenium_browser"));
            System.out.println("Browser surcharged by Jenkins to " + tool.platform.getBrowser());
        }

        if (System.getProperty("selenium_os") != null) {
            tool.platform.setOS(System.getProperty("selenium_os"));
            System.out.println("Browser surcharged by Jenkins to " + tool.platform.getOS());
        }

        String useGRID = propsHelper.readInitProperties("USE.GRID");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (tool.platform.getComputerName().equalsIgnoreCase(propsHelper.readInitProperties("MasterMachine.Name")) || useGRID.equalsIgnoreCase("true")) {
            String gridBrowser = propsHelper.readInitProperties("GRID.BROWSER");

            if (useGRID.equalsIgnoreCase("true")) {
                if (gridBrowser.equalsIgnoreCase("IE")) {
                    tool.platform.IE(capabilities);
                }

                if (gridBrowser.equalsIgnoreCase("FF")) {
                    tool.platform.FF(capabilities);
                }

                if (gridBrowser.equalsIgnoreCase("CH")) {
                    tool.platform.CH(capabilities);
                }

                String gridHubIP = propsHelper.readInitProperties("GRID.HUB.IP");
                String gridHubPort = propsHelper.readInitProperties("GRID.HUB.PORT");
                String gridOS = propsHelper.readInitProperties("GRID.OS");
                capabilities.setCapability("tool.platform", gridOS);
                tool.platform.setBrowser(gridBrowser);

                System.out.println("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub");
                tool.driver = new RemoteWebDriver(new URL("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub"), capabilities);

            } else {
                if (System.getProperty("selenium_browser").equalsIgnoreCase("IE")) {
                    tool.platform.IE(capabilities);
                }

                if (System.getProperty("selenium_browser").equalsIgnoreCase("FF")) {
                    tool.platform.FF(capabilities);
                }

                if (System.getProperty("selenium_browser").equalsIgnoreCase("CH")) {
                    tool.platform.CH(capabilities);
                }
                test.setDebug(false);
                String gridHubIP = "10.230.22.121";
                String gridHubPort = "4444";
                capabilities.setCapability("tool.platform", tool.platform.getOS());

                tool.driver = new RemoteWebDriver(new URL("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub"), capabilities);
            }

        } else {

            if (tool.platform.getBrowser().equalsIgnoreCase("IE")) {
                tool.platform.IE(capabilities);
                tool.driver = new InternetExplorerDriver();
            }

            if (tool.platform.getBrowser().equalsIgnoreCase("FF")) {
                FirefoxProfile profile = tool.platform.FF(capabilities);
                tool.driver = new FirefoxDriver(profile);
            }

            if (tool.platform.getBrowser().equalsIgnoreCase("CH")) {
                tool.platform.CH(capabilities);
                tool.driver = new ChromeDriver();
            }
        }
        if (tool.driver == null) {
            throw new IllegalStateException("Browser not supported. Please use IE, CH or FF");
        }

        tool.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        tool.driver.manage().window().maximize();

        return tool.platform.getBrowser();
    }

    @Override
    public void parseUserAgent(AutomationTool tool, Test test, String intBrowser) {
        String userAgent = (String) ((JavascriptExecutor) tool.driver).executeScript("return navigator.userAgent;");

        if (test.getDebug())
            System.out.println("userAgent : " + userAgent);

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
    public void clickUsingXPath(AutomationTool tool, String xpath) throws Exception {
        tool.driver.findElement(By.xpath(xpath)).click();
    }

    @Override
    public void clickUsingID(AutomationTool tool, String id) throws Exception {
        tool.driver.findElement(By.id(id)).click();
    }

    @Override
    public void clickUsingName(AutomationTool tool, String name) throws Exception {
        tool.driver.findElement(By.name(name)).click();
    }

    @Override
    public void clickUsingTagName(AutomationTool tool, String tagName) throws Exception {
        tool.driver.findElement(By.tagName(tagName)).click();
    }

    @Override
    public WebElement searchUsingTagName(AutomationTool tool, String tagName) throws Exception {
        return tool.driver.findElement(By.tagName(tagName));
    }

    @Override
    public WebElement searchUsingID(AutomationTool tool, String id) throws Exception {
        return tool.driver.findElement(By.id(id));
    }

    @Override
    public WebElement searchUsingName(AutomationTool tool, String name) throws Exception {
        return tool.driver.findElement(By.name(name));
    }

    @Override
    public void clickUsingLinkText(AutomationTool tool, String linkText) throws Exception {
        tool.driver.findElement(By.linkText(linkText)).click();
    }

    @Override
    public void clickUsingLinkPartialText(AutomationTool tool, String partialLinkText) throws Exception {
        tool.driver.findElement(By.partialLinkText(partialLinkText)).click();
    }

    @Override
    public void clickUsingCssSelector(AutomationTool tool, String cssSelector) throws Exception {
        tool.driver.findElement(By.cssSelector(cssSelector)).click();
    }

    @Override
    public void enterStringUsingId(AutomationTool tool, String id, String data) throws Exception {
        tool.driver.findElement(By.id(id)).clear();
        tool.driver.findElement(By.id(id)).sendKeys(data);
    }

    @Override
    public void enterStringUsingName(AutomationTool tool, String name, String data) throws Exception {
        tool.driver.findElement(By.name(name)).clear();
        tool.driver.findElement(By.name(name)).sendKeys(data);
    }

    @Override
    public void enterStringUsingXPath(AutomationTool tool, String xpath, String data) throws Exception {
        tool.driver.findElement(By.xpath(xpath)).clear();
        tool.driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    @Override
    public void enterStringUsingCssSelector(AutomationTool tool, String cssSelector, String data) throws Exception {
        tool.driver.findElement(By.cssSelector(cssSelector)).clear();
        tool.driver.findElement(By.cssSelector(cssSelector)).sendKeys(data);
    }

}
