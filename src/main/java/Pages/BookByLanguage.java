package Pages;

import static Consts.Consts.ENGLISH_ONLY_URL;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookByLanguage extends BasePage {
    private static final String BOOKS_BY_LANGUAGE = "//a[@aria-controls = 'SiteNavLabel-books-by-language']";
    // private static final String LANGUAGE_MENU = "//*[contains(text(),'Find your language')]";
    private static final String LANGUAGE_MENU = "//*[contains(text(),'English Only')]";
    private static final String ENGLISH_ONLY = "//*[text() = 'English Only']";
    public static final String ENGLISH_ONLY_HEADER = "//div[@id = 'shopify-section-collection-template']";
    public static final String BOOK = "//img[@class = 'grid-view-item__image fade-in lazyloaded']";
    public static final String FORMAT = "//select[@id = 'SingleOptionSelector-0']";
    public static final String TEMPLATE = "//*[@value = 'Hardcover']";
public static final String QUANTITY = "//input[@name = 'quantity']";
private static final String BANNER = "//i[@class = '_close-icon']";


    public BookByLanguage clickBooksByLanguage() {
        moveToElement(BOOKS_BY_LANGUAGE);
        return new BookByLanguage();


    }

    public boolean isMenuOpened() {
        return elementExists(LANGUAGE_MENU);


    }

    public  BookByLanguage chooseEnglish() {
        moveToElement(ENGLISH_ONLY);
        closeBanner();
        return new BookByLanguage();
    }

    public boolean isPageTitleVisible() {
        return elementExists(ENGLISH_ONLY_HEADER);

    }
public BookByLanguage clickOnBook (){
        webDriver.navigate().to(ENGLISH_ONLY_URL);
        clickElementByXpath(BOOK);
        return new BookByLanguage();

}
    public String checkIfBookOpened() {
        String actualURL = getCurrentPageUrl();

        return actualURL;
}
public BookByLanguage changeFormat(){
        moveToElement(FORMAT);
        clickElementByXpath(TEMPLATE);
        return new BookByLanguage();
}
public BookByLanguage changeNumber(String NUMBER){
        findElementByXpath(QUANTITY).clear();
        findElementByXpath(QUANTITY).sendKeys(NUMBER);
        return new BookByLanguage();


}
public void closeBanner(){
        clickElementByXpath(BANNER);
}
}
