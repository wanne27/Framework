package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends AbstractPage {

    private final String sneakersArticle = "//div[@class = 'basket-item-property-custom-value']";
    private final String sizeSelected = "/html/body/div[3]/div[3]/div[2]/div/div/div/div/div[3]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/div[2]/div/div[1]/div[2]/ul/li[3]";;
    private final String orderTotal = "//*[@id='basket-root']/div[1]/div/div/div[2]/div/div[2]/div/div";
    private final String deleteFromCart ="//span[@class='basket-item-actions-remove']";
    private final String checkCart="//td[contains(@class,'img_wrapp')]";

    public CartPage(WebDriver driver){super(driver);}

    public String getSneakersArticle() {
        return waitForElementLocatedBy(driver, By.xpath(sneakersArticle), WAIT_TIME_SECONDS).getText();
    }

    public String actualSizeSelected() {
        return waitForElementLocatedBy(driver, By.xpath(sizeSelected), WAIT_TIME_SECONDS).getText();

    }

    public double getCartOrderTotal() {
        return Double.parseDouble(waitForElementLocatedBy(driver, By.xpath(orderTotal), WAIT_TIME_SECONDS).getText().replace(" BYN", ""));
    }

    public CartPage deleteFromCart() {
        WebElement deleteButton = waitForElementLocatedBy(driver,
                By.xpath(deleteFromCart),WAIT_TIME_SECONDS);
        deleteButton.click();
        return this;
    }
    public boolean checkCart() {
        return waitForElementLocatedBy(driver,
                By.xpath(checkCart),WAIT_TIME_SECONDS).isDisplayed();
    }
}
