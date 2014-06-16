package com.comverse.css.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Set;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.DB;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Common {

    public Common() {
    }

    public static void waitForEndOfWaitingPage(AutomationTool tool, String className) throws Exception {
        for (int iteration = 0;; iteration++) {

            System.out.println(className + ": Iteration " + iteration + " of 90");
            if (iteration >= 90) {
                throw new Exception("Timeout");
            }

            if (tool.driver.getTitle().matches("Waiting Page")) {
                // System.out.println("Please Wait present");
                Thread.sleep(3000);
            } else {
                // System.out.println("Executing BREAK out of loop.");
                Thread.sleep(3000);
                break;
            }

        }
    }

    public static void sleepForNumberOfSeconds(long value) throws Exception {

        long numberOfSeconds = value * 1000;
        Thread.sleep(numberOfSeconds);
    }

    public static Boolean isTextOnPage(AutomationTool tool, String searchText) throws Exception {

        String pageSource = tool.driver.getPageSource();
        return pageSource.contains(searchText);
    }

    public static Boolean isCheckBoxSelected(AutomationTool tool, String idOfCheckBox) throws Exception {

        return (tool.driver.findElement(By.id(idOfCheckBox)).isSelected());
    }

    public static void assertTextOnPage(AutomationTool tool, String searchText) throws Exception {

        String pageSource = Common.returnCleanPageSource(tool);
        assertTrue(pageSource.contains(searchText));
    }

    public static void assertTextNotOnPage(AutomationTool tool, String searchText) throws Exception {

        String pageSource = Common.returnCleanPageSource(tool);
        assertFalse(pageSource.contains(searchText));
    }

    public static boolean isElementPresent(AutomationTool tool, By by) {
        try {
            tool.driver.findElements(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String removeHTMLTags(String dirtyString) throws Exception {

        String dirtyString1 = dirtyString.replaceAll("&nbsp;", "");
        String dirtyString2 = dirtyString1.replaceAll("<![CDATA[.*?]]>", "");
        String dirtyString3 = dirtyString2.replaceAll("\\<.*?>", "");
        return dirtyString3.replaceAll("  ", " ");

    }

    public static String returnCleanPageSource(AutomationTool tool) throws Exception {
        String dirtyString = tool.driver.getPageSource();
        dirtyString = removeHTMLTags(dirtyString);
        return cleanStringOfIllegalChars(dirtyString);
    }

    public static Boolean isTextOnPageWithRegex(AutomationTool tool, String searchText) throws Exception {

        String pageSource = Common.returnCleanPageSource(tool);
        return pageSource.matches("^[\\s\\S]*" + searchText + "[\\s\\S]*$");
    }

    public static Boolean isTextNotOnPage(AutomationTool tool, String searchText) throws Exception {

        String pageSource = Common.returnCleanPageSource(tool);

        return !pageSource.contains(searchText);
    }

    public static Boolean isOfferTextOnPage(AutomationTool tool, String searchText) throws Exception {
        Boolean foundIt = false;
        int startOfOfferIndex = 1;

        String pageSource = tool.driver.getPageSource();

        while (startOfOfferIndex > 0 && foundIt == false) {

            startOfOfferIndex = pageSource.indexOf(searchText);
            int endOfOfferIndex = pageSource.toLowerCase().indexOf("</p>", startOfOfferIndex);

            if (startOfOfferIndex > -1) {
                String offerNameOnPage = pageSource.substring(startOfOfferIndex, endOfOfferIndex);

                offerNameOnPage = offerNameOnPage.replaceAll("[^\\p{Print}]", "");
                offerNameOnPage = offerNameOnPage.replaceAll("\\p{Cntrl}", "");
                offerNameOnPage = offerNameOnPage.trim();

                if (offerNameOnPage.equals(searchText)) {

                    foundIt = true;

                }

                pageSource = pageSource.substring(endOfOfferIndex);
            }

        }

        return foundIt;
    }

    public static String cleanStringOfIllegalChars(String dirtyString) throws Exception {

        String dirtyString1 = dirtyString.replaceAll("[^\\p{Print}]", "");
        String dirtyString2 = dirtyString1.replaceAll("\\p{Cntrl}", "");
        String dirtyString3 = dirtyString2.replaceAll("\'", "");
        String dirtyString4 = dirtyString3.replaceAll("\"", "");

        return dirtyString4.trim();
    }

    public static String replaceAmpCodeWithCharacter(String value) {

        return value.replaceAll("&amp;", "&");
    }

    public static String cleanStringOfAllNonDigits(String dirtyString) throws Exception {

        dirtyString.replaceAll("\\pL+", "");
        String cleanString = dirtyString.trim();
        return cleanString;

    }

    public static void checkForExistingBasketAndDiscard(AutomationTool tool) throws Exception {
        if (tool.driver.getTitle().equals("Restore Previous Basket")) {
            tool.clickUsingXPath(tool, "//input[@value='Discard']");
            tool.clickUsingCssSelector(tool, "input.submit");
        }
    }

    public static void waitForOffersToLoadOnPage(AutomationTool tool, String className) throws Exception {
        for (int iteration = 0;; iteration++) {

            System.out.println(className + ": Iteration " + iteration + " of 5");
            if (iteration >= 5) {
                throw new Exception("Timeout");
            }

            if (isTextOnPage(tool, "Loading Primary Offers and Subscriber Bundles")) {
                System.out.println("Still loading offers ...");
                Thread.sleep(3000);
            } else {
                System.out.println("Offers Loaded");
                break;
            }

        }
    }

    public static void waitForEventsToLoadOnPage(AutomationTool tool, String className) throws Exception {

        boolean foundElement = false;
        for (int iteration = 0;; iteration++) {
            System.out.println(className + ": Iteration " + iteration + " of 10");
            if (iteration >= 90) {
                throw new Exception("Timeout");
            }
            try {
                tool.driver.findElement(By.cssSelector("img[title=\" Action\"]"));
                foundElement = true;

                System.out.println("FoundElement =  ..." + foundElement);
                break;
            } catch (Exception e) {
            }
        }
    }

    public static void waitForAccountBundlesToLoadOnPage(AutomationTool tool, String className) throws Exception {
        for (int iteration = 0;; iteration++) {
            Thread.sleep(1000);
            System.out.println(className + ": Iteration " + iteration + " of 90");
            if (iteration >= 90) {
                throw new Exception("Timeout");
            }

            if (isTextOnPage(tool, "Loading Account Bundles...")) {
                System.out.println("Still loading Bundles ...");
                Thread.sleep(1000);
            } else {
                System.out.println("Bundles Loaded");
                break;
            }

        }
    }

    public static void waitForDevicesToLoadOnPage(AutomationTool tool, String className) throws Exception {
        for (int iteration = 0;; iteration++) {

            System.out.println(className + ": Iteration " + iteration + " of 90");
            if (iteration >= 90) {
                throw new Exception("Timeout");
            }

            if (isTextOnPage(tool, "Loading Devices...")) {
                System.out.println("Still loading Devices ...");
                Thread.sleep(1000);
            } else {
                System.out.println("Devices Loaded");
                break;
            }

        }
    }

    public static void waitForAccessoriesToLoadOnPage(AutomationTool tool, String className) throws Exception {
        for (int iteration = 0;; iteration++) {

            System.out.println(className + ": Iteration " + iteration + " of 90");
            if (iteration >= 90) {
                throw new Exception("Timeout");
            }

            if (isTextOnPage(tool, "Loading Accessories...")) {
                System.out.println("Still loading Accessories ...");
                Thread.sleep(1000);
            } else {
                System.out.println("Accessories Loaded");
                break;
            }

        }
    }

    private static void insertPropertyInDB(String key, String value, String comment) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        String testEnvironment = propsHelper.getENV();

        PreparedStatement statement = null;
        Connection connection = null;

        try {
            DB autotest = new DB("AUTOTEST");
            connection = autotest.mysqlDBcnx();

            statement = connection
                    .prepareStatement("INSERT INTO dynamic_test_data ( environment, property_key, property_value, property_comment, property_used  ) VALUES (?, ?, ?, ?, false)");

            statement.setString(1, testEnvironment);
            statement.setString(2, key);
            statement.setString(3, value);
            statement.setString(4, comment);
            // statement.setString(5, false);
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
            connection = autotest.mysqlDBcnx();

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
            connection = autotest.mysqlDBcnx();

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
        connection = autotest.mysqlDBcnx();

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
        connection = autotest.mysqlDBcnx();

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
        connection = autotest.mysqlDBcnx();

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

    /*
     * private static String getUnusedPropertyValueFromDB(String key) throws
     * Exception {
     * 
     * PropertyHelper propsHelper = new PropertyHelper();
     * 
     * String testEnvironment = propsHelper.getEnvProperties();
     * 
     * PreparedStatement statement = null; ResultSet resultSet = null; String
     * propertyValue; Connection connection = null; connection =
     * DriverManager.getConnection(url + dbName, userName, password);
     * 
     * try { // Class.forName(tool.driver).newInstance();
     * 
     * System.out.println("Connected to the database");
     * 
     * statement = connection.prepareStatement("SELECT property_value FROM
     * dynamic_test_data WHERE property_key = ? AND environment = ? AND
     * property_used = false");
     * 
     * statement.setString(1, key); statement.setString(2, testEnvironment);
     * 
     * resultSet = statement.executeQuery(); resultSet.next(); propertyValue =
     * resultSet.getString("property_value");
     * 
     * 
     * } finally { resultSet.close(); statement.close(); connection.close(); }
     * 
     * return propertyValue;
     * 
     * }
     */
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

    public static void storeLastNamePostpaidAccount(String lastName, String comment) throws Exception {

        if (lastName.matches("BillingLN[0-9]{13}")) {

            storePropertyInDB("postpaid_last_name", lastName, comment);
        } else {

            System.out.println("\r\n**************************************");
            System.out.println("WARNING - The property postpaid_last_name does not match the pattern 'BillingLN12314567890123/' " + lastName + "'");
            System.out.println("WARNING - data has not been save to the database.");
            System.out.println("**************************************");
        }

    }

    public static void storeOrderingCUPLastNameAndAccountNumber(String lastName, String accountNumber, String comment) throws Exception {

        storeMultiplePropertiesInDB("cup_ordering_login_lastnameAccount", lastName + "++" + accountNumber, comment);

    }

    public static void storeNonOrderingCUPLastNameAndAccountNumber(String lastName, String accountNumber, String comment) throws Exception {

        storeMultiplePropertiesInDB("cup_nonordering_login_lastnameAccount", lastName + "++" + accountNumber, comment);

    }

    public static void storeNonOrderingCUPLoginAndPassword(String login, String password, String comment) throws Exception {

        storePropertyInDB("nonordering_cup_login_password", login + "++" + password, comment);
    }

    public static void storeCUPLoginAndPassword(String login, String password, String comment) throws Exception {

        storePropertyInDB("cup_login_password", login + "++" + password, comment);
    }

    public static void storeCOPLoginAndPassword(String login, String password, String comment) throws Exception {

        storePropertyInDB("cop_login_password", login + "++" + password, comment);
    }

    public static String getCUPB2CLogin() throws Exception {
        String temp[];
        String propertyValue = "";

        try {
            propertyValue = getPropertyValueFromDB("cup_login_password");
        } catch (Exception e) {
            System.out.println("[ERROR]");
            System.out.println("Property value cup_login_password does not exist");
            System.out.println("Please run CSR 'UAM0200_Add_Login_To_Persona' \n");
            throw e;
        }

        temp = propertyValue.split("\\+\\+");

        return temp[0];
    }

    public static String getCUPB2CPassword(String login) throws Exception {

        String temp[];

        String propertyValue = getMatchingPropertyValueFromDB("cup_login_password", login);
        // deletePropertyFromDB("cup_login_password", propertyValue);
        // System.out.println("propertyValue " + propertyValue);
        temp = propertyValue.split("\\+\\+");

        return temp[1];

    }

    public static String getNonOrderingCUPB2CLogin() throws Exception {
        String temp[];
        String propertyValue = "";

        try {
            propertyValue = getPropertyValueFromDB("nonordering_cup_login_password");
        } catch (Exception e) {
            System.out.println("[ERROR]");
            System.out.println("Property value nonordering_cup_login_password does not exist");
            System.out.println("Please run CSR 'UAM0200_Add_Login_To_Persona' \n");
            throw e;
        }

        temp = propertyValue.split("\\+\\+");

        return temp[0];
    }

    public static String getNonOrderingCUPB2CPassword(String login) throws Exception {

        String temp[];

        String propertyValue = getMatchingPropertyValueFromDB("nonordering_cup_login_password", login);
        // deletePropertyFromDB("cup_login_password", propertyValue);
        // System.out.println("propertyValue " + propertyValue);
        temp = propertyValue.split("\\+\\+");

        return temp[1];

    }

    public static String getCOPB2CLogin() throws Exception {
        String temp[];
        String propertyValue = "";

        try {
            propertyValue = getPropertyValueFromDB("cop_login_password");
        } catch (Exception e) {
            System.out.println("[ERROR]");
            System.out.println("Property value cup_login_password does not exist");
            System.out.println("Please run CSR 'UAM0200_Add_Login_To_Persona' \n");
            throw e;
        }

        temp = propertyValue.split("\\+\\+");

        return temp[0];
    }

    public static String getCOPB2CPassword(String login) throws Exception {

        String temp[];

        String propertyValue = getMatchingPropertyValueFromDB("cop_login_password", login);
        // deletePropertyFromDB("cup_login_password", propertyValue);
        // System.out.println("propertyValue " + propertyValue);
        temp = propertyValue.split("\\+\\+");

        return temp[1];

    }

    public static void storeLastNameAndAccountNumberPrepaidAccount(String lastName, String accountNumber, String comment) throws Exception {

        storeMultiplePropertiesInDB("prepaid_last_name_account", lastName + "++" + accountNumber, comment);
    }

    public static void storeLastNameAndAccountNumberPostpaidAccount(String lastName, String accountNumber, String comment) throws Exception {

        storeMultiplePropertiesInDB("postpaid_last_name_account", lastName + "++" + accountNumber, comment);
    }

    public static String getLastNamePrepaidAccount() throws Exception {
        String temp[];

        String propertyValue = getPropertyValueFromDB("prepaid_last_name_account");
        deletePropertyFromDB("prepaid_last_name_account", propertyValue);
        System.out.println("propertyValue " + propertyValue);
        temp = propertyValue.split("\\+\\+");

        return temp[0];

    }

    public static String getAccountNumPrepaidAccount() throws Exception {

        return getPropertyValueFromDB("prepaid_account_number");
    }

    public static String getLastNameRechargableAccount() throws Exception {

        return getPropertyValueFromDB("bct_lastname");
    }

    public static String get3GIMSISerialNumber() throws Exception {

        return getPropertyValueFromDB("3GIMSI");
    }

    public static void storeNext3GIMSISerialNumber() throws Exception {
        Long serialNumber = Long.parseLong(getPropertyValueFromDB("3GIMSI"));
        serialNumber++;
        String stringSerialNumber = Long.toString(serialNumber);
        storePropertyInDB("3GIMSI", stringSerialNumber, "Updated by method storeNext3GIMSISerialNumber");
    }

    public static String get3GSIMSerialNumber() throws Exception {

        return getPropertyValueFromDB("3GSIM");
    }

    public static void storeNext3GSIMSerialNumber() throws Exception {
        Long serialNumber = Long.parseLong(getPropertyValueFromDB("3GSIM"));
        serialNumber++;
        String stringSerialNumber = Long.toString(serialNumber);
        storePropertyInDB("3GSIM", stringSerialNumber, "Updated by method storeNext3GSIMSerialNumber");
    }

    public static String getPrepaidMSISDNServicenumber() throws Exception {

        return getPropertyValueFromDB("PrepaidMSISDN");
    }

    public static void storeNextPrepaidMSISDNServicenumber() throws Exception {
        Long serialNumber = Long.parseLong(getPropertyValueFromDB("PrepaidMSISDN"));
        serialNumber++;
        String stringSerialNumber = Long.toString(serialNumber);
        storePropertyInDB("PrepaidMSISDN", stringSerialNumber, "Updated by method storeNextPrepaidMSISDNServicenumber");
    }

    public static String getNormalMSISDNServicenumber() throws Exception {

        return getPropertyValueFromDB("NormalMSISDN");
    }

    public static void storeNextNormalMSISDNServicenumber() throws Exception {
        Long serialNumber = Long.parseLong(getPropertyValueFromDB("NormalMSISDN"));
        serialNumber++;
        String stringSerialNumber = Long.toString(serialNumber);
        storePropertyInDB("NormalMSISDN", stringSerialNumber, "Updated by method storeNextNormalMSISDNServicenumber");
    }

    public static String getBCTLastName() throws Exception {

        return getPropertyValueFromDB("bct_lastname");
    }

    public static String getPersonFirstName() throws Exception {

        return "FN" + getPropertyValueFromDB("bct_login");
    }

    public static String getPersonLastName() throws Exception {

        return "LN" + getPropertyValueFromDB("bct_login");
    }

    public static void storeB2CLoginDetailsAndLastName(String lastName, String login, String Password, String comment) throws Exception {

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

    public static void storeSubscriberMSISDN(String subscriberMSISDN, String comment) throws Exception {

        storePropertyInDB("subscriber_MSISDN", subscriberMSISDN, comment);
    }

    public static void storeBusinessAccountID(String accountID, String comment) throws Exception {

        storePropertyInDB("business_account_id", accountID, comment);
    }

    public static String getBusinessAccountID() throws Exception {

        String propertyValue = "";

        try {
            propertyValue = getPropertyValueFromDB("business_account_id");
        } catch (Exception e) {
            System.out.println("[ERROR]");
            System.out.println("Property value business_account_id does not exist");
            System.out.println("Please run CSR 'NCA0010_New_customer_for_Business_and_CSR_Portal' \n");
            throw e;
        }
        return propertyValue;

    }

    public static String getSubscriberMSISDN() throws Exception {

        String propertyValue = "";

        try {
            propertyValue = getPropertyValueFromDB("subscriber_MSISDN");
        } catch (Exception e) {
            System.out.println("[ERROR]");
            System.out.println("Property value subscriber_MSISDN does not exist");
            System.out.println("Please run CSR 'NCA0010 tests' \n");
            throw e;
        }
        return propertyValue;

    }

    public static String getLastNameOfUnregisteredAccountForSignMeUp(String accountnumber) throws Exception {

        String temp[];

        String propertyValue = getMatchingPropertyValueFromDB("prepaid_last_name_account", accountnumber);
        deletePropertyFromDB("prepaid_last_name_account", propertyValue);
        // System.out.println("propertyValue " + propertyValue);
        temp = propertyValue.split("\\+\\+");

        return temp[0];
    }

    public static String getAccountNumberOfUnregisteredAccountForSignMeUp() throws Exception {

        String temp[];
        String propertyValue = "";
        try {
            propertyValue = getPropertyValueFromDB("prepaid_last_name_account");

        } catch (Exception e) {
            System.out.println("[ERROR]");
            System.out.println("Property key 'prepaid_last_name_account' does not exist");
            System.out.println("Please run CSR 'NCA0010_New_customer_Residential_Prepaid_With_CUP' \n");
            throw e;
        }
        temp = propertyValue.split("\\+\\+");
        return temp[1];
    }

    public static String getLastNameOfCOPForSignMeUp(String accountnumber) throws Exception {

        String temp[];

        String propertyValue = getMatchingPropertyValueFromDB("postpaid_last_name_account", accountnumber);
        deletePropertyFromDB("postpaid_last_name_account", propertyValue);
        // System.out.println("propertyValue " + propertyValue);
        temp = propertyValue.split("\\+\\+");

        return temp[0];
    }

    public static String getAccountNumberOfCOPForSignMeUp() throws Exception {

        String temp[];
        String propertyValue = "";
        try {
            propertyValue = getPropertyValueFromDB("postpaid_last_name_account");

        } catch (Exception e) {
            System.out.println("[ERROR]");
            System.out.println("Property key 'postpaid_last_name_account' does not exist");
            System.out.println("Please run CSR 'NCA0010_New_customer_for_Residential_Postpaid_and_CSR_Portal' \n");
            throw e;
        }
        temp = propertyValue.split("\\+\\+");
        return temp[1];
    }

    public static String getB2CLoginName() throws Exception {

        return getPropertyValueFromDB("bct_login");
    }

    public static String getB2CPassword() throws Exception {

        return getPropertyValueFromDB("bct_password");
    }

    public static String generateTimeStamp() throws Exception {
        long ts = (new java.util.Date()).getTime();
        // System.out.print("Unique string - " + String.valueOf(ts));
        return String.valueOf(ts);
    }

    public static String getLastNameOfPostPaidAccount() throws Exception {
        String accountLastName = getPropertyValueFromDB("postpaid_last_name");
        System.out.print("Account Last Name : " + accountLastName + "\r\n");
        return accountLastName;
    }

    public static String getLastNameOfOrderingCUP() throws Exception {
        String temp[];
        String propertyValue = "";

        try {
            propertyValue = getPropertyValueFromDB("cup_ordering_login_lastnameAccount");
            deletePropertyFromDB("cup_ordering_login_lastnameAccount", propertyValue);

        } catch (Exception e) {
            System.out.println("[ERROR]");
            System.out.println("Property key 'cup_ordering_login_lastnameAccount' does not exist");
            System.out.println("Please run CSR 'NPA0010_Add_Persona_CUP' \n");
            throw e;
        }

        temp = propertyValue.split("\\+\\+");
        return temp[0];
    }

    public static String getLastNameOfNonOrderingCUP() throws Exception {
        String temp[];
        String propertyValue = "";

        try {
            propertyValue = getPropertyValueFromDB("cup_nonordering_login_lastnameAccount");
            deletePropertyFromDB("cup_nonordering_login_lastnameAccount", propertyValue);

        } catch (Exception e) {
            System.out.println("[ERROR]");
            System.out.println("Property key 'cup_nonordering_login_lastnameAccount' does not exist");
            System.out.println("Please run CSR 'NPA0010_Add_Persona_CUP' \n");
            throw e;
        }

        temp = propertyValue.split("\\+\\+");
        return temp[0];
    }

    public static String getRechargeVoucher() throws Exception {

        String propertyValue;
        try {
            propertyValue = getPropertyValueFromDB("RechargeVoucher");
            deletePropertyFromDB("RechargeVoucher", propertyValue);

        } catch (Exception e) {
            System.out.println("[ERROR]");
            System.out.println("Property key 'RechargeVoucher' does not exist");
            System.out.println("Please add them manually \n");
            throw e;
        }

        return propertyValue;
    }

    public static void clickAction2ItemIsAccessible(AutomationTool tool, String actionID, String classTitle) throws Exception {
        boolean successfullyDisplayed = false;
        int loopCounter = 0;

        while (!successfullyDisplayed) {
            try {

                loopCounter++;

                System.out.println("Loop: " + loopCounter + " of 20");
                if (loopCounter >= 20) {
                    successfullyDisplayed = true;
                }
                Common.sleepForNumberOfSeconds(2);
                tool.clickUsingXPath(tool, "(//input[@value='+ Action'])[2]");
                tool.clickUsingID(tool, actionID);
                String pageTitle = tool.getTitle(tool);

                if (pageTitle.equals(classTitle) || pageTitle.equals("Waiting Page")) {
                    successfullyDisplayed = true;
                } else {

                    tool.driver.navigate().refresh();
                }
            } catch (Exception e) {
                System.out.println("Menu item not selectable");
            }
        }
    }

    public static void clickAction1ItemIsAccessible(AutomationTool tool, String classTitle, String... actionIDTable) throws Exception {
        boolean successfullyDisplayed = false;
        int loopCounter = 0;

        while (!successfullyDisplayed) {
            try {

                loopCounter++;

                System.out.println("Loop: " + loopCounter + " of 20");
                if (loopCounter >= 20) {
                    successfullyDisplayed = true;
                }
                Common.sleepForNumberOfSeconds(2);
                tool.clickUsingXPath(tool, "//input[@value='+ Action']");
                if (actionIDTable != null) {
                    for (String actionID : actionIDTable) {
                        Common.sleepForNumberOfSeconds(1);
                        tool.clickUsingID(tool, actionID);
                    }
                }
                String pageTitle = tool.getTitle(tool);

                if (pageTitle.equals(classTitle) || pageTitle.equals("Waiting Page")) {
                    successfullyDisplayed = true;
                } else {

                    tool.driver.navigate().refresh();
                    System.out.println("Trying browser refresh");
                }
            } catch (Exception e) {
                System.out.println("Menu item not selectable");
            }
        }
    }

    public static void storeOrganizationName(String orgName, String comment) throws Exception {
        storePropertyInDB("SFA_BCT_Organization", orgName, comment);
    }

    public static String getOrganizationName() throws Exception {
        String orgName = getPropertyValueFromDB("SFA_BCT_Organization");
        System.out.print("SFA_BCT_Organization  : " + orgName + "\r\n");
        return orgName;
    }

    public static void storeB2BLeadName(String fieldName, String leadName, String comment) throws Exception {
        storePropertyInDB(fieldName, leadName, comment);
    }

    public static String getB2BLeadName(String fieldName) throws Exception {
        String leadName = getPropertyValueFromDB(fieldName);
        System.out.print(fieldName + " : " + leadName + "\r\n");
        return leadName;
    }

    public static void storeOpportunityName(String fieldName, String opportunityName, String comment) throws Exception {
        storePropertyInDB(fieldName, opportunityName, comment);
    }

    public static String getCurrentWindowHandle(AutomationTool tool) {
        return tool.driver.getWindowHandle();
    }

    public static void switchToThisWindow(AutomationTool tool, String windowHandle) {
        tool.driver.switchTo().window(windowHandle);
    }

    public static void switchToNewWindow(AutomationTool tool, String... windowHandleTable) {
        Set<String> windows = tool.driver.getWindowHandles();
        for (String window : windows) {
            for (String windowHandle : windowHandleTable) {
                if (!window.equals(windowHandle)) {
                    tool.driver.switchTo().window(window);
                    break;
                }
            }
        }
    }

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

    public static double removeCurrencyAndConvertToDouble(String value) {
        String value1 = value.replace("$", "");
        String value2 = value1.replace(" ", "");

        double doubleValue = Double.parseDouble(value2);
        return doubleValue;
    }

    public static int getCurrentDayOfMonth() {
        Calendar day = Calendar.getInstance();
        return day.get(Calendar.DAY_OF_MONTH);
    }

    public static int getCurrentMonth() {
        Calendar month = Calendar.getInstance();
        return month.get(Calendar.MONTH) + 1;
    }

    public static int getCurrentYear() {
        Calendar year = Calendar.getInstance();
        return year.get(Calendar.YEAR);
    }

    public static String getSysdateDDMMYYYY() {
        String sysdate = Common.getCurrentDayOfMonth() + "/" + Common.getCurrentMonth() + "/" + Common.getCurrentYear();
        return sysdate;
    }

    public static String formatToHHmmss(String howManySeconds) throws Exception {

        int initSeconds = Integer.parseInt(howManySeconds);
        int hours = initSeconds / 3600;
        int remainder = initSeconds % 3600;
        int minutes = remainder / 60;
        int seconds = remainder % 60;

        String time = ((hours < 10 ? "0" : "") + hours + ":" + (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds);

        return time;
    }

}
