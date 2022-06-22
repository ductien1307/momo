package stepDefinitions;

import driver.DriverManager;
import driver.ServerManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;

public class Hook {
    private static final Logger logger = LogManager.getLogger(Hook.class);

    @Before
    public void init() throws MalformedURLException {
        //ServerManager.startServer();
        DriverManager.initialize();
    }

    @After
    public void afterTest(Scenario scenario) throws InterruptedException {

       /* Thread.sleep(2000);
        if (scenario.isFailed()) {
            byte[] screenshot = DriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        logger.info("close appium server...");
        DriverManager.getDriver().quit();

        if (ServerManager.getServer() != null) {
            ServerManager.getServer().stop();

        }
*/
    }
}
