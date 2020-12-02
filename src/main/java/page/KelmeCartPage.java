package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wait.WaitElementMethod;

import java.util.List;

public class KelmeCartPage  extends KelmeShopPage{
    public KelmeCartPage(WebDriver driver){super(driver);}

    public String getSneakersArticle()
    {
        WebElement sneakers = WaitElementMethod.waitForElementLocatedBy(driver,
                By.xpath("//div[@class = 'basket-item-property-custom-value']"), WAIT_TIME_SECONDS);
        return sneakers.getText();
    }

    public String actualSizeSelected() {

        WebElement actualSize =  WaitElementMethod.waitForElementLocatedBy(driver,
                By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/div/div/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/div[2]/div/div[1]/div[2]/ul/li[3]"), WAIT_TIME_SECONDS);
        return actualSize.getText();

    }

    public double getCartOrderTotal() {
        WebElement cartOrderTotal = WaitElementMethod.waitForElementLocatedBy(driver,
                By.xpath("//*[@id=\"basket-root\"]/div[1]/div/div/div[2]/div/div[2]/div/div"), WAIT_TIME_SECONDS);
        return Double.parseDouble(cartOrderTotal.getText().replace(" BYN", ""));
    }
}
