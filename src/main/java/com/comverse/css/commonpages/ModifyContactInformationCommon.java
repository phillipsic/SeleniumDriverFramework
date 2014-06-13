/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyContactInformationCommon extends CommonMenu {

    public ModifyContactInformationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Modify Contact Information";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getFirstName() throws Exception {

        return tool.driver.findElement(By.id("first_name")).getAttribute("value");
    }

    public String getLastName() throws Exception {

        return tool.driver.findElement(By.id("last_name")).getAttribute("value");
    }

    public String getAddressLineOne() throws Exception {

        return tool.driver.findElement(By.id("address_line_1")).getAttribute("value");
    }

    public String getAddressLineTwo() throws Exception {

        return tool.driver.findElement(By.id("address_line_2")).getAttribute("value");
    }

    public String getAddressLineThree() throws Exception {

        return tool.driver.findElement(By.id("address_line_3")).getAttribute("value");
    }

    public String getAddressLineFour() throws Exception {

        return tool.driver.findElement(By.id("address_line_4")).getAttribute("value");
    }

    public String getZipCode() throws Exception {

        return tool.driver.findElement(By.id("home_zip")).getAttribute("value");
    }

    public String getCity() throws Exception {

        return tool.driver.findElement(By.id("home_city")).getAttribute("value");
    }

    public String getState() throws Exception {

        return new Select(tool.searchUsingID(tool, "home_state")).getFirstSelectedOption().getText();

    }

    public String getEmail() throws Exception {

        return tool.driver.findElement(By.id("email")).getAttribute("value");
    }

    public String getPhoneNumber() throws Exception {
        return tool.driver.findElement(By.id("home_phone")).getAttribute("value");
    }

    public String getFaxNumber() throws Exception {
        return tool.driver.findElement(By.id("fax")).getAttribute("value");
    }

    public String getDayPhone() throws Exception {
        return tool.driver.findElement(By.id("home_phone")).getAttribute("value");
    }

    public String getEveningPhone() throws Exception {
        return tool.driver.findElement(By.id("work_phone")).getAttribute("value");
    }

    public void enterFirstName(String FN) throws Exception {
        tool.driver.findElement(By.id("first_name")).clear();
        tool.driver.findElement(By.id("first_name")).sendKeys(FN);
    }

    public void enterLastName(String lastName) throws Exception {
        tool.driver.findElement(By.id("last_name")).clear();
        tool.driver.findElement(By.id("last_name")).sendKeys(lastName);

    }

    public void enterDayPhone(String dayPhone) throws Exception {
        tool.driver.findElement(By.id("home_phone")).clear();
        tool.driver.findElement(By.id("home_phone")).sendKeys(dayPhone);

    }

    public void enterEveningPhone(String eveningPhone) throws Exception {
        tool.driver.findElement(By.id("work_phone")).clear();
        tool.driver.findElement(By.id("work_phone")).sendKeys(eveningPhone);

    }

    public void enterEmail(String eMail) throws Exception {
        tool.driver.findElement(By.id("email")).clear();
        tool.driver.findElement(By.id("email")).sendKeys(eMail);
    }

    public void enterPhoneNumber(String phoneNumber) throws Exception {
        tool.driver.findElement(By.id("home_phone")).clear();
        tool.driver.findElement(By.id("home_phone")).sendKeys(phoneNumber);
    }

    public void enterFaxNumber(String faxNumber) throws Exception {
        tool.driver.findElement(By.id("fax")).clear();
        tool.driver.findElement(By.id("fax")).sendKeys(faxNumber);
    }

    public void enterAddressLineOne(String addressLineOne) throws Exception {
        tool.driver.findElement(By.id("address_line_1")).clear();
        tool.driver.findElement(By.id("address_line_1")).sendKeys(addressLineOne);
    }

    public void enterPostCode(String postCode) throws Exception {
        tool.driver.findElement(By.id("home_zip")).clear();
        tool.driver.findElement(By.id("home_zip")).sendKeys(postCode);
    }

    public void enterCity(String city) throws Exception {
        tool.driver.findElement(By.id("home_city")).clear();
        tool.driver.findElement(By.id("home_city")).sendKeys(city);
    }

    public void enterState(String state) throws Exception {
        new Select(tool.searchUsingID(tool, "home_state")).selectByVisibleText(state);

    }

    public void enterCountry(String country) throws Exception {
        new Select(tool.searchUsingID(tool, "home_country")).selectByVisibleText(country);
    }

    public ModifyContactInformationConfirmationCommon clickOk() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ModifyContactInformationConfirmationCommon(tool, test, user);
    }

    public void setLevelName(String uniqueString) throws Exception {

        tool.driver.findElement(By.id("company_name")).clear();
        tool.driver.findElement(By.id("company_name")).sendKeys(uniqueString);
    }

    public void setLevelState(String uniqueState) throws Exception {

        new Select(tool.searchUsingID(tool, "home_state")).selectByVisibleText(uniqueState);
    }
}
