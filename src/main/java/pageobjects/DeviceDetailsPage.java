package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeviceDetailsPage extends BasePage{
    public DeviceDetailsPage(WebDriver webDriver) { super(webDriver); }

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

    public WebElement getDeviceImg() { return btnDeviceImg; }
    public WebElement getDeviceTitle() { return btnDeviceTitle; }
    public WebElement getDevicePrice() { return btnDevicePrice; }
    public WebElement getDeviceDescription() { return btnDeviceDescription; }
    public WebElement getAddProduct() { return btnAddProduct; }
}
