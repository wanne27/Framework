package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wait.WaitElementMethod;

public class KelmeProductPage extends KelmeShopPage {
    public KelmeProductPage(WebDriver driver){super(driver);}

    public  KelmeProductPage selectedSneakersSize(){
         WebElement sneakersSize = WaitElementMethod.waitForElementLocatedBy(driver,
            By.xpath("//*[@id=\"bx_117848907_2422_prop_225_list\"]/li[3]/div"),WAIT_TIME_SECONDS);
         sneakersSize.click();
         return this;
    }

    public String getSneakersArticle(String articleProduct) {
        WebElement sneakers = WaitElementMethod.waitForElementLocatedBy(driver,
                By.xpath("//span[@class = 'prod-article' and text() ='"+articleProduct+"']"), WAIT_TIME_SECONDS);
        return sneakers.getText();
    }

    public String actualSizeSelected() {
        WebElement actualSize = WaitElementMethod.waitForElementLocatedBy(driver,
                By.xpath("//div[contains(@class,'bx_size')]//li[contains(@class, 'active')]"), WAIT_TIME_SECONDS);
        return actualSize.getText();
    }
    public KelmeProductPage addToCart() {
        WebElement cartButton = WaitElementMethod.waitForElementLocatedBy(driver,
                By.xpath("//div[contains(@class, 'button_block')]//span//span[text()=\"В корзину\"]"), WAIT_TIME_SECONDS);
        cartButton.click();
        return this;
    }

}
