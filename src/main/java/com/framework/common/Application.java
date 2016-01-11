package com.framework.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author S823509
 */
public class Application extends Main {

    private String Name;
    private String CommonName;
    private String Version;
    private String MainURLKey;
    private String DirectURLKey;

    /**
     *
     */
    public Application() {
        setMainURLKey("base_url");
        setDirectURLKey("direct_url");

    }

    /**
     *
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @return
     */
    public String getCommonName() {
        return CommonName;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     *
     * @param commonName
     */
    public void setCommonName(String commonName) {
        CommonName = commonName;
    }

    /**
     *
     * @param mainURLKey
     */
    public void setMainURLKey(String mainURLKey) {
        MainURLKey = mainURLKey;
    }

    /**
     *
     * @param directURLKey
     */
    public void setDirectURLKey(String directURLKey) {
        DirectURLKey = directURLKey;
    }

    /**
     *
     * @return
     */
    public String getDirectURLKey() {
        return DirectURLKey;
    }

    /**
     * build the complete URL to be called. appURL = baseURL + application
     *
     * First do a check to see if the applicationName has an INI setting. If not
     * then no application name in the URL so use the baseURL.
     *
     * @return
     */
    public String appURL() {
        PropertyHelper propsHelper = new PropertyHelper();

        String applicationName = propsHelper.getInitProperties(this.getName() + "_url");
        String fullURL = "";

        if (applicationName == null) {
            fullURL = proxyURL() + "/";
        } else {
            fullURL = proxyURL() + "/" + applicationName + "/";
        }

        return fullURL;
    }

    // Needs to be rewritten - flag for where to get build nubmer
//    public String versionURL() {
//        PropertyHelper propsHelper = new PropertyHelper();
//
//        String URL = "";
//        String buildNumberInIniFile = propsHelper.getInitProperties("buildNumberIniFile");
//
//        if (buildNumberInIniFile.equals("TRUE")) {
//            URL = proxyURL() + "/" + propsHelper.getInitProperties(this.getName() + "_url") + "/";
//        } else {
//            URL = proxyURL() + "/" + propsHelper.getInitProperties("myshapepos_url") + "/";
//        }
//
//        return URL;
//    }
    /**
     *
     * @return
     */
    public String proxyURL() {
        PropertyHelper propsHelper = new PropertyHelper();
        return propsHelper.getInitProperties(MainURLKey);
    }

    /**
     *
     * @return
     */
    public String getVersion() {
        return Version;
    }

    /**
     *
     * @param tool
     * @param test
     * @throws Exception
     */
    public void setVersion(AutomationTool tool, TestDetails test) throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();

        Boolean buildNumberInIniFile = Boolean.valueOf(propsHelper.readInitProperties("buildNumberIniFile"));

        if (buildNumberInIniFile) {
            this.Version = propsHelper.getInitProperties("build_number");

        } else {
            // Using date here but you could write code to get the version from the app  

            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            Date today = Calendar.getInstance().getTime();

            this.Version = df.format(today);

        }

        test.writeInLogFile("INFO", "Version: " + this.getVersion());
    }

    // Needed for debug purpose
    /**
     *
     * @param version
     * @throws Exception
     */
    public void setVersion(String version) throws Exception {
        Version = version;
    }

    /**
     *
     * @return
     */
    public String appFullURL() {
        PropertyHelper propsHelper = new PropertyHelper();
        return propsHelper.getInitProperties(this.getName() + "_url");
    }

}
