package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/config.properties"})
public interface ReadProperties extends Config {

    String driverType();

    //android
    String appPackage();

    String appActivity();

    String deviceNameAndroid();

    //ios
    String deviceNameIOS();
    String platformVersionIOS();

}
