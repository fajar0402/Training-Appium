package common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by C07HJAXNDJD0 on 6/14/16.
 */
public class BaseAcceptance {

    protected Platform platform = new Platform();

    private String currentDeviceName = System.getProperty("deviceName");
    private String currentPlatformVersion = System.getProperty("platformVersion");
    private String currentAppName = System.getProperty("appName");
    private String currentAppPath = System.getProperty("appPath");
    private String currentAppActivity = System.getProperty("appActivity");
    private String currentAppPackage = System.getProperty("appPackage");

    public void setPlatform(Platform platform){
        this.platform = platform;
    }

    public Platform getPlatform(){
        return platform;
    }

    public boolean isCurrentDeviceNameNull(){
        log.info(" device name is             : " + currentDeviceName);
        return (currentDeviceName == null);
    }

    public boolean isCurrentPlatformVersionNull(){
        log.info(" platform version is        : " + currentPlatformVersion);
        return (currentPlatformVersion == null);
    }

    public boolean isCurrentAppNameNull(){
        log.info(" application name is        : " + currentAppName);
        return (currentAppName == null);
    }

    public boolean isCurrentAppPathNull(){
        log.info(" application path is        : " + currentAppPath);
        return (currentAppPath == null);
    }

    public boolean isCurrentAppActivityNull(){
        log.info(" application activity is    : " + currentAppActivity);
        return (currentAppActivity == null);
    }

    public boolean isCurrentAppPackageNull(){
        log.info(" application package is     : " + currentAppPackage);
        return (currentAppPackage == null);
    }

    public boolean isIosPlatform(){
        return platform.getPlatformName().equalsIgnoreCase("ios");
    }

    public boolean isAndroidPlatform(){
        return platform.getPlatformName().equalsIgnoreCase("android");
    }

    protected String deviceName;

    public String getDeviceName(){
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    protected String platformVersion;
    protected String appName;
    protected String appPath;
    protected String appPackage;
    protected String appActivity;
    public DesiredCapabilities capabilities;

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    protected final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

    protected static AppiumDriver driver;

    private ArrayList<AbstractPage> pages = new ArrayList<AbstractPage>();

    public void setPages(AbstractPage abstractPage){
        pages.add(abstractPage);
    }

    public ArrayList<AbstractPage> getPages(){
        return pages;
    }

    public void setPageFactory(ArrayList<AbstractPage> pages){
        for (AbstractPage currentPage : pages){
            PageFactory.initElements(new AppiumFieldDecorator(driver), currentPage);
        }
    }

    public void isParameterNull(){
        capabilities = new DesiredCapabilities();
        /**
         * Irfan :
         *
         * The purpose of this method is to set the default value of parameters from Constants class if
         * its not invoked from system properties.
         *
         * Issue:
         * There's still an issue when determining the default value of parameter from Constants.
         * The current parameters will return null pointer. For now, make sure all of the parameters from
         * system properties all filled. The browserName variable temporarily not validated, due to it's the
         * optional parameter but become the mandatory when validated.
         */

        if(isIosPlatform()){

            log.info("Now using iOS platform");

            if(isCurrentDeviceNameNull() &&
                    isCurrentPlatformVersionNull() &&
                    isCurrentAppNameNull() &&
                    isCurrentAppPathNull()){

                log.info("The parameter(s) not invoked from system properties, now using the iOS default value from Constants.");
                setCommonCapabilities(Constants.DEFAULT_DEVICE_NAME,Constants.DEFAULT_PLATFORM_VERSION,Constants.DEFAULT_APP_PATH,Constants.DEFAULT_APP_NAME,false,false);

            }else {
                log.info("Using the iOS parameter from system properties.");
                setCommonCapabilities(currentDeviceName,currentPlatformVersion,currentAppPath,currentAppName,false,false);
            }
        }else if(isAndroidPlatform()){
            if(isCurrentDeviceNameNull() &&
                    isCurrentPlatformVersionNull() &&
                    isCurrentAppNameNull() &&
                    isCurrentAppPathNull() &&
                    isCurrentAppActivityNull() &&
                    isCurrentAppPackageNull()){

                log.info("The parameters not invoked from system properties, now using the default value.");
                setCommonCapabilities(Constants.DEFAULT_DEVICE_NAME,Constants.DEFAULT_PLATFORM_VERSION,Constants.DEFAULT_APP_PATH,Constants.DEFAULT_APP_NAME,true,true);
                setAppActivity(Constants.DEFAULT_APP_ACTIVITY);
                setAppPackage(Constants.DEFAULT_APP_PACKAGE);

                capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,getAppActivity());
                capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,getAppPackage());
            }else {
                log.info("Using the parameters from system properties.");
                setCommonCapabilities(currentDeviceName,currentPlatformVersion,currentAppPath,currentAppName,true,true);
                setAppActivity(currentAppActivity);
                setAppActivity(currentAppPackage);

                capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY,getAppActivity());
                capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,getAppPackage());
            }
        }

    }

    /**
     * Run before each test *
     */
    @Before
    public void setUp() throws Exception {
        isParameterNull();

        System.out.println(" ------- After check the condition  -------");
        System.out.println(" - Application name	: " + getAppName());
        System.out.println(" - Application path	: " + getAppPath());
        System.out.println(" - Platform version	: " + getPlatformVersion());
        System.out.println(" - Device name		: " + getDeviceName());
        System.out.println(" ------------------------------------------");

        setPageFactory(getPages());

        log.info("Application launched.");

    }

    /**
     * Run after each test *
     */
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    public void setCommonCapabilities(String deviceName, String platformVersion, String appPath, String appName, boolean autoAcceptAlerts, boolean takesScreenshot) {

        setDeviceName(deviceName);
        setPlatformVersion(platformVersion);
        setAppPath(appPath);
        setAppName(appName);

        File app = new File(getAppPath(), getAppName());

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getDeviceName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getPlatformVersion());
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("autoAcceptAlerts", autoAcceptAlerts);
        capabilities.setCapability("takesScreenshot", takesScreenshot);
        capabilities.setCapability("sendKeyStrategy", "setValue");

        try{
            if(isIosPlatform()){
                driver = new IOSDriver(new URL(Constants.WD_URL),capabilities);
            }else if(isAndroidPlatform()){
                driver = new AndroidDriver(new URL(Constants.WD_URL),capabilities);
            }

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

}
