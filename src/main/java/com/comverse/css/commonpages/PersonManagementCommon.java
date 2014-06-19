package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Person;

public class PersonManagementCommon extends CommonMenu {

    public PersonManagementCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Person Management";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickPersonAdd() throws Exception {
        tool.clickUsingID(tool, "personadd");
    }

    public void selectTitle(String value) throws Exception {
        tool.selectVisibleTextByID(tool, "title", value);
    }

    public void setFirstName(String value) throws Exception {

        tool.enterStringUsingId(tool, "firstName", value);
    }

    public void setLastName(String value) throws Exception {

        tool.enterStringUsingId(tool, "lastName", value);
    }

    public void setAddressLine1(String value) throws Exception {

        tool.enterStringUsingId(tool, "address1", value);
    }

    public void setPostalCode(String value) throws Exception {

        tool.enterStringUsingId(tool, "zipcode", value);
    }

    public void setCity(String value) throws Exception {

        tool.enterStringUsingId(tool, "city", value);
    }

    public void selectCountry(String value) throws Exception {
        tool.selectVisibleTextByID(tool, "country", value);
    }

    public void selectRegion(String value) throws Exception {
        tool.selectVisibleTextByID(tool, "state", value);
    }

    public void selectFirstUserinDropDown() throws Exception {
        tool.selectByIndexByID(tool, "subscriber", 1);
    }

    public void clickOrdering() throws Exception {
        tool.clickUsingID(tool, "ordering");
    }

    public void clickAddRole() throws Exception {
        tool.clickUsingID(tool, "add_role");
    }

    public void clickAdd() throws Exception {
        tool.clickUsingID(tool, "submitButton");
    }

    public void clickAccountManager() throws Exception {
        tool.clickUsingID(tool, "roleCmp");
    }

    public void clickActions(String FName) throws Exception {
        tool.clickUsingXPath(tool, "//div[contains(text(),'" + FName + "')]/../..//button");
    }

    public void clickActionstoChangeOwner() throws Exception {
        tool.clickUsingXPath(tool,
                " //div[contains(text(),'Customer Owner Person')]/../following-sibling::td/following-sibling::td//div[contains(text(),'Active')]/../following-sibling::td//button");
    }

    public void clickActions3() throws Exception {
        tool.clickUsingCssSelector(tool, "button[type='button'][id$=-button][class='submit']");
    }

    public void clickModifyRole() throws Exception {

        tool.clickUsingLinkText(tool, "Modify Role");

    }

    public void selectCustomerManagerPersonRole() throws Exception {
        tool.clickUsingID(tool, "role_2");
    }

    public void clickOKFromSelectPersonaRole() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
    }

    public void clickDeactivateRole() throws Exception {
        tool.clickUsingLinkText(tool, "Deactivate Role");
    }

    public void clickOKFromDeactivateRole() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
    }

    public void checkAccountManager() throws Exception {
        tool.clickUsingID(tool, "roleCmp");
    }

    public void clickChangeOwner() throws Exception {
        tool.clickUsingXPath(tool, "//a[contains(text(),'Change Owner')]");
    }

    public void clickSwap() throws Exception {
        tool.clickUsingID(tool, "submitButton");
    }

    public AddLoginCommon clickActionsAddLoginForPerson(String personLastName) throws Exception {

        tool.clickUsingXPath(tool, "//div[contains(text(),'" + personLastName + "')]/../..//*[@type='button']");
        tool.clickUsingLinkText(tool, "Add Login");

        return new AddLoginCommon(tool, test, user);
    }

    public Person addCMP() throws Exception {
        String CMPUniqueString = Common.generateTimeStamp();
        Person person3 = new Person(CMPUniqueString);

        person3.setPersonLastNameProperty("CMPLN" + CMPUniqueString);
        person3.setPersonFirstNameProperty("CMPFN" + CMPUniqueString);
        person3.setPersonTitleProperty("Mrs.");
        person3.setPersonHomeCountryProperty("United States");
        person3.setPersonHomeStateProperty("Florida");
        person3.setPersonStreetNumberProperty("CMPUniqueString");
        person3.setPersonStreetNameProperty("CMPAdd1-");
        person3.setPersonCityProperty("CMPcity");
        person3.setPersonPostCodeProperty("CMPPostCode");

        this.clickPersonAdd();
        this.selectTitle(person3.getPersonTitleProperty());
        this.setFirstName(person3.getPersonFirstNameProperty());
        this.setLastName(person3.getPersonLastNameProperty());
        this.setAddressLine1(person3.getPersonStreetNameProperty() + person3.getPersonStreetNumberProperty());
        this.setPostalCode(person3.getPersonPostCodeProperty());
        this.setCity(person3.getPersonCityProperty());
        this.selectCountry(person3.getPersonHomeCountryProperty());
        this.selectRegion(person3.getPersonHomeStateProperty());
        this.checkAccountManager();
        this.clickAdd();
        Common.assertTextOnPage(tool, "Customer Manager Person");

        setPerson3(person3);

        return person3;
    }

    public Person addCOP() throws Exception {
        String COPUniqueString = Common.generateTimeStamp();
        Person person3 = new Person(COPUniqueString);

        person3.setPersonLastNameProperty("COPLN" + COPUniqueString);
        person3.setPersonFirstNameProperty("COPFN" + COPUniqueString);
        person3.setPersonTitleProperty("Mrs.");
        person3.setPersonHomeCountryProperty("United States");
        person3.setPersonHomeStateProperty("Florida");
        person3.setPersonStreetNumberProperty("COPUniqueString");
        person3.setPersonStreetNameProperty("COPAdd1-");
        person3.setPersonCityProperty("COPcity");
        person3.setPersonPostCodeProperty("COPPostCode");

        this.selectTitle(person3.getPersonTitleProperty());
        this.setFirstName(person3.getPersonFirstNameProperty());
        this.setLastName(person3.getPersonLastNameProperty());
        this.setAddressLine1(person3.getPersonStreetNameProperty() + person3.getPersonStreetNumberProperty());
        this.setPostalCode(person3.getPersonPostCodeProperty());
        this.setCity(person3.getPersonCityProperty());
        this.selectCountry(person3.getPersonHomeCountryProperty());
        this.selectRegion(person3.getPersonHomeStateProperty());

        setPerson3(person3);

        return person3;
    }

    public void searchPerson() throws Exception {
        tool.selectVisibleTextByID(tool, "title", "Mr.");
        tool.enterStringUsingId(tool, "firstName", "test*");
        tool.clickUsingID(tool, "pm-button-search");
        tool.clickListUsingName(tool, "pfr-selected-person");
        tool.clickUsingXPath(tool, "//*[@id='personfind']/div[2]/div/form/div[2]/input[2]");
        tool.clickUsingCssSelector(tool, "input[id=submitButton][value='Swap']");
    }

    public void clickDissociate() throws Exception {
        tool.clickUsingLinkText(tool, "Disassociate Role");
    }

    public void clickOKFromDissociate() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
    }

    public void clickAssociateRoleToSubscriber() throws Exception {
        tool.clickUsingLinkText(tool, "Associate Role to Subscriber");
    }

    public void clickOKAssociateRoleToSubscriber() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
    }

    public String getLastNameOfCOP() throws Exception {
        String cop_fullName = tool.getTextUsingXPath(tool, "//div[contains(text(),'Customer Owner Person')]/../../td[1]");

        String temp[] = cop_fullName.split(" ");
        System.out.println("COP LastName" + temp[1]);
        return temp[1];

    }

    public PersonMergeCommon clickPersonMerge() throws Exception {
        tool.clickUsingLinkText(tool, "Person Merge");

        return new PersonMergeCommon(tool, test, user);
    }

}
