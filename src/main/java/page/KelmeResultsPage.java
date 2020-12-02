package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wait.WaitElementMethod;

public class KelmeResultsPage extends KelmeShopPage {
    private String sneakersName;

    public KelmeResultsPage(WebDriver driver, String sneakersName) {
        super(driver);
        this.sneakersName = sneakersName;
    }
    public KelmeProductPage selectProductLink(){
        WebElement productInfoLink = WaitElementMethod.waitForElementLocatedBy(driver,
                By.xpath("//*[@id=\"bx_3966226736_2422\"]/div/div[2]/div[1]/a/span"),WAIT_TIME_SECONDS);
        productInfoLink.click();
        return new KelmeProductPage(driver);
    }
}

