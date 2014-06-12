package com.comverse.common;

public class Test extends Main {

    private String name;
    private String result;
    private String bugId;
    private Boolean debug;

    public Test() throws Exception {
        setResult("fail");
        setBugId("NoBug");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

}
