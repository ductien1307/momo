package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/config.properties"})
public interface Properties extends Config {

    String android_automation_name();
    String android_platform_name();
    String android_platform_version();
    String android_device_name();
    String android_app();
    String android_app_activity();
    String android_app_package();

    String ios_automation_name();
    String ios_platform_name();
    String ios_platform_version();
    String ios_device_name();
    String ios_app();

    String hubs();
    String no_reset();
    String full_reset();
    String skipDeviceInitialization();
    String skipServerInstallation();
}
