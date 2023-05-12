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
}
