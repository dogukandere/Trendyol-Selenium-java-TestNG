package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class TrendyolPage extends ReusableMethods {
    WebDriver driver;

    public TrendyolPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement popup;

    @FindBy(xpath = "//img[@alt='Trendyol']")
    private WebElement logo;

    @FindBy(xpath = "//p[contains(text(),'Giriş Yap')]")
    private WebElement logo2;

    @FindBy(xpath = "//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/input")
    private WebElement searchBox;

    @FindBy(xpath = "//i[@class='cyrzo7gC']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"search-app\"]/div/div[1]/div[2]/div[3]/div[1]/div/div[1]/div[1]/a/div[3]/div[2]/p[2]")
    private WebElement popup2;

    @FindBy(xpath = "//span[@title='iPhone 14 Pro Max 128GB Uzay Siyahı']")
    private WebElement product;

    @FindBy(xpath = "//div[normalize-space()='1 TB']")
    private WebElement memoryElement;

    @FindBy(xpath = "//div[@class='add-to-basket-button-text']")
    private WebElement cartElement;

    @FindBy(xpath = "//a[@class='goBasket']")
    private WebElement goToCartElement;

    @FindBy(xpath = "//button[contains(text(),'Anladım')]")
    private WebElement button;

    @FindBy(xpath = "//div[@class='pb-summary']//div[1]//a[1]//span[1]")
    private WebElement button2;

    @FindBy(className = "category-header")
    private List<WebElement> hoverElement;

    @FindBy(xpath = "//div[@class='pb-header']")
    private WebElement headerElement;

    @FindBy(xpath = "//i[@class='i-trash']")
    private WebElement trashElement;

    @FindBy(xpath = "//span[@class='add-coupon-toggle-title']")
    private WebElement discountElement;

    @FindBy(xpath = "//div[@class='pb-summary']//div[1]//a[1]//span[1]")
    private WebElement shopButton;


    public void navigateToUrl(){
        driver.navigate().to("https://www.trendyol.com/");
        waitFor(3);
    }

    public void closePopup(){
        popup.click();
    }

    public void categoryHoverOver(){
        hoverOverMenu(hoverElement);
    }

    public void logoTitleLinkControl(){
        Assert.assertEquals(driver.getTitle(),"En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.trendyol.com/");
        isDisplayed(logo);
        isDisplayed(logo2);
    }

    public void search(){
        SendKeys(searchBox,"iphone 14");
        Click(searchButton);
        scrollDown(300);
    }

    public void productClick(){
        Click(popup2);
    }

    public void memorySelectandAddtoCart(){
        Click(memoryElement);
        scrollDown(300);
        Click(cartElement);
        Click(goToCartElement);
    }

    public void isProductOnTheCart(){
        Assert.assertEquals(headerElement.getText(),"Sepetim (1 Ürün)");
    }

    public void isTrashButtonClickable(){
        isClickable(trashElement);
    }

    public void isDiscountButtonClickable(){
        isClickable(discountElement);
    }

    public void isShopButtonClickable(){
        isClickable(shopButton);
    }

    public void buying(){
        Click(button);
    }
}
