package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KelmeHomePage extends KelmeShopPage {

    public  KelmeHomePage(WebDriver driver){super(driver);}

    public KelmeHomePage openPage(){
        driver.get(HOME_URL);
        return this;
    }
}
