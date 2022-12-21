package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PlaceOrderPage extends BasePage {

    public PlaceOrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"name\"]")
    private WebElement nameInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
    private WebElement countryInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
    private WebElement cityInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"card\"]")
    private WebElement cardInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"month\"]")
    private WebElement monthInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"year\"]")
    private WebElement yearInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
    private WebElement btnPurchase;
    @FindBy(how = How.XPATH, using = "//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")
    private WebElement btnClose;
    @FindBy(how = How.XPATH, using = "//div[10]/div[4]/div[1]")
    private WebElement completeLogo;
    @FindBy(how = How.XPATH, using = "//div[10]/h2")
    private WebElement lblThanks;
    @FindBy(how = How.XPATH, using = "//div[10]/p")
    private WebElement lblOrderInfo;
    @FindBy(how = How.XPATH, using = "//div[7]/div/button")
    private WebElement btnAcknowledge;

    public WebElement getNameForm() { return nameInput; }
    public WebElement getCountryForm() { return countryInput; }
    public WebElement getCityForm() { return cityInput; }
    public WebElement getCardForm() { return cardInput; }
    public WebElement getMonthForm() { return monthInput; }
    public WebElement getYearForm() { return yearInput; }
    public WebElement getPurchaseBtn() { return btnPurchase; }
    public WebElement getCloseBtn() { return btnClose; }
    public WebElement getCompleteLogo() { return completeLogo; }
    public WebElement getLblOrderInfo() { return lblOrderInfo; }
    public WebElement getLblThanks() { return lblThanks; }
    public WebElement getAcknowledgeBtn() { return btnAcknowledge; }
}
