package com.framework.app.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;

import com.framework.common.Main;

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


    /* This class should be used for setting up the environment. If you need to update a DB or property files
     Then this is the place to do it.
     */
   // public void enableDevice(Application application) throws Exception {
    //    enableParameter(application.getCommonName() + "_char_value", "DEVICE", "true");
    //  }
    //    private void enableParameter(String paramValue, String paramName, String paramExpectedValue) throws Exception {
//        DB cid = new DB(propsHelper.getENV() + "CID");
//        if (cid.execSQLSelectWithParam(cid.oracleDBCnx(), propsHelper.getSQLPrepProperties("CHECK_" + paramName), 1, paramValue).equals(paramExpectedValue))
//            System.out.println(paramName + " already enabled");
//        else {
//            cid.execSQLUpdateWithParam(cid.oracleDBStatement(), propsHelper.getSQLPrepProperties("ENABLE_" + paramName), paramValue);
//            updateVersion(cid);
//            System.out.println(paramName + " is now enabled");
//        }
//    }
}
