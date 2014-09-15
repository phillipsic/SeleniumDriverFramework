package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ShoppingCommon extends CommonMenu {
    static String expectedScreen = "Shopping";

    public ShoppingCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void filterSubscriberBundlePrimaryOfferByName(String offername) throws Exception {  test.writeInLog(Common.getMethodName());

        this.waitForOffersToLoadOnPage();
        tool.enterStringUsingId("filter_str_plan_name", offername);

    }

    public void waitForOffersToLoadOnPage() throws Exception {  test.writeInLog(Common.getMethodName());

        Common.waitForOffersToLoadOnPage(tool, this.getClass().getSimpleName());
    }

    public void clickSubscriberBundlePrimaryOfferName(String offername) throws Exception {  test.writeInLog(Common.getMethodName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForOffersToLoadOnPage(tool, this.getClass().getSimpleName());
        tool.clickUsingLinkText(offername);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void clickPOCompatibleOffersTab() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//div[@id='planDetails']/ul/li[2]/a/em");
    }

    public void clickPOTermsAndConditionsTab() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//div[@id='planDetails']/ul/li[3]/a/em");
    }

    public void clickPOOfferPolicyDetailsTab() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//div[@id='planDetails']/ul/li[4]/a/em");
    }

    public void clickABCompatibleOffersTab() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//div[@id='accountBundleDetails']/ul/li[2]/a/em");
    }

    public void clickABTermsAndConditionsTab() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//div[@id='accountBundleDetails']/ul/li[3]/a/em");
    }

    public void clickAccountBundleOfferName(String accountBundle) throws Exception {  test.writeInLog(Common.getMethodName());

        String pageSource = tool.getPageSource();
        String temp[];
        String cleanString;

        temp = pageSource.split(accountBundle);

        temp = temp[1].split("accountBundleDetails");
        cleanString = Common.cleanStringOfIllegalChars(temp[1]);
        cleanString = cleanString.replaceAll("\\(", "");
        cleanString = cleanString.replaceAll("\\)", "");
        cleanString = cleanString.replaceAll(",", "");
        String accountBundleID = cleanString.replaceAll(">", "");

        Common.waitForAccountBundlesToLoadOnPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        tool.clickUsingXPath("//b[@onclick=\"javascript: accountBundleDetails('" + accountBundleID + "')\"]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public MyBasketCommon clickSelectOfferInPopUpWindow() throws Exception {  test.writeInLog(Common.getMethodName());

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingName("select");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new MyBasketCommon(tool, test, user);
    }

    public ConfigureBalanceCommon clickSelectOfferInPopUpWindowExpectingConfigureBalance() throws Exception {  test.writeInLog(Common.getMethodName());

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingName("select");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ConfigureBalanceCommon(tool, test, user);
    }

    public TestServiceAbilityCommon clickSelectOfferInPopUpWindowWithServiceAbility() throws Exception {  test.writeInLog(Common.getMethodName());

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingName("select");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new TestServiceAbilityCommon(tool, test, user);
    }

    public TestServiceAbilityCommon clickNotEligibleLink() throws Exception {  test.writeInLog(Common.getMethodName());

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingXPath("//a/span");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new TestServiceAbilityCommon(tool, test, user);
    }

    public ConfigureContractDetailsCommon clickSelectOfferInPopUpWindowExpectingConfigureContract() throws Exception {  test.writeInLog(Common.getMethodName());

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingName("select");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ConfigureContractDetailsCommon(tool, test, user);
    }

    public EnterYourSubscriptionDetailsCommon clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails() throws Exception {  test.writeInLog(Common.getMethodName());

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingName("select");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new EnterYourSubscriptionDetailsCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber() throws Exception {  test.writeInLog(Common.getMethodName());

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingName("select");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public EnterYourSubscriptionDetailsCommon clickNoThankstoHandsets() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingName("nothanks");
        return new EnterYourSubscriptionDetailsCommon(tool, test, user);
    }

    public MyBasketCommon selectHandset(String value) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingID("lnk_ADVANCE_FILTER");
        tool.enterStringUsingId("filterByFreeText", value);
        Common.sleepForNumberOfSeconds(3);
        tool.clickUsingName("buy_outright");
        return new MyBasketCommon(tool, test, user);
    }

    public void clickAccountBundlesTab() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//div[@id='shoppingTabs']/ul/li[2]/a/em");
        Common.waitForAccountBundlesToLoadOnPage(tool, this.getClass().getSimpleName());
    }

    public void clickHandsetsTab() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//div[@id='shoppingTabs']/ul/li[3]/a/em");
        Common.waitForDevicesToLoadOnPage(tool, this.getClass().getSimpleName());
    }

    public void clickAccessoriesTab() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingPartialLinkText("Accessories");
        Common.waitForAccessoriesToLoadOnPage(tool, this.getClass().getSimpleName());
    }

    public void selectBundleByName(String bundleName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//tr[@id='abtr:" + bundleName + "']/td/input");
    }

    public void selectAccountOffer(String accountBundleID, String accountOfferName) throws Exception {  test.writeInLog(Common.getMethodName());

        /*
         * String temp[]; String temp2[]; String tokenizedOfferName; String
         * accountOfferID; String pageSource = tool.getPageSource();
         * 
         * temp = pageSource.split(accountBundleID + "_selectiveService\"");
         * 
         * tokenizedOfferName = accountOfferName.replaceAll("\\(", "\\\\(");
         * tokenizedOfferName = tokenizedOfferName.replaceAll("\\)", "\\\\)");
         * 
         * temp2 = temp[1].split(tokenizedOfferName); temp =
         * temp2[0].split("_service"); temp = temp[1].split("\">");
         * accountOfferID = temp[0];
         */
        // div[contains(text(),'DIYe - extended Interactivity (Your
        // account).')]/../..//input
        tool.clickUsingXPath("//div[contains(text(),'" + accountOfferName + "')]/../..//input");
    }

    public void selectOptionalSubscriberBundle(String accountBundleID, String optionalSubscriberBundle) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("(//input[@type='checkbox' and @name='" + accountBundleID + "_subs_bundle' and contains(@id,'" + optionalSubscriberBundle + "')])");
    }

    public void selectOptionalSupplementaryOffers(String accountBundleID, String optionalSupplementaryOffers) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//td[@class = 'oddRow' and contains(.,'" + optionalSupplementaryOffers + "')]/../td/input[@parentabid = '" + accountBundleID + "']");
    }

    private String retrieveAccountBundleID(String accountBundleName) throws Exception {  test.writeInLog(Common.getMethodName());

        String pageSource = tool.getPageSource();
        String temp[];
        String cleanString;

        temp = pageSource.split("abtr:" + accountBundleName);
        temp = temp[1].split("value=");
        temp = temp[1].split(">");

        cleanString = Common.cleanStringOfIllegalChars(temp[0]);
        cleanString = cleanString.replaceAll("\\(", "");
        cleanString = cleanString.replaceAll("\\)", "");
        cleanString = cleanString.replaceAll(",", "");

        /*
         * In Firefox, there is additional text after the account bundle ID,
         * e.g: 1032 onchange=javascript:displayAccountBundlethis.value;
         */
        // String accountBundleID = cleanString.replaceAll(">", "");
        cleanString = cleanString.replaceAll(">", "");
        String[] extractAccountBundleID = cleanString.split(" ");
        String accountBundleID = extractAccountBundleID[0].trim();

        return accountBundleID;
    }

    public ConfigureContractDetailsCommon subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(String accountBundle, String accountOffer,
            String optionalSubscriberBundle, String... optionalSupplementaryOffersTable) throws Exception {  test.writeInLog(Common.getMethodName());

        this.subscribeToAccountBundlelSubscriberSelectiveOfferByName(accountBundle, accountOffer, optionalSubscriberBundle, optionalSupplementaryOffersTable);

        return new ConfigureContractDetailsCommon(tool, test, user);
    }

    public ConfigureBalanceCommon subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureBalance(String accountBundle, String accountOffer,
            String optionalSubscriberBundle, String... optionalSupplementaryOffersTable) throws Exception {  test.writeInLog(Common.getMethodName());

        this.subscribeToAccountBundlelSubscriberSelectiveOfferByName(accountBundle, accountOffer, optionalSubscriberBundle, optionalSupplementaryOffersTable);

        return new ConfigureBalanceCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingSelectOffersForSubscriber(String accountBundle, String accountOffer,
            String optionalSubscriberBundle, String... optionalSupplementaryOffersTable) throws Exception {  test.writeInLog(Common.getMethodName());

        this.subscribeToAccountBundlelSubscriberSelectiveOfferByName(accountBundle, accountOffer, optionalSubscriberBundle, optionalSupplementaryOffersTable);

        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    private void subscribeToAccountBundlelSubscriberSelectiveOfferByName(String accountBundle, String accountOffer, String optionalSubscriberBundle,
            String... optionalSupplementaryOffersTable) throws Exception {  test.writeInLog(Common.getMethodName());

        String accountBundleID = this.retrieveAccountBundleID(accountBundle);
        this.selectBundleByName(accountBundle);

        if (accountOffer != null) {
            this.selectAccountOffer(accountBundleID, accountOffer);
        }

        if (optionalSubscriberBundle != null) {
            this.selectOptionalSubscriberBundle(accountBundleID, optionalSubscriberBundle);
            Thread.sleep(1000);
        }

        if (optionalSupplementaryOffersTable != null) {
            for (String optionalSupplementaryOffers : optionalSupplementaryOffersTable) {
                this.selectOptionalSupplementaryOffers(accountBundleID, optionalSupplementaryOffers);
            }
        }

        tool.clickUsingXPath("(//input[@type='button' and @value='Subscribe' and contains( @onclick, '" + accountBundleID + "') and contains( @onclick,'" + accountBundle
                + "')])");

        // return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public ConfigureContractDetailsCommon clickSubscribe() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//input[@value='Subscribe'])[2]");
        return new ConfigureContractDetailsCommon(tool, test, user);
    }

    public MyBasketCommon clickSubscribeNoConfiguration() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//input[@value='Subscribe'])[3]");

        return new MyBasketCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon clickSubscribeAccountBundle() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//input[@value='Subscribe'])[3]");

        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public void clickClose() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//input[@value='Close'])");
    }

    public MyBasketCommon selectAccessory(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.enterStringUsingId("filter_acc_name", value);
        Common.sleepForNumberOfSeconds(3);
        tool.clickUsingLinkText(value);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingXPath("//input[@value='Select']");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new MyBasketCommon(tool, test, user);
    }
}
