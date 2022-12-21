package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends BasePage{
    public CartPage(WebDriver webDriver) { super(webDriver); }

    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/tr/td[1]/img")
    private WebElement btnCartImg;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/tr/td[2]")
    private WebElement btnCartTitle;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/tr/td[3]")
    private WebElement btnCartPrice;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/tr/td[4]/a")
    private WebElement btnCartDelete;
    @FindBy(how = How.XPATH, using = "//*[@id=\"totalp\"]")
    private WebElement btnCartTotal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
    private WebElement btnCartPlaceOrder;

    public WebElement getCartImg() { return btnCartImg; }
    public WebElement getCartTitle() { return btnCartTitle; }
    public WebElement getCartPrice() { return btnCartPrice; }
    public WebElement getCartDelete() { return btnCartDelete; }
    public WebElement getCartTotal() { return btnCartTotal; }
    public WebElement getCartPlaceOrder() { return btnCartPlaceOrder; }
}
