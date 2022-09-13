package utilities;

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
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.android_automation_name());
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.android_platform_name());
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.android_platform_version());
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.android_device_name());
                caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + prop.android_app());
                caps.setCapability(MobileCapabilityType.NO_RESET, prop.no_reset());
                caps.setCapability(MobileCapabilityType.FULL_RESET, prop.full_reset());
                caps.setCapability("autoGrantPermissions", true);
                caps.setCapability("appWaitForLaunch", true);
                caps.setCapability("unicodeKeyboard", true);
                break;
            case "ios":
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.ios_automation_name());
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.ios_platform_name());
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.ios_platform_version());
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.ios_device_name());
                caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + prop.ios_app());
                break;
            default:
                logger.info("FW Can not support with your OS!");
                break;
        }
        return caps;
    }
}



