package com.framework.app.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Set;

import com.framework.common.AutomationTool;
import com.framework.common.DB;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
 *
 * @author S823509
 */
public class Common {

    /**
     * This class should be used to store methods that can be used by any
     * application
     */
    public Common() {
    }

    /**
     *
     * @param value
     * @throws Exception
     */
    public static void sleepForNumberOfSeconds(long value) throws Exception {
        long numberOfSeconds = value * 1000;
        Thread.sleep(numberOfSeconds);
    }

    /**
     *
     * @param tool
     * @param searchText
     * @return
     * @throws Exception
     */
    public static Boolean isTextOnPage(AutomationTool tool, String searchText) throws Exception {
        String pageSource = tool.getPageSource();
        return pageSource.contains(searchText);
    }

    /**
     *
     * @param tool
     * @param idOfCheckBox
     * @return
     * @throws Exception
     */
    public static Boolean isCheckBoxSelected(AutomationTool tool, String idOfCheckBox) throws Exception {
        return (tool.searchUsingID(idOfCheckBox)).isSelected();
    }

    /**
     * This should be used instead of using an assert in the Test. This method
     * has a description added that will appear in the debugging information.
     *
     * @param tool
     * @param searchText
     * @throws Exception
     */
    public static void assertTextOnPage(AutomationTool tool, String searchText) throws Exception {
        String pageSource = Common.returnCleanPageSource(tool);
        assertTrue("ASSERTION FAIL: Expecting " + searchText + " in page", pageSource.contains(searchText));
    }

    /**
     *     * This should be used instead of using an assert in the Test. This
     * method has a description added that will appear in the debugging
     * information.
     *
     * @param tool
     * @param searchText
     * @throws Exception
     */
    public static void assertTextNotOnPage(AutomationTool tool, String searchText) throws Exception {
        String pageSource = Common.returnCleanPageSource(tool);
        assertFalse("ASSERTION FAIL: NOT expecting " + searchText + "in page", pageSource.contains(searchText));
    }

    /**
     * This should be used instead of using an assert in the Test. This method
     * has a description added that will appear in the debugging information.
     *
     * @param tool
     * @param verify
     * @throws Exception
     */
    public static void assertVerifyTrue(AutomationTool tool, Boolean verify) throws Exception {
        assertTrue("ASSERTION FAIL: expecting True", verify);
    }

    /**
     * This should be used instead of using an assert in the Test. This method
     * has a description added that will appear in the debugging information.
     *
     * @param tool
     * @param verify
     * @throws Exception
     */
    public static void assertVerifyFalse(AutomationTool tool, Boolean verify) throws Exception {
        assertFalse("ASSERTION FAIL: expecting False", verify);
    }

    /**
     * This should be used instead of using an assert in the Test. This method
     * has a description added that will appear in the debugging information.
     *
     * @param expectedText
     * @param actualText
     * @throws Exception
     */
    public static void assertTextEquals(Object expectedText, Object actualText) throws Exception {
        assertEquals("ASSERTION FAIL: Expecting " + expectedText + " but was " + actualText, expectedText, actualText);
    }

    /**
     *
     * @param dirtyString
     * @return
     * @throws Exception
     */
    public static String removeHTMLTags(String dirtyString) throws Exception {
        String dirtyString1 = dirtyString.replaceAll("&nbsp;", "");
        String dirtyString2 = dirtyString1.replaceAll("<![CDATA[.*?]]>", "");
        String dirtyString3 = dirtyString2.replaceAll("\\<.*?>", "");
        return dirtyString3.replaceAll("  ", " ");
    }

    /**
     *
     * @param tool
     * @return
     * @throws Exception
     */
    public static String returnCleanPageSource(AutomationTool tool) throws Exception {
        String dirtyString = tool.getPageSource();
        dirtyString = removeHTMLTags(dirtyString);
        return cleanStringOfIllegalChars(dirtyString);
    }

    /**
     *
     * @param tool
     * @param searchText
     * @return
     * @throws Exception
     */
    public static Boolean isTextOnPageWithRegex(AutomationTool tool, String searchText) throws Exception {
        String pageSource = Common.returnCleanPageSource(tool);
        return pageSource.matches("^[\\s\\S]*" + searchText + "[\\s\\S]*$");
    }

    /**
     *
     * @param tool
     * @param searchText
     * @return
     * @throws Exception
     */
    public static Boolean isTextNotOnPage(AutomationTool tool, String searchText) throws Exception {
        String pageSource = Common.returnCleanPageSource(tool);
        return !pageSource.contains(searchText);
    }

    /**
     *
     * @param dirtyString
     * @return
     * @throws Exception
     */
    public static String cleanStringOfIllegalChars(String dirtyString) throws Exception {
        String dirtyString1 = dirtyString.replaceAll("[^\\p{Print}]", "");
        String dirtyString2 = dirtyString1.replaceAll("\\p{Cntrl}", "");
        String dirtyString3 = dirtyString2.replaceAll("\'", "");
        String dirtyString4 = dirtyString3.replaceAll("\"", "");

        return dirtyString4.trim();
    }

    /**
     *
     * @param value
     * @return
     */
    public static String replaceAmpCodeWithCharacter(String value) {
        return value.replaceAll("&amp;", "&");
    }

    /**
     *
     * @param dirtyString
     * @return
     * @throws Exception
     */
    public static String cleanStringOfAllNonDigits(String dirtyString) throws Exception {
        dirtyString.replaceAll("\\pL+", "");
        String cleanString = dirtyString.trim();
        return cleanString;
    }

    /**
     * Generates a unique number that can be used in data.
     *
     * @return @throws Exception
     */
    public static String generateTimeStamp() throws Exception {
        long ts = (new java.util.Date()).getTime();
        // System.out.print("Unique string - " + String.valueOf(ts));
        return String.valueOf(ts);
    }

    private static void insertPropertyInDB(String key, String value, String comment) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        String testEnvironment = propsHelper.getENV();

        PreparedStatement statement = null;
        Connection connection = null;

        try {
            DB autotest = new DB("AUTOTEST");
            connection = autotest.mysqlDBCnx();

            statement = connection
                    .prepareStatement("INSERT INTO dynamic_test_data ( environment, property_key, property_value, property_comment, property_used  ) VALUES (?, ?, ?, ?, false)");

            statement.setString(1, testEnvironment);
            statement.setString(2, key);
            statement.setString(3, value);
            statement.setString(4, comment);
            statement.executeUpdate();
            System.out.println("1 row affected");

        } finally {
            statement.close();
            connection.close();
        }

    }

    private static void updatePropertyInDB(String key, String value, String comment) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        String testEnvironment = propsHelper.getENV();

        PreparedStatement statement = null;
        Connection connection = null;

        try {
            DB autotest = new DB("AUTOTEST");
            connection = autotest.mysqlDBCnx();

            statement = connection
                    .prepareStatement("UPDATE dynamic_test_data SET property_value = ?, property_comment = ?, property_used = false WHERE property_key = ? AND environment = ?");

            statement.setString(1, value);
            statement.setString(2, comment);
            statement.setString(3, key);
            statement.setString(4, testEnvironment);

            statement.executeUpdate();

        } finally {
            statement.close();
            connection.close();
        }
    }

    private static void deletePropertyFromDB(String key, String value) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        String testEnvironment = propsHelper.getENV();

        PreparedStatement statement = null;
        Connection connection = null;

        try {
            DB autotest = new DB("AUTOTEST");
            connection = autotest.mysqlDBCnx();

            statement = connection.prepareStatement("DELETE FROM dynamic_test_data WHERE property_value = ? AND property_key = ? AND environment = ?");
            statement.setString(1, value);
            statement.setString(2, key);
            statement.setString(3, testEnvironment);

            statement.executeUpdate();

        } finally {
            statement.close();
            connection.close();
        }
    }

    private static boolean checkPropertyExistsInDB(String key) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();

        String testEnvironment = propsHelper.getENV();

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean exist = false;
        Connection connection = null;
        DB autotest = new DB("AUTOTEST");
        connection = autotest.mysqlDBCnx();

        try {
            statement = connection.prepareStatement("SELECT COUNT(*) as MY_COUNT FROM dynamic_test_data WHERE property_key = ? AND environment = ?");

            statement.setString(1, key);
            statement.setString(2, testEnvironment);

            resultSet = statement.executeQuery();
            resultSet.next();
            int rows = resultSet.getInt("MY_COUNT");
            if (rows > 0) {
                exist = true;
            }

        } finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return exist;

    }

    private static String getPropertyValueFromDB(String key) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();

        String testEnvironment = propsHelper.getENV();

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String propertyValue;
        Connection connection = null;
        DB autotest = new DB("AUTOTEST");
        connection = autotest.mysqlDBCnx();

        try {
            statement = connection.prepareStatement("SELECT property_value FROM dynamic_test_data WHERE property_key = ? AND environment = ?");

            statement.setString(1, key);
            statement.setString(2, testEnvironment);

            resultSet = statement.executeQuery();
            resultSet.next();
            propertyValue = resultSet.getString("property_value");

            if (propertyValue == null) {
                throw new Exception("Property does not exist in DB");
            }

        } finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return propertyValue;

    }

    private static String getMatchingPropertyValueFromDB(String key, String matchString) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();

        String testEnvironment = propsHelper.getENV();

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String propertyValue;
        Connection connection = null;
        DB autotest = new DB("AUTOTEST");
        connection = autotest.mysqlDBCnx();

        try {
            statement = connection.prepareStatement("SELECT property_value FROM dynamic_test_data WHERE property_key = ? AND property_value like ? AND environment = ?");

            statement.setString(1, key);
            statement.setString(2, "%" + matchString + "%");
            statement.setString(3, testEnvironment);

            resultSet = statement.executeQuery();
            resultSet.next();
            propertyValue = resultSet.getString("property_value");

        } finally {
            resultSet.close();
            statement.close();
            connection.close();
        }

        return propertyValue;

    }

    private static void storePropertyInDB(String key, String value, String comment) throws Exception {
        if (checkPropertyExistsInDB(key)) {
            updatePropertyInDB(key, value, comment);
        } else {
            insertPropertyInDB(key, value, comment);
        }
    }

    private static void storeMultiplePropertiesInDB(String key, String value, String comment) throws Exception {

        insertPropertyInDB(key, value, comment);
    }

    /* Folowing left in as examples - code will need to be changed 

     * Retrieves a string from the database that has been previously stored.
     * @return @throws Exception
     */
    public static String getBCTLastName() throws Exception {
        return getPropertyValueFromDB("bct_lastname");
    }

    /**
     * Retrieves a string from the database that has been previously stored.
     *
     * @return @throws Exception
     */
    public static String getPersonFirstName() throws Exception {
        return "FN" + getPropertyValueFromDB("bct_login");
    }

    /**
     * Retrieves a string from the database that has been previously stored.
     *
     * @return @throws Exception
     */
    public static String getPersonLastName() throws Exception {
        return "LN" + getPropertyValueFromDB("bct_login");
    }

    /**
     * Stores information in the database that can be used by other tests. Below
     * is only an example and needs to be changed for your needs.
     *
     * @param lastName
     * @param login
     * @param Password
     * @param comment
     * @throws Exception
     */
    public static void storeLoginDetailsAndLastName(String lastName, String login, String Password, String comment) throws Exception {
        if (lastName.matches("LN[0-9]{13}")) {
            storePropertyInDB("bct_login", login, comment);
            storePropertyInDB("bct_password", Password, comment);
            storePropertyInDB("bct_lastname", lastName, comment);
        } else {
            System.out.println("\r\n**************************************");
            System.out.println("WARNING - The property postpaid_last_name does not match the pattern LN12314567890123/'" + lastName + "'");
            System.out.println("WARNING - data has not been save to the database.");
            System.out.println("**************************************");
        }
    }

    /**
     *
     * @return @throws Exception
     */
    public static String getB2CLoginName() throws Exception {
        return getPropertyValueFromDB("bct_login");
    }

    /**
     *
     * @return @throws Exception
     */
    public static String getB2CPassword() throws Exception {
        return getPropertyValueFromDB("bct_password");
    }

    /**
     *
     * @param orgName
     * @param comment
     * @throws Exception
     */
    public static void storeOrganizationName(String orgName, String comment) throws Exception {
        storePropertyInDB("SFA_BCT_Organization", orgName, comment);
    }

    /**
     *
     * @return @throws Exception
     */
    public static String getOrganizationName() throws Exception {
        String orgName = getPropertyValueFromDB("SFA_BCT_Organization");
        System.out.print("SFA_BCT_Organization  : " + orgName + "\r\n");
        return orgName;
    }

    public static String getPropertyFromIniFile(String key) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        String value = propsHelper.readPropertyFromTestIniFile(key);
        return value;
    }

    public static void storePropertyInIniFile(String key, String value, String comment) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        propsHelper.savePropertyToTestIniFile(key, value, comment);
    }

    /**
     *
     * @param tool
     * @return
     * @throws Exception
     */
    public static String getCurrentWindowHandle(AutomationTool tool) throws Exception {
        return tool.getWindowHandle();
    }

    /**
     *
     * @param tool
     * @param windowHandle
     * @throws Exception
     */
    public static void switchToThisWindow(AutomationTool tool, String windowHandle) throws Exception {
        tool.switchToWindow(windowHandle);
    }

    /**
     *
     * @param tool
     * @param windowHandleTable
     * @throws Exception
     */
    public static void switchToNewWindow(AutomationTool tool, String... windowHandleTable) throws Exception {
        Set<String> windows = tool.getWindowHandles();
        for (String window : windows) {
            for (String windowHandle : windowHandleTable) {
                if (!window.equals(windowHandle)) {
                    tool.switchToWindow(window);
                    break;
                }
            }
        }
    }

    /**
     *
     * @param host
     * @param login
     * @param password
     * @param sourceFile
     * @param targetDir
     * @throws Exception
     */
    public static void sftpFile(String host, String login, String password, String sourceFile, String targetDir) throws Exception {
        Session session = null;
        Channel channel = null;

        JSch jsch = new JSch();

        session = jsch.getSession(login, host);

        if (session == null) {
            throw new Exception("Fail to connect " + host);
        }

        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.setTimeout(30000);
        System.out.println("Connecting to " + host);
        session.connect();

        try {
            channel = session.openChannel("sftp");

            channel.connect(1000);
            ChannelSftp sftp = (ChannelSftp) channel;

            // create targetDir if it doesn't exist
            try {
                sftp.cd(targetDir);
            } catch (Exception e) {
                // ignore error "No such file"
            }
            String currentDir = sftp.pwd();
            if (!currentDir.equals(targetDir)) {
                sftp.mkdir(targetDir);
            }

            sftp.put(sourceFile, targetDir);
        } finally {
            session.disconnect();
            channel.disconnect();
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static double removeCurrencyAndConvertToDouble(String value) {
        String value1 = value.replace("$", "");
        String value2 = value1.replace(" ", "");

        double doubleValue = Double.parseDouble(value2);
        return doubleValue;
    }

    /**
     *
     * @return
     */
    public static int getCurrentDayOfMonth() {
        Calendar day = Calendar.getInstance();
        return day.get(Calendar.DAY_OF_MONTH);
    }

    /**
     *
     * @return
     */
    public static int getCurrentMonth() {
        Calendar month = Calendar.getInstance();
        return month.get(Calendar.MONTH) + 1;
    }

    /**
     *
     * @return
     */
    public static int getCurrentYear() {
        Calendar year = Calendar.getInstance();
        return year.get(Calendar.YEAR);
    }

    /**
     *
     * @return
     */
    public static String getSysdateDDMMYYYY() {
        String sysdate = Common.getCurrentDayOfMonth() + "/" + Common.getCurrentMonth() + "/" + Common.getCurrentYear();
        return sysdate;
    }

    /**
     *
     * @param howManySeconds
     * @return
     * @throws Exception
     */
    public static String formatToHHmmss(String howManySeconds) throws Exception {
        int initSeconds = Integer.parseInt(howManySeconds);
        int hours = initSeconds / 3600;
        int remainder = initSeconds % 3600;
        int minutes = remainder / 60;
        int seconds = remainder % 60;

        String time = ((hours < 10 ? "0" : "") + hours + ":" + (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds);

        return time;
    }

    /**
     *
     * @return @throws Exception
     */
    public static String getMethodName() throws Exception {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        // maybe this number needs to be corrected
        StackTraceElement e = stacktrace[2];
        return e.getMethodName();
    }

    public static void assertCorrectPageTitle(AutomationTool tool, String expectedScreen) throws Exception {
        String currentScreen = tool.getTitle();
        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }
}
