package Test;

import Page.BuyingPage;
import Page.ProductListPage;
import Page.ProductPage;
import Page.TrendyolPage;
import Utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TrendyolTest extends TestBase {

    TrendyolPage trendyolPage;
    ProductPage productPage;
    ProductListPage productListPage;
    BuyingPage buyingPage;

    @BeforeClass
    public void before(){

        trendyolPage = new TrendyolPage(driver);
        productPage = new ProductPage(driver);
        productListPage = new ProductListPage(driver);
        buyingPage = new BuyingPage(driver);
    }

    @Test(priority = 1 , description = "Search product and add to cart")
    public void searchProduct(){

        trendyolPage.navigateToUrl("https://www.trendyol.com/");
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


