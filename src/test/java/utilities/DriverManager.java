package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.Logger;


public class DriverManager {
    public static final Logger logger = LogManager.getLogger(DriverManager.class);
    public static String os = "";
    public static String project = "";
    public static Properties prop = ConfigFactory.create(Properties.class);
    public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void initialize() throws MalformedURLException {
        os = System.getProperty("os");
        project = System.getProperty("project");
        logger.info("OS: " + os);
        logger.info("Project: " + project);
        AppiumDriver appiumDriver = null;
        if (appiumDriver == null) {
            switch (os) {
                case "android":
                    appiumDriver = new AndroidDriver(new URL(
                            prop.hubs()), new CapabilitiesManager().getCaps(os));
                    break;
                case "ios":
                    appiumDriver = new IOSDriver(new URL(prop.hubs()),
                            new CapabilitiesManager().getCaps(os));
                    break;
                default:
                    logger.info("incorrect platform");
                    break;
            }
            driver.set(appiumDriver);
        }
    }
}
