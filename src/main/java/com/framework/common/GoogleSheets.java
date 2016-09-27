/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.framework.data.GoogleSheetConnectionDetails;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.ServiceException;

/**
 *
 * @author IanPhillips
 */
public class GoogleSheets {

    private String sheetName;
    private String workSheetName;
    private String workSheetHREF;
    private String CLIENT_ID;
    private String CLIENT_SECRET;
    private String accessToken;
    private String refreshToken;

    private int totalSheets;

    static final String appName = "MY_APP";

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();

    public SpreadsheetService requiredservice;
    public com.google.gdata.data.spreadsheet.SpreadsheetEntry requiredSpreadsheet;
    public WorksheetEntry requiredWorkSheet;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getWorkSheetName() {
        return workSheetName;
    }

    public void setWorkSheetName(String workSheetName) {
        this.workSheetName = workSheetName;
    }

    public String getWorkSheetHREF() {
        return workSheetHREF;
    }

    public void setWorkSheetHREF(String workSheetHREF) {
        this.workSheetHREF = workSheetHREF;
    }

    public int getTotalSheets() {
        return totalSheets;
    }

    public void setTotalSheets(int totalSheets) {
        this.totalSheets = totalSheets;
    }

    public GoogleSheets(GoogleSheetConnectionDetails requiredSheet) {

        this.sheetName = requiredSheet.getSpreadSheetName();
        this.workSheetName = requiredSheet.getWorkSheetName();
        this.CLIENT_ID = requiredSheet.getClient_id();
        this.CLIENT_SECRET = requiredSheet.getClient_secret();
        this.refreshToken = requiredSheet.getRefreshToken();
        this.accessToken = requiredSheet.getAccessToken();

//        List<String> scopes = Arrays.asList("https://www.googleapis.com/auth/drive");
        try {

            GoogleCredential credential
                    = new GoogleCredential.Builder()
                    .setTransport(HTTP_TRANSPORT)
                    .setJsonFactory(JSON_FACTORY)
                    .setClientSecrets(CLIENT_ID, CLIENT_SECRET)
                    .build();

            credential.setRefreshToken(refreshToken);
            credential.setAccessToken(accessToken);

            SpreadsheetService service = new SpreadsheetService("Aplication-name");

            this.requiredservice = service;

            service.setOAuth2Credentials(credential);

            URL SPREADSHEET_FEED_URL = new URL(
                    "https://spreadsheets.google.com/feeds/spreadsheets/private/full");
            // Make a request to the API and get all spreadsheets.

            SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL,
                    SpreadsheetFeed.class);

            List<com.google.gdata.data.spreadsheet.SpreadsheetEntry> spreadsheets = feed.getEntries();

            boolean spreadsheetfound = false;
            int sheetCounter = 0;
            for (com.google.gdata.data.spreadsheet.SpreadsheetEntry spreadsheet : spreadsheets) {

                if (spreadsheets.isEmpty()) {
                    System.out.println(" No spread sheets found.");
                    throw new IllegalArgumentException();
                }

                System.out.println(spreadsheet.getTitle().getPlainText());
                if (spreadsheet.getTitle().getPlainText().equalsIgnoreCase(this.sheetName)) {
//                    System.out.println("Found it");
                    this.requiredSpreadsheet = spreadsheet;
                    this.workSheetHREF = spreadsheet.getHtmlLink().getHref();
                    System.out.println(spreadsheet.getHtmlLink().getHref());
                    spreadsheetfound = true;
                }

            }

            if (!spreadsheetfound) {
                System.out.println("Spreadsheet not found, please check the name");
                throw new IllegalArgumentException("Spreadsheet not found, please check the name");
            }

            WorksheetFeed worksheetFeed = service.getFeed(requiredSpreadsheet.getWorksheetFeedUrl(), WorksheetFeed.class);

            List<WorksheetEntry> worksheets = worksheetFeed.getEntries();

            boolean worksheetfound = false;
            for (WorksheetEntry worksheet : worksheets) {
                System.out.println(worksheet.getTitle().getPlainText());
                System.out.println("Searching for " + workSheetName);
                if (worksheet.getTitle().getPlainText().equalsIgnoreCase(workSheetName)) {

                    this.requiredWorkSheet = worksheet;

                    worksheetfound = true;
                }
                sheetCounter++;
            }
            if (!worksheetfound) {
                this.sheetName = this.addNewSheet();
                System.out.println("Worksheet was not found, please check the name");
                throw new IllegalArgumentException("Worksheet was not found, please check the name");
            }
            this.totalSheets = sheetCounter;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String addNewSheet() throws IOException, ServiceException {

        String sheetName = "Sheet" + (this.totalSheets + 1);

        WorksheetEntry worksheet = new WorksheetEntry();
        worksheet.setTitle(new PlainTextConstruct(sheetName));
        worksheet.setColCount(20);
        worksheet.setRowCount(20);

        URL worksheetFeedUrl = this.requiredSpreadsheet.getWorksheetFeedUrl();
        this.requiredservice.insert(worksheetFeedUrl, worksheet);
        this.totalSheets = this.totalSheets + 1;
        return sheetName;
    }

    public String getCellValue(String cellId) throws IOException, ServiceException {

        String cellValue = "";

//     Fetch the cell feed of the worksheet.
        URL cellFeedUrl = requiredWorkSheet.getCellFeedUrl();
        CellFeed cellFeed = requiredservice.getFeed(cellFeedUrl, CellFeed.class);

        // Iterate through each cell, printing its value.
        for (CellEntry cell : cellFeed.getEntries()) {
            // Print the cell's address in A1 notation
//            System.out.print(cell.getTitle().getPlainText() + "\t");
////            // Print the cell's address in R1C1 notation
//            System.out.print(cell.getId().substring(cell.getId().lastIndexOf('/') + 1) + "\t");
////            // Print the cell's formula or text value
//            System.out.print(cell.getCell().getInputValue() + "\t");
////            // Print the cell's calculated value if the cell's value is numeric
////            // Prints empty string if cell's value is not numeric
//            System.out.print(cell.getCell().getNumericValue() + "\t");
////            // Print the cell's displayed value (useful if the cell has a formula)
//            System.out.println(cell.getCell().getValue() + "\t");

            if (cell.getTitle().getPlainText().equalsIgnoreCase(cellId)) {

                cellValue = cell.getCell().getValue().toString();

            }

        }
        return cellValue;
    }
    
       public String getCellInputValue(String cellId) throws IOException, ServiceException {

        String cellValue = "";

//     Fetch the cell feed of the worksheet.
        URL cellFeedUrl = requiredWorkSheet.getCellFeedUrl();
        CellFeed cellFeed = requiredservice.getFeed(cellFeedUrl, CellFeed.class);

        // Iterate through each cell, printing its value.
        for (CellEntry cell : cellFeed.getEntries()) {
            // Print the cell's address in A1 notation
//            System.out.print(cell.getTitle().getPlainText() + "\t");
////            // Print the cell's address in R1C1 notation
//            System.out.print(cell.getId().substring(cell.getId().lastIndexOf('/') + 1) + "\t");
////            // Print the cell's formula or text value
//            System.out.print(cell.getCell().getInputValue() + "\t");
////            // Print the cell's calculated value if the cell's value is numeric
////            // Prints empty string if cell's value is not numeric
//            System.out.print(cell.getCell().getNumericValue() + "\t");
////            // Print the cell's displayed value (useful if the cell has a formula)
//            System.out.println(cell.getCell().getValue() + "\t");

            if (cell.getTitle().getPlainText().equalsIgnoreCase(cellId)) {

                cellValue = cell.getCell().getInputValue();

            }

        }
        return cellValue;
    }

    public void updateCellValue(String cellId, String value) throws IOException, ServiceException {

//        String cellValue = "";

//     Fetch the cell feed of the worksheet.
        URL cellFeedUrl = requiredWorkSheet.getCellFeedUrl();
        CellFeed cellFeed = requiredservice.getFeed(cellFeedUrl, CellFeed.class);

        // Iterate through each cell, printing its value.
        for (CellEntry cell : cellFeed.getEntries()) {

            
            System.out.print("comparing " + cell.getTitle().getPlainText() + " with " + cellId +"\n");
            
            if (cell.getTitle().getPlainText().equalsIgnoreCase(cellId)) {

//                cellValue = cell.getCell().getValue().toString();

                cell.changeInputValueLocal(value);
                cell.update();
                 System.out.print("Cell updated\n");
            
            }

        }

    }

    public int getNumberOfRows() {
        return requiredWorkSheet.getRowCount();
    }

    public int getNumberOfColumns() {
        return requiredWorkSheet.getColCount();
    }

    public List<String> getSpreadSheetAsArray() throws IOException, ServiceException {

        List<String> cellValue = new ArrayList<String>();

//     Fetch the cell feed of the worksheet.
        URL cellFeedUrl = requiredWorkSheet.getCellFeedUrl();
        CellFeed cellFeed = requiredservice.getFeed(cellFeedUrl, CellFeed.class
        );

        // Iterate through each cell, printing its value.
        for (CellEntry cell : cellFeed.getEntries()) {
            // Print the cell's address in A1 notation
            System.out.print(cell.getTitle().getPlainText() + "\t");
//            // Print the cell's address in R1C1 notation
            System.out.print(cell.getId().substring(cell.getId().lastIndexOf('/') + 1));
//            // Print the cell's formula or text value
            System.out.print(cell.getCell().getInputValue() + "\t");
//            // Print the cell's calculated value if the cell's value is numeric
//            // Prints empty string if cell's value is not numeric
            System.out.print(cell.getCell().getNumericValue() + "\t");
//             Print the cell's displayed value (useful if the cell has a formula)
            System.out.println(cell.getCell().getValue() + "\t");

            System.out.println("");

            try {
                if (!cell.getCell().getValue().equalsIgnoreCase("")) {

                    cellValue.add(cell.getCell().getValue());
                }
            } catch (NullPointerException e) {
// do nothing
                cellValue.add("");
            }
        }

        return cellValue;
    }

    public void createSpreadSheet() throws MalformedURLException, IOException, ServiceException {

//        DocsService docsService = new DocsService("MySampleApplication-v3");
//        docsService.setUserCredentials("ianphillipstest@gmail.com", "kahn+DUAL");
        URL GOOGLE_DRIVE_FEED_URL = new URL("https://docs.google.com/feeds/default/private/full/");
        DocumentListEntry documentListEntry = new com.google.gdata.data.docs.SpreadsheetEntry();
        documentListEntry.setTitle(new PlainTextConstruct("Spreadsheet_name"));
        documentListEntry = this.requiredservice.insert(GOOGLE_DRIVE_FEED_URL, documentListEntry);

    }
}
