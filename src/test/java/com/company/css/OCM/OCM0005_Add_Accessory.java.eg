package com.company.css.OCM;

import com.company.css.OCM.LoginPage;
import com.company.css.OCM.OCMApplication;
import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.app.common.AppTest;
import com.framework.app.common.Prep;
import com.company.data.apps.OCM;
import com.company.data.users.OCMPub;

public class OCM0005_Add_Accessory extends AppTest {
    private String inputFile;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new OCM();
        user = new OCMPub();
    }

    @AppTest
    public void testOCM0005_Add_Accessory() throws Exception {
        boolean accessoryAlreadyExists = false;

        launchOCMApplicationAndGetBuildNumber();
        LoginPage loginPage = new LoginPage(tool, test, user);
        OCMApplication ocmApplication = loginPage.loginToOCM(user);

        this.inputFile = System.getProperty("user.dir") + "\\src\\test\\java\\com\\company\\css\\OCM\\Data\\Accessories.xls";
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String accessoryType = "";

        w = Workbook.getWorkbook(inputWorkbook);
        Sheet sheet = w.getSheet(0);

        int rowCounter = 0;

        tool.get(application.appURL() + "/faces/catalog/product_by_type.jsp;" + ocmApplication.getSessionIDFromUrl());
        tool.clickUsingID("mainPanel:treeForm:type-tree:0:t2");
        tool.clickUsingID("mainPanel:treeForm:type-tree:0:0:t2");

        for (rowCounter = 1; rowCounter < sheet.getRows(); rowCounter++) {
            System.out.println("****************************************************");
            System.out.println("Accessory name: " + sheet.getCell(2, rowCounter).getContents());

            Cell cell = sheet.getCell(0, rowCounter);
            accessoryType = cell.getContents();

            accessoryAlreadyExists = false;

            if (accessoryType.equals("Headset")) {
                tool.clickUsingLinkText("Headset");
                tool.clickUsingLinkText("Create New Headset");
                System.out.println("Starting creation of Create New Headset");
            }

            if (accessoryType.equals("Battery")) {
                tool.clickUsingLinkText("Battery");
                tool.clickUsingLinkText("Create New Battery");
                System.out.println("Starting creation of Create New Battery");
            }

            accessoryAlreadyExists = ocmApplication.createNewAccescoryProduct(sheet, rowCounter);

            if (accessoryAlreadyExists != true) {
                System.out.println("Starting edition of ProductAttributes");
                ocmApplication.editProductAttributes(sheet, rowCounter);
                System.out.println("Starting edition of PriceLists");
                ocmApplication.editAccessoryPriceLists(sheet, rowCounter);
                System.out.println("Starting edition of AccessoryCategories");
                ocmApplication.editAccessoryCategories();
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
