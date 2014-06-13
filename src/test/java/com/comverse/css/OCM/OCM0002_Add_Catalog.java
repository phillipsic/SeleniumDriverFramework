package com.comverse.css.OCM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.OCM;
import com.comverse.data.users.OCMPub;

public class OCM0002_Add_Catalog extends CSSTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new OCM();
        user = new OCMPub();
    }

    @Test
    public void testOCM0002_Add_Catalog() throws Exception {

        String productName = "CSS_PQA_Catalog40";
        String productCode = "CSS_PQA_Catalog40";
        String productDescription = "CSS_PQA_Catalog40";

        launchOCMApplicationAndGetBuildNumber();

        LoginPage loginPage = new LoginPage(tool, test, user);
        OCMApplication ocmApplication = loginPage.loginToOCM(user);
        ocmApplication.getSessionIDFromUrl();

        ocmApplication.clickMenuManageCatalogs(application);

        tool.driver.findElement(By.id("mainPanel:treeForm:catalog-tree:0:t2")).click();
        tool.driver.findElement(By.id("mainPanel:treeForm:catalog-tree:0:0:_idJsp18_link")).click();
        // click "Create New Catalog"
        tool.driver.findElement(By.id("mainPanel:boxForm:actionBox:actionList:entityType:add")).click();
        
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:name", productName);
        
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:code", productCode);
        
        tool.enterStringUsingId(tool, "mainPanel:edit:fields:description", productDescription);
        tool.driver.findElement(By.id("mainPanel:edit:buttons:createProductCategory")).click();

        test.setResult("pass");
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
