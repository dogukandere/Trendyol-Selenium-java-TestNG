package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends ReusableMethods {
    WebDriver driver;

    public ProductPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final String CART_ELEMENT = "//div[@class='add-to-basket-button-text']";
    private final String GO_TO_CART_ELEMENT = "//a[@class='goBasket']";

    public ProductPage clickCartElement(){

        click(CART_ELEMENT);
        waitFor(2);
        return this;
    }

    public ProductPage clickGoToCartElement(){

        click(GO_TO_CART_ELEMENT);
        waitFor(2);
        return this;
    }
}
