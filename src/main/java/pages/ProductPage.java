package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"test-Cart drop zone\").childSelector(new UiSelector().className(android.widget.TextView))")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"PRODUCTS\"]/XCUIElementTypeStaticText")
    private MobileElement title;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    private MobileElement productList;


    public String getTitle() {
        return getTextOf(title);

    }

    public void scrollTo(String text) {
        scrollToElementIos(productList, text);
    }
}
