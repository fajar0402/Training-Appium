package platform.ios;

import org.junit.Test;
import platform.ios.pages.HomePage;
import platform.ios.runner.BaseIOSTest;

/**
 * Created by C07HJAXNDJD0 on 6/14/16.
 */
public class HomeTest extends BaseIOSTest {

    @Test
    public void Test(){

        loginPage.signIn("asd@mail.com", "Welcome123");
    }

}
