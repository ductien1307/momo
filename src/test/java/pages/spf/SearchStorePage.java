package pages.spf;

import utilities.BasePage;

public class SearchStorePage extends BasePage {

    public static final String SEARCH_TXT = "(//android.widget.TextView)[3]";
    public static final String SEARCH_DETAIL_TXT = "//android.widget.EditText";
    public static final String STORE_FIRST_LBL = "//android.widget.ScrollView//*[contains(@text,'Highlands Coffee - Lê Trọng Tấn')]";
    public static final String MOST_ORDER_LBL = "(//android.widget.HorizontalScrollView//\t\n" +
            "android.widget.TextView)[1]";

    public void inputKeyword(String keyword) throws InterruptedException {
        clickOn(SEARCH_TXT);
        typeTextTo(SEARCH_DETAIL_TXT, keyword);
        sleep(2);
        printInfoElements("//android.widget.TextView");
        sleep(2);
        printInfoElements(xPathDynamic("Highlands Coffee - Lê Trọng Tấn"));
        clickOn(STORE_FIRST_LBL);
    }

    public void mostOrder() throws InterruptedException {
        //clickOn(MOST_ORDER_LBL);
        clickOn(xPathDynamic("Highlands Coffee - Nguyễn Trãi"));
    }

}
