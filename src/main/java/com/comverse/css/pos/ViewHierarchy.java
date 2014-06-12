package com.comverse.css.pos;

import java.util.Calendar;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.RegisterLoginCommon;
import com.comverse.css.commonpages.ViewHierarchyCommon;

public class ViewHierarchy extends ViewHierarchyCommon {

    public ViewHierarchy(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    public String addEmployeeTelcoRetailerAdministrator(String uniqueCode) throws Exception {

        AddEmployeeContactInformation addEmployeeContactInformation = this.clickAddEmployee();
        addEmployeeContactInformation.setFirstName("FN" + uniqueCode);
        addEmployeeContactInformation.setLastName("LN" + uniqueCode);
        addEmployeeContactInformation.enterHomeState("Alaska");
        AddEmployeeRegisterLogin addEmployeeRegisterLogin = addEmployeeContactInformation.clickContinue();
        addEmployeeRegisterLogin.setLogin(uniqueCode);
        addEmployeeRegisterLogin.selectRoleTelcoRetailerAdministrator();
        AddEmployeeConfirmation addMemberConfirmation = addEmployeeRegisterLogin.clickContinue();
        RegisterLoginCommon registerLogin = addMemberConfirmation.clickOk();
        String tempPassword = registerLogin.getTempPasswordFromPage();
        registerLogin.clickOk();

        return tempPassword;
    }

    public AddEmployeeContactInformation clickAddEmployee() throws Exception {

        tool.driver.findElement(By.id("smnu_REGISTER_EMPLOYEE")).click();

        return new AddEmployeeContactInformation(tool, test, user);

    }

    public ViewHierarchyCommon addWeeklyLevel() throws Exception {

        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        String weeklyLevelName = "level" + week + "a";

        if (!Common.isTextOnPage(tool, weeklyLevelName)) {

            AddLevelContactInformation addLevelContactInformation = this.clickAddLevel();

            addLevelContactInformation.setLevelName(weeklyLevelName);
            addLevelContactInformation.setLevelState("Alaska");
            addLevelContactInformation.setLevelZipCode("zip code");

            AddLevelConfirmation addLevelConfirmation = addLevelContactInformation.clickOk();
            AddLevel addLevel = addLevelConfirmation.clickOk();

            addLevel.clickOk();

            System.out.println("Created level " + weeklyLevelName);
        } else {

            System.out.println("Weekly level already exists " + weeklyLevelName);
        }

        return new ViewHierarchyCommon(tool, test, user);

    }

    public AddLevelContactInformation clickAddLevel() throws Exception {

        tool.driver.findElement(By.id("smnu_ADD_LEVEL")).click();
        return new AddLevelContactInformation(tool, test, user);
    }

    @Override
    public ContactInformation clickEmployeeNameLink(String firstName, String lastName) throws Exception {

        super.clickEmployeeNameLink(firstName, lastName);
        return new ContactInformation(tool, test, user);
    }

    public String addEmployeeTelcoRetailerSubscriber(String uniqueCode) throws Exception {

        AddEmployeeContactInformation addEmployeeContactInformation = this.clickAddEmployee();
        addEmployeeContactInformation.setFirstName("FN" + uniqueCode);
        addEmployeeContactInformation.setLastName("LN" + uniqueCode);
        addEmployeeContactInformation.enterHomeState("Alaska");
        AddEmployeeRegisterLogin addEmployeeRegisterLogin = addEmployeeContactInformation.clickContinue();
        addEmployeeRegisterLogin.setLogin(uniqueCode);
        addEmployeeRegisterLogin.selectRoleTelcoRetailerSubscriber();
        AddEmployeeConfirmation addMemberConfirmation = addEmployeeRegisterLogin.clickContinue();
        RegisterLogin registerLogin = addMemberConfirmation.clickOk();
        String tempPassword = registerLogin.getTempPasswordFromPage();
        registerLogin.clickOk();

        return tempPassword;
    }

    @Override
    public MyShapeChannel clickLogout() throws Exception {

        super.clickLogout();
        return new MyShapeChannel(tool, test, user);
    }

    public MoveLevel clickMoveLevel() throws Exception {

        tool.driver.findElement(By.id("smnu_MOVE_LEVEL")).click();
        return new MoveLevel(tool, test, user);
    }

    public RemoveLevel clickRemoveLevel() throws Exception {

        tool.driver.findElement(By.id("smnu_REMOVE_LEVEL")).click();
        return new RemoveLevel(tool, test, user);
    }

    public ContactInformation clickViewContact() throws Exception {

        tool.driver.findElement(By.id("smnu_ADDRESS")).click();
        return new ContactInformation(tool, test, user);
    }

    public ProfileInformation clickViewProfile() throws Exception {

        tool.driver.findElement(By.id("smnu_PROFILE")).click();
        return new ProfileInformation(tool, test, user);
    }
}
