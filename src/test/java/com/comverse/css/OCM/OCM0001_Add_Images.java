package com.comverse.css.OCM;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.OCM;
import com.comverse.data.users.OCMPub;

public class OCM0001_Add_Images extends CSSTest {
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
    public void testOCM0001_Add_Images() throws Exception {

        launchOCMApplicationAndGetBuildNumber();
        Date date = new Date();
        SimpleDateFormat myformat = new SimpleDateFormat("MM/dd/yy");
        System.out.println(myformat.format(date));

        LoginPage loginPage = new LoginPage(tool, test, user);
        OCMApplication ocmApplication = loginPage.loginToOCM(user);

        ocmApplication.clickMenuManageMediaFiles(application);

        // Click "Root Content"
        tool.driver.findElement(By.id("mainPanel:treeForm:ContentMgtTree:0:_idJsp19_link")).click();
        // Click "Move this Folder"
        tool.driver.findElement(By.id("mainPanel:boxForm:folderSelection_ActionBox:actionList:folder:moveHierarchy")).click();
        tool.enterStringUsingId(tool, "mainPanel:_idJsp28:mainfields:NewSubHierarchy", "/Images/");
        tool.driver.findElement(By.id("mainPanel:_idJsp28:buttons:moveHierarchy")).click();
        Common.assertTextOnPage(tool, "Images");

        this.inputFile = "test\\com\\comverse\\css\\OCM\\Data\\images.xls";
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String[][] contents;
        contents = new String[10][2];

        w = Workbook.getWorkbook(inputWorkbook);
        // Get the first sheet
        Sheet sheet = w.getSheet(0);

        int j = 0;
        String ImageDetails;

        for (int i = 1; i < sheet.getRows(); i++) {

            Cell cell = sheet.getCell(j, i);
            contents[i][j] = cell.getContents();
            System.out.println("I got a label " + cell.getContents());
            // Click "Upload Media Files in this Folder"
            tool.driver.findElement(By.id("mainPanel:boxForm:folderSelection_ActionBox:actionList:mediaFiles:uploadMediaFile")).click();
            ImageDetails = System.getProperty("user.dir") + "\\test\\com\\comverse\\css\\OCM\\Data\\Img\\" + cell.getContents();
            System.out.println(ImageDetails);

            // Thread.sleep(4000);
            // => Line not converted yet:
            // selenium.focus("mainPanel:edit:mainfields:file");
            // tool.enterStringUsingId(tool, "fileUpload", path +
            // locationOfFile);
            tool.enterStringUsingId(tool, "mainPanel:edit:mainfields:file", ImageDetails);
            tool.driver.findElement(By.id("mainPanel:edit:buttons:upload")).click();
            Common.assertTextOnPage(tool, "1 media files uploaded successfully");
        }

        Common.assertTextOnPage(tool, "Displaying 8 media files from 1 to 8 of 8 media files.");

        test.setResult("pass");
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
