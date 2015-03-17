package com.framework.app.common;

import java.io.*;
import java.util.Properties;

import com.framework.common.Main;

public class PropertyHelper extends Main {

    /**
     * 
     * @param name
     * @return
     * @throws IOException
     */
    public Properties readProperties(String name) throws IOException {
        Properties properties = new Properties();
        ClassLoader loader = PropertyHelper.class.getClassLoader();
        InputStream inStream = loader.getResourceAsStream(name);
        properties.load(inStream);
        return properties;
    }

    /**
     * 
     * @param key
     * @return
     */
    public String getInitProperties(String key) {

        Properties props = null;
        String value = "";

        String environmentIdentifier = this.getENV();

        try {
            props = readProperties(INIT_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        if (key.equals("BROWSER.type")) {
            value = props.getProperty(key);
        } else {
            value = props.getProperty(environmentIdentifier + "." + key);
            try {
                props = readProperties(environmentIdentifier + "_" + INIT_PROPERTY_FILE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            value = props.getProperty(key);
        }

        return value;
    }

    public String readInitProperties(String key) {

        Properties props = null;
        String value = "";

        try {
            props = readProperties(INIT_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            props = readProperties(INIT_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        value = props.getProperty(key);

        return value;
    }

    public String getPasswordProperties(String key) {

        Properties props = null;
        String value = "";

        String environmentIdentifier = this.getENV();

        try {
            props = readProperties(environmentIdentifier + "_" + PASSWORD_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        if (key.equals("BROWSER.type")) {
            value = props.getProperty(key);
        } else {
            value = props.getProperty(key);
        }

        return value;
    }

    public int getInitPropertiesInt(String key) {

        Properties props = null;
        try {
            props = readProperties(INIT_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        String value = props.getProperty(key);
        int num = Integer.parseInt(value);

        return num;
    }

    /**
     * 
     * @param key
     * @return
     */
    public String getAccountProperties(String key) {

        System.out.println("This is the key " + key);
        Properties props = null;

        String environmentIdentifier = this.getENV();

        try {
            props = readProperties(environmentIdentifier + "_" + ACCOUNTS_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        String value = props.getProperty(key);
        return value;
    }

    // changed for setting the property for success order
    /**
     * 
     * @param key
     * @param lastname
     */
    public void setProperties(String key, String lastname) {
        ClassLoader loader = PropertyHelper.class.getClassLoader();
        System.out.println(loader.getResourceAsStream(INIT_PROPERTY_FILE));
        InputStream inStream = loader.getResourceAsStream(INIT_PROPERTY_FILE);
        InputStreamReader in = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        String textinLine;

        try {
            in = new InputStreamReader(inStream);
            br = new BufferedReader(in);
            while (true) {
                textinLine = br.readLine();

                if (textinLine != null && textinLine.contains(key)) {

                    String textToEdit1 = key + " = " + lastname;
                    sb.append(textToEdit1 + "\n");

                } else if (textinLine.contains("EOF")) {
                    sb.append(textinLine + "\n");
                    break;
                } else {
                    sb.append(textinLine + "\n");
                }

            }

            in.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fstream = new FileWriter(loader.getResource(INIT_PROPERTY_FILE).getFile().replaceAll("%20", " "));
            BufferedWriter outobj = new BufferedWriter(fstream);
            outobj.write(sb.toString());
            outobj.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Writes the last name out to a property file 'BCT_PROPERTY_FILE' The
     * BCT_PROPERTY_FILE should not be in GIT or this causes problems with the
     * PULL
     * 
     * This method should only be called after a successful NCA.
     * 
     * The BCT_PROPERTY_FILE property file will be found at the root of Selenium
     * or workspace.
     * 
     * @param lastnamevalue
     */
    public void savePropertiesToFile(String lastnamevalue, String loginvalue, String passwordvalue, String callingTest) {
        try {
            Properties props = new Properties();

            String environmentIdentifier = this.getENV();

            File initFile = new File(BCT_PROPERTY_FILE);
            boolean exists = (initFile.exists());
            if (exists) {
                String initFilePath = initFile.getAbsolutePath();
                System.out.println("INIT file was found at " + initFilePath);
            } else {
                System.out.println("ERROR INIT file not found");
            }

            System.out.println("Saving lastname to property file - " + lastnamevalue);
            System.out.println("Saving login to property file - " + loginvalue);
            System.out.println("Saving password to property file - " + passwordvalue);
            props.setProperty("bct_password", passwordvalue);
            props.setProperty("bct_lastname", lastnamevalue);
            props.setProperty("bct_login", loginvalue);

            props.store(new FileOutputStream(initFile), "Updated by " + callingTest + "in ENV# " + environmentIdentifier);
            System.out.println("INIT file saved to  " + initFile.getAbsolutePath());

        } catch (IOException e) {
        }
    }

    /**
     * 
     * @return
     */
    public String readLastNameFromFile() {
        Properties prop = new Properties();

        try {
            // load a properties file
            File initFile = new File(BCT_PROPERTY_FILE);

            boolean exists = (initFile.exists());
            if (exists) {
                String initFilePath = initFile.getAbsolutePath();
                System.out.println("INIT file was found at " + initFilePath);
            } else {
                System.out.println("ERROR INIT file not found");
            }

            prop.load(new FileInputStream(initFile.getAbsolutePath()));

            System.out.println("Last name retrieved from file = " + prop.getProperty("bct_lastname"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return (prop.getProperty("bct_lastname"));
    }

    public String readLoginFromFile() {
        Properties prop = new Properties();

        try {
            File initFile = new File(BCT_PROPERTY_FILE);

            boolean exists = (initFile.exists());
            if (exists) {

                String initFilePath = initFile.getAbsolutePath();
                System.out.println("INIT file was found at " + initFilePath);
            } else {
                System.out.println("ERROR INIT file not found");
            }

            // load a properties file

            prop.load(new FileInputStream(initFile.getAbsolutePath()));
            System.out.println("Login retrieved from file = " + prop.getProperty("bct_login"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return (prop.getProperty("bct_login"));
    }

    public String readPasswordFromFile() {
        Properties prop = new Properties();

        try {
            File initFile = new File(BCT_PROPERTY_FILE);

            boolean exists = (initFile.exists());
            if (exists) {

                String initFilePath = initFile.getAbsolutePath();
                System.out.println("INIT file was found at " + initFilePath);
            } else {
                System.out.println("ERROR INIT file not found");
            }

            prop.load(new FileInputStream(initFile.getAbsolutePath()));
            // System.out.println("Password retrieved from file = " +
            // prop.getProperty("bct_password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return (prop.getProperty("bct_password"));
    }

    /**
     * 
     * @param args
     */
    public static void main(String args[]) {
        PropertyHelper myHelper = new PropertyHelper();
        System.out.println(myHelper.getInitProperties("BROWSER.ie"));

    }

    public String getDBProperties(String key) {
        Properties props = null;

        try {
            props = readProperties(DB_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        String value = props.getProperty(key);

        return value;
    }

    public String getENV() {
        Properties props = null;

        try {
            props = readProperties(INIT_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return props.getProperty("environment");
    }

    public String getSQLInvoiceProperties(String key) {
        Properties props = null;
        String value = null;

        try {
            props = readProperties(SQL_INVOICE_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        value = props.getProperty(key);

        return value;
    }

    public String getSQLPrepProperties(String key) {
        Properties props = null;
        String value = null;

        try {
            props = readProperties(SQL_PREP_PROPERTY_FILE);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        value = props.getProperty(key);

        return value;
    }
}
