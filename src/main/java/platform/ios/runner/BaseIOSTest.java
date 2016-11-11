package platform.ios.runner;

import common.AbstractPage;
import common.BaseAcceptance;
import platform.Platform;
import platform.ios.pages.HomePage;
import platform.ios.pages.LoginPage;

public class BaseIOSTest extends BaseAcceptance {

    /*
     * Set the platform name
     */
    Platform iosPlatform = new Platform("ios");

    /*
     * Instantiate page object(s)
     */
    protected HomePage homePage = new HomePage();
    protected LoginPage loginPage = new LoginPage();

    @Override
    public void setPlatform(Platform platform) {
        super.setPlatform(platform);
    }

    @Override
    public void setPages(AbstractPage abstractPage) {
        super.setPages(abstractPage);
    }

    @Override
    public void setUp() throws Exception {

        // Invoke the super class setUp() method
        this.setPages(homePage);
        this.setPages(loginPage);

        this.setPlatform(iosPlatform);
        super.setUp();
    }

}
