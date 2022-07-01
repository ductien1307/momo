package utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {
    public static final Logger logger = LogManager.getLogger(DriverManager.class);
    Properties prop = ConfigFactory.create(Properties.class);

    public DesiredCapabilities getCaps(String os) {
        DesiredCapabilities caps = new DesiredCapabilities();
        switch (os) {
            case "android":
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.automation_name());
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.platform_name());
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.device_name());
                caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + prop.apps());
                break;
            case "ios":
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                break;
            default:
                logger.info("FW Can not support with your OS!");
                break;
        }
        return caps;
    }
}



