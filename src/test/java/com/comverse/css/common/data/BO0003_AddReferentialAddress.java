package com.comverse.css.common.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.AddressAdd;
import com.comverse.css.csr.AddressAdministration;
import com.comverse.css.csr.HomePageBackOffice;
import com.comverse.css.csr.InventoryAdministration;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.BOGAdmin;

public class BO0003_AddReferentialAddress extends CSSTest {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new BOGAdmin();
    }

    @Test
    public void testBO0003_AddReferentialAddress() throws Exception {

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
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
