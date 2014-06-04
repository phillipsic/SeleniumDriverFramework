/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class CustomerAcquisitionCustomerDataReviewCommon extends CommonMenu {

    static String expectedScreen = "Customer Acquisition - Customer Data Review";

    public CustomerAcquisitionCustomerDataReviewCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ShoppingCommon clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ShoppingCommon(driver);
    }

    public String getLastName() throws Exception {

        return driver.findElement(By.xpath("//div[@id='mainContents']/div[5]/fieldset/p[3]")).getText();
    }

    public String getEmailAddress() throws Exception {

        return driver.findElement(By.xpath("//div[@id='mainContents']/div[5]/fieldset/p[5]")).getText();
    }

    public String getPhoneNumber() throws Exception {

        return driver.findElement(By.xpath("//div[@id='mainContents']/div[5]/fieldset/p[6]")).getText();
    }

    public String getFaxNumber() throws Exception {

        return driver.findElement(By.xpath("//div[@id='mainContents']/div[5]/fieldset/p[7]")).getText();
    }

    public String getAddressLine1() throws Exception {

        String cleanString = Common.cleanStringOfIllegalChars(driver.findElement(By.xpath("//div[@id='mainContents']/div[5]/fieldset[2]/p"))
                .getText());

        return cleanString;
    }

    public String getZipCode() throws Exception {

        return Common.cleanStringOfIllegalChars(driver.findElement(By.xpath("//div[@id='mainContents']/div[5]/fieldset[2]/p[5]")).getText());
    }

    public String getCity() throws Exception {

        return Common.cleanStringOfIllegalChars(driver.findElement(By.xpath("//div[@id='mainContents']/div[5]/fieldset[2]/p[6]")).getText());
    }

    public String getState() throws Exception {

        return Common.cleanStringOfIllegalChars(driver.findElement(By.xpath("//div[@id='mainContents']/div[5]/fieldset[2]/p[7]")).getText());
    }

    public String getCountry() throws Exception {

        return Common.cleanStringOfIllegalChars(driver.findElement(By.xpath("//div[@id='mainContents']/div[5]/fieldset[2]/p[8]")).getText());
    }

    public UpdateAccountContactInformationsCommon clickEditCustomerIdentityAndContact() throws Exception {

        driver.findElement(By.xpath("//input[@value='Edit']")).click();
        return new UpdateAccountContactInformationsCommon(driver);
    }

    public void setTitle(String TitleName) throws Exception {

        driver.findElement(By.id("titleString")).sendKeys(TitleName);
    }

    public void setFirstName(String FirstName) throws Exception {

        driver.findElement(By.id("first_name")).sendKeys(FirstName);
    }

    public void setLastName(String LastName) throws Exception {

        driver.findElement(By.id("last_name")).sendKeys(LastName);
    }

    public void setGender(String Gender) throws Exception {

        driver.findElement(By.id(Gender)).click();

    }

    public void setEmail(String Email) throws Exception {

        driver.findElement(By.id("email")).sendKeys(Email);
    }

    public void setHomePhone(String HomePhone) throws Exception {

        driver.findElement(By.id("home_phone")).sendKeys(HomePhone);
    }

    public void setFax(String Fax) throws Exception {

        driver.findElement(By.id("fax")).sendKeys(Fax);
    }

    public UpdateAccountBillingAddressInformationsCommon clickEditAddressDetail() throws Exception {

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[4]/div/div[5]/fieldset[2]/div/div/form/input")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new UpdateAccountBillingAddressInformationsCommon(driver);
    }

    public void setAddress1(String Address1) throws Exception {

        driver.findElement(By.id("address_line_1")).clear();
        driver.findElement(By.id("address_line_1")).sendKeys(Address1);
    }

    public void setAddress2(String setAddress2) throws Exception {

        driver.findElement(By.id("address_line_2")).clear();
        driver.findElement(By.id("address_line_2")).sendKeys(setAddress2);
    }

    public void setAddress3(String Address3) throws Exception {

        driver.findElement(By.id("address_line_3")).clear();
        driver.findElement(By.id("address_line_3")).sendKeys(Address3);
    }

    public void setAddress4(String Address4) throws Exception {

        driver.findElement(By.id("address_line_4")).clear();
        driver.findElement(By.id("address_line_4")).sendKeys(Address4);
    }

    public void setHomeZip(String HomeZip) throws Exception {

        driver.findElement(By.id("home_zip")).clear();
        driver.findElement(By.id("home_zip")).sendKeys(HomeZip);
    }

    public void setHomeCity(String HomeCity) throws Exception {

        driver.findElement(By.id("home_city")).clear();
        driver.findElement(By.id("home_city")).sendKeys(HomeCity);
    }

    public void setHomeCountry(String HomeCountry) throws Exception {

        driver.findElement(By.id("home_country")).sendKeys(HomeCountry);
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CustomerAcquisitionCustomerDataReviewCommon(driver);
    }

    public UpdateAdministrativeAccountInformationCommon clickAccountContact() throws Exception {

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[4]/div/div[5]/div[3]/fieldset/div/div/form/input[8]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new UpdateAdministrativeAccountInformationCommon(driver);
    }

    public void setSocialSecurityNumber(String SocialSecurityNumber) throws Exception {

        driver.findElement(By.id("p-param-L4:91260")).clear();
        driver.findElement(By.id("p-param-L4:91260")).sendKeys(SocialSecurityNumber);
    }

    public void setPurchaseOrder(String PurchaseOrder) throws Exception {

        driver.findElement(By.id("p-param-L4:91540")).clear();
        driver.findElement(By.id("p-param-L4:91540")).sendKeys(PurchaseOrder);
    }

    public void setSalesCode(String SalesCode) throws Exception {

        driver.findElement(By.id("p-param-L4:91530")).clear();
        driver.findElement(By.id("p-param-L4:91530")).sendKeys(SalesCode);
    }

    public void setSecurityWord(String SecurityWord) throws Exception {

        driver.findElement(By.id("p-param-L4:91070")).clear();
        driver.findElement(By.id("p-param-L4:91070")).sendKeys(SecurityWord);
    }

    public void setSICCode(String SICCode) throws Exception {

        driver.findElement(By.id("p-param-L4:91320")).clear();
        driver.findElement(By.id("p-param-L4:91320")).sendKeys(SICCode);
    }

    public UpdateAdministrativeAccountInformationCommon clickBillingInformationEditButton() throws Exception {

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[4]/div/div[5]/div[4]/fieldset/div/div/form/input[8]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new UpdateAdministrativeAccountInformationCommon(driver);
    }

    public void setBillingBillDispatchMethod(String SocialSecurityNumber) throws Exception {

        driver.findElement(By.id("p-param-L4:91310")).sendKeys(SocialSecurityNumber);
    }

    public void setBillingBillFormatOption(String PurchaseOrder) throws Exception {

        driver.findElement(By.id("p-param-L4:91300")).sendKeys(PurchaseOrder);
    }

    public void setBillingExchangeRateClass(String SalesCode) throws Exception {

        driver.findElement(By.id("p-param-L4:91380")).sendKeys(SalesCode);
    }

    public void setBillingTML(String BillingTML) throws Exception {

        driver.findElement(By.id("p-param-L4:81270" + BillingTML)).click();
    }

    public void setBillingVIPCode(String SICCode) throws Exception {

        driver.findElement(By.id("p-param-L4:80080")).sendKeys(SICCode);
    }

    public void setBillingBillPeriod(String SICCode) throws Exception {

        driver.findElement(By.id("p-param-L4:81010")).sendKeys(SICCode);
    }

}
