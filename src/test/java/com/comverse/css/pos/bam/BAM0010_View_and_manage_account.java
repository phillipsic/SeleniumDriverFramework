package com.comverse.css.pos.bam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class BAM0010_View_and_manage_account extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testBAM0010_View_and_manage_account() throws Exception {
        try {

            launchCSSApplication();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());

            AccountDetails accountDetails = customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());

            ModifyContactInformation modifyContactInformation = accountDetails.clickModifyBillingContact();

            assertEquals(workSpace.getAccount().getBillingFirstNameProperty(), modifyContactInformation.getFirstName());
            assertEquals(workSpace.getAccount().getBillingLastNameProperty(), modifyContactInformation.getLastName());
            assertEquals("Billing55  BillingStreet", modifyContactInformation.getAddressLineOne().trim());
            assertEquals(workSpace.getAccount().getBillingPostCodeProperty(), modifyContactInformation.getZipCode());
            assertEquals(workSpace.getAccount().getBillingCityProperty(), modifyContactInformation.getCity());

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
