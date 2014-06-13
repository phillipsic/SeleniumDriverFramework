/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.OCM;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.Application;
import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.css.common.Common;

public class OCMApplication extends Main {

    public OCMApplication(AutomationTool tool, Test test) {
        this.tool = tool;
        this.test = test;
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "OCM Application";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickMenuPublicationsManagePublications(Application application) throws Exception {
        tool.driver.get(application.appURL() + "faces/publication/manage_publication.jsp;" + this.getSessionIDFromUrl());
        Common.assertTextOnPage(tool, "Manage Publications");
    }

    public void clickMenuManageMediaFiles(Application application) throws Exception {
        tool.driver.get(application.appURL() + "faces/content/browse_content.jsp;" + this.getSessionIDFromUrl());
        Common.assertTextOnPage(tool, "Browse Media Files");
    }

    public void clickMenuManageCatalogs(Application application) throws Exception {
        tool.driver.get(application.appURL() + "faces/catalog/product_by_catalog.jsp;" + this.getSessionIDFromUrl());
        Common.assertTextOnPage(tool, "Browse Products by Catalog");
    }

    public void clickMenuNewPublication(Application application) throws Exception {
        tool.driver.get(application.appURL() + "faces/publication/create_publication.jsp;" + this.getSessionIDFromUrl());
        Common.assertTextOnPage(tool, "New Publication");
    }

    public void clickLatestPropagationResult() throws Exception {
        String source = tool.driver.getPageSource();
        String IDSubscriber[];

        IDSubscriber = source.split("PC Propagation");
        source = IDSubscriber[1];
        IDSubscriber = source.split("publicationRequestList:");
        source = IDSubscriber[1];
        IDSubscriber = source.split(":selectPublicationRequestDetails");
        if (test.getDebug())
            System.out.println(IDSubscriber[0]);

        tool.clickUsingID(tool, "mainPanel:productForm2:publicationRequestList:" + IDSubscriber[0] + ":selectPublicationRequestDetails");

        Common.assertTextOnPage(tool, "Publication Request Details");

    }

    public String getDateOfPropagationFromDetailsPage() throws Exception {
        String creationDate = tool.getTextUsingXPath(tool, "//*[@id=\"mainPanel:publicationCreationDate_detail\"]");

        String dateCreation[];
        dateCreation = creationDate.split(" ");
        creationDate = dateCreation[0] + " " + dateCreation[1] + " " + dateCreation[2];
        return creationDate;
    }

    public String getStatusOfPropagationFromDetailsPage() throws Exception {
        String success = tool.getTextUsingXPath(tool, "//*[@id=\"mainPanel:Status_detail\"]");
        return success;
    }

    public String getTodaysDateInFormat(String dateFormat) throws Exception {
        DateFormat df = new SimpleDateFormat(dateFormat);
        Date today = Calendar.getInstance().getTime();

        String reportDate = df.format(today);

        return reportDate;
    }

    public boolean createNewDeviceProduct(Sheet workSheet, int rowCount) throws Exception {

        boolean abortFlag = false;

        Cell codeCell = workSheet.getCell(1, rowCount);
        String deviceCode = codeCell.getContents();

        Cell nameCell = workSheet.getCell(2, rowCount);
        String deviceName = nameCell.getContents();

        Cell descCell = workSheet.getCell(3, rowCount);
        String deviceDesc = descCell.getContents();

        System.out.println("Starting creation of " + deviceName);
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:name", deviceName);
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:code", deviceCode);
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:shortDesc", deviceDesc);
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:description", deviceDesc);
        tool.clickUsingID(tool, "mainPanel:edit:buttons:createProduct");

        boolean ExistingDevice = false;
        String pageSource = tool.driver.getPageSource();
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
        String AttributeState = "";
        AttributeState = tool.getTextUsingXPath(tool, "//html/body/table/tbody/tr[2]/td/div/div[2]/div/div/span");
        return AttributeState;
    }

    public void editDeviceProductAttributes(Sheet workSheet, int rowCount) throws Exception {
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

        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("SMALL_IMAGE_PATH") + ":contentRef", smallImagePath);

        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("LARGE_IMAGE_PATH") + ":contentRef", largeImagePath);

        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("SMALL_IMAGE_PATH") + ":simpleDisclaimer", smallImagePath);
        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("LARGE_IMAGE_PATH") + ":simpleDisclaimer", largeImagePath);

        new Select(tool.searchUsingID(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("MANUFACTURERS") + ":selectOne")).selectByVisibleText(manufacturer);

        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("WAREHOUSE_NUMBER") + ":longString", warehouse);
        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("TERMS_AND_CONDITIONS") + ":longString", 
                "CSS_PQA Terms And Conditions");
        tool.driver.findElement(By.id("mainPanel:productForm:attributeList:" + this.selectFirstIDs("Cable") + ":choiceMany:" + this.selectSecondIDs("Cable") + ":selected"))
                .click();
        tool.driver.findElement(
                By.id("mainPanel:productForm:attributeList:" + this.selectFirstIDs("GSM Mobile") + ":choiceMany:" + this.selectSecondIDs("GSM Mobile") + ":selected")).click();

        tool.clickUsingID(tool, "mainPanel:productForm:b_updateAttributes");

        assertTrue(this.getAttributeState().matches("^[\\s\\S]*Attribute values updated[\\s\\S]*$"));

        System.out.println("Attribute values updated");
    }

    public String selectFirstIDs(String OfferName) throws Exception {
        String str = tool.driver.getPageSource();
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
        String str = tool.driver.getPageSource();
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
        Date date = new Date();
        SimpleDateFormat myformat = new SimpleDateFormat("MM/dd/yy");
        System.out.println(myformat.format(date));

        Cell priceUSDCell = workSheet.getCell(9, rowCount);
        String priceUSD = priceUSDCell.getContents();

        Cell priceEURCell = workSheet.getCell(10, rowCount);
        String priceEUR = priceEURCell.getContents();

        tool.clickUsingName(tool, "mainPanel:productForm:productDetailsTabbedPane.7");

        this.SelectUSDCurrency();
        tool.clickUsingID(tool, "mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:price", priceUSD);
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:cancel");

        this.SelectEURCurrency();
        tool.clickUsingID(tool, "mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:price", priceEUR);
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:cancel");

        System.out.println("DevicePriceLists values updated");
    }

    public void editSubsidizing(Sheet workSheet, int rowCount) throws Exception {
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

        tool.clickUsingName(tool, "mainPanel:productForm:productDetailsTabbedPane.5");

        // Click on "Residential - Ultra Postpaid"
        // @TODO this link needs to be fixed - need to do string chop to
        // construct with good ID's
        tool.clickUsingXPath(tool, "//span[.= 'Residential - Ultra Postpaid']/../..//a");

        tool.enterStringUsingId(tool, "mainPanel:edit:fields:name", deviceName + SubsidizeString);
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:code", deviceCode + SubsidizeString);
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:shortDesc", deviceDesc + SubsidizeString);
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:description", deviceDesc + SubsidizeString);
        tool.clickUsingID(tool, "mainPanel:edit:buttons:createProduct");

        // Click on Prices tab
        tool.clickUsingName(tool, "mainPanel:productForm:productDetailsTabbedPane.7");

        this.SelectUSDCurrency();
        tool.clickUsingID(tool, "mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:price", priceUSD);
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:cancel");

        this.SelectEURCurrency();
        tool.clickUsingID(tool, "mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:price", priceEUR);
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:cancel");

        System.out.println("Subsidized values updated");
    }

    public void SelectEURCurrency() throws Exception {
        tool.clickUsingID(tool, "menu:mainForm:_idJsp5ToggleCollapsed");
        new Select(tool.searchUsingID(tool, "menu:mainForm:displayedCurrency")).selectByVisibleText("EUR");
        tool.clickUsingID(tool, "menu:mainForm:_idJsp5ToggleCollapsed");
    }

    public void SelectUSDCurrency() throws Exception {
        tool.clickUsingID(tool, "menu:mainForm:_idJsp5ToggleCollapsed");
        new Select(tool.searchUsingID(tool, "menu:mainForm:displayedCurrency")).selectByVisibleText("USD");
        tool.clickUsingID(tool, "menu:mainForm:_idJsp5ToggleCollapsed");
    }

    public void editVoiceDeviceCategories() throws Exception {
        tool.clickUsingName(tool, "mainPanel:productForm:productDetailsTabbedPane.9");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryTab:view_product_availability_in_categories:editListAvailabilityCategory");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryList:" + this.selectFirstIDs("CSS_PQA_Catalog") + ":attach");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryList:" + this.selectFirstIDs("DS_VOICE_DEVICES_PC") + ":attach");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryList:buttons:modifyList");

        System.out.println("VoiceDeviceCategories values updated");
    }

    public void editDataDeviceCategories() throws Exception {
        tool.clickUsingName(tool, "mainPanel:productForm:productDetailsTabbedPane.9");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryTab:view_product_availability_in_categories:editListAvailabilityCategory");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryList:" + this.selectFirstIDs("CSS_PQA_Catalog") + ":attach");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryList:" + this.selectFirstIDs("DS_DATA_DEVICES_PC") + ":attach");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryList:buttons:modifyList");

        System.out.println("DataDeviceCategories values updated");
    }

    public boolean createNewAccescoryProduct(Sheet workSheet, int rowCount) throws Exception {

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

        tool.enterStringUsingId(tool, "mainPanel:edit:fields:name", accessoryName);
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:code", accessoryCode);
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:shortDesc", accessoryDesc);
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:description", accessoryDesc);
        tool.clickUsingID(tool, "mainPanel:edit:buttons:createProduct");

        boolean ExistingAccessory = false;
        String pageSource = tool.driver.getPageSource();
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

        Cell smallImagePathCell = workSheet.getCell(4, rowCount);
        String smallImagePath = smallImagePathCell.getContents();

        Cell largeImagePathCell = workSheet.getCell(5, rowCount);
        String largeImagePath = largeImagePathCell.getContents();

        Cell manufacturerCell = workSheet.getCell(7, rowCount);
        String manufacturer = manufacturerCell.getContents();

        Cell warehouseCell = workSheet.getCell(9, rowCount);
        String warehouse = warehouseCell.getContents();

        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("SMALL_IMAGE_PATH") + ":contentRef", smallImagePath);

        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("LARGE_IMAGE_PATH") + ":contentRef", largeImagePath);

        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("SMALL_IMAGE_PATH") + ":simpleDisclaimer", smallImagePath);
        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("LARGE_IMAGE_PATH") + ":simpleDisclaimer", largeImagePath);

        new Select(tool.searchUsingID(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("MANUFACTURERS") + ":selectOne")).selectByVisibleText(manufacturer);

        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("WAREHOUSE_NUMBER") + ":longString", warehouse);
        tool.enterStringUsingId(tool, "mainPanel:productForm:attributeList:" + this.selectFirstIDs("TERMS_AND_CONDITIONS") + ":longString", 
                "CSS_PQA Terms And Conditions");

        tool.clickUsingID(tool, "mainPanel:productForm:b_updateAttributes");

        assertTrue(this.getAttributeState().matches("^[\\s\\S]*Attribute values updated[\\s\\S]*$"));

        System.out.println("Attribute values updated");
    }

    public void editAccessoryPriceLists(Sheet workSheet, int rowCount) throws Exception {

        Date date = new Date();
        SimpleDateFormat myformat = new SimpleDateFormat("MM/dd/yy");
        System.out.println(myformat.format(date));

        Cell priceUSDCell = workSheet.getCell(10, rowCount);
        String priceUSD = priceUSDCell.getContents();

        Cell priceEURCell = workSheet.getCell(11, rowCount);
        String priceEUR = priceEURCell.getContents();

        tool.clickUsingName(tool, "mainPanel:productForm:productDetailsTabbedPane.7");

        this.SelectUSDCurrency();
        tool.clickUsingID(tool, "mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:price", priceUSD);
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:cancel");

        this.SelectEURCurrency();
        tool.clickUsingID(tool, "mainPanel:productForm:priceTab:view_product_prices:defaultPricesList:0:editDefaultPrices");
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:price", priceEUR);
        tool.enterStringUsingId(tool, "mainPanel:productForm:priceList:0:startDate", myformat.format(date));
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:modifyPriceList");
        tool.clickUsingID(tool, "mainPanel:productForm:priceList:buttons:cancel");

        System.out.println("DevicePriceLists values updated");
    }

    public void editAccessoryCategories() throws Exception {
        tool.clickUsingName(tool, "mainPanel:productForm:productDetailsTabbedPane.9");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryTab:view_product_availability_in_categories:editListAvailabilityCategory");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryList:" + this.selectFirstIDs("CSS_PQA_Catalog") + ":attach");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryList:" + this.selectFirstIDs("DS_DATA_ACCESSORIES_PC") + ":attach");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryList:" + this.selectFirstIDs("DS_PHONE_ACCESSORIES_PC") + ":attach");
        tool.clickUsingID(tool, "mainPanel:productForm:categoryList:buttons:modifyList");

        System.out.println("AccessoryCategories values updated");
    }

    public String getSessionIDFromUrl() throws Exception {
        String currentURL = tool.driver.getCurrentUrl();
        String sessionID[];

        sessionID = currentURL.split(";");

        return sessionID[1];
    }

}
