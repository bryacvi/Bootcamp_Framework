package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class HoverOverPage extends BasePage{
    public HoverOverPage(WebDriver webDriver) {
        super(webDriver);
    }

    //Home
    @FindBy(how = How.XPATH, using = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    private WebElement btnHome;
    @FindBy(how = How.XPATH, using = "//*[@id=\"cartur\"]")
    private WebElement btnCart;
    @FindBy(how = How.XPATH, using = "//*[@onclick=\"byCat('phone')\"]")
    private WebElement btnCategoryPhones;
    @FindBy(how = How.XPATH, using = "//*[@onclick=\"byCat('notebook')\"]")
    private WebElement btnCategoryLaptops;
    @FindBy(how = How.XPATH, using = "//*[@onclick=\"byCat('monitor')\"]")
    private WebElement btnCategoryMonitors;
    @FindBy(how = How.XPATH, using = "//div[1]/div/div/h4/a")
    private WebElement btnFirstDevice;

    //Device
    @FindBy(how = How.XPATH, using = "//*[@id=\"imgp\"]/div/img")
    private WebElement btnDeviceImg;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/h2")
    private WebElement btnDeviceTitle;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/h3")
    private WebElement btnDevicePrice;
    @FindBy(how = How.XPATH, using = "//*[@id=\"more-information\"]/p")
    private WebElement btnDeviceDescription;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    private WebElement btnAddProduct;

    //Cart
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

    //Buy
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

    public WebElement getHome() { return btnHome; }
    public WebElement getCart() { return btnCart; }
    public WebElement getCategoryPhones() { return btnCategoryPhones; }
    public WebElement getCategoryLaptops() { return btnCategoryLaptops; }
    public WebElement getCategoryMonitors() { return btnCategoryMonitors; }
    public WebElement getFirstDevice() { return btnFirstDevice; }

    public WebElement getDeviceImg() { return btnDeviceImg; }
    public WebElement getDeviceTitle() { return btnDeviceTitle; }
    public WebElement getDevicePrice() { return btnDevicePrice; }
    public WebElement getDeviceDescription() { return btnDeviceDescription; }
    public WebElement getAddProduct() { return btnAddProduct; }

    public WebElement getCartImg() { return btnCartImg; }
    public WebElement getCartTitle() { return btnCartTitle; }
    public WebElement getCartPrice() { return btnCartPrice; }
    public WebElement getCartDelete() { return btnCartDelete; }
    public WebElement getCartTotal() { return btnCartTotal; }
    public WebElement getCartPlaceOrder() { return btnCartPlaceOrder; }

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
