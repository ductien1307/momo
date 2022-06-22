package driver;

//import config.ReadProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();


    public static AppiumDriver getDriver() {
        return driver.get();
    }

    //static ReadProperties readProperties = ConfigFactory.create(ReadProperties.class);


    public static void initialize() throws MalformedURLException {
        String os = "android";
        //String os = readProperties.driverType().toLowerCase();
        System.out.println("os = " + os);
        AppiumDriver appiumDriver = null;
        if (appiumDriver == null) {
            switch (os) {
                case "android":
                    //System.out.println(ServerManager.getServer().getUrl());
                    appiumDriver = new AndroidDriver(new URL(
                            "http://localhost:4723/wd/hub"), new CapabilitiesManager().getCaps(os));
                    break;
                case "ios":
                    //appiumDriver = new IOSDriver(ServerManager.getServer().getUrl(), new CapabilitiesManager().getCaps(os));
                    //break;
            }
            driver.set(appiumDriver);
        }

    }
}
