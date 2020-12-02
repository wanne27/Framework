package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wait.WaitElementMethod;

public abstract class KelmeShopPage {
    protected WebDriver driver;
    protected static final String HOME_URL = "https://kelme.by";
    protected final long WAIT_TIME_SECONDS = 20;

    public KelmeShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public KelmeResultsPage searchForSneakersArticle(String sneakersArticle) {
        WebElement searchInputField = WaitElementMethod.waitForElementLocatedBy(driver,
                By.xpath("//*[@id=\"title-search-input_fixed\"]"), WAIT_TIME_SECONDS);
        searchInputField.sendKeys(sneakersArticle);
        searchInputField.submit();
        return new KelmeResultsPage(driver, sneakersArticle);
    }

    public KelmeCartPage openCart(){

        WebElement cartButtonGoTo = WaitElementMethod.waitForElementLocatedBy(driver,
                By.xpath("//a[contains(@class,'btn btn-default white')]"),WAIT_TIME_SECONDS);
        cartButtonGoTo.click();
        return new KelmeCartPage(driver);
    }


}
