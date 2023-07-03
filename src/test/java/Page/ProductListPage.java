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
        PageFactory.initElements(driver,this);
    }

    private static final By PRODUCT_ELEMENT = By.xpath("//span[@title='Lf27t350fhrxuf 27\" 5ms 1920x1080 Vga/hdmı Full Hd Siyah Led Monıtor']");

    public ProductListPage clickProduct(){

        click(PRODUCT_ELEMENT);
        return this;
    }
}
