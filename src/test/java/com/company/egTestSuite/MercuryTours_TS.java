package com.company.egTestSuite;

import com.company.mercurytours.CHK001_RegisterUser;
import com.company.mercurytours.CHK002_LaunchSecondApplication;
import com.company.mercurytours.CHK003_RegisterUserBugIdExample;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CHK001_RegisterUser.class,
    CHK002_LaunchSecondApplication.class,
    CHK003_RegisterUserBugIdExample.class
})
public class MercuryTours_TS {
}
