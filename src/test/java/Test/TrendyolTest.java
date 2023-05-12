package Test;

import Page.TrendyolPage;
import Utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TrendyolTest extends TestBase {
    TrendyolPage trendyolPage;

    @BeforeClass
    public void before(){
        trendyolPage = new TrendyolPage(driver);
    }

    @Test(priority = 1 , description = "Search product and add to cart")
    public void searchProduct(){

        trendyolPage.navigateToUrl("https://www.trendyol.com/");
        trendyolPage.closePopup()
                .categoryHoverOver();

        Assert.assertEquals(driver.getTitle(),"En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.trendyol.com/");

        trendyolPage.trendyolLogoControl();
        trendyolPage.loginLogoControl();
        trendyolPage.searchProduct("samsung monitör")
                .clickSearchButton()
                .clickProduct();

        trendyolPage.switchToTab();
        trendyolPage.clickCartElement().clickGoToCartElement();
        trendyolPage.clickBuyingElement();
    }

    @Test(priority = 2 , description = "Verify Product and Buttons")
    public void checkProduct(){

        Assert.assertEquals(trendyolPage.isProductOnTheCart(),"Sepetim (1 Ürün)");

        trendyolPage.isTrashButtonClickable();
        trendyolPage.isDiscountButtonClickable();
        trendyolPage.isShopButtonClickable();
    }
}


