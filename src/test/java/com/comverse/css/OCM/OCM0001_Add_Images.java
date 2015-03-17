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

import com.framework.app.common.CSSTest;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
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
        tool.clickUsingID("mainPanel:treeForm:ContentMgtTree:0:_idJsp19_link");
        // Click "Move this Folder"
        tool.clickUsingID("mainPanel:boxForm:folderSelection_ActionBox:actionList:folder:moveHierarchy");
        tool.enterStringUsingId("mainPanel:_idJsp28:mainfields:NewSubHierarchy", "/Images/");
        tool.clickUsingID("mainPanel:_idJsp28:buttons:moveHierarchy");
        Common.assertTextOnPage(tool, "Images");

        this.inputFile = "src\\test\\java\\com\\comverse\\css\\OCM\\Data\\images.xls";
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
            tool.clickUsingID("mainPanel:boxForm:folderSelection_ActionBox:actionList:mediaFiles:uploadMediaFile");
            ImageDetails = System.getProperty("user.dir") + "\\src\\test\\java\\com\\comverse\\css\\OCM\\Data\\Img\\" + cell.getContents();
            System.out.println(ImageDetails);

            tool.selectImage("mainPanel:edit:mainfields:file", ImageDetails);
            tool.clickUsingID("mainPanel:edit:buttons:upload");
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
