package Screens;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginScreen {
    SHAFT.GUI.WebDriver mobile;

    private By mobileBtn = By.xpath("//*[contains(@resource-id, 'btnmobileNumber')]");
    private By userNameFld = By.xpath("//MwalletCustomTextInputLayout/*[contains(@resource-id, 'editText_username')]");
    private By passwordFld = By.xpath("//*[contains(@resource-id, 'editText_password')]");
    private By loginBtn = By.xpath("//*[contains(@resource-id, 'button_login')]");
    private By nationalIdFld = By.xpath("//*[contains(@resource-id, 'et_nationa_id')]");
    private By nationalIDConfirmBtn = By.xpath("//*[contains(@resource-id, 'btn_nation_id_confirm')]");
    private By verificationCodeFld = By.xpath("//*[contains(@resource-id, 'et_verification_code')]");
    private By continueBtn = By.xpath("//*[contains(@resource-id, 'button_continue')]");
    private By newVersionCancelBtn = By.id("btn_negative");
    private By disableFingerPrint = By.xpath("//*[ (@text = 'No, Thank you' or . = 'No, Thank you') and contains(@resource-id, 'custom_dialog_cancelBtn_id')]");
    private By skipBtn = By.xpath("//*[contains(@resource-id, 'tv_skip')]");
    private By quickPayCancelBtn = By.id("tv_cancel");

    public LoginScreen(SHAFT.GUI.WebDriver mobile) {
        this.mobile = mobile;
    }

    public void Login(String phone, String password) {

                addCredential(phone,password)
                .checkNationalId()
                .checkVerificationCode()
                .checkNewVersionPopup()
                .disableFingerPrint()
                .skip();

    }

    public LoginScreen addCredential(String phone, String password) {
        mobile.element().waitToBeReady(mobileBtn)
                .click(mobileBtn)
                .typeAppend(userNameFld, phone)
                .typeAppend(passwordFld, password)
                .click(loginBtn);

        return this;
    }

    public LoginScreen checkNationalId() {
        AppiumDriver driver = (AppiumDriver) mobile.getDriver();

        // 'Verify if National ID Field is Required'
        try {

            mobile.assertThat().element(nationalIdFld).exists().perform();
            mobile.element()
                    .click(nationalIdFld)
                    .typeAppend(nationalIdFld, "t432")
                    .click(nationalIDConfirmBtn);
        } catch (Error e) {
            System.out.println("_____" + "NationalId screen is not exist" + "_____");
        }

        return this;
    }

    public LoginScreen checkVerificationCode() {
        try {
            mobile.assertThat().element(verificationCodeFld).exists().perform();
            ;
            mobile.element()
                    .typeAppend(verificationCodeFld, "t432")
                    .click(continueBtn);
        } catch (Error e) {
            System.out.println("_____" + "Verification Code  screen is not exist" + "_____");
        }
        return this;
    }

    public LoginScreen checkNewVersionPopup() {
        try {
            mobile.assertThat().element(newVersionCancelBtn).exists().perform();
            mobile.element().click(newVersionCancelBtn);
        } catch (Error e) {
            System.out.println("_____" + "New Version cancel Button is not exist" + "_____");
        }
        return this;
    }

    public LoginScreen disableFingerPrint() {
        try {
            mobile.assertThat().element(disableFingerPrint).exists().perform();
            mobile.element().click(disableFingerPrint);
        } catch (
                Error e) {
            System.out.println("_____" + "Finger Button is not exist" + "_____");
        }
        return this;
    }

    public HomeScreen skip() {
        try {
            mobile.element()
                    .waitToBeReady(skipBtn)
                    .click(skipBtn);
        } catch (
                Error e) {
            System.out.println("_____" + "Skip Button is not exist" + "_____");
        }

        //Skip Quick Pay
        try {
            mobile.element()
                    .waitToBeReady(quickPayCancelBtn)
                    .click(quickPayCancelBtn);
        } catch (
                Error e) {
            System.out.println("_____" + "Quick Pay Popup is not exist" + "_____");
        }
        return new HomeScreen(mobile);
    }


}


