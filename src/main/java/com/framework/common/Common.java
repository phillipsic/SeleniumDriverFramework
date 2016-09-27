package com.framework.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Set;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author S823509
 */
public class Common {

    /**
     * This class should be used to store methods that can be used by any
     * application
     */
    PropertyHelper propsHelper = new PropertyHelper();

    public Common() {
    }

    /**
     * Puts the test to sleep for a number of seconds.
     *
     * @param value Number of seconds for test to sleep
     * @throws Exception
     */
    public static void sleepForNumberOfSeconds(long value) throws Exception {
        long numberOfSeconds = value * 1000;
        Thread.sleep(numberOfSeconds);
    }

    /**
     * Method checks if a string is found on a page.
     *
     * @param tool Automation object
     * @param searchText text to be find in a page
     * @return TRUE or FALSE
     * @throws Exception
     */
    public static Boolean isTextOnPage(AutomationTool tool, String searchText) throws Exception {
        String pageSource = tool.getPageSource();
        return pageSource.contains(searchText);
    }

    /**
     * Method used to find out if a checkbox is selected or not
     *
     * @param tool Automation object
     * @param idOfCheckBox id of the checkbox to be checked
     * @return TRUE or FALSE
     * @throws Exception
     */
    public static Boolean isCheckBoxSelected(AutomationTool tool, String idOfCheckBox) throws Exception {
        return (tool.searchUsingID(idOfCheckBox)).isSelected();
    }

    /**
     * This should be used instead of using an assert in the Test. This method
     * has a description added that will appear in the debugging information.
     *
     * @param tool Automation object
     * @param searchText text to search in page
     * @throws Exception
     */
    /**
     * Cleans a string. Removes CDATA tags, double spaces, and &nbsp.
     *
     * @param dirtyString String that needs to be cleaned
     * @return clean string
     * @throws Exception
     */
    public static String removeHTMLTags(String dirtyString) throws Exception {
        String dirtyString1 = dirtyString.replaceAll("&nbsp;", "");
        String dirtyString2 = dirtyString1.replaceAll("<![CDATA[.*?]]>", "");
        String dirtyString3 = dirtyString2.replaceAll("\\<.*?>", "");
        return dirtyString3.replaceAll("  ", " ");
    }

    /**
     * Returns a cleaned page source. Removes htlm tags and illegal chars
     *
     * @param tool Automation object
     * @return clean page source
     * @throws Exception
     */
    public static String returnCleanPageSource(AutomationTool tool) throws Exception {
        String dirtyString = tool.getPageSource();
        dirtyString = removeHTMLTags(dirtyString);
        return cleanStringOfIllegalChars(dirtyString);
    }

    /**
     * Will take a string with regex imbeded to find the string in the page,
     * after the page has been cleaned
     *
     * @param tool Automation object
     * @param searchText Text containing a regular expression to be found on the
     * page
     * @return
     * @throws Exception
     */
    public static Boolean isTextOnPageWithRegex(AutomationTool tool, String searchText) throws Exception {
        String pageSource = Common.returnCleanPageSource(tool);
        return pageSource.matches("^[\\s\\S]*" + searchText + "[\\s\\S]*$");
    }

    /**
     * Method will check to see if the string is contained in a clean page
     * source
     *
     * @param tool Automation object
     * @param searchText Text that should not be found on the page.
     * @return
     * @throws Exception
     */
    public static Boolean isTextNotOnPage(AutomationTool tool, String searchText) throws Exception {
        String pageSource = Common.returnCleanPageSource(tool);
        return !pageSource.contains(searchText);
    }

    /**
     * Cleans a sting of unprintable characters
     *
     * @param dirtyString String to be cleaned.
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
     * Replaces the code &amp; with &
     *
     * @param value String to be searched for &amp and replaced with &
     * @return
     */
    public static String replaceAmpCodeWithCharacter(String value) {
        return value.replaceAll("&amp;", "&");
    }

    /**
     * Removes all non digit characters from a string
     *
     * @param dirtyString STring to be cleaned of Non digits
     * @return
     * @throws Exception
     */
    public static String cleanStringOfAllNonDigits(String dirtyString) throws Exception {
        dirtyString.replaceAll("\\pL+", "");
        String cleanString = dirtyString.trim();
        return cleanString;
    }

    /**
     * Generates a unique number based on a timestamp that can be used in data.
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

//    private static String getMatchingPropertyValueFromDB(String key, String matchString) throws Exception {
//
//        PropertyHelper propsHelper = new PropertyHelper();
//
//        String testEnvironment = propsHelper.getENV();
//
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        String propertyValue;
//        Connection connection = null;
//        DB autotest = new DB("AUTOTEST");
//        connection = autotest.mysqlDBCnx();
//
//        try {
//            statement = connection.prepareStatement("SELECT property_value FROM dynamic_test_data WHERE property_key = ? AND property_value like ? AND environment = ?");
//
//            statement.setString(1, key);
//            statement.setString(2, "%" + matchString + "%");
//            statement.setString(3, testEnvironment);
//
//            resultSet = statement.executeQuery();
//            resultSet.next();
//            propertyValue = resultSet.getString("property_value");
//
//        } finally {
//            resultSet.close();
//            statement.close();
//            connection.close();
//        }
//
//        return propertyValue;
//
//    }

    /**
     * Stores a property based on the key. If the key already exists then it
     * will update. If it does not exist then it will insert.
     *
     *
     * @param key key of the property
     * @param value value of the property
     * @param comment any comment to go with the key value pair.
     * @throws java.lang.Exception
     */
    public static void storePropertyInDB(String key, String value, String comment) throws Exception {
        if (checkPropertyExistsInDB(key)) {
            updatePropertyInDB(key, value, comment);
        } else {
            insertPropertyInDB(key, value, comment);
        }
    }

    public static void storeProperty(String key, String value, String comment) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();

        if (propsHelper.readInitProperties("DB_REPORTING").equalsIgnoreCase("true")) {
            storePropertyInDB(key, value, comment);
        } else {
            storePropertyInIniFile(key, value, comment);
        }

    }

    /**
     * Will store multiple copies of a particular property based on the key,
     * rather than update it will always insert. This should be used for
     * key-values that can only be used once and then should be removed/deleted
     * from the DB using getDisposablePropertyFromDatabase()
     *
     *
     * @param key key of the property
     * @param value value of the property
     * @param comment any comment to go with the key value pair.
     * @throws java.lang.Exception
     */
    public static void storeMultiplePropertiesInDB(String key, String value, String comment) throws Exception {

        insertPropertyInDB(key, value, comment);
    }

    /**
     * This method should be used when you want the property removed after it is
     * read from the database. Some data can only be used once. This should be
     * used in conjunction with the storeMultiplePropertiesInDB() method.
     *
     * @param key key to find corresponding value in database. Will then be
     * removed from the DB.
     * @return @throws Exception
     */
    public static String getDisposablePropertyFromDatabase(String key) throws Exception {

        String propertyValue = getPropertyValueFromDB(key);
        deletePropertyFromDB(key, propertyValue);
        return propertyValue;
    }

    /**
     * Returns the value of the key-value property from the database. The
     * property is left in the database after the read. Should be used for
     * properties that can be reused.
     *
     * @param key to find corresponding value in database
     * @return @throws Exception
     */
    public static String getPropertyFromDatabase(String key) throws Exception {
        return getPropertyValueFromDB(key);
    }

    public static String getStoredProperty(String key) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();

        String propertyValue = "";

        if (propsHelper.readInitProperties("DB_REPORTING").equalsIgnoreCase("true")) {
            propertyValue = getPropertyFromDatabase(key);

        } else {
            propertyValue = getPropertyFromIniFile(key);
        }
        return propertyValue;

    }

    /**
     * Returns the value of a property that has been previously stored in a
     * local property file. The property file can be found in the root of the
     * project directory.
     *
     * @param key to find corresponding vavlue in ini file
     * @return
     * @throws Exception
     */
    private static String getPropertyFromIniFile(String key) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        String value = propsHelper.readPropertyFromTestIniFile(key);
        return value;
    }

    /**
     * Stores a property in a local property file under the section [main] The
     * property file can be found in the root of the project directory.
     *
     * @param key key/value pair to be stored in ini file
     * @param value key/value pair to be stored in ini file
     * @param comment users comment to go with the key/value pair
     * @throws Exception
     */
    private static void storePropertyInIniFile(String key, String value, String comment) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        propsHelper.savePropertyToTestIniFile(key, value, comment);
    }

    /**
     * Returns the handle of the window that currently has focus.
     *
     * @param tool Automation object
     * @return returns the handle of the current window
     * @throws Exception
     */
    public static String getCurrentWindowHandle(AutomationTool tool) throws Exception {
        return tool.getWindowHandle();
    }

    /**
     * Use this method to switch to a window when you already have the handle
     *
     * @param tool Automation object
     * @param windowHandle handle of the window to switch to.
     * @throws Exception
     */
    public static void switchToThisWindow(AutomationTool tool, String windowHandle) throws Exception {
        tool.switchToWindow(windowHandle);
    }

    /**
     * When a new window/popup is opened used this method to switch to it. You
     * need to pass in all the old window handles for the method to identify the
     * new window
     *
     * @param tool Automation object
     * @param windowHandleTable list of open window handles
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
     * Method is used to upload files to servers. Needs to be rewriten to read
     * the properties from an ini file and not stored in a test. The [section]
     * could be used to identify a server in the ini file. This would remove the
     * need to pass in the connection details, only the name of the server and
     * the file details.
     *
     * @param host ip or url of server
     * @param login login name
     * @param password password
     * @param sourceFile File to be uploaded
     * @param targetDir target directory to upload the file to.
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
     * Used to remove currency symbols from strings and convert to a double.
     * Allows the test to then do calculations with figures extracted from a web
     * page
     *
     * @param value value in which we need to remove the currency symbol
     * @return returns the currency after converting it to a double
     */
    public static double removeCurrencyAndConvertToDouble(String currencySymbol, String value) {
        String value1 = value.replace(currencySymbol, "");
        String value2 = value1.replace(" ", "");

        double doubleValue = Double.parseDouble(value2);
        return doubleValue;
    }

    /**
     * Returns the day of the month so tests can check or set dates.
     *
     * @return returns the current day of the month as an INT
     */
    public static String getCurrentDayOfMonth() {
        NumberFormat formatter = new DecimalFormat("00");
        Calendar day = Calendar.getInstance();
        return formatter.format(day.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * Returns the current month so tests can check or set dates.
     *
     * @return returns the current month as an INT
     */
    public static int getCurrentMonth() {
        Calendar month = Calendar.getInstance();
        return month.get(Calendar.MONTH) + 1;
    }

    /**
     * Returns the current year so tests can check or set dates.
     *
     * @return returns the current year as an INT
     */
    public static int getCurrentYear() {
        Calendar year = Calendar.getInstance();
        return year.get(Calendar.YEAR);
    }

    public static String todaysDatePlusDays(int days, String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return sdf.format(cal.getTime());
    }

    /**
     * Wrapper script for constructing todays date in a particular format. Might
     * be a better way of reworking this to be able to change the format of the
     * date returned.
     *
     * @return returns the date in the following format: DD/MM/YYYY
     */
    public static String getSysdateDDMMYYYYWithSeparater(String separater) {
        String sysdate = Common.getCurrentDayOfMonth() + separater + Common.getCurrentMonth() + separater + Common.getCurrentYear();
        return sysdate;
    }

    public static String getSysdateYYYYMMDDWithSeparater(String separater) {
        String sysdate = Common.getCurrentYear() + separater + Common.getCurrentMonth() + separater + Common.getCurrentDayOfMonth();
        return sysdate;
    }

    /**
     * Method takes a number of seconds and then converts them into hours,
     * minutes and seconds, and converst to a string.
     *
     * @param howManySeconds Number of seconds to be converted into hours,
     * minutes and seconds.
     * @return Returns the converted number of seconds as a string
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
     * This method is mainly used internally but can be used in a test
     *
     * @return
     * @throws Exception
     */
    public static String getMethodName() throws Exception {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        // maybe this number needs to be corrected
        StackTraceElement e = stacktrace[2];
        return e.getMethodName();
    }

    public static void clickOKOnAlertPopup(AutomationTool tool) throws Exception {
        tool.switchToAlertAndAccept();
    }

    public static String getBaseURLFromPropertyFile(Application application) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        return propsHelper.getInitProperties(application.getMainURLKey());
    }

    public static String getAlertPopupText(AutomationTool tool) throws Exception {
        return tool.switchToAlertAndGetText();

    }

//    public static String readExcelCell(String filePathAndName, String sheetNumber, int rowNumber, int cellNumber) throws IOException, InvalidFormatException, NullPointerException {
//
//        FileInputStream fileInputStream = new FileInputStream(filePathAndName);
//        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
//        HSSFSheet worksheet = workbook.getSheet(sheetNumber);
//        HSSFRow row1 = worksheet.getRow(rowNumber);
//        HSSFCell cellA1 = row1.getCell(cellNumber);
//        String a1Val;
//
//        try {
//            a1Val = cellA1.getStringCellValue();
//        } catch (NullPointerException e) {
//
//            a1Val = "";
//        }
//
//        return a1Val;
//    }
//
//    public static int getNumberOfExcelRows(String filePathAndName, String sheetNumber) throws IOException, InvalidFormatException {
//
//        String current = System.getProperty("user.dir");
////        System.out.println("Current working directory in Java : " + current);
//
//        filePathAndName = current + "/" + filePathAndName;
//
//        InputStream inp = new FileInputStream(filePathAndName);
//        Workbook wb = WorkbookFactory.create(inp);
//
//        Sheet sheet = wb.getSheet(sheetNumber);
//        if (sheet == null) {
//
//            System.out.println("ERROR - sheet not found  : " + sheetNumber);
//        }
//
//        System.out.println("Number of rows detected : " + sheet.getPhysicalNumberOfRows());
//
//        return sheet.getPhysicalNumberOfRows();
//    }
}
