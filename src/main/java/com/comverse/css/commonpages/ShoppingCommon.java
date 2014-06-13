package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ShoppingCommon extends CommonMenu {

    static String expectedScreen = "Shopping";

    public ShoppingCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void filterSubscriberBundlePrimaryOfferByName(String offername) throws Exception {

        this.waitForOffersToLoadOnPage();
        tool.enterStringUsingId(tool, "filter_str_plan_name", offername);

    }

    public void waitForOffersToLoadOnPage() throws Exception {

        Common.waitForOffersToLoadOnPage(tool, this.getClass().getSimpleName());
    }

    public void clickSubscriberBundlePrimaryOfferName(String offername) throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForOffersToLoadOnPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.linkText(offername)).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void clickPOCompatibleOffersTab() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='planDetails']/ul/li[2]/a/em")).click();
    }

    public void clickPOTermsAndConditionsTab() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='planDetails']/ul/li[3]/a/em")).click();
    }

    public void clickPOOfferPolicyDetailsTab() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='planDetails']/ul/li[4]/a/em")).click();
    }

    public void clickABCompatibleOffersTab() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='accountBundleDetails']/ul/li[2]/a/em")).click();
    }

    public void clickABTermsAndConditionsTab() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='accountBundleDetails']/ul/li[3]/a/em")).click();
    }

    public void clickAccountBundleOfferName(String accountBundle) throws Exception {

        String pageSource = tool.driver.getPageSource();
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

        tool.driver.findElement(By.xpath("//b[@onclick=\"javascript: accountBundleDetails('" + accountBundleID + "')\"]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public MyBasketCommon clickSelectOfferInPopUpWindow() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new MyBasketCommon(tool, test, user);
    }

    public ConfigureBalanceCommon clickSelectOfferInPopUpWindowExpectingConfigureBalance() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ConfigureBalanceCommon(tool, test, user);
    }

    public TestServiceAbilityCommon clickSelectOfferInPopUpWindowWithServiceAbility() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new TestServiceAbilityCommon(tool, test, user);
    }

    public TestServiceAbilityCommon clickNotEligibleLink() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.xpath("//a/span")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new TestServiceAbilityCommon(tool, test, user);
    }

    public ConfigureContractDetailsCommon clickSelectOfferInPopUpWindowExpectingConfigureContract() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ConfigureContractDetailsCommon(tool, test, user);
    }

    public EnterYourSubscriptionDetailsCommon clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new EnterYourSubscriptionDetailsCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public EnterYourSubscriptionDetailsCommon clickNoThankstoHandsets() throws Exception {

        tool.driver.findElement(By.name("nothanks")).click();
        return new EnterYourSubscriptionDetailsCommon(tool, test, user);
    }

    public MyBasketCommon selectHandset(String value) throws Exception {

        tool.driver.findElement(By.id("lnk_ADVANCE_FILTER")).click();
        tool.enterStringUsingId(tool, "filterByFreeText", value);
        Common.sleepForNumberOfSeconds(3);
        tool.driver.findElement(By.name("buy_outright")).click();
        return new MyBasketCommon(tool, test, user);
    }

    public void clickAccountBundlesTab() throws Exception {

        tool.driver.findElement(By.xpath("//div[@id='shoppingTabs']/ul/li[2]/a/em")).click();
        Common.waitForAccountBundlesToLoadOnPage(tool, this.getClass().getSimpleName());
    }

    public void clickHandsetsTab() throws Exception {

        tool.driver.findElement(By.xpath("//div[@id='shoppingTabs']/ul/li[3]/a/em")).click();
        Common.waitForDevicesToLoadOnPage(tool, this.getClass().getSimpleName());
    }

    public void clickAccessoriesTab() throws Exception {

        tool.clickUsingPartialLinkText(tool, "Accessories");
        Common.waitForAccessoriesToLoadOnPage(tool, this.getClass().getSimpleName());
    }

    public void selectBundleByName(String bundleName) throws Exception {

        tool.driver.findElement(By.xpath("//tr[@id='abtr:" + bundleName + "']/td/input")).click();
    }

    public void selectAccountOffer(String accountBundleID, String accountOfferName) throws Exception {

        /*
         * String temp[]; String temp2[]; String tokenizedOfferName; String
         * accountOfferID; String pageSource = tool.driver.getPageSource();
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
        tool.driver.findElement(By.xpath("//div[contains(text(),'" + accountOfferName + "')]/../..//input")).click();
    }

    public void selectOptionalSubscriberBundle(String accountBundleID, String optionalSubscriberBundle) throws Exception {

        tool.driver.findElement(By.xpath("(//input[@type='checkbox' and @name='" + accountBundleID + "_subs_bundle' and contains(@id,'" + optionalSubscriberBundle + "')])"))
                .click();
    }

    public void selectOptionalSupplementaryOffers(String accountBundleID, String optionalSupplementaryOffers) throws Exception {
        tool.driver.findElement(By.xpath("//td[@class = 'oddRow' and contains(.,'" + optionalSupplementaryOffers + "')]/../td/input[@parentabid = '" + accountBundleID + "']"))
                .click();
    }

    private String retrieveAccountBundleID(String accountBundleName) throws Exception {

        String pageSource = tool.driver.getPageSource();
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

    /*
     * public ConfigureContractDetailsCommon
     * subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract
     * (String accountBundle, String accountOffer, String
     * optionalSubscriberBundle) throws Exception {
     * 
     * String accountBundleID = this.retrieveAccountBundleID(accountBundle);
     * this.selectBundleByName(accountBundle);
     * 
     * if (accountOffer != null) { this.selectAccountOffer(accountBundleID,
     * accountOffer); }
     * 
     * if (optionalSubscriberBundle != null) {
     * this.selectOptionalSubscriberBundle(accountBundleID,
     * optionalSubscriberBundle); Thread.sleep(1000); }
     * 
     * tool.driver.findElement(By.xpath(
     * "(//input[@type='button' and @value='Subscribe' and @onclick=\"javascript: selectBundle('"
     * + accountBundleID + "','" + accountBundle + "')\"])")).click();
     * 
     * return new ConfigureContractDetailsCommon(tool, test, user); }
     */
    public ConfigureContractDetailsCommon subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(String accountBundle, String accountOffer,
            String optionalSubscriberBundle, String... optionalSupplementaryOffersTable) throws Exception {

        this.subscribeToAccountBundlelSubscriberSelectiveOfferByName(accountBundle, accountOffer, optionalSubscriberBundle, optionalSupplementaryOffersTable);

        return new ConfigureContractDetailsCommon(tool, test, user);
    }

    public ConfigureBalanceCommon subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureBalance(String accountBundle, String accountOffer,
            String optionalSubscriberBundle, String... optionalSupplementaryOffersTable) throws Exception {

        this.subscribeToAccountBundlelSubscriberSelectiveOfferByName(accountBundle, accountOffer, optionalSubscriberBundle, optionalSupplementaryOffersTable);

        return new ConfigureBalanceCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingSelectOffersForSubscriber(String accountBundle, String accountOffer,
            String optionalSubscriberBundle, String... optionalSupplementaryOffersTable) throws Exception {

        this.subscribeToAccountBundlelSubscriberSelectiveOfferByName(accountBundle, accountOffer, optionalSubscriberBundle, optionalSupplementaryOffersTable);

        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    private void subscribeToAccountBundlelSubscriberSelectiveOfferByName(String accountBundle, String accountOffer, String optionalSubscriberBundle,
            String... optionalSupplementaryOffersTable) throws Exception {

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

        tool.driver.findElement(
                By.xpath("(//input[@type='button' and @value='Subscribe' and contains( @onclick, '" + accountBundleID + "') and contains( @onclick,'" + accountBundle + "')])"))
                .click();

        // return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public ConfigureContractDetailsCommon clickSubscribe() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@value='Subscribe'])[2]")).click();
        return new ConfigureContractDetailsCommon(tool, test, user);
    }

    public MyBasketCommon clickSubscribeNoConfiguration() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@value='Subscribe'])[3]")).click();

        return new MyBasketCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon clickSubscribeAccountBundle() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@value='Subscribe'])[3]")).click();

        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public void clickClose() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@value='Close'])")).click();
    }

    public MyBasketCommon selectAccessory(String value) throws Exception {
        tool.enterStringUsingId(tool, "filter_acc_name", value);
        Common.sleepForNumberOfSeconds(3);
        tool.driver.findElement(By.linkText(value)).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.xpath("//input[@value='Select']")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new MyBasketCommon(tool, test, user);
    }
}
