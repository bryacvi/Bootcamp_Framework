package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductStoreNavigationBar extends BasePage{
    public ProductStoreNavigationBar(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    private WebElement btnHome;
    @FindBy(how = How.XPATH, using = "//*[@id=\"cartur\"]")
    private WebElement btnCart;

    public WebElement getHome() { return btnHome; }
    public WebElement getCart() { return btnCart; }
}
