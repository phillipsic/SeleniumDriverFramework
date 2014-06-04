package com.comverse.css.csr;

import com.comverse.css.commonpages.ShoppingCommon;
import org.openqa.selenium.WebDriver;

public class Shopping extends ShoppingCommon {

    public Shopping(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public MyBasket clickSelectOfferInPopUpWindow() throws Exception {

        super.clickSelectOfferInPopUpWindow();
        return new MyBasket(driver);
    }

    @Override
    public ConfigureBalance clickSelectOfferInPopUpWindowExpectingConfigureBalance() throws Exception {

        super.clickSelectOfferInPopUpWindowExpectingConfigureBalance();
        return new ConfigureBalance(driver);
    }

    @Override
    public ConfigureContractDetails clickSelectOfferInPopUpWindowExpectingConfigureContract() throws Exception {

        super.clickSelectOfferInPopUpWindowExpectingConfigureContract();
        return new ConfigureContractDetails(driver);
    }
    
    
    
    

    public ConfigureContractDetails subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(String accountBundle,
            String accountOffer,
            String optionalSubscriberBundle)
            throws Exception {
        super.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(accountBundle, accountOffer, optionalSubscriberBundle);
        return new ConfigureContractDetails(driver);
    }

    public ConfigureBalance subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureBalance(String accountBundle,
            String accountOffer,
            String optionalSubscriberBundle)
            throws Exception {
        super.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureBalance(accountBundle, accountOffer, optionalSubscriberBundle);
        return new ConfigureBalance(driver);
    }
    
    
    public SelectOffersForYourSubscriber subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingSelectOffersForSubscriber(String accountBundle,
            String accountOffer,
            String optionalSubscriberBundle,
            String... optionalSupplementaryOffersTable)
            throws Exception {
        super.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingSelectOffersForSubscriber(accountBundle, accountOffer, optionalSubscriberBundle,
                optionalSupplementaryOffersTable);
        return new SelectOffersForYourSubscriber(driver);
    }
    
     
     
     
     

    @Override
    public MyBasket selectHandset(String value) throws Exception {

        super.selectHandset(value);
        return new MyBasket(driver);
    }

    @Override
    public MyBasket selectAccessory(String value) throws Exception {

        super.selectAccessory(value);
        return new MyBasket(driver);
    }

    @Override
    public TestServiceAbility clickSelectOfferInPopUpWindowWithServiceAbility() throws Exception {

        super.clickSelectOfferInPopUpWindowWithServiceAbility();
        return new TestServiceAbility(driver);
    }

    @Override
    public TestServiceAbility clickNotEligibleLink() throws Exception {

        super.clickNotEligibleLink();
        return new TestServiceAbility(driver);
    }

 
   

    @Override
    public SelectOffersForYourSubscriber clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber() throws Exception {

        super.clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber();
        return new SelectOffersForYourSubscriber(driver);
    }

    @Override
    public EnterYourSubscriptionDetails clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails() throws Exception {

        super.clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails();
        return new EnterYourSubscriptionDetails(driver);
    }
}
