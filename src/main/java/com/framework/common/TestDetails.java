package com.framework.common;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;

public class TestDetails extends Main {

    private String name;
    private String result;
    private String bugId;
    private String message;
    private Boolean debug = false;
    private String LOG_FILE;
    public Writer w;

    public TestDetails() throws Exception {
        setResult("fail");
        setBugId("NoBug");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getLOG_FILE() {
        return LOG_FILE;
    }

    public void setLOG_FILE() throws Exception {
        if (this.getDebug()) {
            LOG_FILE = System.getProperty("java.io.tmpdir") + this.name + ".log";
            System.out.println(">>>>Log file location and name >>> " + LOG_FILE);
            openLogFile();
            this.writeInLogFile("INFO", "Test Start: " + this.getName());
        }
    }

    public void openLogFile() throws FileNotFoundException {
        File log = new File(getLOG_FILE());
        FileOutputStream is = new FileOutputStream(log);
        OutputStreamWriter osw = new OutputStreamWriter(is);
        w = new BufferedWriter(osw);
    }

    public void writeInLogFile(String text) throws Exception {
        this.writeInLogFile("TEST", text);
    }

    public void writeInLogFile(String type, String text) throws Exception {
        if (this.getDebug()) {
            try {
                this.w.write(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(new Date()) + " | " + type + " | " + text);
                this.w.write("\r\n");
            } catch (IOException e) {
                System.err.println("Problem writing to the file log file");
            }
        }
    }

    public void closeLogFile() throws Exception {
        if (this.getDebug()) {
            this.writeInLogFile("INFO", "Test Stop: " + this.getName());
            this.w.close();
        }
    }

}
