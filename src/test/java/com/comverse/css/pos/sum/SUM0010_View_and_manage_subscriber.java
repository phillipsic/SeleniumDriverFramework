package com.comverse.css.pos.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.IdentifyCustomer;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.WorkSpace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class SUM0010_View_and_manage_subscriber extends CSSTest {
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
    public void testSUM0010_View_and_manage_subscriber() throws Exception {

        try {
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.searchBySubscriberMSISDNMultiplePersons(workSpace.getSubscriber().getSubscriberMSISDNProperty());
            identifyCustomer.clickSubscriberLink(workSpace.getSubscriber().getSubscriberMSISDNProperty());

            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonTitleProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonFirstNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonLastNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonStreetNumberProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonStreetNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonPostCodeProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonCityProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonHomeStateProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonHomeCountryProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonLanguageProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonDateOfBirthProperty());

            // Common.assertTextOnPage(tool,
            // workSpace.getAccount().getBillingAccountIDProperty());
            Common.assertTextOnPage(tool, workSpace.getAccount().getBillingFirstNameProperty());
            Common.assertTextOnPage(tool, workSpace.getAccount().getBillingLastNameProperty());

            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberLastNameProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberFirstNameProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberStreetNumberProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberStreetNameProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberPostCodeProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberCityProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberHomeStateProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberHomeCountryProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberMSISDNProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberIMSIProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberSIMProperty());

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            // e.printStackTrace();
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