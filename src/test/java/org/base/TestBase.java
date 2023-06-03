package org.base;

import com.shaft.driver.SHAFT;
import org.testng.annotations.*;

public class TestBase {
    public SHAFT.GUI.WebDriver driver;


    @Parameters({"platformName"})
    @BeforeSuite
    public void setUpDriver(@Optional(value = "Android") String platformName) {

        if (platformName.equalsIgnoreCase("IOS")) {
            SHAFT.Properties.platform.set().targetPlatform("IOS");
            driver = new SHAFT.GUI.WebDriver();

        } else if (platformName.equalsIgnoreCase("ANDROID")) {
            driver = new SHAFT.GUI.WebDriver();

        } else if(platformName.equalsIgnoreCase("BrowserStack")){

        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterClass() {
        //       driver.quit();
    }
}
