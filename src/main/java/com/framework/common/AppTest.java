package com.framework.common;

import com.company.mercurytours.app.Google;
import com.framework.common.Application;
import com.framework.common.DB;
import com.framework.common.Platform;
import com.framework.common.Selenium;
import com.framework.common.Main;
import com.framework.common.User;
import com.framework.common.TestDetails;
import com.relevantcodes.extentreports.ExtentTest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Before;

public class AppTest extends Main {

    @Before
    public void setUp() throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        tool = new Selenium();
        test = new TestDetails();
        test.setName(this.getClass().getSimpleName());
        test.setDebug(Boolean.valueOf(propsHelper.readInitProperties("DEBUG")));
        test.setDBReporting(Boolean.valueOf(propsHelper.readInitProperties("DB_REPORTING")));
        System.out.println("DEBUG = " + test.getDebug());
        test.setLOG_FILE();
        test.startResultLogger();
        tool.platform = new Platform();
        user = new User();
        tool.parseUserAgent(tool, test, tool.instanciateDriver(tool, test));
       
    }

    public void launchMainApplication() throws Exception {
        application.setVersion(tool, test);
        tool.get(application.appURL());
        test.writeInLogFile("INFO", "Browser: " + tool.platform.getBrowserFullNameAndVersion() + ", OS: " + tool.platform.getOSFullNameAndVersion());
        test.writeInLogFile("INFO", "Application: " + application.getCommonName() + " " + application.appURL());

        if (!test.getDebug() && test.getDBReporting()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchAnotherApplication(Application otherApplication) throws Exception {

        tool.get(otherApplication.appFullURL());
        Thread.sleep(4000);
    }

    public void logIterationResultInDB(String iteration) {

        test.setResult("pass");
        test.setName(this.getClass().getSimpleName() + "Iteration_" + iteration);
        this.logResultsInDB("");
    }

    @SuppressWarnings("resource")
    public void logResultsInDB(String message) {

        if (test.getDBReporting()) {
            try {

                DB cust = new DB("AUTOTEST");
                Statement st = cust.mysqlDBStatement();
                if (test.getDebug()) {
                    System.out.println("Connected to the database");
                }
                try {
                    String sql = "select count(*) as rowcount from test_results where test_id = '" + test.getName() + "'" + " and version = '" + application.getVersion() + "'"
                            + " and application = '" + application.getName() + "'" + " and  browser ='" + tool.platform.getBrowserFullNameAndVersion() + "' and OS = '"
                            + tool.platform.getOSFullNameAndVersion() + "'";

                    if (test.getDebug()) {
                        System.out.println(sql);
                    }
                    ResultSet SQLResult = st.executeQuery(sql);
                    if (test.getDebug()) {
                        System.out.println("SQL 1 executed");
                    }

                    if (message != null) {
                        message = Common.cleanStringOfIllegalChars(message);
                    }
                    while (SQLResult.next()) {
                        if (test.getDebug()) {
                            System.out.println("Number of rows = " + SQLResult.getString("rowcount"));
                        }
                        int iRowCount = Integer.parseInt(SQLResult.getString("rowcount"));
                        if (iRowCount == 1) {
                            sql = "select * from autotest.test_results where test_id = '" + test.getName() + "'" + " and version = '" + application.getVersion() + "'"
                                    + " and application = '" + application.getName() + "'" + " and  browser ='" + tool.platform.getBrowserFullNameAndVersion() + "' and OS = '"
                                    + tool.platform.getOSFullNameAndVersion() + "'";

                            if (test.getDebug()) {
                                System.out.println(sql);
                            }
                            SQLResult = st.executeQuery(sql);
                            if (test.getDebug()) {
                                System.out.println("SQL 2 executed");
                            }
                            SQLResult.next();

                            String storedResult = SQLResult.getString("test_result");
                            if (test.getDebug()) {
                                System.out.println("[INFO] storedResult = " + storedResult);
                                System.out.println("[INFO] bugId = " + test.getBugId());
                            }

                            if (storedResult.equals("fail")) {
                                sql = "UPDATE autotest.test_results SET bug_id ='" + test.getBugId() + "',  ip = '" + tool.platform.getComputerName() + "', fail_message = '"
                                        + message + "', time_stamp = NOW() WHERE test_id = '" + test.getName() + "'" + " and version = '" + application.getVersion() + "'"
                                        + " and application = '" + application.getName() + "'" + " and  browser ='" + tool.platform.getBrowserFullNameAndVersion() + "' and OS = '"
                                        + tool.platform.getOSFullNameAndVersion() + "'";

                                if (test.getDebug()) {
                                    System.out.println(sql);
                                }
                                Statement st2 = cust.mysqlDBStatement();
                                st2.executeUpdate(sql);
                                if (test.getDebug()) {
                                    System.out.println("SQL 3 executed");
                                    System.out.println("[INFO] Update BugId to " + test.getBugId());
                                }
                            }

                            if (test.getResult().equals("pass") && storedResult.equals("fail")) {
                                sql = "UPDATE autotest.test_results SET test_result = 'pass', time_stamp = NOW(), bug_id = 'NoBug', ip = '" + tool.platform.getComputerName()
                                        + "'   WHERE test_id = '" + test.getName() + "'" + " and version = '" + application.getVersion() + "'" + " and application = '"
                                        + application.getName() + "'" + " and  browser ='" + tool.platform.getBrowserFullNameAndVersion() + "' and OS = '"
                                        + tool.platform.getOSFullNameAndVersion() + "'";

                                if (test.getDebug()) {
                                    System.out.println(sql);
                                }
                                Statement st2 = cust.mysqlDBStatement();
                                st2.executeUpdate(sql);
                                if (test.getDebug()) {
                                    System.out.println("SQL 4 executed");
                                    System.out.println("[INFO] Update result to pass");
                                }
                            }

                        } else if (iRowCount > 1) {
                            System.out.println("More than one row found - issue updating, please check manually.");

                        } else if (iRowCount == 0) {
                            sql = "INSERT INTO autotest.test_results ( bug_id, ip , version , application , test_id , time_stamp , test_result, browser, OS, fail_message )VALUES ("
                                    + "'"
                                    + test.getBugId()
                                    + "','"
                                    + tool.platform.getComputerName()
                                    + "','"
                                    + application.getVersion()
                                    + "','"
                                    + application.getName()
                                    + "','"
                                    + test.getName()
                                    + "', NOW(),'"
                                    + test.getResult()
                                    + "','"
                                    + tool.platform.getBrowserFullNameAndVersion()
                                    + "', '"
                                    + tool.platform.getOSFullNameAndVersion() + "', '" + message + "')";

                            if (test.getDebug()) {
                                System.out.println(sql);
                            }
                            Statement st2 = cust.mysqlDBStatement();
                            st2.executeUpdate(sql);
                            if (test.getDebug()) {
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

                if (test.getDebug()) {
                    System.out.println("Disconnected from database");
                }
            } catch (Exception e) {
            }
        } else {
            System.out.println("No database installed so result not stored.");
            System.out.println("DB_REPORTING=false in INIT.PROPERTIES file");

        }

    }
}
