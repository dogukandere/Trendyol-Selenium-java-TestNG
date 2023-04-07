package Test;

import Page.TrendyolPage;
import Utilities.TestBase;
import org.testng.annotations.Test;

public class TrendyolTest extends TestBase {
    TrendyolPage trendyolPage;

    @Test(priority = 1 , description = "Search product and add to cart")
    public void test01(){
        trendyolPage = new TrendyolPage(driver);
        trendyolPage.navigateToUrl();
        trendyolPage.closePopup();
        trendyolPage.categoryHoverOver();
        trendyolPage.logoTitleLinkControl();
        trendyolPage.search();
        trendyolPage.productClick();
        trendyolPage.switchToTab();
        trendyolPage.memorySelectandAddtoCart();
        trendyolPage.buying();
    }

    @Test(priority = 2 , description = "Verify Product and Buttons")
    public void test02(){
        trendyolPage = new TrendyolPage(driver);
        trendyolPage.isProductOnTheCart();
        trendyolPage.isTrashButtonClickable();
        trendyolPage.isDiscountButtonClickable();
        trendyolPage.isShopButtonClickable();
    }
}


