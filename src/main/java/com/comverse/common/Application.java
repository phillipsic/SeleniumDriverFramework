package com.comverse.common;

import com.comverse.css.common.PropertyHelper;

public class Application extends Main {
    private String Name;
    private String OCMName;
    private String Version;
    private String MainURLKey;
    private String DirectURLKey;
    private boolean isCSSApp;

    public Application() {
        setMainURLKey("css_proxy_url");
        setDirectURLKey("css_direct_url");
        setOCMName("nmy-ocm-app");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean getIsCSSApp() {
        return isCSSApp;
    }

    public void setIsCSSApp(boolean isCSSApp) {
        this.isCSSApp = isCSSApp;
    }

    public String getOCMName() {
        return OCMName;
    }

    public void setOCMName(String ocmname) {
        OCMName = ocmname;
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

    public String appOCMURL() {
        PropertyHelper propsHelper = new PropertyHelper();
        return proxyURL() + "/" + propsHelper.getInitProperties(this.getOCMName() + "_url") + "/";
    }

    // POS URL is used to get versions for non CSS applications
    public String versionURL() {
        PropertyHelper propsHelper = new PropertyHelper();
        String URL = "";
        if (isCSSApp)
            URL = proxyURL() + "/" + propsHelper.getInitProperties(this.getName() + "_url") + "/";
        else
            URL = proxyURL() + "/" + propsHelper.getInitProperties("myshapepos_url") + "/";

        return URL;
    }

    public String proxyURL() {
        PropertyHelper propsHelper = new PropertyHelper();
        return propsHelper.getInitProperties(MainURLKey);
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(AutomationTool tool) throws Exception {
        tool.get(tool, this.versionURL() + "/jfn?entry=status");
        String bodyText = tool.getTextUsingCssSelector(tool, "body");
        String[] temp = bodyText.split("\\r?\\n");
        String[] temp2 = temp[0].split("Service");

        this.Version = temp2[1].trim();
    }

    public String appFullURL() {
        PropertyHelper propsHelper = new PropertyHelper();
        return propsHelper.getInitProperties(this.getName() + "_url");
    }

}
