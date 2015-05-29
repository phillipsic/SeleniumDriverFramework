package com.framework.common;

import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.framework.app.common.Common;
import com.framework.app.common.Prep;

public class Main {

    private StringBuffer verificationErrors = new StringBuffer();
    public TestDetails test;
    public Application application;
    public Prep preparation;
    public Platform platform;
    public User user;
    public AutomationTool tool;

    public static final String INIT_LOCATION = System.getProperty("user.dir") + "/src/main/resources/";
    public static final String INIT_PROPERTY_FILE = "init.properties";
    public static final String ACCOUNTS_PROPERTY_FILE = "Accounts.properties";
    public static final String TEST_PROPERTY_FILE = "testinit.properties";
    public static final String PASSWORD_PROPERTY_FILE = "Passwords.properties";
    public static final String DB_PROPERTY_FILE = "DB.properties";
    public static final String SQL_INVOICE_PROPERTY_FILE = "SQL_invoice.properties";
    public static final String SQL_PREP_PROPERTY_FILE = "SQL_Prep.properties";
    public static final String EMAIL_PROPERTY_FILE = "Email.properties";

    public class LogResults extends TestWatcher {

        @Override
        protected void failed(Throwable e, Description description) {

            String[] line = e.getMessage().split("\n");
            test.setMessage(line[0]);
            try {
                test.writeInLogFile("ERRO", "########## " + test.getMessage() + " ##########");
                test.closeLogFile();
                if (test.getDBReporting()) {
                    this.checkForBadData();
                    this.logResultsInDB(test.getMessage());
                }
            } catch (Exception e1) {
            }
        }

        @Override
        protected void succeeded(Description description) {
            try {
                test.closeLogFile();
                if (test.getDBReporting()) {
                    this.checkForBadData();
                    this.logResultsInDB(test.getMessage());
                }
            } catch (Exception e1) {
            }
        }

        public void checkForBadData() throws Exception {
            if (application.getName() == null || application.getName().equals("null") || application.getName().equals("")) {
                test.writeInLogFile("ERRO", "Application name missing and result not saved to DB");
                throw new Exception("WARNING - Application name missing and result not saved to DB");
            }
            if (application.getVersion() == null || application.getVersion().equals("null") || application.getVersion().equals("Unavailable")
                    || application.getVersion().equals("") || application.getVersion().equals("Temporarily Unavailable")) {
                test.writeInLogFile("ERRO", "Application version missing and result not saved to DB");
                throw new Exception("WARNING - Application version missing and result not saved to DB");
            }
            if (test.getName() == null || test.getName().equals("null") || test.getName().equals("")) {
                test.writeInLogFile("ERRO", "Test name missing and result not saved to DB");
                throw new Exception("WARNING - Test name missing and result not saved to DB");
            }
            if (test.getResult() == null || test.getResult().equals("null") || test.getResult().equals("")) {
                test.writeInLogFile("ERRO", "Result missing and result not saved to DB");
                throw new Exception("WARNING - Result missing and result not saved to DB");
            }
            if (tool.platform.getBrowserFullNameAndVersion() == null || tool.platform.getBrowserFullNameAndVersion().equals("null")
                    || tool.platform.getBrowserFullNameAndVersion().equals("")) {
                test.writeInLogFile("ERRO", "Browser version missing and result not saved to DB");
                throw new Exception("WARNING - Browser version missing and result not saved to DB");
            }

        }

        @SuppressWarnings("resource")
        public void logResultsInDB(String message) {
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
        }
    }

    @Rule
    public LogResults ruleExample = new LogResults();

    public void checkForPassAndAbort(String test_id) throws Exception {

        String domainCode = test_id.substring(0, 3);
        System.out.println("Domain Code = " + domainCode);

        if (domainCode.equals("BCT") == false) {
            DB autotest = new DB("AUTOTEST");
            Statement st = autotest.mysqlDBStatement();
            if (st != null) {
                if (test.getDebug()) {
                    System.out.println("Connected to the database");
                }
            } else {
                System.out.println("Connection to the database FAILED");
            }

            String sql = "select count(*) as passcount from test_results" + " where test_id = '" + test_id + "'" + " and version = '" + application.getVersion() + "'"
                    + " and application = '" + application.getName() + "'" + " and test_result ='pass' and browser ='" + tool.platform.getBrowserFullNameAndVersion()
                    + "' and OS = '" + tool.platform.getOSFullNameAndVersion() + "'";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                System.out.println("Number of Passes = " + result.getString("passcount"));
                int iPassCount = Integer.parseInt(result.getString("passcount"));
                if (iPassCount > 0) {
                    System.out.println("Test " + test_id + " already PASSED on build " + application.getVersion() + " RUN ABORTED");
                    throw new AlreadyRunException();
                }
            }

            if (test.getDebug()) {
                System.out.println("Disconnected from database");
            }

        }
    }

    @After
    public void tearDown() throws Exception {
        tool.quit();
        test.writeInLogFile("Test Result: " + test.getResult());

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }

        System.out.println("Browser : " + tool.platform.getBrowserFullNameAndVersion());
        System.out.println("OS : " + tool.platform.getOSFullNameAndVersion());
        System.out.println("Version : " + application.getVersion());
        System.out.println("Application : " + application.getName());
        System.out.println("Test ID : " + test.getName());
        System.out.println("Bug ID : " + test.getBugId());
        System.out.println("Result : " + test.getResult());
    }

}
