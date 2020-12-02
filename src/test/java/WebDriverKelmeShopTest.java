import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.KelmeCartPage;
import page.KelmeHomePage;
import page.KelmeProductPage;


public class WebDriverKelmeShopTest {
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void shouldBeSelectedSneakersSizeTest(){
        driver.manage().deleteAllCookies();
        String sneakersArticle="55899-919";
        String selectedSize="44";

        KelmeProductPage productPage = new KelmeHomePage(driver)
                .openPage()
                .searchForSneakersArticle(sneakersArticle)
                .selectProductLink()
                .selectedSneakersSize();
        Assert.assertTrue(productPage.getSneakersArticle(sneakersArticle).contains(sneakersArticle));
        Assert.assertTrue(productPage.actualSizeSelected().contains(selectedSize));

    }
    @Test
    public void CartAfterAddingSneakersTest(){
        driver.manage().deleteAllCookies();
        String sneakersArticle="55899-919";
        String selectedSize="37";
        KelmeCartPage cartPage = new KelmeHomePage(driver)
                .openPage()
                .searchForSneakersArticle(sneakersArticle)
                .selectProductLink()
                .selectedSneakersSize()
                .addToCart()
                .openCart();
        Assert.assertTrue(cartPage.actualSizeSelected().contains(selectedSize));
        Assert.assertTrue(cartPage.getSneakersArticle().contains(sneakersArticle));
        Assert.assertEquals(cartPage.getCartOrderTotal(),189.02);


    }
    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
