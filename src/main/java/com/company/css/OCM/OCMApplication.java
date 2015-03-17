/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.css.OCM;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;

import com.framework.common.Application;
import com.framework.common.AutomationTool;
import com.framework.common.Main;
import com.framework.common.Test;
import com.framework.app.common.Common;

public class OCMApplication extends Main {

    public OCMApplication(AutomationTool tool, Test test) throws Exception {
        this.tool = tool;
        this.test = test;
        String currentScreen = tool.getTitle();
        String expectedScreen = "OCM Application";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void clickMenuPublicationsManagePublications(Application application) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.get(application.appURL() + "faces/publication/manage_publication.jsp;" + this.getSessionIDFromUrl());
        Common.assertTextOnPage(tool, "Manage Publications");
    }

    public void clickMenuManageMediaFiles(Application application) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.get(application.appURL() + "faces/content/browse_content.jsp;" + this.getSessionIDFromUrl());
        Common.assertTextOnPage(tool, "Browse Media Files");
    }

    public void clickMenuManageCatalogs(Application application) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.get(application.appURL() + "faces/catalog/product_by_catalog.jsp;" + this.getSessionIDFromUrl());
        Common.assertTextOnPage(tool, "Browse Products by Catalog");
    }

    public void clickMenuNewPublication(Application application) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.get(application.appURL() + "faces/publication/create_publication.jsp;" + this.getSessionIDFromUrl());
        Common.assertTextOnPage(tool, "New Publication");
    }

    public void clickLatestPropagationResult() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String source = tool.getPageSource();
        String IDSubscriber[];

        IDSubscriber = source.split("PC Propagation");
        source = IDSubscriber[1];
        IDSubscriber = source.split("publicationRequestList:");
        source = IDSubscriber[1];
        IDSubscriber = source.split(":selectPublicationRequestDetails");
        if (test.getDebug())
            System.out.println(IDSubscriber[0]);

        tool.clickUsingID("mainPanel:productForm2:publicationRequestList:" + IDSubscriber[0] + ":selectPublicationRequestDetails");

        Common.assertTextOnPage(tool, "Publication Request Details");

    }

    public String getDateOfPropagationFromDetailsPage() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String creationDate = tool.getTextUsingXPath("//*[@id=\"mainPanel:publicationCreationDate_detail\"]");

        String dateCreation[];
        dateCreation = creationDate.split(" ");
        creationDate = dateCreation[0] + " " + dateCreation[1] + " " + dateCreation[2];
        return creationDate;
    }

    public String getStatusOfPropagationFromDetailsPage() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String success = tool.getTextUsingXPath("//*[@id=\"mainPanel:Status_detail\"]");
        return success;
    }

    public String getTodaysDateInFormat(String dateFormat) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        DateFormat df = new SimpleDateFormat(dateFormat);
        Date today = Calendar.getInstance().getTime();

        String reportDate = df.format(today);

        return reportDate;
    }

    public boolean createNewDeviceProduct(Sheet workSheet, int rowCount) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        boolean abortFlag = false;

        Cell codeCell = workSheet.getCell(1, rowCount);
        String deviceCode = codeCell.getContents();

        Cell nameCell = workSheet.getCell(2, rowCount);
        String deviceName = nameCell.getContents();

        Cell descCell = workSheet.getCell(3, rowCount);
        String deviceDesc = descCell.getContents();

        System.out.println("Starting creation of " + deviceName);
        tool.enterStringUsingId("mainPanel:edit:fields:name", deviceName);
        tool.enterStringUsingId("mainPanel:edit:fields:code", deviceCode);
        tool.enterStringUsingId("mainPanel:edit:fields:shortDesc", deviceDesc);
        tool.enterStringUsingId("mainPanel:edit:fields:description", deviceDesc);
        tool.clickUsingID("mainPanel:edit:buttons:createProduct");

        boolean ExistingDevice = false;
        String pageSource = tool.getPageSource();
        ExistingDevice = pageSource.contains("Product code must be unique");
        System.out.println("ExistingDevice = " + ExistingDevice);

        if (ExistingDevice == true) {
            abortFlag = true;
            System.out.println("Device code " + deviceCode + " already exists");
        } else {
            System.out.println("Device " + deviceName + " created");
        }
        return abortFlag;
    }

    public String getAttributeState() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String AttributeState = "";
        AttributeState = tool.getTextUsingXPath("//html/body/table/tbody/tr[2]/td/div/div[2]/div/div/span");
        return AttributeState;
    }

    public void editDeviceProductAttributes(Sheet workSheet, int rowCount) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        Cell smallImagePathCell = workSheet.getCell(4, rowCount);
        String smallImagePath = smallImagePathCell.getContents();
        System.out.println(smallImagePath);

        Cell largeImagePathCell = workSheet.getCell(5, rowCount);
        String largeImagePath = largeImagePathCell.getContents();
        System.out.println(largeImagePath);

        Cell manufacturerCell = workSheet.getCell(7, rowCount);
        String manufacturer = manufacturerCell.getContents();
        System.out.println(manufacturer);

        Cell warehouseCell = workSheet.getCell(8, rowCount);
        String warehouse = warehouseCell.getContents();
        System.out.println(warehouse);

        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("SMALL_IMAGE_PATH") + ":contentRef", smallImagePath);

        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("LARGE_IMAGE_PATH") + ":contentRef", largeImagePath);

        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("SMALL_IMAGE_PATH") + ":simpleDisclaimer", smallImagePath);
        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("LARGE_IMAGE_PATH") + ":simpleDisclaimer", largeImagePath);

        tool.selectVisibleTextByID("mainPanel:productForm:attributeList:" + this.selectFirstIDs("MANUFACTURERS") + ":selectOne", manufacturer);

        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("WAREHOUSE_NUMBER") + ":longString", warehouse);
        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("TERMS_AND_CONDITIONS") + ":longString", "CSS_PQA Terms And Conditions");
        tool.searchUsingID("mainPanel:productForm:attributeList:" + this.selectFirstIDs("Cable") + ":choiceMany:" + this.selectSecondIDs("Cable") + ":selected").click();
        tool.clickUsingID("mainPanel:productForm:attributeList:" + this.selectFirstIDs("GSM Mobile") + ":choiceMany:" + this.selectSecondIDs("GSM Mobile") + ":selected");

        tool.clickUsingID("mainPanel:productForm:b_updateAttributes");

        Common.assertVerifyTrue(tool, this.getAttributeState().matches("^[\\s\\S]*Attribute values updated[\\s\\S]*$"));

        System.out.println("Attribute values updated");
    }

    public String selectFirstIDs(String OfferName) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String str = tool.getPageSource();
        String temp[];

        temp = str.split(OfferName);
        str = temp[1];
        temp = str.split("List:");
        str = temp[1];
        temp = str.split(":");
        System.out.println("FirstID" + temp[0]);

        return (temp[0]);
    }

    public String selectSecondIDs(String OfferName) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String str = tool.getPageSource();
        String temp[];

        temp = str.split(OfferName);
        str = temp[1];
        temp = str.split("Many:");
        str = temp[1];
        temp = str.split(":");
        System.out.println("SecondID" + temp[0]);

        return (temp[0]);
    }

    public void editDevicePriceLists(Sheet workSheet, int rowCount) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        Date date = new Date();
        SimpleDateFormat myformat = new SimpleDateFormat("MM/dd/yy");
        System.out.println(myformat.format(date));

        Cell priceUSDCell = workSheet.getCell(9, rowCount);
        String priceUSD = priceUSDCell.getContents();

        Cell priceEURCell = workSheet.getCell(10, rowCount);
        String priceEUR = priceEURCell.getContents();

        tool.clickUsingName("mainPanel:productForm:productDetailsTabbedPane.7");

        this.SelectUSDCurrency();
        tool.clickUsingID("mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:price", priceUSD);
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:cancel");

        this.SelectEURCurrency();
        tool.clickUsingID("mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:price", priceEUR);
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:cancel");

        System.out.println("DevicePriceLists values updated");
    }

    public void editSubsidizing(Sheet workSheet, int rowCount) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        Date date = new Date();
        SimpleDateFormat myformat = new SimpleDateFormat("MM/dd/yy");
        System.out.println(myformat.format(date));

        Cell codeCell = workSheet.getCell(1, rowCount);
        String deviceCode = codeCell.getContents();

        Cell nameCell = workSheet.getCell(2, rowCount);
        String deviceName = nameCell.getContents();

        Cell descCell = workSheet.getCell(3, rowCount);
        String deviceDesc = descCell.getContents();

        Cell priceUSDCell = workSheet.getCell(15, rowCount);
        String priceUSD = priceUSDCell.getContents();

        Cell priceEURCell = workSheet.getCell(16, rowCount);
        String priceEUR = priceEURCell.getContents();

        String SubsidizeString = "-Subsidized";

        tool.clickUsingName("mainPanel:productForm:productDetailsTabbedPane.5");

        // Click on "Residential - Ultra Postpaid"
        // @TODO this link needs to be fixed - need to do string chop to
        // construct with good ID's
        tool.clickUsingXPath("//span[.= 'Residential - Ultra Postpaid']/../..//a");

        tool.enterStringUsingId("mainPanel:edit:fields:name", deviceName + SubsidizeString);
        tool.enterStringUsingId("mainPanel:edit:fields:code", deviceCode + SubsidizeString);
        tool.enterStringUsingId("mainPanel:edit:fields:shortDesc", deviceDesc + SubsidizeString);
        tool.enterStringUsingId("mainPanel:edit:fields:description", deviceDesc + SubsidizeString);
        tool.clickUsingID("mainPanel:edit:buttons:createProduct");

        // Click on Prices tab
        tool.clickUsingName("mainPanel:productForm:productDetailsTabbedPane.7");

        this.SelectUSDCurrency();
        tool.clickUsingID("mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:price", priceUSD);
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:cancel");

        this.SelectEURCurrency();
        tool.clickUsingID("mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:price", priceEUR);
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:cancel");

        System.out.println("Subsidized values updated");
    }

    public void SelectEURCurrency() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("menu:mainForm:_idJsp5ToggleCollapsed");
        tool.selectVisibleTextByID("menu:mainForm:displayedCurrency", "EUR");
        tool.clickUsingID("menu:mainForm:_idJsp5ToggleCollapsed");
    }

    public void SelectUSDCurrency() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("menu:mainForm:_idJsp5ToggleCollapsed");
        tool.selectVisibleTextByID("menu:mainForm:displayedCurrency", "USD");
        tool.clickUsingID("menu:mainForm:_idJsp5ToggleCollapsed");
    }

    public void editVoiceDeviceCategories() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("mainPanel:productForm:productDetailsTabbedPane.9");
        tool.clickUsingID("mainPanel:productForm:categoryTab:view_product_availability_in_categories:editListAvailabilityCategory");
        tool.clickUsingID("mainPanel:productForm:categoryList:" + this.selectFirstIDs("CSS_PQA_Catalog") + ":attach");
        tool.clickUsingID("mainPanel:productForm:categoryList:" + this.selectFirstIDs("DS_VOICE_DEVICES_PC") + ":attach");
        tool.clickUsingID("mainPanel:productForm:categoryList:buttons:modifyList");

        System.out.println("VoiceDeviceCategories values updated");
    }

    public void editDataDeviceCategories() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("mainPanel:productForm:productDetailsTabbedPane.9");
        tool.clickUsingID("mainPanel:productForm:categoryTab:view_product_availability_in_categories:editListAvailabilityCategory");
        tool.clickUsingID("mainPanel:productForm:categoryList:" + this.selectFirstIDs("CSS_PQA_Catalog") + ":attach");
        tool.clickUsingID("mainPanel:productForm:categoryList:" + this.selectFirstIDs("DS_DATA_DEVICES_PC") + ":attach");
        tool.clickUsingID("mainPanel:productForm:categoryList:buttons:modifyList");

        System.out.println("DataDeviceCategories values updated");
    }

    public boolean createNewAccescoryProduct(Sheet workSheet, int rowCount) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        boolean abortFlag = false;

        Cell codeCell = workSheet.getCell(1, rowCount);
        String accessoryCode = codeCell.getContents();
        System.out.println(accessoryCode);

        Cell nameCell = workSheet.getCell(2, rowCount);
        String accessoryName = nameCell.getContents();
        System.out.println(accessoryName);

        Cell descCell = workSheet.getCell(3, rowCount);
        String accessoryDesc = descCell.getContents();
        System.out.println(accessoryDesc);

        System.out.println("Starting creation of " + accessoryName);

        tool.enterStringUsingId("mainPanel:edit:fields:name", accessoryName);
        tool.enterStringUsingId("mainPanel:edit:fields:code", accessoryCode);
        tool.enterStringUsingId("mainPanel:edit:fields:shortDesc", accessoryDesc);
        tool.enterStringUsingId("mainPanel:edit:fields:description", accessoryDesc);
        tool.clickUsingID("mainPanel:edit:buttons:createProduct");

        boolean ExistingAccessory = false;
        String pageSource = tool.getPageSource();
        ExistingAccessory = pageSource.contains("Product code must be unique");
        System.out.println("ExistingAccessory = " + ExistingAccessory);

        if (ExistingAccessory == true) {
            abortFlag = true;
            System.out.println("Device code " + accessoryCode + " already exists");
        } else {
            System.out.println("Device " + accessoryName + " created");
        }

        return abortFlag;
    }

    public void editProductAttributes(Sheet workSheet, int rowCount) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        Cell smallImagePathCell = workSheet.getCell(4, rowCount);
        String smallImagePath = smallImagePathCell.getContents();

        Cell largeImagePathCell = workSheet.getCell(5, rowCount);
        String largeImagePath = largeImagePathCell.getContents();

        Cell manufacturerCell = workSheet.getCell(7, rowCount);
        String manufacturer = manufacturerCell.getContents();

        Cell warehouseCell = workSheet.getCell(9, rowCount);
        String warehouse = warehouseCell.getContents();

        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("SMALL_IMAGE_PATH") + ":contentRef", smallImagePath);

        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("LARGE_IMAGE_PATH") + ":contentRef", largeImagePath);

        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("SMALL_IMAGE_PATH") + ":simpleDisclaimer", smallImagePath);
        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("LARGE_IMAGE_PATH") + ":simpleDisclaimer", largeImagePath);

        tool.selectVisibleTextByID("mainPanel:productForm:attributeList:" + this.selectFirstIDs("MANUFACTURERS") + ":selectOne", manufacturer);

        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("WAREHOUSE_NUMBER") + ":longString", warehouse);
        tool.enterStringUsingId("mainPanel:productForm:attributeList:" + this.selectFirstIDs("TERMS_AND_CONDITIONS") + ":longString", "CSS_PQA Terms And Conditions");

        tool.clickUsingID("mainPanel:productForm:b_updateAttributes");

        Common.assertVerifyTrue(tool, this.getAttributeState().matches("^[\\s\\S]*Attribute values updated[\\s\\S]*$"));

        System.out.println("Attribute values updated");
    }

    public void editAccessoryPriceLists(Sheet workSheet, int rowCount) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        Date date = new Date();
        SimpleDateFormat myformat = new SimpleDateFormat("MM/dd/yy");
        System.out.println(myformat.format(date));

        Cell priceUSDCell = workSheet.getCell(10, rowCount);
        String priceUSD = priceUSDCell.getContents();

        Cell priceEURCell = workSheet.getCell(11, rowCount);
        String priceEUR = priceEURCell.getContents();

        tool.clickUsingName("mainPanel:productForm:productDetailsTabbedPane.7");

        this.SelectUSDCurrency();
        tool.clickUsingID("mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:price", priceUSD);
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:cancel");

        this.SelectEURCurrency();
        tool.clickUsingID("mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:price", priceEUR);
        tool.enterStringUsingId("mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID("mainPanel:productForm:priceList:buttons:cancel");

        System.out.println("DevicePriceLists values updated");
    }

    public void editAccessoryCategories() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("mainPanel:productForm:productDetailsTabbedPane.9");
        tool.clickUsingID("mainPanel:productForm:categoryTab:view_product_availability_in_categories:editListAvailabilityCategory");
        tool.clickUsingID("mainPanel:productForm:categoryList:" + this.selectFirstIDs("CSS_PQA_Catalog") + ":attach");
        tool.clickUsingID("mainPanel:productForm:categoryList:" + this.selectFirstIDs("DS_DATA_ACCESSORIES_PC") + ":attach");
        tool.clickUsingID("mainPanel:productForm:categoryList:" + this.selectFirstIDs("DS_PHONE_ACCESSORIES_PC") + ":attach");
        tool.clickUsingID("mainPanel:productForm:categoryList:buttons:modifyList");

        System.out.println("AccessoryCategories values updated");
    }

    public String getSessionIDFromUrl() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        String sessionID[] = tool.getCurrentUrl().split(";");

        return sessionID[1];
    }

}
