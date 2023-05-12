package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TrendyolPage extends ReusableMethods {
    WebDriver driver;

    public TrendyolPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final String POPUP = "//*[@id=\"onetrust-accept-btn-handler\"]";
    private final String TRENDYOL_LOGO = "//img[@alt='Trendyol']";
    private final String LOGIN_LOGO = "//p[contains(text(),'Giriş Yap')]";
    private final String SEARCH_BOX_ELEMENT = "//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/input";
    private final String SEARCH_BUTTON_ELEMENT = "//i[@class='cyrzo7gC']";
    private final String PRODUCT_ELEMENT = "//span[@title='Lf27t350fhrxuf 27\" 5ms 1920x1080 Vga/hdmı Full Hd Siyah Led Monıtor']";
    private final String CART_ELEMENT = "//div[@class='add-to-basket-button-text']";
    private final String GO_TO_CART_ELEMENT = "//a[@class='goBasket']";
    private final String HEADER_ELEMENT = "//div[@class='pb-header']";
    private final String TRASH_ELEMENT = "//i[@class='i-trash']";
    private final String DISCOUNT_ELEMENT = "//span[@class='add-coupon-toggle-title']";
    private final String SHOP_BUTTON_ELEMENT = "//div[@class='pb-summary']//div[1]//a[1]//span[1]";
    private final String BUTTON_ELEMENT = "//button[contains(text(),'Anladım')]";

    @FindBy(className = "category-header")
    private List<WebElement> HOVER_ELEMENT;

    public void navigateToUrl(String url){

        driver.navigate().to(url);
    }

    public TrendyolPage closePopup(){

        waitFor(2);
        click(POPUP);
        return this;
    }

    public TrendyolPage categoryHoverOver(){

        hoverOverMenu(HOVER_ELEMENT);
        return this;
    }

    public boolean trendyolLogoControl(){

        return isDisplayed(TRENDYOL_LOGO);
    }

    public boolean loginLogoControl(){

        return isDisplayed(LOGIN_LOGO);
    }

    public TrendyolPage searchProduct(String product){

        sendKeys(SEARCH_BOX_ELEMENT,product);
        return this;
    }

    public TrendyolPage clickSearchButton(){

        click(SEARCH_BUTTON_ELEMENT);
        scrollDown(300);
        return this;
    }

    public TrendyolPage clickProduct(){

        click(PRODUCT_ELEMENT);
        return this;
    }

    public TrendyolPage clickCartElement(){

        click(CART_ELEMENT);
        waitFor(2);
        return this;
    }

    public TrendyolPage clickGoToCartElement(){

        click(GO_TO_CART_ELEMENT);
        waitFor(2);
        return this;
    }

    public TrendyolPage clickBuyingElement(){

        click(BUTTON_ELEMENT);
        return this;
    }

    public String isProductOnTheCart(){

        return getTextOfElement(HEADER_ELEMENT);
    }

    public boolean isTrashButtonClickable(){

        return isClickable(TRASH_ELEMENT);
    }

    public boolean isDiscountButtonClickable(){

        return isClickable(DISCOUNT_ELEMENT);
    }

    public boolean isShopButtonClickable(){

        return isClickable(SHOP_BUTTON_ELEMENT);
    }
}
