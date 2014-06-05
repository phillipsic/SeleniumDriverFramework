package com.comverse.common;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.Prep;
import com.comverse.css.common.PropertyHelper;
import com.comverse.sec.ComverseOneSingleSignOn;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.junit.After;
import static org.junit.Assert.fail;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Main {

    private StringBuffer verificationErrors = new StringBuffer();
    public WebDriver driver;
    public Test test;
    public Application application;
    public Prep preparation;
    public Platform platform;
    public User user;
    public Boolean debug;
    public static String path = System.getProperty("user.dir");
    public static final String INIT_LOCATION = path + "/src/main/resources/";
    public static final String INIT_PROPERTY_FILE = "init.properties";
    public static final String ACCOUNTS_PROPERTY_FILE = "Accounts.properties";
    public static final String BCT_PROPERTY_FILE = "bctinit.properties";
    public static final String PASSWORD_PROPERTY_FILE = "Passwords.properties";
    public static final String DB_PROPERTY_FILE = "DB.properties";
    public static final String SQL_INVOICE_PROPERTY_FILE = "SQL_invoice.properties";

    public String instanciateDriver() throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        test = new Test();
        platform = new Platform();
        user = new User();
        platform.setComputerName(System.getenv("computername"));
        //platform.setComputerName("IPLINUX");
        
         System.out.println("PATH  : " + path);

        if (platform.getComputerName() == null) {
            platform.setComputerName(InetAddress.getLocalHost().getHostName());
        }
        System.out.println("computerName : " + platform.getComputerName());

        debug = Boolean.valueOf(propsHelper.readInitProperties("DEBUG"));
        System.out.println("DEBUG = " + debug);

        if (System.getProperty("selenium_browser") == null) {
            platform.setBrowser(propsHelper.readInitProperties("BROWSER.type"));
        } else {
            platform.setBrowser(System.getProperty("selenium_browser"));
            System.out.println("Browser loaded by Jenkins to " + platform.getBrowser());
        }

        if (System.getProperty("selenium_os") != null) {
            platform.setOS(System.getProperty("selenium_os"));
            System.out.println("Browser surcharged by Jenkins to " + platform.getOS());
        }

        String useGRID = propsHelper.readInitProperties("USE.GRID");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (platform.getComputerName().equalsIgnoreCase(propsHelper.readInitProperties("MasterMachine.Name")) || useGRID.equalsIgnoreCase("true")) {
            String gridBrowser = propsHelper.readInitProperties("GRID.BROWSER");

            if (useGRID.equalsIgnoreCase("true")) {
                if (gridBrowser.equalsIgnoreCase("IE")) {
                    platform.IE(capabilities);
                }

                if (gridBrowser.equalsIgnoreCase("FF")) {
                    platform.FF(capabilities);
                }

                if (gridBrowser.equalsIgnoreCase("CH")) {
                    platform.CH(capabilities);
                }

                String gridHubIP = propsHelper.readInitProperties("GRID.HUB.IP");
                String gridHubPort = propsHelper.readInitProperties("GRID.HUB.PORT");
                String gridOS = propsHelper.readInitProperties("GRID.OS");
                capabilities.setCapability("platform", gridOS);
                platform.setBrowser(gridBrowser);

                System.out.println("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub");
                driver = new RemoteWebDriver(new URL("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub"), capabilities);

            } else {
                
                System.out.println(System.getProperty("selenium_browser"));
                if (System.getProperty("selenium_browser").equalsIgnoreCase("IE")) {
                    platform.IE(capabilities);
                }

                if (System.getProperty("selenium_browser").equalsIgnoreCase("FF")) {
                    platform.FF(capabilities);
                }

                if (System.getProperty("selenium_browser").equalsIgnoreCase("CH")) {
                    platform.CH(capabilities);
                }
                debug = false;
                String gridHubIP = "10.230.22.121";
                String gridHubPort = "4444";
                capabilities.setCapability("platform", platform.getOS());

                driver = new RemoteWebDriver(new URL("http://" + gridHubIP + ":" + gridHubPort + "/wd/hub"), capabilities);
            }

        } else {

            if (platform.getBrowser().equalsIgnoreCase("IE")) {
                platform.IE(capabilities);
                driver = new InternetExplorerDriver();
            }

            if (platform.getBrowser().equalsIgnoreCase("FF")) {
                FirefoxProfile profile = platform.FF(capabilities);
                driver = new FirefoxDriver(profile);
            }

            if (platform.getBrowser().equalsIgnoreCase("CH")) {
                platform.CH(capabilities);
                driver = new ChromeDriver();
            }
        }
        if (driver == null) {
            throw new IllegalStateException("Browser not supported. Please use IE, CH or FF");
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return platform.getBrowser();
    }

    public void parseUserAgent(String intBrowser) {
        String userAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");

        if (debug) {
            System.out.println("userAgent : " + userAgent);
        }

        if (intBrowser.equalsIgnoreCase("IE")) {
            String delimiter = ";";
            String[] temp = userAgent.split(delimiter);
            platform.setBrowserFullNameAndVersion(temp[1].trim());
            platform.setOSFullNameAndVersion(temp[2].trim());
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
            platform.setBrowserFullNameAndVersion(temp3[3].trim());
            platform.setOSFullNameAndVersion(temp2[0].trim());
        }

        if (intBrowser.equalsIgnoreCase("CH")) {
            String[] temp1 = userAgent.split("\\(");
            String[] temp2 = temp1[1].split("\\)");
            String[] temp3 = temp1[2].split(" ");
            platform.setBrowserFullNameAndVersion(temp3[3].substring(0, 11).trim());
            platform.setOSFullNameAndVersion(temp2[0].trim());
        }

        if (debug) {
            System.out.println("UserAgent => Browser : " + platform.getBrowserFullNameAndVersion());
            System.out.println("UserAgent => OS : " + platform.getOSFullNameAndVersion());
        }
    }

    public boolean checkForBadData() {
        boolean badData = false;

        if (application.getVersion() == null || application.getName() == null || test.getName() == null || test.getResult() == null
                || platform.getBrowserFullNameAndVersion() == null) {
            badData = true;
        }

        if (application.getName().equals("null") || application.getName().equals("")) {
            badData = true;
        }

        if (application.getVersion().equals("null") || application.getVersion().equals("Unavailable") || application.getVersion().equals("")
                || application.getVersion().equals("Temporarily Unavailable")) {
            badData = true;
        }

        if (test.getName().equals("null") || test.getName().equals("")) {
            badData = true;
        }

        if (test.getResult().equals("null") || test.getResult().equals("")) {
            badData = true;
        }

        if (platform.getBrowserFullNameAndVersion().equals("null") || platform.getBrowserFullNameAndVersion().equals("")) {
            badData = true;
        }

        return badData;
    }

    public void checkForPassAndAbort(String test_id) throws Exception {

        String domainCode = test_id.substring(0, 3);
        System.out.println("Domain Code = " + domainCode);

        if (domainCode.equals("BCT") == false) {
            DB cust = new DB("AUTOTEST");
            Statement st = cust.mysqlDBcnx();
            if (st != null) {
                if (debug) {
                    System.out.println("Connected to the database");
                }
            } else {
                System.out.println("Connection to the database FAILED");
            }

            String sql = "select count(*) as passcount from test_results" + " where test_id = '" + test_id + "'" + " and version = '" + application.getVersion() + "'"
                    + " and application = '" + application.getName() + "'" + " and test_result ='pass' and browser ='" + platform.getBrowserFullNameAndVersion() + "' and OS = '"
                    + platform.getOSFullNameAndVersion() + "'";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                System.out.println("Number of Passes = " + result.getString("passcount"));
                int iPassCount = Integer.parseInt(result.getString("passcount"));
                if (iPassCount > 0) {
                    System.out.println("Test " + test_id + " already PASSED on build " + application.getVersion() + " RUN ABORTED");
                    throw new AlreadyRunException();
                }
            }

            if (debug) {
                System.out.println("Disconnected from database");
            }

        }
    }

    // public void launchHealthCheckApplication() throws Exception {
    // Platform platform = new Platform();
    // PropertyHelper propsHelper = new PropertyHelper();
    // DesiredCapabilities capabilities = new DesiredCapabilities();
    // String intBrowser = System.getProperty("selenium_browser");
    //
    // if (intBrowser == null) {
    // intBrowser = propsHelper.getInitProperties("BROWSER.type");
    // }
    //
    // if (intBrowser.equalsIgnoreCase("IE")) {
    // driver = new InternetExplorerDriver();
    // }
    //
    // if (intBrowser.equalsIgnoreCase("FF")) {
    // driver = new FirefoxDriver();
    // }
    //
    // if (intBrowser.equalsIgnoreCase("CH")) {
    // platform.CH(capabilities);
    // driver = new ChromeDriver();
    // }
    //
    // if (driver == null) {
    // throw new
    // IllegalStateException("Browser not supported. Please use IE, FF or CH");
    // }
    //
    // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //
    // sapiUrl = propsHelper.getInitProperties("sapi_url");
    // System.out.println("baseUrl:" + sapiUrl);
    //
    // String userAgent = (String) ((JavascriptExecutor)
    // driver).executeScript("return navigator.userAgent;");
    //
    // if (intBrowser.equalsIgnoreCase("IE")) {
    // String delimiter = ";";
    // String[] temp = userAgent.split(delimiter);
    // browser = temp[1];
    // OS = temp[2];
    // }
    //
    // if (intBrowser.equalsIgnoreCase("FF")) {
    // String[] temp1 = userAgent.split("\\(");
    // String[] temp2 = temp1[1].split(";");
    // String[] temp3 = temp2[1].split(" ");
    // browser = temp3[3];
    // OS = temp2[0];
    // }
    //
    // if (intBrowser.equalsIgnoreCase("CH")) {
    // String[] temp1 = userAgent.split("\\(");
    // String[] temp2 = temp1[1].split("\\)");
    // String[] temp3 = temp1[2].split(" ");
    // browser = temp3[3];
    // OS = temp2[0];
    // }
    //
    // System.out.println("OS : " + OS);
    // System.out.println("Browser : " + browser);
    //
    // }
    public void loginSSOUser() throws Exception {
        ComverseOneSingleSignOn ssoLoginPage = new ComverseOneSingleSignOn(driver);
        ssoLoginPage.setUserName(user);
        ssoLoginPage.setPassword(user);
        ssoLoginPage.setRealm(user);
        ssoLoginPage.clickLogin();
    }

    @SuppressWarnings("resource")
    public void logResults(String mode) {
        try {
            DB cust = new DB("AUTOTEST");
            Statement st = cust.mysqlDBcnx();

            if (debug) {
                System.out.println("Connected to the database");
            }
            try {
                String sql = "select count(*) as rowcount from test_results where test_id = '" + test.getName() + "'" + " and version = '" + application.getVersion() + "'"
                        + " and application = '" + application.getName() + "'" + " and  browser ='" + platform.getBrowserFullNameAndVersion() + "' and OS = '"
                        + platform.getOSFullNameAndVersion() + "'";

                if (debug) {
                    System.out.println(sql);
                }
                ResultSet SQLResult = st.executeQuery(sql);
                if (debug) {
                    System.out.println("SQL 1 executed");
                }

                while (SQLResult.next()) {
                    if (debug) {
                        System.out.println("Number of rows = " + SQLResult.getString("rowcount"));
                    }
                    int iRowCount = Integer.parseInt(SQLResult.getString("rowcount"));
                    if (iRowCount == 1) {
                        sql = "select * from csspqa.test_results where test_id = '" + test.getName() + "'" + " and version = '" + application.getVersion() + "'"
                                + " and application = '" + application.getName() + "'" + " and  browser ='" + platform.getBrowserFullNameAndVersion() + "' and OS = '"
                                + platform.getOSFullNameAndVersion() + "'";

                        if (debug) {
                            System.out.println(sql);
                        }
                        SQLResult = st.executeQuery(sql);
                        if (debug) {
                            System.out.println("SQL 2 executed");
                        }
                        SQLResult.next();

                        String storedResult = SQLResult.getString("test_result");
                        if (debug) {
                            System.out.println("[INFO] storedResult = " + storedResult);
                            System.out.println("[INFO] bugId = " + test.getBugId());
                        }

                        if (storedResult.equals("fail") && !test.getBugId().equals("NoBug")) {
                            sql = "UPDATE csspqa.test_results SET bug_id ='" + test.getBugId() + "',  ip = '" + platform.getComputerName() + "' WHERE test_id = '" + test.getName()
                                    + "'" + " and version = '" + application.getVersion() + "'" + " and application = '" + application.getName() + "'" + " and  browser ='"
                                    + platform.getBrowserFullNameAndVersion() + "' and OS = '" + platform.getOSFullNameAndVersion() + "'";

                            if (debug) {
                                System.out.println(sql);
                            }
                            st.executeUpdate(sql);
                            if (debug) {
                                System.out.println("SQL 3 executed");
                                System.out.println("[INFO] Update BugId to " + test.getBugId());
                            }
                        }

                        if (test.getResult().equals("pass") && storedResult.equals("fail")) {
                            sql = "UPDATE csspqa.test_results SET test_result = 'pass', time_stamp = NOW(), bug_id = 'NoBug', ip = '" + platform.getComputerName()
                                    + "'   WHERE test_id = '" + test.getName() + "'" + " and version = '" + application.getVersion() + "'" + " and application = '"
                                    + application.getName() + "'" + " and  browser ='" + platform.getBrowserFullNameAndVersion() + "' and OS = '"
                                    + platform.getOSFullNameAndVersion() + "'";

                            if (debug) {
                                System.out.println(sql);
                            }
                            st.executeUpdate(sql);
                            if (debug) {
                                System.out.println("SQL 4 executed");
                                System.out.println("[INFO] Update result to pass");
                            }
                        }

                    } else if (iRowCount > 1) {
                        System.out.println("More than one row found - issue updating, please check manually.");

                    } else if (iRowCount == 0) {
                        sql = "INSERT INTO csspqa.test_results ( bug_id, ip , version , application , test_id , time_stamp , test_result, tag, browser, OS )VALUES (" + "'"
                                + test.getBugId() + "','" + platform.getComputerName() + "','" + application.getVersion() + "','" + application.getName() + "','" + test.getName()
                                + "', NOW(),'" + test.getResult() + "','" + mode + "','" + platform.getBrowserFullNameAndVersion() + "', '" + platform.getOSFullNameAndVersion()
                                + "')";

                        if (debug) {
                            System.out.println(sql);
                        }
                        Statement st2 = cust.mysqlDBcnx();
                        st2.executeUpdate(sql);
                        if (debug) {
                            System.out.println("SQL 5 executed");
                            System.out.println("Test has been logged as a [" + test.getResult() + "]");
                            System.out.println("Bug ID logged  [" + test.getBugId() + "]");
                        }
                    }
                }
                SQLResult.close();
            } catch (SQLException s) {
                System.err.println(s);
                System.err.println("SQL statement is not executed!");
            }

            if (debug) {
                System.out.println("Disconnected from database");
            }

        } catch (Exception e) {
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
        test.setName(this.getClass().getSimpleName());

        System.out.println("Browser : " + platform.getBrowserFullNameAndVersion());
        System.out.println("OS : " + platform.getOSFullNameAndVersion());
        System.out.println("Version : " + application.getVersion());
        System.out.println("Application : " + application.getName());
        System.out.println("Test ID : " + test.getName());
        System.out.println("Result : " + test.getResult());

        if (this.checkForBadData() == false) {
            this.logResults("CV");
        } else {
            System.out.println("WARNING - Bad data detected and result not saved to DB");
        }

    }
}
