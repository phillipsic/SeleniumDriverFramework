package com.comverse.css.csr;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewHierarchyCommon;

public class ViewHierarchy extends ViewHierarchyCommon {

    public ViewHierarchy(WebDriver driver) throws Exception {
        super(driver);

    }

    public NewMemberLegalAddress clickAddEmployeeOCM() throws Exception {

        driver.findElement(By.id("smnu_ADD_MEMBER")).click();
        return new NewMemberLegalAddress(driver);
    }

    public NewMemberLegalAddress clickAddEmployee() throws Exception {

        driver.findElement(By.id("smnu_ADD_MEMBER")).click();
        return new NewMemberLegalAddress(driver);
    }

    public AddEmployeeContactInformation clickAddB2BEmployee() throws Exception {

        driver.findElement(By.id("smnu_REGISTER_EMPLOYEE")).click();
        return new AddEmployeeContactInformation(driver);
    }

    public ViewHierarchy addWeeklyLevel() throws Exception {

        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        String weeklyLevelName = "level" + week + "a";

        if (!Common.isTextOnPage(driver, weeklyLevelName)) {

            AddSubLevelSelectLevelType addSubLevelSelectLevelType = this.clickAddLevel();

            AddSubLevelLegalAddress addSubLevelLegalAddress = addSubLevelSelectLevelType.clickOk();
            addSubLevelLegalAddress.setLevelName(weeklyLevelName);
            RequestSubmission requestSubmission = addSubLevelLegalAddress.clickOk();
            requestSubmission.clickOk();

            System.out.println("Created level " + weeklyLevelName);
        } else {

            System.out.println("Weekly level already exists " + weeklyLevelName);
        }

        return new ViewHierarchy(driver);

    }

    public AddSubLevelSelectLevelType clickAddLevel() throws Exception {

        driver.findElement(By.id("smnu_ADD_LEVEL")).click();
        return new AddSubLevelSelectLevelType(driver);
    }

    public MoveLevel clickMoveLevel() throws Exception {

        driver.findElement(By.id("smnu_MOVE_LEVEL")).click();
        return new MoveLevel(driver);
    }

    public RemoveSelection clickRemoveLevel() throws Exception {

        driver.findElement(By.id("smnu_REMOVE_LEVEL")).click();
        return new RemoveSelection(driver);
    }

    public LevelLegalContact clickViewContact() throws Exception {

        driver.findElement(By.id("smnu_ADDRESS")).click();
        return new LevelLegalContact(driver);
    }

    @Override
    public ContactInformation clickEmployeeNameLink(String firstName, String lastName) throws Exception {

        super.clickEmployeeNameLink(firstName, lastName);
        return new ContactInformation(driver);
    }

    @Override
    public MyshapeCSRPortal clickLogout() throws Exception {

        super.clickLogout();
        return new MyshapeCSRPortal(driver);
    }

    public String addEmployee(String uniqueCode, @SuppressWarnings("unused") String role) throws Exception {

        NewMemberLegalAddress newMemberLegalAddress = this.clickAddEmployee();
        newMemberLegalAddress.setFirstName("FN" + uniqueCode);
        newMemberLegalAddress.setLastName("LN" + uniqueCode);
        Login addEmployeeRegisterLogin = newMemberLegalAddress.clickContinue();
        addEmployeeRegisterLogin.enterLogin(uniqueCode);

        AddMemberConfirmation addEmployeeConfirmation = addEmployeeRegisterLogin.clickSubmit();
        AddMember registerLogin = addEmployeeConfirmation.clickOk();
        String tempPassword = registerLogin.getTempPasswordFromPage();
        registerLogin.clickOk();

        return tempPassword;
    }

    public String addBusinessAdminEmployee(String uniqueCode) throws Exception {

        AddEmployeeContactInformation addEmployeeContactInformation = this.clickAddB2BEmployee();
        addEmployeeContactInformation.setFirstName("FN" + uniqueCode);
        addEmployeeContactInformation.setLastName("LN" + uniqueCode);
        AddEmployeeRegisterLogin addEmployeeRegisterLogin = addEmployeeContactInformation.clickContinue();
        addEmployeeRegisterLogin.enterLogin(uniqueCode);

        AddEmployeeConfirmation addMemberConfirmation = addEmployeeRegisterLogin.clickSubmit();
        RegisterLogin registerLogin = addMemberConfirmation.clickOk();
        String tempPassword = registerLogin.getTempPasswordFromPage();
        registerLogin.clickOk();

        return tempPassword;
    }

    public String addOCMPublisherEmployee(String uniqueCode) throws Exception {

        NewMemberLegalAddress newMemberLegalAddress = this.clickAddEmployeeOCM();
        newMemberLegalAddress.setFirstName("FN" + uniqueCode);
        newMemberLegalAddress.setLastName("LN" + uniqueCode);
        Login login = newMemberLegalAddress.clickContinue();
        login.enterLogin(uniqueCode);
        login.setRoles("OCM Publisher");

        AddMemberConfirmation addMemberConfirmation = login.clickContinue();
        AddMember AddMember = addMemberConfirmation.clickOk();
        String tempPassword = AddMember.getTempPasswordFromPage();
        AddMember.clickOk();

        return tempPassword;
    }
}
