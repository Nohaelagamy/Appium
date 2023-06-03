package Screens;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class RegisterScreen {
    SHAFT.GUI.WebDriver mobile;

    private By createAccountBtn = By.id("text_view_create_account");
    private By userNameFld = By.xpath("//MwalletCustomTextInputLayout//*[@resource-id,'editText_mobile_number']");
    private By termsChBox = By.id("agree_checkBox");
    private By continueBtn = By.id("btn_Verify");
    private By verificationCodeTxb = By.id("et_verification_code");
    private By verifyBtn = By.xpath("//android.widget.Button[@text='Verify']");
    private By passwordTxb = By.id("editText_password");
    private By renterPasswordTxb = By.id("editText_renter_password");
    private By signUpBtn = By.id("button_signUp");

    public RegisterScreen(SHAFT.GUI.WebDriver mobile) {
        this.mobile = mobile;
    }


    public RegisterScreen addCredential(String phone) {
        mobile.element().waitToBeReady(createAccountBtn)
                .click(createAccountBtn)
                .typeAppend(userNameFld, phone)
                .click(termsChBox)
                .click(continueBtn);

        return this;
    }



    public RegisterScreen addVerificationCode(String code) {
        mobile.element().waitToBeReady(verificationCodeTxb)
                .typeAppend(verificationCodeTxb, code)
                .click(verifyBtn);

        return this;
    }

    public LoginScreen addNewPassword(String password) {
        mobile.element().waitToBeReady(passwordTxb)
                .typeAppend(passwordTxb, password)
                .typeAppend(renterPasswordTxb, password)
                .click(signUpBtn);

        return new LoginScreen(mobile);
    }









}


