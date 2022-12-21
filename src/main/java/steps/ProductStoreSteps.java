package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import pageObjects.ProductStoreNavigationBar;
import pageObjects.HomePage;
import pageObjects.CartPage;
import pageObjects.PlaceOrderPage;
import pageObjects.DeviceDetailsPage;
import org.openqa.selenium.By;
import tests.CustomAssertions;

import static pageObjects.Constants.*;

public class ProductStoreSteps extends BaseSteps {

    MiscellaneousSteps miscellaneousSteps = new MiscellaneousSteps(webDriver);
    ElementsSteps elementsSteps = new ElementsSteps(webDriver);
    ProductStoreNavigationBar productStoreNavigationBar = PageFactory.initElements(webDriver,
            ProductStoreNavigationBar.class);
    HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
    CartPage cartPage = PageFactory.initElements(webDriver, CartPage.class);
    PlaceOrderPage placeOrderPage = PageFactory.initElements(webDriver, PlaceOrderPage.class);
    DeviceDetailsPage deviceDetailsPage = PageFactory.initElements(webDriver, DeviceDetailsPage.class);

    public ProductStoreSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateHome() {
        miscellaneousSteps.scrollToElement(productStoreNavigationBar.getHome());
        productStoreNavigationBar.getHome().click();
        sleepFor(1000);
    }

    public void categoriesVerification(Wait<WebDriver> wait) {
        miscellaneousSteps.scrollToElement(homePage.getCategoryPhones());
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(homePage.getCategoryPhones()))));
        CustomAssertions.isTextEqual((homePage.getCategoryPhones().getText()), "Phones");

        miscellaneousSteps.scrollToElement(homePage.getCategoryLaptops());
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(homePage.getCategoryLaptops()))));
        CustomAssertions.isTextEqual((homePage.getCategoryLaptops().getText()), "Laptops");

        miscellaneousSteps.scrollToElement(homePage.getCategoryMonitors());
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(homePage.getCategoryMonitors()))));
        CustomAssertions.isTextEqual((homePage.getCategoryMonitors().getText()), "Monitors");
    }

    public void homeProductVerification(Wait<WebDriver> wait) {
        miscellaneousSteps.scrollToElement(homePage.getFirstDevice());
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(homePage.getFirstDevice()))));
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(homePage.getFirstDevice())))
                .getAttribute("innerText"), "Samsung galaxy s6");
    }

    public void productDetailsVerification(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(deviceDetailsPage.getDeviceImg()))));
        getWebElement(deviceDetailsPage.getDeviceImg());
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(deviceDetailsPage
                        .getDeviceTitle()))).getAttribute("innerText"), "Samsung galaxy s6");
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(deviceDetailsPage
                        .getDevicePrice()))).getAttribute("innerText"), "$360 *includes tax");
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(deviceDetailsPage
                        .getDeviceDescription()))).getAttribute("innerText"), "The Samsung "+
                "Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB "+
                "of RAM. The phone packs 32GB of internal storage cannot be expanded.");
        getWebElement(deviceDetailsPage.getAddProduct());
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(deviceDetailsPage
                        .getAddProduct()))).getAttribute("innerText"), "Add to cart");
    }

    public void addProductVerification(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(deviceDetailsPage.getAddProduct()))));
        deviceDetailsPage.getAddProduct().click();
        sleepFor(1000);
        CustomAssertions.isTextEqual(elementsSteps.getNotificationText(), "Product added");
        elementsSteps.acknowledgeNotification();
    }

    public void cartVerification(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(productStoreNavigationBar.getCart()))));
        productStoreNavigationBar.getCart().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(cartPage.getCartImg()))));
        getWebElement(deviceDetailsPage.getDeviceImg());
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(cartPage.getCartTitle())))
                .getAttribute("innerText"), "Samsung galaxy s6");
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(cartPage.getCartPrice())))
                .getAttribute("innerText"), "360");
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(cartPage.getCartDelete())))
                .getAttribute("innerText"), "Delete");
        cartPage.getCartDelete().click();
        sleepFor(1000);
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(cartPage.getCartTotal())))
                .getAttribute("innerText"), "360");
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(cartPage.getCartPlaceOrder())))
                .getAttribute("innerText"), "Place Order");
    }

    public void placeOrderVerification(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(cartPage.getCartPlaceOrder()))));
        cartPage.getCartPlaceOrder().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(placeOrderPage.getNameForm()))));
        placeOrderPage.getPurchaseBtn().click();
        sleepFor(1000);
        CustomAssertions.isTextEqual(elementsSteps.getNotificationText(),
                "Please fill out Name and Creditcard.");
        elementsSteps.acknowledgeNotification();
        sleepFor(1000);

        fillOrderInformation();
        placeOrderPage.getCloseBtn().click();
        sleepFor(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(cartPage.getCartPlaceOrder()))));
        cartPage.getCartPlaceOrder().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(placeOrderPage.getNameForm()))));
        placeOrderPage.getPurchaseBtn().click();
        sleepFor(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(placeOrderPage.getCompleteLogo()))));
        getWebElement(placeOrderPage.getCompleteLogo());
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(placeOrderPage.getLblThanks())))
                .getAttribute("innerText"), "Thank you for your purchase!");
        String firstLine = extractStringFromLine(webDriver.findElement(
                By.xpath(getWebElement(placeOrderPage.getLblOrderInfo()))).getText(), 1);
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(placeOrderPage.getLblOrderInfo())))
                .getText(), firstLine+System.lineSeparator()+"Amount: 360 USD"+
                System.lineSeparator()+"Card Number: "+CardInfo+System.lineSeparator()+"Name: "+NameInfo+
                System.lineSeparator()+"Date: "+ DateInfoAux);
        placeOrderPage.getAcknowledgeBtn().click();
        sleepFor(1000);
    }

    public void fillOrderInformation() {
        placeOrderPage.getNameForm().sendKeys(NameInfo);
        placeOrderPage.getCountryForm().sendKeys(CountryInfo);
        placeOrderPage.getCityForm().sendKeys(CityInfo);
        placeOrderPage.getCardForm().sendKeys(CardInfo);
        placeOrderPage.getMonthForm().sendKeys(MonthInfo);
        placeOrderPage.getYearForm().sendKeys(YearInfo);
    }
}
