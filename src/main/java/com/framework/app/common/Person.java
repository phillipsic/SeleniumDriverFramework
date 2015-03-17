package com.framework.app.common;

import com.comverse.css.data.C1Data;

public class Person extends C1Data {

    private String personLastNameProperty;
    private String personFirstNameProperty;
    private String personGenderProperty;
    private String personTitleProperty;
    private String personHomeCountryProperty;
    private String personHomeStateProperty;
    private String personStreetNumberProperty;
    private String personStreetNameProperty;
    private String personCityProperty;
    private String personPostCodeProperty;
    private String personNationalityProperty;
    private String personLanguageProperty;
    private String personNationalIDProperty;
    private String personDateOfBirthProperty;
    private String personEmailAddressProperty;
    private String personPhoneNumberProperty;
    private String personMobileNumberProperty;
    private String personFaxNumberProperty;

    public Person(String uniqueTimeStamp) {
        setPersonLastNameProperty("PersonLN" + uniqueTimeStamp);
        setPersonFirstNameProperty("PersonFN" + uniqueTimeStamp);
        setPersonGenderProperty("female");
        setPersonTitleProperty("Mrs.");
        setPersonHomeCountryProperty("United States");
        setPersonHomeStateProperty("Iowa");
        setPersonStreetNumberProperty("Person55");
        setPersonStreetNameProperty("PersonStreet");
        setPersonCityProperty("PersonCity");
        setPersonPostCodeProperty("PersonPostcode");
        setPersonNationalityProperty("Bulgaria");
        setPersonLanguageProperty("English");
        setPersonNationalIDProperty(uniqueTimeStamp);
        setPersonDateOfBirthProperty("03/13/1975");
        setPersonEmailAddressProperty("email@address.com");
        setPersonPhoneNumberProperty("0123456789");
        setPersonMobileNumberProperty("0623456789");
        setPersonFaxNumberProperty("0823456789");
    }

    public Person() {
    }

    public String getPersonLastNameProperty() {
        return personLastNameProperty;
    }

    public void setPersonLastNameProperty(String personLastNameProperty) {
        System.out.println("set PersonLastNameProperty = " + personLastNameProperty);
        this.personLastNameProperty = personLastNameProperty;
    }

    public String getPersonFirstNameProperty() {
        return personFirstNameProperty;
    }

    public void setPersonFirstNameProperty(String personFirstNameProperty) {
        this.personFirstNameProperty = personFirstNameProperty;
    }

    public String getPersonGenderProperty() {
        return personGenderProperty;
    }

    public void setPersonGenderProperty(String personGenderProperty) {
        this.personGenderProperty = personGenderProperty;
    }

    public String getPersonTitleProperty() {
        return personTitleProperty;
    }

    public void setPersonTitleProperty(String personTitleProperty) {
        this.personTitleProperty = personTitleProperty;
    }

    public String getPersonHomeCountryProperty() {
        return personHomeCountryProperty;
    }

    public void setPersonHomeCountryProperty(String personHomeCountryProperty) {
        this.personHomeCountryProperty = personHomeCountryProperty;
    }

    public String getPersonHomeStateProperty() {
        return personHomeStateProperty;
    }

    public void setPersonHomeStateProperty(String personHomeStateProperty) {
        this.personHomeStateProperty = personHomeStateProperty;
    }

    public String getPersonStreetNumberProperty() {
        return personStreetNumberProperty;
    }

    public void setPersonStreetNumberProperty(String personStreetNumberProperty) {
        this.personStreetNumberProperty = personStreetNumberProperty;
    }

    public String getPersonStreetNameProperty() {
        return personStreetNameProperty;
    }

    public void setPersonStreetNameProperty(String personStreetNameProperty) {
        this.personStreetNameProperty = personStreetNameProperty;
    }

    public String getPersonCityProperty() {
        return personCityProperty;
    }

    public void setPersonCityProperty(String personCityProperty) {
        this.personCityProperty = personCityProperty;
    }

    public String getPersonPostCodeProperty() {
        return personPostCodeProperty;
    }

    public void setPersonPostCodeProperty(String personPostCodeProperty) {
        this.personPostCodeProperty = personPostCodeProperty;
    }

    public String getPersonNationalityProperty() {
        return personNationalityProperty;
    }

    public void setPersonNationalityProperty(String personNationalityProperty) {
        this.personNationalityProperty = personNationalityProperty;
    }

    public String getPersonLanguageProperty() {
        return personLanguageProperty;
    }

    public void setPersonLanguageProperty(String personLanguageProperty) {
        this.personLanguageProperty = personLanguageProperty;
    }

    public String getPersonNationalIDProperty() {
        return personNationalIDProperty;
    }

    public void setPersonNationalIDProperty(String personNationalIDProperty) {
        this.personNationalIDProperty = personNationalIDProperty;
    }

    public String getPersonDateOfBirthProperty() {
        return personDateOfBirthProperty;
    }

    public void setPersonDateOfBirthProperty(String personDateOfBirthProperty) {
        this.personDateOfBirthProperty = personDateOfBirthProperty;
    }

    public String getPersonEmailAddressProperty() {
        return personEmailAddressProperty;
    }

    public void setPersonEmailAddressProperty(String personEmailAddressProperty) {
        this.personEmailAddressProperty = personEmailAddressProperty;
    }

    public String getPersonPhoneNumberProperty() {
        return personPhoneNumberProperty;
    }

    public void setPersonPhoneNumberProperty(String personPhoneNumberProperty) {
        this.personPhoneNumberProperty = personPhoneNumberProperty;
    }

    public String getPersonMobileNumberProperty() {
        return personMobileNumberProperty;
    }

    public void setPersonMobileNumberProperty(String personMobileNumberProperty) {
        this.personMobileNumberProperty = personMobileNumberProperty;
    }

    public String getPersonFaxNumberProperty() {
        return personFaxNumberProperty;
    }

    public void setPersonFaxNumberProperty(String personFaxNumberProperty) {
        this.personFaxNumberProperty = personFaxNumberProperty;
    }

}
