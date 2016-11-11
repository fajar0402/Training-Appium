package platform.ios.modules;

import common.AbstractPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import static org.junit.Assert.assertTrue;

public class AbstractOGModule extends AbstractPage {

    // init your global page object and method

    @iOSFindBy(xpath = "//UIAButton[contains(@label, 'Hamburger icon')]")
    public MobileElement hamburgerIcon;

    public void clickHamburgerIcon(){
        assertTrue("Hamburger Icon is not displayed", hamburgerIcon.isDisplayed());
        hamburgerIcon.click();
    }

}
