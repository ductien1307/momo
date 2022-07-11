package utilities;

import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;


import java.net.MalformedURLException;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void initTest() throws MalformedURLException {
        //ServerManager.startServer();
        DriverManager.initialize();
    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) ;
        byte[] screenshot = DriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

}
