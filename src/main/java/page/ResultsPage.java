package page;

import mainpage.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ResultsPage extends MainPage {

    private final String selectProductLink = "//*[@id=\"bx_3966226736_2422\"]/div/div[2]/div[1]/a/span";

    public ResultsPage(WebDriver driver, String sneakersName) {
        super(driver);
    }

    public ProductPage selectProductLink() {
        WebElement productInfoLink = waitForElementLocatedBy(driver,
                By.xpath(selectProductLink),WAIT_TIME_SECONDS);
        productInfoLink.click();
        return new ProductPage(driver);
    }
}

