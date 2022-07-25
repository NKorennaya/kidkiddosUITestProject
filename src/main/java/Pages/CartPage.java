package Pages;

import org.openqa.selenium.Keys;

public class CartPage extends BasePage {

    public static final String CART_BUTTON_FROM_ORDER = "//button[@class = 'btn product-form__cart-submit']";
    public static final String CART_HEADED_FROM_ORDER = "//*[@id = 'bold-cart-msg']";
    public static final String QUANTITY_UPDATE = "//*[@class = 'cart__qty-input']";
    public static final String UPDATE_BUTTON = "//*[@class = 'btn btn--secondary cart__update cart__update--large small--hide']";
    public static final String SUBTOTAL = "//*[@class = 'cart__subtotal']";
    public static final String CART_BUTTON =  "//*[@class = 'icon icon-cart']";
    public static final String CART_HEADED = "//*[@class = 'cart--empty-message']";
    public static final String BOOK_PRICE = "//*[@class = 'cbb-price-digits']";





    public CartPage clickAddToCartButton() {
        clickElementByXpath(CART_BUTTON);
        return new CartPage();

    }
    public CartPage clickAddToCartButtonFromOrder() {
        clickElementByXpath(CART_BUTTON_FROM_ORDER);
        return new CartPage();}

    public boolean isCartOpened() {

        return elementExists(CART_HEADED);
    }
    public boolean isCartOpenedFromOrder(){
        return elementExists(CART_HEADED_FROM_ORDER);
    }

    public CartPage updatingCart() {
        findElementByXpath(QUANTITY_UPDATE).sendKeys(Keys.ARROW_UP);
        clickElementByXpath(UPDATE_BUTTON);
        return new CartPage();

    }

    public String checkIfPriceUpdate() {
        String price = findElementByXpath(BOOK_PRICE).getAttribute("price");
        return price;
    }

    public String checkIfQuantityUpdate() {
        String actualResult = findElementByXpath(QUANTITY_UPDATE).getAttribute("value");

        return actualResult;
    }
}