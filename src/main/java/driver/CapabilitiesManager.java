package driver;


//import config.ReadProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {

    //ReadProperties readProperties = ConfigFactory.create(ReadProperties.class);

    public DesiredCapabilities getCaps(String type) {
        DesiredCapabilities cap = new DesiredCapabilities();
        String os = "android";
        //String os = readProperties.driverType().toLowerCase();

        switch (os) {
            case "android":
                cap.setCapability("automationName", "UiAutomator1");
                cap.setCapability("platformName", "Android");
                cap.setCapability("deviceName", "emulator-5554");
                //cap.setCapability("deviceName", readProperties.deviceNameAndroid());
                //cap.setCapability("appPackage", readProperties.appPackage());
                //cap.setCapability("appActivity", readProperties.appActivity());
                cap.setCapability("app", "/Users/tiennguyen/Desktop/momo/momo/apps/com.mservice.momotransfer_2022-05-18.apk");
                //cap.setCapability("app", System.getProperty("user.dir") + "/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                break;
            case "ios":
/*                cap.setCapability("automationName", "XCUITest");
                cap.setCapability("platformName", "iOS");
                cap.setCapability("deviceName", readProperties.deviceNameIOS());
                cap.setCapability("platformVersion", readProperties.platformVersionIOS());
                cap.setCapability("app", System.getProperty("user.dir") + "/apps/iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.zip");*/
//                cap.setCapability("bundleId", "com.apple.MobileAddressBook");
                break;
        }
        return cap;
    }
}



