package stepDefinitions.spf;

import io.cucumber.java.en.When;
import pages.spf.MenuPage;
import pages.spf.OrderPage;
import utilities.BasePage;

public class OrderStep extends BasePage {
    private MenuPage menuPage;
    private OrderPage orderPage;

    public OrderStep() {
        menuPage = new MenuPage();
        orderPage = new OrderPage();
    }

    @When("I order with product name is {string}")
    public void iOderWithProductNameIs(String productName) throws InterruptedException {
        sleep(3);
        verticalScrolling(0.6, 0.3, 0.5);
        sleep(3);
        orderPage.addProduct(productName);
    }

}
