/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Person;
import com.comverse.css.common.Subscriber;

/**
 * 
 * @author iphilli
 */
public class MyBasketCommon extends CommonMenu {

    public MyBasketCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "My Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public MyBasketCommon clickViewBasket() throws Exception {
        super.clickViewBasket();
        return new MyBasketCommon(tool, test, user);
    }

    public CheckoutReviewCommon clickCheckOut() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Checkout']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckoutReviewCommon(tool, test, user);
    }

    public CheckoutDeliveryAddressCommon clickCheckOutWithGoods() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Checkout']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckoutDeliveryAddressCommon(tool, test, user);
    }

    public TermsAndConditionsCommon clickCheckOutWithTermsAndConditions() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Checkout']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new TermsAndConditionsCommon(tool, test, user);
    }

    public ShoppingCommon clickContinueShopping() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Continue Shopping']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }

    public ServiceConnectionDetailsCommon clickFirstActionsIcon() throws Exception {
        tool.clickUsingCssSelector(tool, "img[title=\"Configure Service Connection Details\"]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public ServiceConnectionDetailsCommon clickSecondActionsIcon() throws Exception {
        tool.clickUsingCssSelector(tool, "#modify_lines_2 > img[title=\"Configure Service Connection Details\"]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ServiceConnectionDetailsCommon(tool, test, user);
    }

    public String getTypeRole() throws Exception {
        return tool.getTextUsingXPath(tool, "//td[2]/div/p");
    }

    public String getAddress() throws Exception {
        String address = tool.getTextUsingXPath(tool, "//td[4]/div/p");
        return address.replaceAll("[^\\p{L}\\p{N}]", " ");
    }

    public String getOfferName() throws Exception {
        return tool.getTextUsingXPath(tool, "//tr[9]/td");
    }

    public String getRecurringCharge() throws Exception {
        return tool.getTextUsingXPath(tool, "//tr[9]/td[4]");
    }

    public String getUpfrontCharge() throws Exception {
        return tool.getTextUsingXPath(tool, "//tr[9]/td[5]");
    }

    public String getQuantity() throws Exception {
        return tool.getTextUsingXPath(tool, "//tr[9]/td[2]");
    }

    public RemoveBasketCommon clickClear() throws Exception {
        tool.clickUsingName(tool, "clear");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RemoveBasketCommon(tool, test, user);
    }

    public void clickAcceptTermsAndConditions() throws Exception {
        tool.clickUsingID(tool, "termsandconditionscheck");
    }

    public RemoveSelectionCommon removeSecondItemFromBasket() throws Exception {
        tool.clickUsingID(tool, "remove_1");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RemoveSelectionCommon(tool, test, user);
    }

    public RemoveSelectionCommon removeFirstItemFromBasket() throws Exception {
        tool.clickUsingLinkText(tool, "Remove");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RemoveSelectionCommon(tool, test, user);
    }

    public void clickAddPersonOrRole() throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingID(tool, "pm-button-add-person");
    }

    public void clickUserOfNewSubscriber1() throws Exception {
        tool.clickUsingXPath(tool, "//td[@id='pm-role-fields']/p[2]/input");
    }

    public void clickOrdering() throws Exception {
        tool.clickUsingName(tool, "role_radio_group_selection_0");
    }

    public void selectTitle(String value) throws Exception {
        new Select(tool.searchUsingID(tool, "pm-field-title")).selectByVisibleText(value);
    }

    public void setFirstName(String value) throws Exception {

        tool.enterStringUsingId(tool, "pm-field-fname", value);
    }

    public void setLastName(String value) throws Exception {

        tool.enterStringUsingId(tool, "pm-field-lname", value);
    }

    public void setAddressLine1(String value) throws Exception {

        tool.enterStringUsingId(tool, "pm-field-address1", value);
    }

    public void setPostalCode(String value) throws Exception {

        tool.enterStringUsingId(tool, "pm-field-zip", value);
    }

    public void setCity(String value) throws Exception {

        tool.enterStringUsingId(tool, "pm-field-city", value);
    }

    public void selectCountry(String value) throws Exception {
        new Select(tool.searchUsingID(tool, "pm-field-country")).selectByVisibleText(value);
    }

    public void selectRegion(String value) throws Exception {
        new Select(tool.searchUsingID(tool, "pm-field-region")).selectByVisibleText(value);
    }

    public void selectFirstUserinDropDown() throws Exception {
        new Select(tool.searchUsingID(tool, "subscriber")).selectByIndex(1);
    }

    public void clickAddRole() throws Exception {
        tool.clickUsingID(tool, "add_role");
    }

    public void clickAdd() throws Exception {
        tool.clickUsingID(tool, "pm-button-add");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public ShoppingCommon changePrimaryOffer() throws Exception {
        tool.clickUsingID(tool, "add_pp_0");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon clickAddSO() throws Exception {
        tool.clickUsingLinkText(tool, "Add Supplementary Offer(s)");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public SelectOffersForYourSubscriberCommon clickChangeSO() throws Exception {
        tool.clickUsingID(tool, "add_srv_1");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourSubscriberCommon(tool, test, user);
    }

    public SelectOffersForYourAccountCommon clickAddAO() throws Exception {
        tool.clickUsingID(tool, "add_srv_ACCOUNT_LEVEL_SELECTION");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourAccountCommon(tool, test, user);
    }

    public Person addConsumerUserPersonOrdering() throws Exception {

        String CUPUniqueString = Common.generateTimeStamp();
        Person person2 = new Person(CUPUniqueString);

        person2.setPersonLastNameProperty("CUPLN" + CUPUniqueString);
        person2.setPersonFirstNameProperty("CUPFN" + CUPUniqueString);
        person2.setPersonTitleProperty("Mrs.");
        person2.setPersonHomeCountryProperty("United States");
        person2.setPersonHomeStateProperty("Florida");
        person2.setPersonStreetNumberProperty("CUPUniqueString");
        person2.setPersonStreetNameProperty("CUPAdd1-");
        person2.setPersonCityProperty("CUPcity");
        person2.setPersonPostCodeProperty("CUPPostCode");

        this.clickAddPersonOrRole();
        this.selectTitle(person2.getPersonTitleProperty());
        this.setFirstName(person2.getPersonFirstNameProperty());
        this.setLastName(person2.getPersonLastNameProperty());
        this.setAddressLine1(person2.getPersonStreetNameProperty() + person2.getPersonStreetNumberProperty());
        this.setPostalCode(person2.getPersonPostCodeProperty());
        this.setCity(person2.getPersonCityProperty());
        this.selectCountry(person2.getPersonHomeCountryProperty());
        this.selectRegion(person2.getPersonHomeStateProperty());
        this.clickUserOfNewSubscriber1();
        this.clickOrdering();
        this.clickAdd();

        setPerson2(person2);

        return person2;
    }

    public void assign3InventoriesFirstOffer(Subscriber subscriber) throws Exception {
        ServiceConnectionDetailsCommon serviceConnectionDetails = this.clickFirstActionsIcon();
        serviceConnectionDetails.clickSetIMSIInventory(subscriber);
        serviceConnectionDetails.clickSetSIMInventory(subscriber);
        serviceConnectionDetails.clickSetMSISDNInventory(subscriber);
        serviceConnectionDetails.clickOk();
    }

    public void assign1InventoryFirstOffer(Subscriber subscriber) throws Exception {
        ServiceConnectionDetailsCommon serviceConnectionDetails = this.clickFirstActionsIcon();
        serviceConnectionDetails.clickSetIMSIInventory(subscriber);
        serviceConnectionDetails.clickOk();
    }

    public void assignEmailInventory(String email) throws Exception {
        ServiceConnectionDetailsCommon serviceConnectionDetails = this.clickFirstActionsIcon();
        serviceConnectionDetails.SetEmailInventory(email);
        serviceConnectionDetails.clickOkAfterSetEmailInventory();
    }

    public void assign3InventoriesSecondOffer(Subscriber subscriber) throws Exception {
        ServiceConnectionDetailsCommon serviceConnectionDetails = this.clickSecondActionsIcon();
        serviceConnectionDetails.clickSetIMSIInventory(subscriber);
        serviceConnectionDetails.clickSetSIMInventory(subscriber);
        serviceConnectionDetails.clickSetMSISDNInventory(subscriber);
        serviceConnectionDetails.clickOk();
    }

    public ParkTheCurrentBasketCommon clickParkBasket() throws Exception {
        tool.clickUsingID(tool, "lnk_SBE.PARK.ADD");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ParkTheCurrentBasketCommon(tool, test, user);
    }
}
