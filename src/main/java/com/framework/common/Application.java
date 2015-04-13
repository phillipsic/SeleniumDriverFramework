package com.framework.common;

import com.framework.app.common.PropertyHelper;

public class Application extends Main {

    private String Name;
    private String CommonName;
    private String Version;
    private String MainURLKey;
    private String DirectURLKey;

    public Application() {
        setMainURLKey("base_url");
        setDirectURLKey("css_direct_url");
       
    }

    public String getName() {
        return Name;
    }

    public String getCommonName() {
        return CommonName;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCommonName(String commonName) {
        CommonName = commonName;
    }

    public void setMainURLKey(String mainURLKey) {
        MainURLKey = mainURLKey;
    }

    public void setDirectURLKey(String directURLKey) {
        DirectURLKey = directURLKey;
    }

    public String getDirectURLKey() {
        return DirectURLKey;
    }

    public String appURL() {
        PropertyHelper propsHelper = new PropertyHelper();
        return proxyURL() + "/" + propsHelper.getInitProperties(this.getName() + "_url") + "/";
    }

    // Needs to be rewritten - flag for where to get build nubmer
    public String versionURL() {
        PropertyHelper propsHelper = new PropertyHelper();
            
        String URL = "";
        if (propsHelper.getInitProperties("buildNumberIniFile").equals("TRUE")) {
            URL = proxyURL() + "/" + propsHelper.getInitProperties(this.getName() + "_url") + "/";
        } else {
            URL = proxyURL() + "/" + propsHelper.getInitProperties("myshapepos_url") + "/";
        }

        return URL;
    }

    public String proxyURL() {
        PropertyHelper propsHelper = new PropertyHelper();
        return propsHelper.getInitProperties(MainURLKey);
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(AutomationTool tool, Test test) throws Exception {
        tool.get(this.versionURL() + "/jfn?entry=status");
        Thread.sleep(1000);
        String bodyText = tool.getTextUsingCssSelector("body");
        String[] temp = bodyText.split("\\r?\\n");
        String[] temp2 = temp[0].split("Service");
        this.Version = temp2[1].trim();

        test.writeInLogFile("INFO", "Version: " + this.getVersion());
    }

    // Needed for debug purpose
    public void setVersion(String version) throws Exception {
        Version = version;
    }

    public String appFullURL() {
        PropertyHelper propsHelper = new PropertyHelper();
        return propsHelper.getInitProperties(this.getName() + "_url");
    }

}
