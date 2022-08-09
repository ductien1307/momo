package pages.spf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.BasePage;

public class LocationPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(LocationPage.class);

    public static final String ENTER_LOCATION_MANUALLY_BTN = "//*[contains(@text,'Enter Location Manually')]";
    public static final String ENTER_YOUR_ADDRESS_TXT = "//*[contains(@text,'Enter your address')]";
    public static final String FIND_ADDRESS_TXT = "//*[contains(@text,'Find Address')]";
    public static final String RESULT_FIRST_TXT = "((//android.widget.ScrollView)[2]//android.widget.TextView)[1]";

    public void setLocation(String location) throws InterruptedException {
        clickOn(xPathDynamic("Enter Location Manually"));
        clickOn(xPathDynamic("Enter your address"));
        clickOn(xPathDynamic("Find Address"));
        typeTextTo(xPathDynamic("Find Address"), location);
        enterKey();
        clickOn(RESULT_FIRST_TXT);
    }
}
