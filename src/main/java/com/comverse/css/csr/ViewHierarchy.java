package com.comverse.css.csr;

import java.util.Calendar;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewHierarchyCommon;
import com.comverse.data.users.OCMPub;

public class ViewHierarchy extends ViewHierarchyCommon {

    public ViewHierarchy(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    public NewMemberLegalAddress clickAddEmployeeOCM() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("smnu_ADD_MEMBER");
        return new NewMemberLegalAddress(tool, test, user);
    }

    public NewMemberLegalAddress clickAddEmployee() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("smnu_ADD_MEMBER");
        return new NewMemberLegalAddress(tool, test, user);
    }

    public AddEmployeeContactInformation clickAddB2BEmployee() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("smnu_REGISTER_EMPLOYEE");
        return new AddEmployeeContactInformation(tool, test, user);
    }

    public ViewHierarchy addWeeklyLevel() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        String weeklyLevelName = "level" + week + "a";

        if (!Common.isTextOnPage(tool, weeklyLevelName)) {

            AddSubLevelSelectLevelType addSubLevelSelectLevelType = this.clickAddLevel();

            AddSubLevelLegalAddress addSubLevelLegalAddress = addSubLevelSelectLevelType.clickOk();
            addSubLevelLegalAddress.setLevelName(weeklyLevelName);
            RequestSubmission requestSubmission = addSubLevelLegalAddress.clickOk();
            requestSubmission.clickOk();

            System.out.println("Created level " + weeklyLevelName);
        } else {

            System.out.println("Weekly level already exists " + weeklyLevelName);
        }

        return new ViewHierarchy(tool, test, user);
    }

    public AddSubLevelSelectLevelType clickAddLevel() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("smnu_ADD_LEVEL");
        return new AddSubLevelSelectLevelType(tool, test, user);
    }

    public MoveLevel clickMoveLevel() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("smnu_MOVE_LEVEL");
        return new MoveLevel(tool, test, user);
    }

    public RemoveSelection clickRemoveLevel() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("smnu_REMOVE_LEVEL");
        return new RemoveSelection(tool, test, user);
    }

    public LevelLegalContact clickViewContact() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("smnu_ADDRESS");
        return new LevelLegalContact(tool, test, user);
    }

    @Override
    public ContactInformation clickEmployeeNameLink(String firstName, String lastName) throws Exception {
        super.clickEmployeeNameLink(firstName, lastName);
        return new ContactInformation(tool, test, user);
    }

    @Override
    public MyshapeCSRPortal clickLogout() throws Exception {
        super.clickLogout();
        return new MyshapeCSRPortal(tool, test, user);
    }

    public String addEmployee(String uniqueCode, String role) throws Exception {
        test.writeInLogFile(Common.getMethodName());
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
        test.writeInLogFile(Common.getMethodName());
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

    public User addOCMPublisherEmployee(String uniqueCode) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        User OCMPubUser = new OCMPub();
        NewMemberLegalAddress newMemberLegalAddress = this.clickAddEmployeeOCM();
        newMemberLegalAddress.setFirstName("FN" + uniqueCode);
        newMemberLegalAddress.setLastName("LN" + uniqueCode);
        Login login = newMemberLegalAddress.clickContinue();
        login.enterLogin(uniqueCode);
        OCMPubUser.setNewLogin(uniqueCode);

        login.setRoles(OCMPubUser.getRole());

        AddMemberConfirmation addMemberConfirmation = login.clickContinue();
        AddMember AddMember = addMemberConfirmation.clickOk();
        String tempPassword = AddMember.getTempPasswordFromPage();
        OCMPubUser.setNewPassword(tempPassword);
        AddMember.clickOk();

        return OCMPubUser;
    }
}
