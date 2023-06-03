package org.Android;

import Screens.LoginScreen;

import com.shaft.driver.SHAFT;
import org.base.TestBase;
import org.testng.annotations.Test;

public class LoginTC extends TestBase {

    SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("simpleJSON.json");

    @Test
    public void login() {
          new LoginScreen(driver)
                  .addCredential(testData.getTestData("userPhone"), testData.getTestData("userPassword"))
                  .checkNationalId()
                  .checkVerificationCode()
                  .checkNewVersionPopup()
                  .disableFingerPrint()
                  .skip();

    }


}
