package Page;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage extends ReusableMethods {

    WebDriver driver;

    public ProductListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private static final By PRODUCT_ELEMENT = By.xpath("//span[@title='LS22F350FHRXUF 21.5\" 60Hz 5ms (Analog+HDMI) Full HD LED Monitör']");

    public ProductListPage clickProduct(){

        click(PRODUCT_ELEMENT);
        return this;
    }
}
