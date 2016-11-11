package common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * Created by c1mnf3tddty3 on 10/6/15.
 */
public class AbstractPage {

    /**
     *   OliveGarden - Page Objects Module
     *   Picker
     */
    @iOSFindBy(xpath = "//UIAPicker[1]/UIAPickerWheel[1]")
    public MobileElement firstPicker;

    /**
     *   OliveGarden - Page Objects Module
     *   Keyboard
     */
    @iOSFindBy(xpath = "//UIAKeyboard[1]/UIAButton[contains(@name,'Search')]")
    public MobileElement searchKeyboard;

    /**
     *   OliveGarden - Page Objects Module
     *   Pop up Alert
     */
    @iOSFindBy(xpath = "//UIAAlert[1]/UIAScrollView[1]/UIAStaticText[1]")
    public MobileElement popUpAlertTitle;

}
