package com.company.css.OCM;

import com.company.css.OCM.LoginPage;
import com.company.css.OCM.OCMApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.app.common.AppTest;
import com.framework.app.common.Prep;
import com.company.data.apps.OCM;
import com.company.data.users.OCMPub;

public class OCM0003_Compatible_Device_Type_with_Primary_Plan_Series extends AppTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new OCM();
        user = new OCMPub();
    }

    @AppTest
    public void testOCM0003_Compatible_Device_Type_with_Primary_Plan_Series() throws Exception {

        launchOCMApplicationAndGetBuildNumber();
        LoginPage loginPage = new LoginPage(tool, test, user);
        OCMApplication ocmApplication = loginPage.loginToOCM(user);

        ocmApplication.clickMenuManageCatalogs(application);

        // Open "Catalogs"
        tool.clickUsingID("mainPanel:treeForm:catalog-tree:0:t2");
        // Open "Offer Series"
        tool.clickUsingID("mainPanel:treeForm:catalog-tree:0:1:t2");
        // Click "Postpaid GSM Mobile"
        tool.clickUsingLinkText("Postpaid GSM Mobile");
        // Click "Manage Relationships with Product Types"
        tool.clickUsingLinkText("Manage Relationships with Product Types");

        // Click "Define Relationships with Product Types"
        tool.clickUsingLinkText("Define Relationships with Product Types");

        // Select "Compatible Device Type with Primary Offer Series"
        tool.selectVisibleTextByID("mainPanel:ruleKindForm:RuleKind", "Compatible Device Type with Primary Offer Series");

        // Check VOICE_DEVICE
        tool.clickUsingID("mainPanel:productForm:productTypeList:0__57a:attach");
        // Check DATA_DEVICE
        tool.clickUsingID("mainPanel:productForm:productTypeList:1__57b:attach");
        // Click Submit
        tool.clickUsingID("mainPanel:productForm:productTypeList:buttons:modifyList");

        test.setResult("pass");
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
