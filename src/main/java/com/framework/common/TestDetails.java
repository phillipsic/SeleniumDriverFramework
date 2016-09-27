package com.framework.common;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

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
    public ExtentTest testExtReport;
    public String reportingPath = System.getProperty("user.dir");
    private String filenameOfReport = reportingPath + "/testReport" + Common.getSysdateYYYYMMDDWithSeparater("") + ".html";
//    public String filenameOfReport = "extendedReport.html";

    /**
     *
     */
    public Writer w;
    public FileOutputStream fileOut;
    public int excelRowCounter;
    public HSSFWorkbook workbook;
    public ExtentReports extent;
    public ExtentTest reportExt;

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
        this.writeResultLoggerInfo("Expecting bug [" + bugId + "] in the following line(s)");
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
     * @return returns true - MySQL reporting being used, false its not being
     * used
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

    public void startResultLogger() {
        extent = new ExtentReports(filenameOfReport, false);
        reportExt = extent.startTest(this.getName(), "Selenium Logger");
    }

    public void writeResultLoggerFail(String message) {
        reportExt.log(LogStatus.FAIL, message);
    }

    public void writeResultLoggerPass(String message) {
        reportExt.log(LogStatus.PASS, message);
    }

    public void writeResultLoggerInfo(String message) {
        reportExt.log(LogStatus.INFO, message);
    }

    public void assertVerifyTrue(AutomationTool tool, Boolean verify, String message) throws Exception {

        assertTrue("ASSERTION FAIL: " + message, verify);
        writeResultLoggerPass("ASSERTING TRUE: " + message + " : " + verify);
    }

    public void assertTextEquals(Object expectedText, Object actualText) throws Exception {

        assertEquals("ASSERTION FAIL: Expecting [" + expectedText + "] but was [" + actualText + "]", expectedText, actualText);
        reportExt.log(LogStatus.PASS, "ASSERTING PASS:  [" + expectedText + "] and was [" + actualText + "]");
    }

    public void assertTextContains(TestDetails test, String expectedText, String actualText) throws Exception {
//        String value = "Asserting string [" + expectedText + "] contains [" + actualText + "]";
        Pattern p = Pattern.compile(actualText);
        Matcher m = p.matcher(expectedText);
        test.assertVerifyTrue(tool, m.find(), "Asserting string contains string");
//        if (m.find()) {
//            test.writeResultLoggerPass(value);
//        } else {
//            test.writeResultLoggerFail(value);
//        }
    }

    public void assertTextOnPage(AutomationTool tool, String searchText) throws Exception {
        Common.sleepForNumberOfSeconds(1);
        String pageSource = Common.returnCleanPageSource(tool);
        reportExt.log(LogStatus.PASS, "ASSERTING TEXT ON PAGE :  [" + searchText + "] ");
        captureScreenShotToResultLogger(tool);
        assertTrue("ASSERTION FAIL: Expecting " + searchText + " in page", pageSource.contains(searchText));

    }

    public void checkTextEqual(TestDetails test, String expectedText, String actualText) throws Exception {

        String value = "Comparison of [" + expectedText + "] with [" + actualText + "]";

        if (expectedText.equals(actualText)) {
            test.writeResultLoggerPass(value);
        } else {
            test.writeResultLoggerFail(value);
        }
    }

    public void checkTextContains(TestDetails test, String expectedText, String actualText) throws Exception {

        String value = "Checking string [" + expectedText + "] contains [" + actualText + "]";

        Pattern p = Pattern.compile(actualText);
        Matcher m = p.matcher(expectedText);

        if (m.find()) {
            test.writeResultLoggerPass(value);
        } else {
            test.writeResultLoggerFail(value);
        }
    }

    /**
     * This should be used instead of using an assert in the Test. This method
     * has a description added that will appear in the debugging information.
     *
     * @param tool Automation object
     * @param searchText text that should not be found on the page.
     * @throws Exception
     */
    public void assertTextNotOnPage(AutomationTool tool, String searchText) throws Exception {
        Common.sleepForNumberOfSeconds(1);
        String pageSource = Common.returnCleanPageSource(tool);
        reportExt.log(LogStatus.PASS, "ASSERTION TEXT NOT ON PAGE :  [" + searchText + "]");
        captureScreenShotToResultLogger(tool);
        assertFalse("ASSERTION FAIL: NOT expecting [" + searchText + "] in page", pageSource.contains(searchText));
    }

    public void assertElementPresentByLinkText(AutomationTool tool, String value) throws Exception {

        assertTrue("ASSERTING Link " + value + " on page", tool.isElementPresentByLinkText(value));
    }

    public void assertElementPresentByXpath(AutomationTool tool, String value) throws Exception {

        assertTrue("ASSERTING Element " + value + " on page", tool.isElementPresentByXPath(value));
    }

    /**
     * This should be used instead of using an assert in the Test. This method
     * has a description added that will appear in the debugging information.
     *
     * @param tool Automation object
     * @param verify value to check for FALSE
     * @throws Exception
     */
    public void assertVerifyFalse(AutomationTool tool, Boolean verify, String message) throws Exception {
        assertFalse("ASSERTION FAIL: " + message, verify);
        reportExt.log(LogStatus.PASS, "ASSERTING FALSE: " + message + " : " + verify);
    }

    public void assertTextNotEquals(Object expectedText, Object actualText) throws Exception {
        assertNotSame("ASSERTION FAIL: Expecting different values but are the same:" + expectedText + " and " + actualText, expectedText, actualText);
        reportExt.log(LogStatus.PASS, "ASSERTION FAIL: Expecting different values but are the same:" + expectedText + " and " + actualText);

    }

    public void captureScreenShotToResultLogger(AutomationTool tool) throws Exception {
        String filePath = tool.takeScreenShot(reportingPath);
        reportExt.log(LogStatus.INFO, "Snapshot below: " + reportExt.addScreenCapture(filePath));
    }

    /**
     * This method should be used in every page object to check the correct page
     * title.
     *
     * @param tool Automation object
     * @param expectedScreen the expected title of the page for an assertion.
     * @throws Exception
     */
    public void assertCorrectPageTitle(AutomationTool tool, String expectedScreen) throws Exception {
        String currentScreen = tool.getTitle();
        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        reportExt.log(LogStatus.PASS, "Checking page title, expected: [" + expectedScreen + "] Actual [" + currentScreen + "]");
    }

    public boolean assertTextFieldIsReadOnlyUsingID(AutomationTool tool, String id) throws Exception {

        return tool.checkEnabledUsingId(id);
    }

    public void closeResultLogger() {
        extent.endTest(reportExt);
// writing everything to document
        extent.flush();
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
        this.writeResultLoggerInfo(text);
//        testExtReport.log(LogStatus.INFO, text);
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

    public void openExcelFile() throws FileNotFoundException, IOException, Exception {
        try {

            String fileName = "ExcelResultFiles/Report-" + Common.todaysDatePlusDays(0, "yyyyMMdd-hhmmss");
            fileOut = new FileOutputStream(fileName + ".xls");
            workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Results");

            HSSFRow row1 = worksheet.createRow((short) 0);

            HSSFCell cellA1 = row1.createCell(0);
            cellA1.setCellValue("Script");

            HSSFCell cellB1 = row1.createCell(1);
            cellB1.setCellValue("Identifier");

            HSSFCell cellC1 = row1.createCell(2);
            cellC1.setCellValue("Message");

            HSSFCell cellD1 = row1.createCell(3);
            cellD1.setCellValue("Result");

            excelRowCounter = 1;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeToExcelFile(String scriptName, String identifier, String message, String result) throws FileNotFoundException, IOException {

        HSSFSheet worksheet = workbook.getSheet("Results");
        HSSFRow row1 = worksheet.createRow((short) excelRowCounter);

        HSSFCell cellA1 = row1.createCell(0);
        cellA1.setCellValue(scriptName);

        HSSFCell cellB1 = row1.createCell(1);
        cellB1.setCellValue(identifier);

        HSSFCell cellC1 = row1.createCell(2);
        cellC1.setCellValue(message);

        HSSFCell cellD1 = row1.createCell(3);
        cellD1.setCellValue(result);
        excelRowCounter++;

    }

    public void closeExcelFile() throws FileNotFoundException, IOException {

        workbook.write(fileOut);
        this.fileOut.flush();
        this.fileOut.close();
    }

}
