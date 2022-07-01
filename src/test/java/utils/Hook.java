package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;

import java.net.MalformedURLException;

public class Hook {
    private static final Logger logger = LogManager.getLogger(Hook.class);

    @Before
    public void initTest() throws MalformedURLException {
        //ServerManager.startServer();
        DriverManager.initialize();
    }

   /* @After
    public void endTest(Scenario scenario) throws InterruptedException {
        Thread.sleep(2000);
        if (scenario.isFailed()) {
            byte[] screenshot = DriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }*/

    /*@After
    public void endTest(){
        logger.info("close appium server...");
        DriverManager.getDriver().quit();
        if (ServerManager.getServer() != null) {
            ServerManager.getServer().stop();
        }
    }*/
}
