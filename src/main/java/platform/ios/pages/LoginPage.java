package platform.ios.pages;

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
    
    public void inputPassword(String password){
        assertTrue("Password Field is missing", passwordField.isDisplayed());
        passwordField.sendKeys(password);
    }
}
