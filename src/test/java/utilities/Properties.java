package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/config.properties"})
public interface Properties extends Config {
    String hubs();
    String automation_name();
    String platform_name();
    String platform_version();
    String device_name();
    String app();
    String app_activity();
    String app_package();
    String no_reset();
    String full_reset();
    String skipDeviceInitialization();
    String skipServerInstallation();
}
