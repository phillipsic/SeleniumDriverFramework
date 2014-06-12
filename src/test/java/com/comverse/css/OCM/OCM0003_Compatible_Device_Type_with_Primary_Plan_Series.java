package com.comverse.css.OCM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.OCM;
import com.comverse.data.users.OCMPub;

public class OCM0003_Compatible_Device_Type_with_Primary_Plan_Series extends CSSTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new OCM();
        user = new OCMPub();
    }

    @Test
    public void testOCM0003_Compatible_Device_Type_with_Primary_Plan_Series() throws Exception {

        launchOCMApplicationAndGetBuildNumber();
        LoginPage loginPage = new LoginPage(tool, test, user);
        OCMApplication ocmApplication = loginPage.loginToOCM(user);

        ocmApplication.clickMenuManageCatalogs(application);

        // Open "Catalogs"
        tool.driver.findElement(By.id("mainPanel:treeForm:catalog-tree:0:t2")).click();
        // Open "Offer Series"
        tool.driver.findElement(By.id("mainPanel:treeForm:catalog-tree:0:1:t2")).click();
        // Click "Postpaid GSM Mobile"
        tool.driver.findElement(By.linkText("Postpaid GSM Mobile")).click();
        // Click "Manage Relationships with Product Types"
        tool.driver.findElement(By.linkText("Manage Relationships with Product Types")).click();

        // Click "Define Relationships with Product Types"
        tool.driver.findElement(By.linkText("Define Relationships with Product Types")).click();

        // Select "Compatible Device Type with Primary Offer Series"
        new Select(tool.driver.findElement(By.id("mainPanel:ruleKindForm:RuleKind"))).selectByVisibleText("Compatible Device Type with Primary Offer Series");

        // Check VOICE_DEVICE
        tool.driver.findElement(By.id("mainPanel:productForm:productTypeList:0__57a:attach")).click();
        // Check DATA_DEVICE
        tool.driver.findElement(By.id("mainPanel:productForm:productTypeList:1__57b:attach")).click();
        // Click Submit
        tool.driver.findElement(By.id("mainPanel:productForm:productTypeList:buttons:modifyList")).click();

        test.setResult("pass");
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
