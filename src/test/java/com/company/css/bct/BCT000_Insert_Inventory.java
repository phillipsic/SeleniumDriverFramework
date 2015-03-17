package com.company.css.bct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.app.common.CSSTest;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
import com.company.css.csr.ActionDone;
import com.company.css.csr.HomePageBackOffice;
import com.company.css.csr.InsertInventory;
import com.company.css.csr.InventoryAdministration;
import com.company.data.apps.CSR;
import com.company.data.users.BOGAdmin;

public class BCT000_Insert_Inventory extends CSSTest {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new BOGAdmin();
    }

    @Test
    public void testBCT000_Insert_Inventory() throws Exception {
        launchCSSApplicationAndSSOLogin();
        String imsiSerialnumber, simSerialnumber, prepaidSerialnumber, normalSerialnumber;

        HomePageBackOffice homePageBackOffice = new HomePageBackOffice(tool, test, user);

        InventoryAdministration inventoryAdministration = homePageBackOffice.clickBackOffice();

        InsertInventory insertInventory = inventoryAdministration.clickInsertInventory();

        // 3g IMSI
        for (int invCounter = 0; invCounter < 5; invCounter++) {
            imsiSerialnumber = Common.get3GIMSISerialNumber();
            System.out.println("****************************************************");
            System.out.println("Inv 3G IMSI " + invCounter + " " + imsiSerialnumber);

            insertInventory.selectInventoryType("3G IMSI");
            insertInventory.setSerialNumber(imsiSerialnumber);
            ActionDone actionDone = insertInventory.clickInsert();
            Common.storeNext3GIMSISerialNumber();
            actionDone.clickBack();

            // 3g SIM
            simSerialnumber = Common.get3GSIMSerialNumber();
            System.out.println("****************************************************");
            System.out.println("Inv 3G SIM " + invCounter + " " + simSerialnumber);

            insertInventory.selectInventoryType("3G SIM");
            insertInventory.setSerialNumber(simSerialnumber);
            actionDone = insertInventory.clickInsert();
            Common.storeNext3GSIMSerialNumber();
            actionDone.clickBack();

            // Prepaid MSISDN

            prepaidSerialnumber = Common.getPrepaidMSISDNServicenumber();
            System.out.println("****************************************************");
            System.out.println("Inv Voice Prepaid MSISDN" + invCounter + " " + prepaidSerialnumber);

            insertInventory.selectInventoryType("Voice Prepaid MSISDN");
            insertInventory.setPrimaryNumber("185");
            insertInventory.setSecondaryNumber("655");
            insertInventory.setTertiaryNumber("53");
            insertInventory.setServiceNumber(prepaidSerialnumber);
            actionDone = insertInventory.clickInsert();
            Common.storeNextPrepaidMSISDNServicenumber();
            actionDone.clickBack();

            // Normal MSISDN
            normalSerialnumber = Common.getNormalMSISDNServicenumber();
            System.out.println("****************************************************");
            System.out.println("Inv Voice Normal MSISDN" + invCounter + " " + normalSerialnumber);

            insertInventory.selectInventoryType("Voice Normal MSISDN");
            insertInventory.setPrimaryNumber("185");
            insertInventory.setSecondaryNumber("666");
            insertInventory.setTertiaryNumber("63");
            insertInventory.setServiceNumber(normalSerialnumber);
            actionDone = insertInventory.clickInsert();
            Common.storeNextNormalMSISDNServicenumber();
            actionDone.clickBack();
        }
        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
