package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CartPage;
import page.ResultsPage;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected static final String HOME_URL = "https://kelme.by";
    protected final long WAIT_TIME_SECONDS = 20;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultsPage searchForSneakersArticle(String sneakersArticle) {
        WebElement searchInputField = waitForElementLocatedBy(driver,
                By.xpath("//*[@id=\"title-search-input_fixed\"]"), WAIT_TIME_SECONDS);
        searchInputField.sendKeys(sneakersArticle);
        searchInputField.submit();
        return new ResultsPage(driver, sneakersArticle);
    }

    public CartPage openCart() {
        WebElement cartButtonGoTo = waitForElementLocatedBy(driver,
                By.xpath("//a[contains(@class,'btn btn-default white')]"),WAIT_TIME_SECONDS);
        cartButtonGoTo.click();
        return new CartPage(driver);
    }

    public CartPage openCartFromMAin() {
        WebElement cartButtonGoTo = waitForElementLocatedBy(driver,
                By.xpath("//div[@class = 'basket_count small clicked empty']"),WAIT_TIME_SECONDS);
        cartButtonGoTo.click();
        return new CartPage(driver);
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by, long time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
