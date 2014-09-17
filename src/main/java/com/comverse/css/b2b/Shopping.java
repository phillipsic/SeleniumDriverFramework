package com.comverse.css.b2b;

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

    // @Override
    // public ConfigureContractDetails
    // clickSelectOfferInPopUpWindowExpectingConfigureContract() throws
    // Exception {
    //
    // super.clickSelectOfferInPopUpWindowExpectingConfigureContract();
    // return new ConfigureContractDetails(tool, test, user);
    // }

    // @Override
    // public ConfigureContractDetails
    // subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(String
    // accountBundle,
    // String accountOffer,
    // String optionalSubscriberBundle)
    // throws Exception { test.writeInLog(Common.getMethodName());
    // super.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(accountBundle,
    // accountOffer, optionalSubscriberBundle);
    // return new ConfigureContractDetails(tool, test, user);
    // }

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

    // @Override
    // public TestServiceAbility
    // clickSelectOfferInPopUpWindowWithServiceAbility() throws Exception {
    // test.writeInLog(Common.getMethodName());
    //
    // super.clickSelectOfferInPopUpWindowWithServiceAbility();
    // return new TestServiceAbility(tool, test, user);
    // }
    //
    // @Override
    // public TestServiceAbility clickNotEligibleLink() throws Exception {
    // test.writeInLog(Common.getMethodName());
    //
    // super.clickNotEligibleLink();
    // return new TestServiceAbility(tool, test, user);
    // }

    // @Override
    // public SelectOffersForYourSubscriber
    // subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingSelectOffers(String
    // accountBundle,
    // String accountOffer,
    // String optionalSubscriberBundle)
    // throws Exception { test.writeInLog(Common.getMethodName());
    //
    // super.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingSelectOffers(accountBundle,
    // accountOffer, optionalSubscriberBundle);
    // return new SelectOffersForYourSubscriber(tool, test, user);
    // }
}
