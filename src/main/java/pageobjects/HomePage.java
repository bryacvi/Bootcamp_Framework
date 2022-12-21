package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.XPATH, using = "//*[@onclick=\"byCat('phone')\"]")
    private WebElement btnCategoryPhones;
    @FindBy(how = How.XPATH, using = "//*[@onclick=\"byCat('notebook')\"]")
    private WebElement btnCategoryLaptops;
    @FindBy(how = How.XPATH, using = "//*[@onclick=\"byCat('monitor')\"]")
    private WebElement btnCategoryMonitors;
    @FindBy(how = How.XPATH, using = "//div[1]/div/div/h4/a")
    private WebElement btnFirstDevice;

    public WebElement getCategoryPhones() { return btnCategoryPhones; }
    public WebElement getCategoryLaptops() { return btnCategoryLaptops; }
    public WebElement getCategoryMonitors() { return btnCategoryMonitors; }
    public WebElement getFirstDevice() { return btnFirstDevice; }
}
