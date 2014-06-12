package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ShoppingCommon;

public class Shopping extends ShoppingCommon {

    public Shopping(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public MyBasket clickSelectOfferInPopUpWindow() throws Exception {

        super.clickSelectOfferInPopUpWindow();
        return new MyBasket(tool, test, user);
    }

    @Override
    public ConfigureBalance clickSelectOfferInPopUpWindowExpectingConfigureBalance() throws Exception {

        super.clickSelectOfferInPopUpWindowExpectingConfigureBalance();
        return new ConfigureBalance(tool, test, user);
    }

    @Override
    public ConfigureContractDetails clickSelectOfferInPopUpWindowExpectingConfigureContract() throws Exception {

        super.clickSelectOfferInPopUpWindowExpectingConfigureContract();
        return new ConfigureContractDetails(tool, test, user);
    }

    public ConfigureContractDetails subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(String accountBundle, String accountOffer,
            String optionalSubscriberBundle) throws Exception {
        super.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(accountBundle, accountOffer, optionalSubscriberBundle);
        return new ConfigureContractDetails(tool, test, user);
    }

    public ConfigureBalance subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureBalance(String accountBundle, String accountOffer,
            String optionalSubscriberBundle) throws Exception {
        super.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureBalance(accountBundle, accountOffer, optionalSubscriberBundle);
        return new ConfigureBalance(tool, test, user);
    }

    public SelectOffersForYourSubscriber subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingSelectOffersForSubscriber(String accountBundle, String accountOffer,
            String optionalSubscriberBundle, String... optionalSupplementaryOffersTable) throws Exception {
        super.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingSelectOffersForSubscriber(accountBundle, accountOffer, optionalSubscriberBundle,
                optionalSupplementaryOffersTable);
        return new SelectOffersForYourSubscriber(tool, test, user);
    }

    @Override
    public MyBasket selectHandset(String value) throws Exception {

        super.selectHandset(value);
        return new MyBasket(tool, test, user);
    }

    @Override
    public MyBasket selectAccessory(String value) throws Exception {

        super.selectAccessory(value);
        return new MyBasket(tool, test, user);
    }

    @Override
    public TestServiceAbility clickSelectOfferInPopUpWindowWithServiceAbility() throws Exception {

        super.clickSelectOfferInPopUpWindowWithServiceAbility();
        return new TestServiceAbility(tool, test, user);
    }

    @Override
    public TestServiceAbility clickNotEligibleLink() throws Exception {

        super.clickNotEligibleLink();
        return new TestServiceAbility(tool, test, user);
    }

    @Override
    public SelectOffersForYourSubscriber clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber() throws Exception {

        super.clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber();
        return new SelectOffersForYourSubscriber(tool, test, user);
    }

    @Override
    public EnterYourSubscriptionDetails clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails() throws Exception {

        super.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
        return new EnterYourSubscriptionDetails(tool, test, user);
    }
}
