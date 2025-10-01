package util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
//import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class driverFactory {

    public static ThreadLocal<RemoteWebDriver>  driverThreadLocal =  new ThreadLocal<>();;
    propertiesFactory propertiesFactory = new propertiesFactory();
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    public void initDriver(String app) {
        switch (app) {
            case "android":
                desiredCapabilities.setCapability("appium:platformName", "Android");
                desiredCapabilities.setCapability("appium:deviceName", "R5CT61E4NEN");
                desiredCapabilities.setCapability("appium:appPackage", "com.pozitron.hepsiburada");
                desiredCapabilities.setCapability("appium:appActivity", "com.hepsiburada.ui.startup.SplashActivity");
                desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
                desiredCapabilities.setCapability("appium:noReset", true);
                desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
                desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
                try {
                    driverThreadLocal.set(new AndroidDriver(new URL("http://localhost:4723/"), desiredCapabilities));

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                Assert.assertTrue(false, "İstenilen browser seçeneeklerimizde yok");
                break;
        }
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        getDriver().quit();
    }

    public static synchronized RemoteWebDriver getDriver() {
        return driverThreadLocal.get();
    }
}