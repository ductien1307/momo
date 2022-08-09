package utilities;

import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;


import java.net.MalformedURLException;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private static boolean dunit = false;

    @Before
    public void initTest() throws MalformedURLException {
        if (!dunit) {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                }
            });
            DriverManager.initialize();
            dunit = true;
        }
    }

    /*@After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) ;
        byte[] screenshot = DriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }*/

}
