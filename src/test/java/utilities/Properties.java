package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/config.properties"})
public interface Properties extends Config {
    String hubs();
    String automation_name();
    String platform_name();
    String device_name();
    String apps();
    String no_reset();
    String full_reset();
}
