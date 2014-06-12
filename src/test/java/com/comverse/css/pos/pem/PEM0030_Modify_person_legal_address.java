package com.comverse.css.pos.pem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PEM0030_Modify_person_legal_address extends CSSTest {
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
    public void testPEM0030_Modify_person_legal_address() throws Exception {

        try {
            launchCSSApplication();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());
            AccountDetails accountDetails = customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());

            PersonDetails personDetails = accountDetails.clickUpdatePerson();

            workSpace.getPerson().setPersonHomeCountryProperty("France");
            workSpace.getPerson().setPersonStreetNumberProperty("Person66");
            workSpace.getPerson().setPersonStreetNameProperty("PersonStreet2");
            workSpace.getPerson().setPersonCityProperty("PersonCity2");
            workSpace.getPerson().setPersonPostCodeProperty("PersonPostcode2");

            personDetails.setAddressLine1(workSpace.getPerson().getPersonStreetNameProperty() + workSpace.getPerson().getPersonStreetNumberProperty());
            personDetails.setPostCode(workSpace.getPerson().getPersonPostCodeProperty());
            personDetails.setCity(workSpace.getPerson().getPersonCityProperty());
            personDetails.selectHomeCountry(workSpace.getPerson().getPersonHomeCountryProperty());

            personDetails.clickUpdate();

            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonStreetNameProperty());

            accountDetails.clickUpdatePerson();

            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonHomeCountryProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonStreetNumberProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonStreetNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonCityProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonPostCodeProperty());

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
