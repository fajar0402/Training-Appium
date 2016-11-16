package platform.ios.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import platform.ios.modules.AbstractOGModule;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by angga_p on 11/11/16.
 */
public class LoginPage extends AbstractOGModule {

    @iOSFindBy(xpath = "//UIASecureTextField[1]") // Xpath
    public WebElement passwordField;

    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]")
    public MobileElement loginTabBtn;

    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]")
    public MobileElement createAccountTabBtn;

    @iOSFindBy(xpath = "//UIAButton[contains(@name, 'LOGIN WITH FACEBOOK')]")
    public MobileElement loginWithFacebookBtn;

    @iOSFindBy(xpath = "//UIATextField[contains(@name, 'Email')]")
    public MobileElement emailTextField;

    @iOSFindBy(xpath = "//UIASecureTextField[1]")
    public MobileElement passwordTextField;

    @iOSFindBy (xpath ="//UIATableCell[5]/UIAStaticText[1]")
    public MobileElement rememberMeText;

    @iOSFindBy(xpath="//UIATableCell[5]/UIASwitch[1]")
    public MobileElement rememberMeToggle;

    @iOSFindBy(xpath="//UIAButton[contains(@name, 'LOG IN')]")
    public MobileElement loginBtn;

    @iOSFindBy(xpath="//UIAButton[contains(@name, 'I FORGOT MY PASSWORD')]")
    public MobileElement forgotPasswordBtn;

    @iOSFindBy(xpath="//UIAButton[contains(@name, 'CREATE ACCOUNT')]")
    public MobileElement createAccountBtn;

    public void inputPassword(String password){
        assertTrue("Password Field is missing", passwordField.isDisplayed());
        passwordField.sendKeys(password);
    }

    public void inputEmailAddress(String emailAddress){
        assertTrue("Failed : Email address Field is not displayed",emailTextField.isDisplayed());
        emailTextField.click();
        emailTextField.sendKeys(emailAddress);
    }

    public void clickLoginBtn(){
        assertTrue("Failed : Login button is not displayed",loginBtn.isDisplayed());
        loginBtn.click();
    }

    public void signIn(String emailAddress, String password){
        inputEmailAddress(emailAddress);
        inputPassword(password);
        clickLoginBtn();
    }

}
