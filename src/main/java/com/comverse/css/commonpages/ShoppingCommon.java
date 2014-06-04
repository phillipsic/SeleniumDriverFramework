package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class ShoppingCommon extends CommonMenu {

    static String expectedScreen = "Shopping";

    public ShoppingCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void filterSubscriberBundlePrimaryOfferByName(String offername) throws Exception {

        this.waitForOffersToLoadOnPage();
        driver.findElement(By.id("filter_str_plan_name")).sendKeys(offername);

    }

    public void waitForOffersToLoadOnPage() throws Exception {

        Common.waitForOffersToLoadOnPage(driver, this.getClass().getSimpleName());
    }

    public void clickSubscriberBundlePrimaryOfferName(String offername) throws Exception {
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForOffersToLoadOnPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.linkText(offername)).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

    public void clickPOCompatibleOffersTab() throws Exception {
        driver.findElement(By.xpath("//div[@id='planDetails']/ul/li[2]/a/em")).click();
    }

    public void clickPOTermsAndConditionsTab() throws Exception {
        driver.findElement(By.xpath("//div[@id='planDetails']/ul/li[3]/a/em")).click();
    }

    public void clickPOOfferPolicyDetailsTab() throws Exception {
        driver.findElement(By.xpath("//div[@id='planDetails']/ul/li[4]/a/em")).click();
    }

    public void clickABCompatibleOffersTab() throws Exception {
        driver.findElement(By.xpath("//div[@id='accountBundleDetails']/ul/li[2]/a/em")).click();
    }

    public void clickABTermsAndConditionsTab() throws Exception {
        driver.findElement(By.xpath("//div[@id='accountBundleDetails']/ul/li[3]/a/em")).click();
    }

    public void clickAccountBundleOfferName(String accountBundle) throws Exception {

        String pageSource = driver.getPageSource();
        String temp[];
        String cleanString;

        temp = pageSource.split(accountBundle);

        temp = temp[1].split("accountBundleDetails");
        cleanString = Common.cleanStringOfIllegalChars(temp[1]);
        cleanString = cleanString.replaceAll("\\(", "");
        cleanString = cleanString.replaceAll("\\)", "");
        cleanString = cleanString.replaceAll(",", "");
        String accountBundleID = cleanString.replaceAll(">", "");

        Common.waitForAccountBundlesToLoadOnPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        driver.findElement(By.xpath("//b[@onclick=\"javascript: accountBundleDetails('" + accountBundleID + "')\"]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

    public MyBasketCommon clickSelectOfferInPopUpWindow() throws Exception {

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new MyBasketCommon(driver);
    }

    public ConfigureBalanceCommon clickSelectOfferInPopUpWindowExpectingConfigureBalance() throws Exception {

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new ConfigureBalanceCommon(driver);
    }

    public TestServiceAbilityCommon clickSelectOfferInPopUpWindowWithServiceAbility() throws Exception {

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new TestServiceAbilityCommon(driver);
    }

    public TestServiceAbilityCommon clickNotEligibleLink() throws Exception {

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.xpath("//a/span")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new TestServiceAbilityCommon(driver);
    }

    public ConfigureContractDetailsCommon clickSelectOfferInPopUpWindowExpectingConfigureContract() throws Exception {

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new ConfigureContractDetailsCommon(driver);
    }

    public EnterYourSubscriptionDetailsCommon clickSelectOfferInPopUpWindowExpectingEnterYourSubscriptionDetails() throws Exception {

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new EnterYourSubscriptionDetailsCommon(driver);
    }

    public SelectOffersForYourSubscriberCommon clickSelectOfferInPopUpWindowExpectingSelectOffersForYourSubscriber() throws Exception {

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.name("select")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new SelectOffersForYourSubscriberCommon(driver);
    }

    public EnterYourSubscriptionDetailsCommon clickNoThankstoHandsets() throws Exception {

        driver.findElement(By.name("nothanks")).click();
        return new EnterYourSubscriptionDetailsCommon(driver);
    }

    public MyBasketCommon selectHandset(String value) throws Exception {

        driver.findElement(By.id("lnk_ADVANCE_FILTER")).click();
        driver.findElement(By.id("filterByFreeText")).sendKeys(value);
        Common.sleepForNumberOfSeconds(3);
        driver.findElement(By.name("buy_outright")).click();
        return new MyBasketCommon(driver);
    }

    public void clickAccountBundlesTab() throws Exception {

        driver.findElement(By.xpath("//div[@id='shoppingTabs']/ul/li[2]/a/em")).click();
        Common.waitForAccountBundlesToLoadOnPage(driver, this.getClass().getSimpleName());
    }

    public void clickHandsetsTab() throws Exception {

        driver.findElement(By.xpath("//div[@id='shoppingTabs']/ul/li[3]/a/em")).click();
        Common.waitForDevicesToLoadOnPage(driver, this.getClass().getSimpleName());
    }

    public void clickAccessoriesTab() throws Exception {

        driver.findElement(By.partialLinkText("Accessories")).click();
        Common.waitForAccessoriesToLoadOnPage(driver, this.getClass().getSimpleName());
    }

    public void selectBundleByName(String bundleName) throws Exception {

        driver.findElement(By.xpath("//tr[@id='abtr:" + bundleName + "']/td/input")).click();
    }

    public void selectAccountOffer(@SuppressWarnings("unused") String accountBundleID, String accountOfferName) throws Exception {

        /*
         * String temp[]; String temp2[]; String tokenizedOfferName; String
         * accountOfferID; String pageSource = driver.getPageSource();
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
        driver.findElement(By.xpath("//div[contains(text(),'" + accountOfferName + "')]/../..//input")).click();
    }

    public void selectOptionalSubscriberBundle(String accountBundleID, String optionalSubscriberBundle) throws Exception {

        driver.findElement(By.xpath("(//input[@type='checkbox' and @name='" + accountBundleID + "_subs_bundle' and contains(@id,'" + optionalSubscriberBundle + "')])")).click();
    }

    public void selectOptionalSupplementaryOffers(String accountBundleID, String optionalSupplementaryOffers) throws Exception {
        driver.findElement(By.xpath("//td[@class = 'oddRow' and contains(.,'" + optionalSupplementaryOffers + "')]/../td/input[@parentabid = '" + accountBundleID + "']")).click();
    }

    private String retrieveAccountBundleID(String accountBundleName) throws Exception {

        String pageSource = driver.getPageSource();
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
     * driver.findElement(By.xpath(
     * "(//input[@type='button' and @value='Subscribe' and @onclick=\"javascript: selectBundle('"
     * + accountBundleID + "','" + accountBundle + "')\"])")).click();
     * 
     * return new ConfigureContractDetailsCommon(driver); }
     */
    public ConfigureContractDetailsCommon subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(String accountBundle, String accountOffer,
            String optionalSubscriberBundle, String... optionalSupplementaryOffersTable) throws Exception {

        this.subscribeToAccountBundlelSubscriberSelectiveOfferByName(accountBundle, accountOffer, optionalSubscriberBundle, optionalSupplementaryOffersTable);

        return new ConfigureContractDetailsCommon(driver);
    }

    public ConfigureBalanceCommon subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureBalance(String accountBundle, String accountOffer,
            String optionalSubscriberBundle, String... optionalSupplementaryOffersTable) throws Exception {

        this.subscribeToAccountBundlelSubscriberSelectiveOfferByName(accountBundle, accountOffer, optionalSubscriberBundle, optionalSupplementaryOffersTable);

        return new ConfigureBalanceCommon(driver);
    }

    public SelectOffersForYourSubscriberCommon subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingSelectOffersForSubscriber(String accountBundle, String accountOffer,
            String optionalSubscriberBundle, String... optionalSupplementaryOffersTable) throws Exception {

        this.subscribeToAccountBundlelSubscriberSelectiveOfferByName(accountBundle, accountOffer, optionalSubscriberBundle, optionalSupplementaryOffersTable);

        return new SelectOffersForYourSubscriberCommon(driver);
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

        driver.findElement(
                By.xpath("(//input[@type='button' and @value='Subscribe' and contains( @onclick, '" + accountBundleID + "') and contains( @onclick,'" + accountBundle + "')])"))
                .click();

        // return new SelectOffersForYourSubscriberCommon(driver);
    }

    public ConfigureContractDetailsCommon clickSubscribe() throws Exception {

        driver.findElement(By.xpath("(//input[@value='Subscribe'])[2]")).click();
        return new ConfigureContractDetailsCommon(driver);
    }

    public MyBasketCommon clickSubscribeNoConfiguration() throws Exception {

        driver.findElement(By.xpath("(//input[@value='Subscribe'])[3]")).click();

        return new MyBasketCommon(driver);
    }

    public SelectOffersForYourSubscriberCommon clickSubscribeAccountBundle() throws Exception {

        driver.findElement(By.xpath("(//input[@value='Subscribe'])[3]")).click();

        return new SelectOffersForYourSubscriberCommon(driver);
    }

    public void clickClose() throws Exception {

        driver.findElement(By.xpath("(//input[@value='Close'])")).click();
    }

    public MyBasketCommon selectAccessory(String value) throws Exception {
        driver.findElement(By.id("filter_acc_name")).sendKeys(value);
        Common.sleepForNumberOfSeconds(3);
        driver.findElement(By.linkText(value)).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.xpath("//input[@value='Select']")).click();

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new MyBasketCommon(driver);
    }
}
