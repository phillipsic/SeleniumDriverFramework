package com.comverse.css.b2c.prod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.ChooseYourPrimaryOfferInThisAccountBundle;
import com.comverse.css.b2c.HomePage;
import com.comverse.css.b2c.Shopping;
import com.comverse.css.b2c.SubscriberBundleDetails;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.SB.SB_ResidentialBasicPrepaidBundle;
import com.comverse.data.apps.B2C;

public class PROD1400_View_Plan_Bundle_Details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testPROD1400_View_Plan_Bundle_Details() throws Exception {
        try {
            launchCSSApplication();
            SB_ResidentialBasicPrepaidBundle sb_ResidentialBasicPrepaidBundle = new SB_ResidentialBasicPrepaidBundle();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOfferInThisAccountBundle chooseYourPrimaryOfferInThisAccountBundle = shopping.clickFamilyPackLink();
            SubscriberBundleDetails subscriberBundleDetails = chooseYourPrimaryOfferInThisAccountBundle.viewDetailsOfPrimaryOffer(sb_ResidentialBasicPrepaidBundle.getOfferName());
            subscriberBundleDetails.clickTermsAndConditionsTab();

            // @TODO - need to replace hard coded string
            Common.assertTextOnPage(tool, "DIY - Super-Pack Terms and Conditions.");
            chooseYourPrimaryOfferInThisAccountBundle = subscriberBundleDetails.clickReturnToList();

            Common.assertTextOnPage(tool, sb_ResidentialBasicPrepaidBundle.getOfferName());

            // @TODO - More validation steps to be added.

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
