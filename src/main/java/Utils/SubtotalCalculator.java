package Utils;

import Pages.BasePage;

import static Pages.CartPage.BOOK_PRICE;
import static Pages.CartPage.QUANTITY_UPDATE;

public class SubtotalCalculator extends BasePage {

    public String subtotalCalculator() {
        int quantity = Integer.parseInt(findElementByXpath(QUANTITY_UPDATE).getAttribute("value"));
        double price = Double.parseDouble(findElementByXpath(BOOK_PRICE).getAttribute("price"));
        String ExpectedResult = String.valueOf(quantity * price);
        return ExpectedResult;

    }
}