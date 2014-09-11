package com.comverse.css.csr.nsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid15DiscountICB;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class NSA0025_Update_administrative_data extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testNSA0025_Update_administrative_data() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            String uniqueTimeStamp = Common.generateTimeStamp();
            Account account = new Account(uniqueTimeStamp);
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            String accountLastname = Common.getLastNameOfPostPaidAccount();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);
            PO_ResidentialUltraPostpaid15DiscountICB po_ResidentialUltraPostpaid15DiscountICB = new PO_ResidentialUltraPostpaid15DiscountICB();

            accountDetails.getAccountNumber();
            CustomerAcquisitionCustomerDataReview customerAcquisitionCustomerDataReview = accountDetails.clickNewConvergentSubscriberOnExistingAccount();

            Common.assertTextOnPage(tool, "Please review the following customer data is correct");
            customerAcquisitionCustomerDataReview.clickEditCustomerIdentityAndContact();

            Common.assertTextOnPage(tool, "Update account contact informations");

            account.setBillingTitleProperty("Mr.");
            account.setBillingFirstNameProperty("SubFNModified");
            account.setBillingLastNameProperty("SubLNModified");
            account.setBillingGenderProperty("sex_male");
            account.setBillingEmailProperty("emailModified@email.com");
            account.setBillingPhoneProperty("01Modified");
            account.setBillingFaxProperty("06Modified");

            customerAcquisitionCustomerDataReview.setTitle(account.getBillingTitleProperty());
            customerAcquisitionCustomerDataReview.setFirstName(account.getBillingFirstNameProperty());
            customerAcquisitionCustomerDataReview.setLastName(account.getBillingLastNameProperty());
            customerAcquisitionCustomerDataReview.setGender(account.getBillingGenderProperty());
            customerAcquisitionCustomerDataReview.setEmail(account.getBillingEmailProperty());
            customerAcquisitionCustomerDataReview.setHomePhone(account.getBillingPhoneProperty());
            customerAcquisitionCustomerDataReview.setFax(account.getBillingFaxProperty());

            
            customerAcquisitionCustomerDataReview.clickContinue();

            UpdateAccountBillingAddressInformations updateAccountBillingAddressInformation = customerAcquisitionCustomerDataReview.clickEditAddressDetail();

            Common.assertTextOnPage(tool, "Update account billing address informations");

            account.setBillingStreetNameProperty("AcctaddModified");
            account.setBillingPostCodeProperty("AcctZipModified");
            account.setBillingCityProperty("AcctCityModified");
            account.setBillingHomeCountryProperty("France");

            updateAccountBillingAddressInformation.setAddress1(account.getBillingStreetNameProperty() + "1");
            updateAccountBillingAddressInformation.setAddress2(account.getBillingStreetNameProperty() + "2");
            updateAccountBillingAddressInformation.setAddress3(account.getBillingStreetNameProperty() + "3");
            updateAccountBillingAddressInformation.setAddress4(account.getBillingStreetNameProperty() + "4");
            updateAccountBillingAddressInformation.setHomeZip(account.getBillingPostCodeProperty());
            updateAccountBillingAddressInformation.setHomeCity(account.getBillingCityProperty());
            updateAccountBillingAddressInformation.setHomeCountry(account.getBillingHomeCountryProperty());

             customerAcquisitionCustomerDataReview = updateAccountBillingAddressInformation.clickContinue();

          
            customerAcquisitionCustomerDataReview.clickAccountContact();

         

            account.setBillingCustomerSocialSecurityNumberProperty("987654320");
            account.setBillingPurchaseOrderProperty("98765430");
            account.setBillingSalesCodeProperty("9876540");
            account.setBillingSecurityWordProperty("987650");
            account.setBillingSICCodeProperty("981");

            customerAcquisitionCustomerDataReview.setSocialSecurityNumber(account.getBillingCustomerSocialSecurityNumberProperty());
            customerAcquisitionCustomerDataReview.setPurchaseOrder(account.getBillingPurchaseOrderProperty());
            customerAcquisitionCustomerDataReview.setSalesCode(account.getBillingSalesCodeProperty());
            customerAcquisitionCustomerDataReview.setSecurityWord(account.getBillingSecurityWordProperty());
            customerAcquisitionCustomerDataReview.setSICCode(account.getBillingSICCodeProperty());

            customerAcquisitionCustomerDataReview.clickContinue();

           

            Shopping shopping = customerAcquisitionCustomerDataReview.clickContinue();
            shopping.filterSubscriberBundlePrimaryOfferByName(po_ResidentialUltraPostpaid15DiscountICB.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid15DiscountICB.getOfferName());
            ConfigureBalance configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid15DiscountICB.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid15DiscountICB
                    .getBAL_GPRS_WAP_INTERNET().getBalanceValue());
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();
            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid15DiscountICB.getOfferName());
            myBasket.assign3InventoriesFirstOffer(subscriber);
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            Common.assertTextOnPage(tool, "Your order has been submitted.");
            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            accountDetails = checkoutConfirmation.clickOkExpectingAccountDashboard();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.clickSearch();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();

            requestsForCustomer.clickOnOrderNumberLink(orderNumber);

            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid15DiscountICB.getOfferName());

            Common.assertTextOnPage(tool, account.getBillingTitleProperty());
            Common.assertTextOnPage(tool, account.getBillingFirstNameProperty());
            Common.assertTextOnPage(tool, account.getBillingLastNameProperty());
            Common.assertTextOnPage(tool, account.getBillingEmailProperty());
            Common.assertTextOnPage(tool, account.getBillingPhoneProperty());
            Common.assertTextOnPage(tool, account.getBillingFaxProperty());
            Common.assertTextOnPage(tool, account.getBillingStreetNameProperty() + "1");
            Common.assertTextOnPage(tool, account.getBillingStreetNameProperty() + "2");
            Common.assertTextOnPage(tool, account.getBillingStreetNameProperty() + "3");
            Common.assertTextOnPage(tool, account.getBillingStreetNameProperty() + "4");
            Common.assertTextOnPage(tool, account.getBillingPostCodeProperty());
            Common.assertTextOnPage(tool, account.getBillingCityProperty());
            Common.assertTextOnPage(tool, account.getBillingHomeCountryProperty());

            Common.assertTextOnPage(tool, account.getBillingCustomerSocialSecurityNumberProperty());
            Common.assertTextOnPage(tool, account.getBillingPurchaseOrderProperty());
            Common.assertTextOnPage(tool, account.getBillingSalesCodeProperty());
            Common.assertTextOnPage(tool, account.getBillingSecurityWordProperty());
            Common.assertTextOnPage(tool, account.getBillingSICCodeProperty());

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