/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.SubscriberDetailsCommon;

public class SubscriberDetails extends SubscriberDetailsCommon {

    public SubscriberDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewCombinedHistory clickonCombinedHistory() throws Exception {
        super.clickonCombinedHistory();
        return new ViewCombinedHistory(tool, test, user);
    }

    @Override
    public ViewTransactionHistory clickHistories() throws Exception {
        super.clickHistories();
        return new ViewTransactionHistory(tool, test, user);
    }

    @Override
    public ViewBalance viewBalanceAndRecharge() throws Exception {
        super.viewBalanceAndRecharge();
        return new ViewBalance(tool, test, user);
    }

    @Override
    public SuspendSubscriberRequestForDetails clickSuspendSubscriber() throws Exception {
        super.clickSuspendSubscriber();
        return new SuspendSubscriberRequestForDetails(tool, test, user);
    }

    @Override
    public ResumeSubscriberRequestForDetails clickResumeSubscriber() throws Exception {
        super.clickResumeSubscriber();
        return new ResumeSubscriberRequestForDetails(tool, test, user);
    }

    @Override
    public FraudlockSubscriberRequestForDetails clickFraudlockSubscriber() throws Exception {
        super.clickFraudlockSubscriber();
        return new FraudlockSubscriberRequestForDetails(tool, test, user);
    }

    @Override
    public UnlockSubscriberRequestForDetails clickUnlockSubscriber() throws Exception {
        super.clickUnlockSubscriber();
        return new UnlockSubscriberRequestForDetails(tool, test, user);
    }

    @Override
    public DisconnectSubscriberRequestForDetails clickDisconnectSubscriber() throws Exception {
        super.clickDisconnectSubscriber();
        return new DisconnectSubscriberRequestForDetails(tool, test, user);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickMigrateToPostpaidSubscriber() throws Exception {
        super.clickMigrateToPostpaidSubscriber();
        return new CustomerAcquisitionCustomerDataReview(tool, test, user);
    }

    @Override
    public ModifySubscriberAttributes clickModifySubscriberDetails() throws Exception {
        super.clickModifySubscriberDetails();
        return new ModifySubscriberAttributes(tool, test, user);
    }

    @Override
    public ModifyOfferParameters clickModifyOfferParameters() throws Exception {
        super.clickModifyOfferParameters();
        return new ModifyOfferParameters(tool, test, user);
    }

    @Override
    public RemoveOffer clickDeleteOffer() throws Exception {
        super.clickDeleteOffer();
        return new RemoveOffer(tool, test, user);
    }

    @Override
    public ModifyContactInformation clickModifyContactInformation() throws Exception {
        super.clickModifyContactInformation();
        return new ModifyContactInformation(tool, test, user);
    }

    @Override
    public YourFriendsAndFamilyNumbers clickManageFriendsAndFamily() throws Exception {
        super.clickManageFriendsAndFamily();
        return new YourFriendsAndFamilyNumbers(tool, test, user);
    }

    @Override
    public PrimaryOfferDetails clickImageOfPrimaryOfferName(String offername) throws Exception {
        super.clickImageOfPrimaryOfferName(offername);
        return new PrimaryOfferDetails(tool, test, user);
    }

    @Override
    public Shopping clickChangePO_SBAndSO() throws Exception {
        super.clickChangePO_SBAndSO();
        return new Shopping(tool, test, user);
    }
}
