package com.company.css.common.data;

import com.framework.common.AlreadyRunException;
import org.junit.Before;
import org.junit.Test;

import com.framework.app.common.CSSTest;
import com.framework.app.common.Prep;
import com.company.css.csr.AddressAdd;
import com.company.css.csr.AddressAdministration;
import com.company.css.csr.HomePageBackOffice;
import com.company.css.csr.InventoryAdministration;
import com.company.data.apps.CSR;
import com.company.data.users.BOGAdmin;
import org.junit.After;

public class DATA003_AddReferentialAddress extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new BOGAdmin();
    }

    @Test
    public void testDATA003_AddReferentialAddress() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            HomePageBackOffice homePageBackOffice = new HomePageBackOffice(tool, test, user);
            InventoryAdministration inventoryAdministration = homePageBackOffice.clickBackOffice();
            AddressAdministration addressAdministration = inventoryAdministration.clickAddressAdministration();
            AddressAdd addressAdd = addressAdministration.clickAdd();
            addressAdd.selectCountry("France");
            addressAdd.setCity("La Defense");
            addressAdd.setStreetName("Terrasses Boieldieu");
            addressAdd.setZipCode("92042");
            addressAdministration = addressAdd.clickOK();

            test.setResult("pass");
        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
