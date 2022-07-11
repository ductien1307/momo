package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.BasePage;

public class SearchStorePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(SearchStorePage.class);

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Tìm số điện thoại, bạn bè và dịch vụ/TextInput\"]")
    private MobileElement searchTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"highland_coffee\"]")
    private MobileElement highlandsCoffeeLbl;

    public void inputKeyword(String keyword) {
        typeTextTo(searchTxt, keyword);
    }

    public void clickHighLandsShop() {
        clickOn(highlandsCoffeeLbl);
    }

}
