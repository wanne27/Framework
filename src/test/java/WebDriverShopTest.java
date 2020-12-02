import model.Article;
import model.Size;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.CartPage;
import page.HomePage;


public class WebDriverShopTest {

    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }


    @Test
    public void cartAfterAddingSneakersTest(){
        CartPage cartPage = new HomePage(driver)
                .openPage()
                .searchForSneakersArticle(Article.US1.getArticle())
                .selectProductLink()
                .selectedSneakersSize()
                .addToCart()
                .openCart();
        Assert.assertTrue(cartPage.actualSizeSelected().contains(Size.RU37.getSize()));
        Assert.assertTrue(cartPage.getSneakersArticle().contains(Article.US1.getArticle()));
        Assert.assertEquals(cartPage.getCartOrderTotal(),189.02);
    }

    @Test
    public void checkCartAfterDeleting(){
        CartPage cartPage = new HomePage(driver)
                .openPage()
                .searchForSneakersArticle(Article.US1.getArticle())
                .selectProductLink()
                .selectedSneakersSize()
                .addToCart()
                .openCart()
                .deleteFromCart();
        cartPage.openCartFromMAin();
        Assert.assertEquals(cartPage.checkCart(),"Ваша корзина пуста");
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
