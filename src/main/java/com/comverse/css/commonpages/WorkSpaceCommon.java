package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.data.PO.PO_DIYRechargesPromotions;
import com.comverse.css.data.PO.PO_DIYRechargesPromotions2;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.css.data.SB.SB_ResidentialBasicPrepaidBundle;

public class WorkSpaceCommon extends CommonMenu {

    public WorkSpaceCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Welcome to Your Workspace";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getHomePageWelcomeMessage() throws Exception {

        return tool.getTextUsingXPath(tool, "/html/body/h1");
    }

    public EnterIdentificationDataCommon startNewConvergentResidentialCustomer() throws Exception {

        tool.clickUsingLinkText(tool, "New Convergent Residential Customer");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterIdentificationDataCommon(tool, test, user);
    }

    public EnterIdentificationDataCommon startNewConvergentBusinessCustomer() throws Exception {

        tool.clickUsingLinkText(tool, "New Convergent Business Customer");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterIdentificationDataCommon(tool, test, user);
    }

    public EnterIdentificationDataCommon startNewPrePaidBusinessCustomer() throws Exception {

        tool.clickUsingLinkText(tool, "New Pure Prepaid Business Customer");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterIdentificationDataCommon(tool, test, user);
    }

    public WorkSpaceCommon doResitdentialNCAResidentialUltraPostpaidPOS() throws Exception {
        PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
        EnterIdentificationDataCommon enterIdentificationData = this.startNewConvergentResidentialCustomer();

        account = enterIdentificationData.enterDefaultIdentificationData();
        person = enterIdentificationData.getPerson();
        subscriber = enterIdentificationData.getSubscriber();

        ShoppingCommon shopping = enterIdentificationData.clickContinue();

        shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
        ConfigureBalanceCommon configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();
        configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                .getBalanceValue());
        MyBasketCommon myBasket = configureBalance.clickContinueExpectingMyBasket();
        myBasket.assign3InventoriesFirstOffer(subscriber);

        person2 = myBasket.addConsumerUserPersonOrdering();

        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();

        String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
        WorkSpaceCommon workSpaceCommon = checkoutConfirmation.clickOk();

        setAccount(account);
        setPerson(person);
        setSubscriber(subscriber);

        SearchRequestsCommon searchRequests = workSpaceCommon.clickRequests();
        SearchOrdersCommon searchOrders = searchRequests.clickSearchOrders();
        searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
        Common.storeLastNamePostpaidAccount(account.getBillingLastNameProperty(), "Created in doResitdentialNCAResidentialUltraPostpaidPOS");
        searchOrders.clickHomeMenu();

        return workSpaceCommon;
    }

    public WorkSpaceCommon doResitdentialNCAResidentialBasicPrepaidBundlePOS() throws Exception {

        String SUBSCRIBER_BUNDLE = "Residential - Basic Prepaid Bundle";
        EnterIdentificationDataCommon enterIdentificationData = this.startNewConvergentResidentialCustomer();

        account = enterIdentificationData.enterDefaultIdentificationData();
        person = enterIdentificationData.getPerson();
        subscriber = enterIdentificationData.getSubscriber();

        ShoppingCommon shopping = enterIdentificationData.clickContinue();

        shopping.clickSubscriberBundlePrimaryOfferName(SUBSCRIBER_BUNDLE);

        MyBasketCommon myBasket = shopping.clickSelectOfferInPopUpWindow();

        myBasket.assign3InventoriesFirstOffer(subscriber);

        myBasket.addConsumerUserPersonOrdering();

        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();

        String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
        WorkSpaceCommon workSpaceCommon = checkoutConfirmation.clickOk();

        setAccount(account);
        setPerson(person);
        setSubscriber(subscriber);

        SearchRequestsCommon searchRequests = workSpaceCommon.clickRequests();
        SearchOrdersCommon searchOrders = searchRequests.clickSearchOrders();
        searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
        Common.storeLastNameAndAccountNumberPrepaidAccount(account.getBillingLastNameProperty(), account.getBillingAccountIDProperty(),
                "Created in doResitdentialNCAResidentialBasicPrepaidBundleCSR");
        searchOrders.clickHomeMenu();

        return workSpaceCommon;
    }

    public WorkSpaceCommon doResitdentialNCAResidentialBasicPrepaidWithSOPOS(String SUPPLEMENTARY_OFFER) throws Exception {

        String PRIMARY_OFFER = "Residential - Basic Prepaid";
        EnterIdentificationDataCommon enterIdentificationData = this.startNewConvergentResidentialCustomer();

        account = enterIdentificationData.enterDefaultIdentificationData();
        person = enterIdentificationData.getPerson();
        subscriber = enterIdentificationData.getSubscriber();

        ShoppingCommon shopping = enterIdentificationData.clickContinue();

        shopping.clickSubscriberBundlePrimaryOfferName(PRIMARY_OFFER);

        MyBasketCommon myBasket = shopping.clickSelectOfferInPopUpWindow();

        myBasket.assign3InventoriesFirstOffer(subscriber);

        myBasket.addConsumerUserPersonOrdering();
        SelectOffersForYourSubscriberCommon selectOffersForYourSubscriber = myBasket.clickAddSO();
        selectOffersForYourSubscriber.selectOffersForSubscriber(SUPPLEMENTARY_OFFER);
        ConfigureOffersCommon configureOffers = selectOffersForYourSubscriber.clickContinue();
        ServiceConnectionDetailsCommon serviceConnectionDetails = configureOffers.clickContinueExpectingServiceConnectionDetails();
        serviceConnectionDetails.clickOk();
        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();

        String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
        WorkSpaceCommon workSpaceCommon = checkoutConfirmation.clickOk();

        setAccount(account);
        setPerson(person);
        setSubscriber(subscriber);

        SearchRequestsCommon searchRequests = workSpaceCommon.clickRequests();
        SearchOrdersCommon searchOrders = searchRequests.clickSearchOrders();
        searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, account);
        searchOrders.clickHomeMenu();

        return workSpaceCommon;
    }

    public WorkSpaceCommon doResitdentialNCAResidentialUltraPostpaidCSR() throws Exception {
        PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
        EnterIdentificationDataCommon enterIdentificationData = this.startNewConvergentResidentialCustomer();

        account = enterIdentificationData.enterDefaultIdentificationData();
        person = enterIdentificationData.getPerson();
        subscriber = enterIdentificationData.getSubscriber();

        ShoppingCommon shopping = enterIdentificationData.clickContinue();

        shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
        ConfigureBalanceCommon configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();
        configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                .getBalanceValue());
        MyBasketCommon myBasket = configureBalance.clickContinueExpectingMyBasket();
        myBasket.assign3InventoriesFirstOffer(subscriber);

        person2 = myBasket.addConsumerUserPersonOrdering();

        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();

        String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
        WorkSpaceCommon workSpaceCommon = checkoutConfirmation.clickOk();

        setAccount(account);
        setPerson(person);
        setPerson2(person2);
        setSubscriber(subscriber);

        SearchRequestsCommon searchRequests = workSpaceCommon.clickRequests();
        SearchOrdersCommon searchOrders = searchRequests.clickSearchOrders();
        searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
        ServiceOrderDetailsCommon serviceDetails = searchOrders.clickViewDetails();
        serviceDetails.getAccountID(account);
        searchOrders = serviceDetails.clickBack();
        Common.storeLastNamePostpaidAccount(account.getBillingLastNameProperty(), "Created in doResitdentialNCAResidentialUltraPostpaidCSR");
        searchOrders.clickHomeMenu();

        return workSpaceCommon;
    }

    public WorkSpaceCommon doResitdentialNCAResidentialBasicPrepaidBundleCSR() throws Exception {
        SB_ResidentialBasicPrepaidBundle sb_ResidentialBasicPrepaidBundle = new SB_ResidentialBasicPrepaidBundle();
        EnterIdentificationDataCommon enterIdentificationData = this.startNewConvergentResidentialCustomer();

        account = enterIdentificationData.enterDefaultIdentificationData();
        person = enterIdentificationData.getPerson();
        subscriber = enterIdentificationData.getSubscriber();

        ShoppingCommon shopping = enterIdentificationData.clickContinue();

        shopping.clickSubscriberBundlePrimaryOfferName(sb_ResidentialBasicPrepaidBundle.getOfferName());

        MyBasketCommon myBasket = shopping.clickSelectOfferInPopUpWindow();

        myBasket.assign3InventoriesFirstOffer(subscriber);

        myBasket.addConsumerUserPersonOrdering();

        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();

        String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
        WorkSpaceCommon workSpaceCommon = checkoutConfirmation.clickOk();

        setAccount(account);
        setPerson(person);
        setSubscriber(subscriber);

        SearchRequestsCommon searchRequests = workSpaceCommon.clickRequests();
        SearchOrdersCommon searchOrders = searchRequests.clickSearchOrders();
        searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, account);
        Common.storeLastNameAndAccountNumberPrepaidAccount(account.getBillingLastNameProperty(), account.getBillingAccountIDProperty(),
                "Created in doResitdentialNCAResidentialBasicPrepaidBundleCSR");
        searchOrders.clickHomeMenu();

        return workSpaceCommon;
    }

    public WorkSpaceCommon doResitdentialNCADIYRechargesPromotionsCSR() throws Exception {
        PO_DIYRechargesPromotions po_DIYRechargesPromotions = new PO_DIYRechargesPromotions();
        EnterIdentificationDataCommon enterIdentificationData = this.startNewConvergentResidentialCustomer();

        account = enterIdentificationData.enterDefaultIdentificationData();
        person = enterIdentificationData.getPerson();
        subscriber = enterIdentificationData.getSubscriber();

        ShoppingCommon shopping = enterIdentificationData.clickContinue();

        shopping.clickSubscriberBundlePrimaryOfferName(po_DIYRechargesPromotions.getOfferName());

        MyBasketCommon myBasket = shopping.clickSelectOfferInPopUpWindow();

        myBasket.assign1InventoryFirstOffer(subscriber);

        myBasket.addConsumerUserPersonOrdering();

        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();

        String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
        WorkSpaceCommon workSpaceCommon = checkoutConfirmation.clickOk();

        setAccount(account);
        setPerson(person);
        setSubscriber(subscriber);

        SearchRequestsCommon searchRequests = workSpaceCommon.clickRequests();
        SearchOrdersCommon searchOrders = searchRequests.clickSearchOrders();
        searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, account);
        Common.storeLastNameAndAccountNumberPrepaidAccount(account.getBillingLastNameProperty(), account.getBillingAccountIDProperty(),
                "Created in doResitdentialNCAResidentialBasicPrepaidBundleCSR");
        searchOrders.clickHomeMenu();

        return workSpaceCommon;
    }

    public WorkSpaceCommon doResitdentialNCADIYRechargesPromotions2CSR() throws Exception {
        PO_DIYRechargesPromotions2 po_DIYRechargesPromotions2 = new PO_DIYRechargesPromotions2();
        EnterIdentificationDataCommon enterIdentificationData = this.startNewConvergentResidentialCustomer();

        account = enterIdentificationData.enterDefaultIdentificationData();
        person = enterIdentificationData.getPerson();
        subscriber = enterIdentificationData.getSubscriber();

        ShoppingCommon shopping = enterIdentificationData.clickContinue();

        shopping.clickSubscriberBundlePrimaryOfferName(po_DIYRechargesPromotions2.getOfferName());

        MyBasketCommon myBasket = shopping.clickSelectOfferInPopUpWindow();

        myBasket.assign1InventoryFirstOffer(subscriber);

        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();

        String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
        WorkSpaceCommon workSpaceCommon = checkoutConfirmation.clickOk();

        setAccount(account);
        setPerson(person);
        setSubscriber(subscriber);

        SearchRequestsCommon searchRequests = workSpaceCommon.clickRequests();
        SearchOrdersCommon searchOrders = searchRequests.clickSearchOrders();
        searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, account);

        searchOrders.clickHomeMenu();

        return workSpaceCommon;
    }

    public ViewHierarchyCommon clickManageTelco() throws Exception {
        tool.clickUsingID(tool, "mnu_TELCO");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewHierarchyCommon(tool, test, user);
    }

    public WorkSpaceCommon doResitdentialNCAResidentialBasicPrepaidWithSOCSR(String SUPPLEMENTARY_OFFER) throws Exception {
        PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
        EnterIdentificationDataCommon enterIdentificationData = this.startNewConvergentResidentialCustomer();

        account = enterIdentificationData.enterDefaultIdentificationData();
        person = enterIdentificationData.getPerson();
        subscriber = enterIdentificationData.getSubscriber();

        ShoppingCommon shopping = enterIdentificationData.clickContinue();

        shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialBasicPrepaid.getOfferName());

        MyBasketCommon myBasket = shopping.clickSelectOfferInPopUpWindow();

        myBasket.assign3InventoriesFirstOffer(subscriber);

        myBasket.addConsumerUserPersonOrdering();
        SelectOffersForYourSubscriberCommon selectOffersForYourSubscriber = myBasket.clickAddSO();
        selectOffersForYourSubscriber.selectOffersForSubscriber(SUPPLEMENTARY_OFFER);
        ConfigureOffersCommon configureOffers = selectOffersForYourSubscriber.clickContinue();
        ServiceConnectionDetailsCommon serviceConnectionDetails = configureOffers.clickContinueExpectingServiceConnectionDetails();
        serviceConnectionDetails.clickOk();
        CheckoutReviewCommon checkoutReview = myBasket.clickCheckOut();
        CheckoutConfirmationCommon checkoutConfirmation = checkoutReview.clickConfirm();

        String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
        WorkSpaceCommon workSpaceCommon = checkoutConfirmation.clickOk();

        setAccount(account);
        setPerson(person);
        setSubscriber(subscriber);

        SearchRequestsCommon searchRequests = workSpaceCommon.clickRequests();
        SearchOrdersCommon searchOrders = searchRequests.clickSearchOrders();
        searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, account);
        searchOrders.clickHomeMenu();

        return workSpaceCommon;
    }

    public void clickBrowseCatalog() throws Exception {
        tool.clickUsingLinkText(tool, "Browse Catalog");
    }

    public void selectCustomerType(String customerType) throws Exception {
        tool.selectVisibleTextByID(tool, "orgTypeId", customerType);
    }

    public ShoppingCommon clickSubmit() throws Exception {

        tool.clickUsingXPath(tool, "(//input[@value='Submit'])");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }
}
