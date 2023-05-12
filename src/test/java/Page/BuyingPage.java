package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BuyingPage extends ReusableMethods {

    WebDriver driver;

    public BuyingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final String HEADER_ELEMENT = "//div[@class='pb-header']";
    private final String TRASH_ELEMENT = "//i[@class='i-trash']";
    private final String DISCOUNT_ELEMENT = "//span[@class='add-coupon-toggle-title']";
    private final String SHOP_BUTTON_ELEMENT = "//div[@class='pb-summary']//div[1]//a[1]//span[1]";
    private final String UNDERSTAND_POPUP = "//button[contains(text(),'Anladım')]";

    public BuyingPage clickBuyingElement(){

        click(UNDERSTAND_POPUP);
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
