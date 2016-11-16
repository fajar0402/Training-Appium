package platform.ios.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import platform.ios.modules.AbstractOGModule;

/**
 * Created by C07HJAXNDJD0 on 6/14/16.
 */
public class HomePage extends AbstractOGModule {

    // init your page object in home page

    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")
    private WebElement homeDiscoverText;

    @iOSFindBy(xpath = "//UIAStaticText[@name='Discover the New Olive Garden®']")
    private MobileElement homeDiscoverName;

    @iOSFindBy(xpath = "//UIAStaticText[contains(@name, 'Discover')]")
    private MobileElement homeDiscoverContains;

    @iOSFindBy(xpath = "//UIATableView[2]/UIATableCell[2]/UIAStaticText[1]")
    private MobileElement findRestaurantOption;

    /**
     * To check Home Discover in Home page
     */
    public void checkHomeDiscoverText(){
        assertEquals("Text is not match", "Discover the New Olive Garden®", homeDiscoverText.getText());
    }

    /**
     * To click Find Restaurant Option in Home page
     */
    public void clickFindRestaurantOptionsBtn(){
        assertTrue("Find Restaurant button is missing", findRestaurantOption.isDisplayed());
        findRestaurantOption.click();
    }

}
