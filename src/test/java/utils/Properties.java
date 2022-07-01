package utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/config.properties"})
public interface Properties extends Config {
    String automation_name();
    String platform_name();
    String device_name();
    String apps();
    String hubs();
}
