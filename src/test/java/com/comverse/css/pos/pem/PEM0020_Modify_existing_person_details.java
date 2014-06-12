package com.comverse.css.pos.pem;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PEM0020_Modify_existing_person_details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testPEM0020_Modify_existing_person_details() throws Exception {

        try {
            launchCSSApplication();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());
            AccountDetails accountDetails = customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());

            PersonDetails personDetails = accountDetails.clickUpdatePerson();

            workSpace.getPerson().setPersonLastNameProperty("PersonLN2");
            workSpace.getPerson().setPersonFirstNameProperty("PersonFN2");
            workSpace.getPerson().setPersonGenderProperty("male");
            workSpace.getPerson().setPersonTitleProperty("Mr.");
            workSpace.getPerson().setPersonNationalityProperty("Togo");
            workSpace.getPerson().setPersonLanguageProperty("Dutch");
            workSpace.getPerson().setPersonNationalIDProperty("9876543210");
            workSpace.getPerson().setPersonDateOfBirthProperty("01/01/1976");
            workSpace.getPerson().setPersonEmailAddressProperty("email2@address.com");
            workSpace.getPerson().setPersonPhoneNumberProperty("1234567890");
            workSpace.getPerson().setPersonMobileNumberProperty("6234567890");
            workSpace.getPerson().setPersonFaxNumberProperty("8234567890");

            personDetails.selectTitle(workSpace.getPerson().getPersonTitleProperty());
            personDetails.setFirstName(workSpace.getPerson().getPersonFirstNameProperty());
            personDetails.setLastName(workSpace.getPerson().getPersonLastNameProperty());
            personDetails.setGender(workSpace.getPerson().getPersonGenderProperty());
            personDetails.setNationality(workSpace.getPerson().getPersonNationalityProperty());
            personDetails.setLanguage(workSpace.getPerson().getPersonLanguageProperty());
            personDetails.setEmailAddress(workSpace.getPerson().getPersonEmailAddressProperty());
            personDetails.setPhoneNumber(workSpace.getPerson().getPersonPhoneNumberProperty());
            personDetails.setMobileNumber(workSpace.getPerson().getPersonMobileNumberProperty());
            personDetails.setFaxNumber(workSpace.getPerson().getPersonFaxNumberProperty());
            personDetails.setNationalID(workSpace.getPerson().getPersonNationalIDProperty());
            personDetails.setDateOfBirth(workSpace.getPerson().getPersonDateOfBirthProperty());

            personDetails.clickUpdate();

            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonLastNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonFirstNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonDateOfBirthProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonLanguageProperty());

            accountDetails.clickUpdatePerson();

            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonLastNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonFirstNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonGenderProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonTitleProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonNationalityProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonLanguageProperty());

            assertEquals(tool.driver.findElement(By.id("nationalid")).getAttribute("value"), workSpace.getPerson().getPersonNationalIDProperty());
            assertEquals(tool.driver.findElement(By.id("dateOfBirth")).getAttribute("value"), workSpace.getPerson().getPersonDateOfBirthProperty());
            assertEquals(tool.driver.findElement(By.id("email")).getAttribute("value"), workSpace.getPerson().getPersonEmailAddressProperty());
            assertEquals(tool.driver.findElement(By.id("phone")).getAttribute("value"), workSpace.getPerson().getPersonPhoneNumberProperty());
            assertEquals(tool.driver.findElement(By.id("mobile")).getAttribute("value"), workSpace.getPerson().getPersonMobileNumberProperty());
            assertEquals(tool.driver.findElement(By.id("fax")).getAttribute("value"), workSpace.getPerson().getPersonFaxNumberProperty());

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}