/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;

import com.comverse.common.Application;
import com.comverse.common.DB;
import com.comverse.common.Main;

public class Prep extends Main {
    private PropertyHelper propsHelper = new PropertyHelper();

    public Prep() throws Exception {
    }

    public String readUsersPasswordFromIniFile(String key) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();

        String passwordKey = "PASSWD." + key;
        String password = propsHelper.getPasswordProperties(passwordKey);

        if (password == null || password.length() == 0) {
            throw new MissingResourceException("Missing property " + passwordKey, PASSWORD_PROPERTY_FILE, passwordKey);
        }
        return password;
    }

    public String readUsersUserNameFromIniFile(String key) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();

        String passwordKey = "LOGIN." + key;
        String password = propsHelper.getPasswordProperties(passwordKey);

        if (password == null || password.length() == 0) {
            throw new MissingResourceException("Missing property " + passwordKey, PASSWORD_PROPERTY_FILE, passwordKey);
        }
        return password;
    }

    public String readPropertyFromAccountPropertyFile(String key) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();

        String property = propsHelper.getAccountProperties(key);

        if (property == null || property.length() == 0) {
            throw new MissingResourceException("Missing property " + key, ACCOUNTS_PROPERTY_FILE, key);
        }
        return property;
    }

    public static Properties readProperties(String name) throws IOException {
        Properties properties = new Properties();
        ClassLoader loader = Prep.class.getClassLoader();
        InputStream inStream = loader.getResourceAsStream(name);
        properties.load(inStream);
        return properties;
    }

    public void updateVersion(DB cid) throws Exception {
        cid.execSQLUpdate(cid.oracleDBStatement(), propsHelper.getSQLPrepProperties("UPDATE_TIMESTAMP"));
    }

    private void enableParameter(String paramValue, String paramName, String paramExpectedValue) throws Exception {
        DB cid = new DB(propsHelper.getENV() + "CID");
        if (cid.execSQLSelectWithParam(cid.oracleDBCnx(), propsHelper.getSQLPrepProperties("CHECK_" + paramName), 1, paramValue).equals(paramExpectedValue))
            System.out.println(paramName + " already enabled");
        else {
            cid.execSQLUpdateWithParam(cid.oracleDBStatement(), propsHelper.getSQLPrepProperties("ENABLE_" + paramName), paramValue);
            updateVersion(cid);
            System.out.println(paramName + " is now enabled");
        }
    }

    public void enableDevice(Application application) throws Exception {
        enableParameter(application.getCommonName() + "_char_value", "DEVICE", "true");
    }

    public void enableSubscribeStatusHistory(Application application) throws Exception {
        enableParameter(application.getCommonName() + "_char_value", "SUBSCRIBER_STATUS_HISTORY", "true");
    }

    public void enableBusinessNCA(Application application) throws Exception {
        enableParameter(application.getCommonName(), "BUSINESS_NCA", "19");
    }

    // public void savePropertiesToFile(String lastnamevalue, String loginvalue,
    // String passwordvalue, String callingTest) {
    //
    // try {
    // Properties props = new Properties();
    //
    // try {
    // props = readProperties(INIT_PROPERTY_FILE);
    // } catch (IOException e) {
    // System.err.println(e.getMessage());
    // e.printStackTrace();
    // }
    // String environmentIdentifier = props.getProperty("environment");
    //
    // File initFile = new File(environmentIdentifier + BCT_PROPERTY_FILE);
    // boolean exists = (initFile.exists());
    // if (exists) {
    // String initFilePath = initFile.getAbsolutePath();
    // System.out.println("INIT file was found at " + initFilePath);
    // } else {
    // System.out.println("ERROR INIT file not found");
    // }
    //
    // System.out.println("Saving lastname to property file - " +
    // lastnamevalue);
    // System.out.println("Saving login to property file - " + loginvalue);
    // System.out.println("Saving password to property file - " +
    // passwordvalue);
    // props.setProperty("bct_password", passwordvalue);
    // props.setProperty("bct_lastname", lastnamevalue);
    // props.setProperty("bct_login", loginvalue);
    //
    // props.store(new FileOutputStream(initFile), "Updated by " + callingTest +
    // "in ENV# " + environmentIdentifier);
    // System.out.println("INIT file saved to  " + initFile.getAbsolutePath());
    //
    // } catch (IOException e) {
    // }
    // }
    //
    // public String readLastNameFromFile() {
    // Properties prop = new Properties();
    //
    // try {
    // prop = readProperties(INIT_PROPERTY_FILE);
    // } catch (IOException e) {
    // System.err.println(e.getMessage());
    // e.printStackTrace();
    // }
    // String environmentIdentifier = prop.getProperty("environment");
    //
    // try {
    // //load a properties file
    // File initFile = new File(environmentIdentifier + BCT_PROPERTY_FILE);
    //
    // boolean exists = (initFile.exists());
    // if (exists) {
    // String initFilePath = initFile.getAbsolutePath();
    // System.out.println("INIT file was found at " + initFilePath);
    // } else {
    // System.out.println("ERROR INIT file not found");
    // }
    //
    // prop.load(new FileInputStream(initFile.getAbsolutePath()));
    //
    // System.out.println("Last name retrieved from file = " +
    // prop.getProperty("bct_lastname"));
    //
    // } catch (IOException ex) {
    // ex.printStackTrace();
    // }
    // return (prop.getProperty("bct_lastname"));
    // }
    // public String readBCTLoginFromINIFile() {
    // Properties prop = new Properties();
    //
    // try {
    // prop = readProperties(INIT_PROPERTY_FILE);
    // } catch (IOException e) {
    // System.err.println(e.getMessage());
    // e.printStackTrace();
    // }
    // String environmentIdentifier = prop.getProperty("environment");
    //
    // try {
    // //load a properties file
    // File initFile = new File(environmentIdentifier + BCT_PROPERTY_FILE);
    //
    // boolean exists = (initFile.exists());
    // if (exists) {
    // String initFilePath = initFile.getAbsolutePath();
    // System.out.println("INIT file was found at " + initFilePath);
    // } else {
    // System.out.println("ERROR INIT file not found");
    // }
    //
    // prop.load(new FileInputStream(initFile.getAbsolutePath()));
    //
    // System.out.println("Last name retrieved from file = " +
    // prop.getProperty("bct_login"));
    //
    // } catch (IOException ex) {
    // ex.printStackTrace();
    // }
    // return (prop.getProperty("bct_login"));
    // }
    //
    // public String readBCTPasswordFromINIFile() {
    // Properties prop = new Properties();
    //
    // try {
    // prop = readProperties(INIT_PROPERTY_FILE);
    // } catch (IOException e) {
    // System.err.println(e.getMessage());
    // e.printStackTrace();
    // }
    // String environmentIdentifier = prop.getProperty("environment");
    //
    // try {
    // //load a properties file
    // File initFile = new File(environmentIdentifier + BCT_PROPERTY_FILE);
    //
    // boolean exists = (initFile.exists());
    // if (exists) {
    // String initFilePath = initFile.getAbsolutePath();
    // System.out.println("INIT file was found at " + initFilePath);
    // } else {
    // System.out.println("ERROR INIT file not found");
    // }
    //
    // prop.load(new FileInputStream(initFile.getAbsolutePath()));
    //
    // System.out.println("Last name retrieved from file = " +
    // prop.getProperty("bct_password"));
    //
    // } catch (IOException ex) {
    // ex.printStackTrace();
    // }
    // return (prop.getProperty("bct_password"));
    // }
}
