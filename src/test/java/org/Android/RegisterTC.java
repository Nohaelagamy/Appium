package org.Android;

import Screens.LoginScreen;
import Screens.RegisterScreen;
import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;
import org.base.TestBase;
import org.testng.annotations.Test;

public class RegisterTC extends TestBase {

    SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("simpleJSON.json");

    @Test
    public void register() {
      new RegisterScreen(driver)
              .addCredential("010"+ Faker.instance().phoneNumber().subscriberNumber(8))
              .addVerificationCode("12345")
              .addNewPassword("P@ssw0rd");

    }


}
