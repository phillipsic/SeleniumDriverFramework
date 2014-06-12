package com.comverse.css.OCM;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.OCM;
import com.comverse.data.users.OCMPub;

public class OCM0006_Add_Subsidized_Device extends CSSTest {
    private String inputFile;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new OCM();
        user = new OCMPub();
    }

    @Test
    public void testOCM0006_Add_Subsidized_Device() throws Exception {
        boolean DeviceAlreadyExist = false;

        launchOCMApplicationAndGetBuildNumber();
        LoginPage loginPage = new LoginPage(tool, test, user);
        OCMApplication ocmApplication = loginPage.loginToOCM(user);

        this.inputFile = "test\\com\\comverse\\css\\OCM\\Data\\DevicesSubsidized.xls";
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String DeviceType = "";

        w = Workbook.getWorkbook(inputWorkbook);
        Sheet sheet = w.getSheet(0);

        int rowCounter = 0;

        tool.driver.get(application.appURL() + "ocmweb/faces/catalog/product_by_type.jsp;" + ocmApplication.getSessionIDFromUrl());
        tool.driver.findElement(By.id("mainPanel:treeForm:type-tree:0:t2")).click();
        tool.driver.findElement(By.id("mainPanel:treeForm:type-tree:0:1:t2")).click();

        for (rowCounter = 1; rowCounter < sheet.getRows(); rowCounter++) {
            System.out.println("****************************************************");
            System.out.println("Device name: " + sheet.getCell(2, rowCounter).getContents());

            Cell cell = sheet.getCell(0, rowCounter);
            DeviceType = cell.getContents();

            DeviceAlreadyExist = false;

            if (DeviceType.equals("Voice Device")) {
                tool.driver.findElement(By.linkText("Voice Device")).click();
                tool.driver.findElement(By.linkText("Create New Voice Device")).click();
                System.out.println("Starting creation of New Voice Device");
            }

            if (DeviceType.equals("Data Device")) {
                tool.driver.findElement(By.linkText("Data Device")).click();
                tool.driver.findElement(By.linkText("Create New Data Device")).click();
                System.out.println("Starting creation of New Data Device");
            }

            DeviceAlreadyExist = ocmApplication.createNewDeviceProduct(sheet, rowCounter);

            if (DeviceAlreadyExist != true) {
                System.out.println("Starting edition of DeviceProductAttributes");
                ocmApplication.editDeviceProductAttributes(sheet, rowCounter);
                System.out.println("Starting edition of DevicePriceLists");
                ocmApplication.editDevicePriceLists(sheet, rowCounter);

                if (DeviceType.equals("Voice Device")) {
                    System.out.println("Starting edition of VoiceDeviceCategories");
                    ocmApplication.editVoiceDeviceCategories();
                }

                if (DeviceType.equals("Data Device")) {
                    System.out.println("Starting edition of DataDeviceCategories");
                    ocmApplication.editDataDeviceCategories();
                }

                System.out.println("Starting edition of Subsidizing");
                ocmApplication.editSubsidizing(sheet, rowCounter);
            }
            System.out.println("****************************************************");
        }

        test.setResult("pass");
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}