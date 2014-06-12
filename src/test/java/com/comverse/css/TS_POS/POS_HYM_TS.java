package com.comverse.css.TS_POS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.comverse.css.pos.hym.*;

@RunWith(Suite.class)
@SuiteClasses({ HYM0010_Browse_Hierarchy.class, HYM0020_Add_level.class, HYM0030_Move_level.class, HYM0040_Remove_level.class,
               HYM0050_View_level_contact.class, HYM0060_Modify_level_contact.class, HYM0070_View_level_profile.class,
               HYM0080_Modify_level_profile.class })
public class POS_HYM_TS {
}
