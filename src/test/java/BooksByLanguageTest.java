import Pages.BookByLanguage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static Consts.Consts.BOOK_URL;
import static org.junit.jupiter.api.Assertions.*;

public class BooksByLanguageTest extends UseCaseBase {
    private static MainPage mainPage;
    private static BookByLanguage bookByLanguage;

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
        bookByLanguage = new BookByLanguage();

    }

    @BeforeEach
    public void beforeTest() {
       // mainPage.navigateToBookByLanguagePage();
        mainPage.navigateToMainPage();

    }

    @Test
    public void openBookByLanguageMenu() {
        boolean isOpened = bookByLanguage.clickBooksByLanguage().isMenuOpened();
        assertTrue(isOpened);
    }

    @Test
    public void chooseEnglishLanguage() {
        bookByLanguage.clickBooksByLanguage().chooseEnglish();
        boolean isVisible = bookByLanguage.isPageTitleVisible();
        assertTrue(isVisible);

    }

    @Test
    public void openBook() {
        bookByLanguage.clickOnBook();
        assertEquals(BOOK_URL, bookByLanguage.checkIfBookOpened());


    }

    @Test
    public void changeFormat() {
        bookByLanguage.clickOnBook().changeFormat();
        mainPage.takesScreenshot("HardcoreFormat");

    }

    @Test
    public void
    changeNumber() {
        bookByLanguage.clickOnBook().changeNumber("5");
        mainPage.takesScreenshot("ChangeBooksNumber");

    }
}