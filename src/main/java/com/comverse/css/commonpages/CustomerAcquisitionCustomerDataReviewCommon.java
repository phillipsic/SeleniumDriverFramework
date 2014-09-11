/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CustomerAcquisitionCustomerDataReviewCommon extends CommonMenu {

    static String expectedScreen = "Customer Acquisition - Customer Data Review";

    public CustomerAcquisitionCustomerDataReviewCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ShoppingCommon clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickContinueExpectingCustomerDataReview() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerAcquisitionCustomerDataReviewCommon(tool, test, user);
    }

    public ShoppingCommon clickContinueExpectingShopping() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }

    public String getLastName() throws Exception {

        return tool.getTextUsingXPath("//div[@id='mainContents']/div[5]/fieldset/p[3]");
    }

    public String getEmailAddress() throws Exception {

        return tool.getTextUsingXPath("//div[@id='mainContents']/div[5]/fieldset/p[5]");
    }

    public String getPhoneNumber() throws Exception {

        return tool.getTextUsingXPath("//div[@id='mainContents']/div[5]/fieldset/p[6]");
    }

    public String getFaxNumber() throws Exception {

        return tool.getTextUsingXPath("//div[@id='mainContents']/div[5]/fieldset/p[7]");
    }

    public String getAddressLine1() throws Exception {
        String cleanString = Common.cleanStringOfIllegalChars(tool.getTextUsingXPath("//div[@id='mainContents']/div[5]/fieldset[2]/p"));

        return cleanString;
    }

    public String getZipCode() throws Exception {

        return Common.cleanStringOfIllegalChars(tool.getTextUsingXPath("//div[@id='mainContents']/div[5]/fieldset[2]/p[5]"));
    }

    public String getCity() throws Exception {

        return Common.cleanStringOfIllegalChars(tool.getTextUsingXPath("//div[@id='mainContents']/div[5]/fieldset[2]/p[6]"));
    }

    public String getState() throws Exception {

        return Common.cleanStringOfIllegalChars(tool.getTextUsingXPath("//div[@id='mainContents']/div[5]/fieldset[2]/p[7]"));
    }

    public String getCountry() throws Exception {

        return Common.cleanStringOfIllegalChars(tool.getTextUsingXPath("//div[@id='mainContents']/div[5]/fieldset[2]/p[8]"));
    }

    public UpdateAccountContactInformationsCommon clickEditCustomerIdentityAndContact() throws Exception {

        tool.clickUsingXPath("//input[@value='Edit']");
        return new UpdateAccountContactInformationsCommon(tool, test, user);
    }

    public void setTitle(String TitleName) throws Exception {

        tool.enterStringUsingId("titleString", TitleName);
    }

    public void setFirstName(String FirstName) throws Exception {

        tool.enterStringUsingId("first_name", FirstName);
    }

    public void setLastName(String LastName) throws Exception {

        tool.enterStringUsingId("last_name", LastName);
    }

    public void setGender(String Gender) throws Exception {

        tool.clickUsingID(Gender);

    }

    public void setEmail(String Email) throws Exception {

        tool.enterStringUsingId("email", Email);
    }

    public void setHomePhone(String HomePhone) throws Exception {

        tool.enterStringUsingId("home_phone", HomePhone);
    }

    public void setFax(String Fax) throws Exception {

        tool.enterStringUsingId("fax", Fax);
    }

    public UpdateAccountBillingAddressInformationsCommon clickEditAddressDetail() throws Exception {

        tool.clickUsingXPath("/html/body/div[3]/div[2]/div[4]/div/div[5]/fieldset[2]/div/div/form/input");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new UpdateAccountBillingAddressInformationsCommon(tool, test, user);
    }

    public void setAddress1(String Address1) throws Exception {

        tool.enterStringUsingId("address_line_1", Address1);
    }

    public void setAddress2(String setAddress2) throws Exception {

        tool.enterStringUsingId("address_line_2", setAddress2);
    }

    public void setAddress3(String Address3) throws Exception {

        tool.enterStringUsingId("address_line_3", Address3);
    }

    public void setAddress4(String Address4) throws Exception {

        tool.enterStringUsingId("address_line_4", Address4);
    }

    public void setHomeZip(String HomeZip) throws Exception {

        tool.enterStringUsingId("home_zip", HomeZip);
    }

    public void setHomeCity(String HomeCity) throws Exception {

        tool.enterStringUsingId("home_city", HomeCity);
    }

    public void setHomeCountry(String HomeCountry) throws Exception {

        tool.enterStringUsingId("home_country", HomeCountry);
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickConfirm() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerAcquisitionCustomerDataReviewCommon(tool, test, user);
    }

    public UpdateAdministrativeAccountInformationCommon clickAccountContactEdit() throws Exception {

        tool.clickUsingXPath("/html/body/div[3]/div[2]/div[4]/div/div[5]/div[3]/fieldset/div/div/form/input[8]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new UpdateAdministrativeAccountInformationCommon(tool, test, user);
    }

    public void setSocialSecurityNumber(String SocialSecurityNumber) throws Exception {

        tool.enterStringUsingId("p-param-L4:91260", SocialSecurityNumber);
    }

    public void setPurchaseOrder(String PurchaseOrder) throws Exception {

        tool.enterStringUsingId("p-param-L4:91540", PurchaseOrder);
    }

    public void setSalesCode(String SalesCode) throws Exception {

        tool.enterStringUsingId("p-param-L4:91530", SalesCode);
    }

    public void setSecurityWord(String SecurityWord) throws Exception {

        tool.enterStringUsingId("p-param-L4:91070", SecurityWord);
    }

    public void setSICCode(String SICCode) throws Exception {

        tool.enterStringUsingId("p-param-L4:91320", SICCode);
    }

    public UpdateAdministrativeAccountInformationCommon clickBillingInformationEditButton() throws Exception {

        tool.clickUsingXPath("/html/body/div[3]/div[2]/div[4]/div/div[5]/div[4]/fieldset/div/div/form/input[8]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new UpdateAdministrativeAccountInformationCommon(tool, test, user);
    }

    public void setBillingBillDispatchMethod(String SocialSecurityNumber) throws Exception {

        tool.enterStringUsingId("p-param-L4:91310", SocialSecurityNumber);
    }

    public void setBillingBillFormatOption(String PurchaseOrder) throws Exception {

        tool.enterStringUsingId("p-param-L4:91300", PurchaseOrder);
    }

    public void setBillingExchangeRateClass(String SalesCode) throws Exception {

        tool.enterStringUsingId("p-param-L4:91380", SalesCode);
    }

    public void setBillingTML(String BillingTML) throws Exception {

        tool.clickUsingID("p-param-L4:81270" + BillingTML);
    }

    public void setBillingVIPCode(String SICCode) throws Exception {

        tool.enterStringUsingId("p-param-L4:80080", SICCode);
    }

    public void setBillingBillPeriod(String SICCode) throws Exception {

        tool.enterStringUsingId("p-param-L4:81010", SICCode);
    }

}
