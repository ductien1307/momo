package pages.spf;

import utilities.BasePage;

public class OrderPage extends BasePage {

    public static final String ADD_BTN = "(//android.widget.ScrollView//android.view.ViewGroup)[9]";

    public void addProduct(String productName) throws InterruptedException {
        clickOn(xPathDynamic(productName));
        clickOn(ADD_BTN);
        clickOn(xPathDynamic("Add to Basket"));
        //clickOn(xPathDynamic("Check Out"));
        clickOn(xPathDynamic("Schedule"));
        clickOn(xPathDynamic("Place Order"));
        clickOn(xPathDynamic("Correct"));
    }

}
