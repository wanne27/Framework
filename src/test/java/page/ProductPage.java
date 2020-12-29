package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductPage extends AbstractPage {

    private final static String PRODUCT_ARTICLE = "//span[@class = 'prod-article' and text() ='$']";
    private final String selectedSneakersSize= "//*[@id='bx_117848907_2422_prop_225_list']/li[3]/div";
    private final String actualSizeSelected = "//div[contains(@class,'bx_size')]//li[contains(@class, 'active')]";
    private final String addToCart ="//div[contains(@class, 'button_block')]//span//span[text()='В корзину']";

    private String url;

    public ProductPage(WebDriver driver){super(driver);}

    public ProductPage(WebDriver driver, String productUrl){
        super(driver);
        this.url = productUrl;
    }
    public ProductPage openPage()
    {
        driver.get(url);
        return this;
    }

    public ProductPage selectedSneakersSize() {
         WebElement sneakersSize = waitForElementLocatedBy(driver,
            By.xpath(selectedSneakersSize),WAIT_TIME_SECONDS);
         sneakersSize.click();
         return this;
    }

    public String getSneakersArticle(String articleProduct) {
        return waitForElementLocatedBy(driver,
                By.xpath(PRODUCT_ARTICLE.replace("$",articleProduct)), WAIT_TIME_SECONDS).getText();
    }

    public String actualSizeSelected() {
        return waitForElementLocatedBy(driver,
                By.xpath(actualSizeSelected), WAIT_TIME_SECONDS).getText();
    }

    public ProductPage addToCart() {
        WebElement cartButton = waitForElementLocatedBy(driver,
                By.xpath(addToCart), WAIT_TIME_SECONDS);
        cartButton.click();
        return this;
    }
}
