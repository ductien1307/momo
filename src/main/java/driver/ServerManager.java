package driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ServerManager {
    private static final Logger logger = LogManager.getLogger(ServerManager.class);

    private static ThreadLocal<AppiumDriverLocalService> driverLocalServiceThreadLocal = new ThreadLocal<>();

    public static AppiumDriverLocalService getServer() {
        return driverLocalServiceThreadLocal.get();
    }

    public static void startServer() {
        logger.info("starting appium server by java code...");
        AppiumDriverLocalService server = WindowsGetAppiumService();
        server.start();
        if (server == null || !server.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
        server.clearOutPutStreams();
        driverLocalServiceThreadLocal.set(server);
        logger.info("Appium server started");
    }

    public static AppiumDriverLocalService WindowsGetAppiumService() {
        return AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                        .usingAnyFreePort()
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                        .withLogFile(new File("log" + File.separator + "log_appium_server.txt"))

        );
    }


}
