package com.framework.common;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Ian Phillips
 */
public class TestDetails extends Main {

    private String name;
    private String result;
    private String bugId;
    private String message;
    private Boolean debug = false;
    private Boolean dbReporting = false;
    private String LOG_FILE;

    /**
     *
     */
    public Writer w;

    /**
     * Main class that stores the results of the test.
     *
     * @throws Exception
     */
    public TestDetails() throws Exception {
        setResult("fail");
        setBugIdNoBug();
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public String getResult() {
        return result;
    }

    /**
     *
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     *
     * @return
     */
    public String getBugId() {
        return bugId;
    }

    /**
     * After a bug has been reported before a failing line, then this method
     * should reset the bug ID back to No Bug. This SHOULD only be used in a
     * test.
     */
    public void setBugIdNoBug() {
        this.bugId = "NoBug";
    }

    /**
     * Used to indicate an existing failure that has an associated defect This
     * information is writting to the log file and if installed the MySQL
     * database and used in the reporint application. This SHOULD only be used
     * in a test.
     *
     * @param bugId Id of the bugs
     * @throws Exception
     */
    public void setBugId(String bugId) throws Exception {
        this.writeInLogFile("INFO", "Expecting bug [" + bugId + "] in the following line");
        this.bugId = bugId;
    }

    /**
     * Returns if debug mode TRUE or FALSE
     *
     * @return True or False
     */
    public Boolean getDebug() {
        return debug;
    }

    /**
     * Sets the debug mode: TRUE or FALSE
     *
     * @param debug True to turn debug on, False to turn if off.
     */
    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    /**
     * Gets the status of the MySQL DB installation: TRUE or FALSE Should NOT be
     * used in a test
     *
     * @return returns true - MySQL reporting being used, false its not being used
     */
    public Boolean getDBReporting() {
        return dbReporting;
    }

    /**
     * Sets the status of the MySQL DB installation: TRUE or FALSE read from the
     * INIT.property file Should NOT be used in a test.
     *
     * @param dbReporting set true or false for MySQL reporting to be used.
     */
    public void setDBReporting(Boolean dbReporting) {
        this.dbReporting = dbReporting;
    }

    /**
     *
     * @return
     */
    public String getLOG_FILE() {
        return LOG_FILE;
    }

    /**
     *
     * @throws Exception
     */
    public void setLOG_FILE() throws Exception {
        if (this.getDebug()) {
            LOG_FILE = System.getProperty("java.io.tmpdir") + this.name + ".log";
            System.out.println(">>>>Log file location and name >>> " + LOG_FILE);
            openLogFile();
            this.writeInLogFile("INFO", "Test Start: " + this.getName());
        }
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public void openLogFile() throws FileNotFoundException {
        File log = new File(getLOG_FILE());
        FileOutputStream is = new FileOutputStream(log);
        OutputStreamWriter osw = new OutputStreamWriter(is);
        w = new BufferedWriter(osw);
    }

    /**
     *
     * @param text
     * @throws Exception
     */
    public void writeInLogFile(String text) throws Exception {
        this.writeInLogFile("TEST", text);
    }

    /**
     *
     * @param type
     * @param text
     * @throws Exception
     */
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

    /**
     *
     * @throws Exception
     */
    public void closeLogFile() throws Exception {
        if (this.getDebug()) {
            this.writeInLogFile("INFO", "Test Stop: " + this.getName());
            this.w.close();
        }
    }

}
