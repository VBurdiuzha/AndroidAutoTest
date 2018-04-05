package services;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTestBase {

    protected static AndroidDriver driver;

    @Parameters({"appPackage", "appActivity"})
    @BeforeTest(alwaysRun = true)
    public void setUp(String appPackage, String appActivity) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel");
        //File app = new File("bin/momondo.apk");
        //caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Tools.setDriver(driver);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
