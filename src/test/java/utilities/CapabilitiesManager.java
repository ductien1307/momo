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
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.automation_name());
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.platform_name());
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.platform_version());
                //Prod
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.device_name());
                caps.setCapability(MobileCapabilityType.NO_RESET, prop.no_reset());
                caps.setCapability(MobileCapabilityType.FULL_RESET, prop.full_reset());

                caps.setCapability("autoGrantPermissions", true);
                caps.setCapability("appWaitForLaunch", true);
                caps.setCapability("unicodeKeyboard", true);
                //caps.setCapability("resetKeyboard", true);

                /*caps.setCapability("appActivity", prop.app_activity());
                caps.setCapability("skipDeviceInitialization", prop.skipDeviceInitialization());
                caps.setCapability("skipServerInstallation", prop.skipServerInstallation());
                caps.setCapability("connectHardwareKeyboard", true);*/

                //end prod
                caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + prop.app());
                break;
            case "ios":
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                break;
            default:
                logger.info("FW Can not support with your OS!");
                break;
        }
        logger.info(caps);
        return caps;
    }
}



