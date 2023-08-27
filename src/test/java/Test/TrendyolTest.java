package Test;

import Page.BuyingPage;
import Page.ProductListPage;
import Page.ProductPage;
import Page.TrendyolPage;
import Utilities.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Utilities.DriverFactory.driver;

public class TrendyolTest {

    private static TrendyolPage trendyolPage;
    private static ProductPage productPage;
    private static ProductListPage productListPage;
    private static BuyingPage buyingPage;

    @BeforeTest
    public void before(){

        DriverFactory.getDriver();
        trendyolPage = new TrendyolPage();
        productPage = new ProductPage();
        productListPage = new ProductListPage();
        buyingPage = new BuyingPage();
    }

    @Test(priority = 1 , description = "Search product and add to cart")
    public void searchProduct(){

        driver.navigate().to("https://www.trendyol.com/");
        trendyolPage.closePopup().categoryHoverOver();
        Assert.assertEquals(driver.getTitle(),"En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.trendyol.com/");
        Assert.assertTrue(trendyolPage.trendyolLogoControl());
        Assert.assertTrue(trendyolPage.loginLogoControl());
        trendyolPage.searchProduct("samsung monitör").clickSearchButton();

        productListPage.clickProduct();
        productListPage.switchToTab();

        productPage.clickCartElement().clickGoToCartElement();
    }

    @Test(priority = 2 , description = "Verify Product and Buttons")
    public void checkProduct(){

        buyingPage.clickBuyingElement();
        Assert.assertEquals(buyingPage.isProductOnTheCart(),"Sepetim (1 Ürün)");
        Assert.assertTrue(buyingPage.isTrashButtonClickable());
        Assert.assertTrue(buyingPage.isDiscountButtonClickable());
        Assert.assertTrue(buyingPage.isShopButtonClickable());
    }
}


