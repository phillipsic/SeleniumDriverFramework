package com.comverse.css.csr;

import java.util.Calendar;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewHierarchyCommon;

public class ViewHierarchy extends ViewHierarchyCommon {

    public ViewHierarchy(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    public NewMemberLegalAddress clickAddEmployeeOCM() throws Exception {

        tool.clickUsingID(tool, "smnu_ADD_MEMBER");
        return new NewMemberLegalAddress(tool, test, user);
    }

    public NewMemberLegalAddress clickAddEmployee() throws Exception {

        tool.clickUsingID(tool, "smnu_ADD_MEMBER");
        return new NewMemberLegalAddress(tool, test, user);
    }

    public AddEmployeeContactInformation clickAddB2BEmployee() throws Exception {

        tool.clickUsingID(tool, "smnu_REGISTER_EMPLOYEE");
        return new AddEmployeeContactInformation(tool, test, user);
    }

    public ViewHierarchy addWeeklyLevel() throws Exception {

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

        tool.clickUsingID(tool, "smnu_ADD_LEVEL");
        return new AddSubLevelSelectLevelType(tool, test, user);
    }

    public MoveLevel clickMoveLevel() throws Exception {

        tool.clickUsingID(tool, "smnu_MOVE_LEVEL");
        return new MoveLevel(tool, test, user);
    }

    public RemoveSelection clickRemoveLevel() throws Exception {

        tool.clickUsingID(tool, "smnu_REMOVE_LEVEL");
        return new RemoveSelection(tool, test, user);
    }

    public LevelLegalContact clickViewContact() throws Exception {

        tool.clickUsingID(tool, "smnu_ADDRESS");
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
