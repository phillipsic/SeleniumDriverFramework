package com.company.css.common.data;

import com.framework.app.common.Subscriber;
import com.framework.app.common.Prep;
import com.framework.app.common.AppTest;
import com.framework.app.common.Common;
import com.framework.common.AlreadyRunException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.common.Application;
import com.framework.common.User;
import com.company.css.b2b.MyshapeBusiness;
import com.company.css.csr.*;
import com.company.css.data.PO.PO_BusinessHQEmployee;
import com.company.data.apps.B2B;
import com.company.data.apps.CSR;
import com.company.data.users.B2BAdmin;
import com.company.data.users.CSRAdmin;

public class DATA009_CreateB2BAccountAndAdmin extends AppTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @AppTest
    public void testDATA009_CreateB2BAccountAndAdmin() throws Exception {
        try {
            Application applicationtemp = application;
            launchCSSApplicationAndSSOLogin();
            PO_BusinessHQEmployee po_BusinessHQEmployee = new PO_BusinessHQEmployee();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentBusinessCustomer();

            enterIdentificationData.enterBusinessAccountIdentificationData();

            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.filterSubscriberBundlePrimaryOfferByName(po_BusinessHQEmployee.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(po_BusinessHQEmployee.getOfferName());
            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();
            myBasket.assign3InventoriesFirstOffer(subscriber);

            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, enterIdentificationData.getAccount());

            Common.storeBusinessAccountID(enterIdentificationData.getAccount().getBillingAccountIDProperty(), "Created by " + this.getClass().getSimpleName());

            workSpace = searchOrders.clickHomeMenu();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(enterIdentificationData.getAccount().getBillingAccountIDProperty());

            ViewHierarchy viewHierarchy = accountDetails.clickCustomerHierarchy();

            AddEmployeeContactInformation addEmployeeContactInformation = viewHierarchy.clickAddB2BEmployee();
            addEmployeeContactInformation.setFirstName("FN" + uniqueTimeStamp);
            addEmployeeContactInformation.setLastName("LN" + uniqueTimeStamp);

            AddEmployeeRegisterLogin addEmployeeRegisterLogin = addEmployeeContactInformation.clickContinue();

            user.setNewLogin(uniqueTimeStamp);
            addEmployeeRegisterLogin.enterLogin(user.getLogin());

            AddEmployeeConfirmation addEmployeeConfirmation = addEmployeeRegisterLogin.clickSubmit();
            RegisterLogin registerLogin = addEmployeeConfirmation.clickOk();
            user.setNewPassword(registerLogin.getTempPasswordFromPage());
            viewHierarchy = registerLogin.clickOk();

            viewHierarchy.clickLogoutExpectingSSO();

            Common.storeBusinessAdminLogin(user.getLogin(), "Created by " + this.getClass().getSimpleName());
            Common.storeBusinessAdminPassword(user.getPassword(), "Created by " + this.getClass().getSimpleName());

            User B2BAdimUser = new B2BAdmin();
            application = new B2B();
            launchCSSApplicationOnly();
            application = applicationtemp;
            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, B2BAdimUser);

            loginPage.loginWithChangeOfPassword(B2BAdimUser.getLogin(), B2BAdimUser.getPassword());
            loginPage.setYourPassword(B2BAdimUser.getPassword());
            B2BAdimUser.setNewPassword("Passw0rd!");
            loginPage.setNewPassword(B2BAdimUser.getPassword());
            loginPage.setConfirmNewPassword(B2BAdimUser.getPassword());
            loginPage.setSecretAnswer(B2BAdimUser.getPassword());
            loginPage.clickChangeButton();

            Common.storeBusinessAdminLogin(B2BAdimUser.getLogin(), "Created by " + this.getClass().getSimpleName());
            Common.storeBusinessAdminPassword(B2BAdimUser.getPassword(), "Created by " + this.getClass().getSimpleName());

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
