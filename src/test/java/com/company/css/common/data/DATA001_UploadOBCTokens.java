package com.company.css.common.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.app.common.Test;
import com.framework.app.common.Prep;
import com.company.css.csr.HomePageBackOffice;
import com.company.css.csr.InventoryAdministration;
import com.company.css.csr.TokenAdministration;
import com.company.css.csr.UploadToken;
import com.company.data.apps.CSR;
import com.company.data.users.BOGAdmin;

public class DATA001_UploadOBCTokens extends Test {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new BOGAdmin();
    }

    @Test
    public void testDATA001_UploadOBCTokens() throws Exception {

        // Make sure OUTBOUND_COMM is enabled before running this test.

        launchCSSApplicationAndSSOLogin();

        HomePageBackOffice homePageBackOffice = new HomePageBackOffice(tool, test, user);
        InventoryAdministration inventoryAdministration = homePageBackOffice.clickBackOffice();
        TokenAdministration tokenAdministration = inventoryAdministration.clickTokenAdministration();
        UploadToken uploadToken = tokenAdministration.clickUpload();

        uploadToken.selectFile("OBCData/Token4CaseCreation.csv");
        tokenAdministration = uploadToken.clickOk();
        uploadToken = tokenAdministration.clickUpload();

        uploadToken.selectFile("OBCData/Token4BasketSummary.csv");
        tokenAdministration = uploadToken.clickOk();

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
