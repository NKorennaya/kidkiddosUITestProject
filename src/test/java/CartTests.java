import Pages.BookByLanguage;
import Pages.CartPage;
import Pages.MainPage;
import Utils.SubtotalCalculator;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CartTests extends UseCaseBase {
    private static MainPage mainPage;
    private static CartPage cartPage;
    private static BookByLanguage bookByLanguage;
    private static SubtotalCalculator subtotalCalculator;

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
        cartPage = new CartPage();
        bookByLanguage = new BookByLanguage();
        subtotalCalculator = new SubtotalCalculator();

    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();

    }

    @Test
    public void openCartPage() {
        Boolean isOpened = cartPage.clickAddToCartButton().isCartOpened();
        assertTrue(isOpened);
    }

    @Test
    public void openCartWithOrder() {
        bookByLanguage.clickOnBook().changeFormat().changeNumber("5");
        Boolean isOpenedFrom = cartPage.clickAddToCartButtonFromOrder().isCartOpenedFromOrder();
        assertTrue(isOpenedFrom);

    }
@Test
    public void verifyIsCartUpdate() {
        bookByLanguage.clickOnBook().changeFormat().changeNumber("5");
        cartPage.clickAddToCartButtonFromOrder().updatingCart();
    assertEquals("6", cartPage.checkIfQuantityUpdate());
}

@Test
    public void verifySubtotal(){
    bookByLanguage.clickOnBook().changeFormat().changeNumber("5");
    cartPage.clickAddToCartButtonFromOrder().updatingCart();
    double price = 31.99;
    double quantity = Double.parseDouble(cartPage.checkIfQuantityUpdate());
    String result = String.valueOf(price*quantity);
    assertEquals("191.94", result);

}
}