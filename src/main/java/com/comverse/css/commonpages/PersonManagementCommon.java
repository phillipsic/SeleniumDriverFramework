package com.comverse.css.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.common.Person;

public class PersonManagementCommon extends CommonMenu {

    public PersonManagementCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Person Management";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickPersonAdd() {
        tool.driver.findElement(By.id("personadd")).click();
    }

    public void selectTitle(String value) throws Exception {
        new Select(tool.searchUsingID(tool, "title")).selectByVisibleText(value);
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
        new Select(tool.searchUsingID(tool, "country")).selectByVisibleText(value);
    }

    public void selectRegion(String value) throws Exception {
        new Select(tool.searchUsingID(tool, "state")).selectByVisibleText(value);
    }

    public void selectFirstUserinDropDown() throws Exception {
        new Select(tool.searchUsingID(tool, "subscriber")).selectByIndex(1);
    }

    public void clickOrdering() throws Exception {
        tool.driver.findElement(By.id("ordering")).click();
    }

    public void clickAddRole() {
        tool.driver.findElement(By.id("add_role")).click();
    }

    public void clickAdd() {
        tool.driver.findElement(By.id("submitButton")).click();
    }

    public void clickAccountManager() {
        tool.driver.findElement(By.id("roleCmp")).click();
    }

    public void clickActions(String FName) {
        tool.driver.findElement(By.xpath("//div[contains(text(),'" + FName + "')]/../..//button")).click();
    }

    public void clickActionstoChangeOwner() {
        // tool.driver.findElement(By.xpath("//*[@id='yui-gen16-button']")).click();
        tool.driver
                .findElement(
                        By.xpath(" //div[contains(text(),'Customer Owner Person')]/../following-sibling::td/following-sibling::td//div[contains(text(),'Active')]/../following-sibling::td//button"))
                .click();
    }

    public void clickActions3() throws Exception {
        tool.clickUsingCssSelector(tool, "button[type='button'][id$=-button][class='submit']");
    }

    public void clickModifyRole() throws Exception {

        tool.clickUsingLinkText(tool, "Modify Role");

    }

    public void selectCustomerManagerPersonRole() {
        tool.driver.findElement(By.id("role_2")).click();
    }

    public void clickOKFromSelectPersonaRole() {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

    public void clickDeactivateRole() throws Exception {
        tool.clickUsingLinkText(tool, "Deactivate Role");
    }

    public void clickOKFromDeactivateRole() {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

    public void checkAccountManager() {
        tool.driver.findElement(By.id("roleCmp")).click();
    }

    public void clickChangeOwner() {
        tool.driver.findElement(By.xpath("//a[contains(text(),'Change Owner')]")).click();
    }

    public void clickSwap() {
        tool.driver.findElement(By.id("submitButton")).click();
    }

    public AddLoginCommon clickActionsAddLoginForPerson(String personLastName) throws Exception {

        tool.driver.findElement(By.xpath("//div[contains(text(),'" + personLastName + "')]/../..//*[@type='button']")).click();
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
        // new
        // Select(tool.searchUsingID(tool,
        // "custPerson")).selectByVisibleText(pers.getPersonFirstNameProperty()
        // + " "
        // + pers.getPersonLastNameProperty());
        new Select(tool.searchUsingID(tool, "title")).selectByVisibleText("Mr.");
        tool.enterStringUsingId(tool, "firstName", "test*");
        tool.driver.findElement(By.id("pm-button-search")).click();
        final List<WebElement> radios = tool.driver.findElements(By.name("pfr-selected-person"));
        radios.get(0).click();
        tool.driver.findElement(By.xpath("//*[@id='personfind']/div[2]/div/form/div[2]/input[2]")).click();
        tool.clickUsingCssSelector(tool, "input[id=submitButton][value='Swap']");

    }

    public void clickDissociate() throws Exception {

        tool.clickUsingLinkText(tool, "Disassociate Role");
    }

    public void clickOKFromDissociate() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

    public void clickAssociateRoleToSubscriber() throws Exception {
        // tool.driver.findElement(By.xpath("//a[contains(text(),'Associate Role to Subscriber')]")).click();
        tool.clickUsingLinkText(tool, "Associate Role to Subscriber");
    }

    public void clickOKAssociateRoleToSubscriber() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
    }

    public String getLastNameOfCOP() throws Exception {

        String cop_fullName = tool.driver.findElement(By.xpath("//div[contains(text(),'Customer Owner Person')]/../../td[1]")).getText();

        String temp[] = cop_fullName.split(" ");
        System.out.println("COP LastName" + temp[1]);
        return temp[1];

    }

    public PersonMergeCommon clickPersonMerge() throws Exception {

        tool.clickUsingLinkText(tool, "Person Merge");

        return new PersonMergeCommon(tool, test, user);
    }

}
