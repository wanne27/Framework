package test;

import model.Cart;
import model.Product;
import org.apache.commons.math3.util.Precision;
import org.testng.annotations.Test;
import page.CartPage;
import page.HomePage;
import page.ProductPage;
import page.ResultsPage;
import service.CheckCartEmpty;
import service.ProductCreator;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WebDriverShopTest extends CommonConditions {
    /*
       @Test
        public void searchProductWithFailedArticleTest(){
            Product testProduct = ProductCreator.withFailedSearch();
            ResultsPage checkResult = new HomePage(driver)
                    .openPage()
                    .searchForSneakersArticle(testProduct.getFailedArticle());

            assertThat(checkResult.getCheckResultSeacrh().contains(testProduct.getFailedArticle())).isTrue();

        }*/
    /*
        @Test
        public void cartAfterAddingSneakersTest(){
            Product testProduct = ProductCreator.withAllProperty();
            CartPage cartPage = new ProductPage(driver,testProduct.getProductUrl())
                    .openPage()
                    .selectedSneakersSize()
                    .addToCart()
                    .openCart();

            assertThat(cartPage.getSneakersArticle(),is(equalTo(testProduct.getArticle())));
            assertThat(cartPage.actualSizeSelected(),is(equalTo(testProduct.getSize())));
            assertThat(cartPage.getCartOrderTotal(),is(equalTo(Double.parseDouble(testProduct.getPrice()))));

        }
    */
    @Test
    public void checkCartAfterDeleting(){
        Product testProduct = ProductCreator.withAllProperty();
        Cart testCart = CheckCartEmpty.withEmpty();
        CartPage cartPage =  new ProductPage(driver,testProduct.getProductUrl())
                .openPage()
                .selectedSneakersSize()
                .addToCart()
                .openCart()
                .deleteFromCart()
                .openCartFromMAin();

        assertThat(cartPage.checkCart()).isTrue();

    }
}
