package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import pageobjects.HoverOverPage;
import org.openqa.selenium.By;
import tests.CustomAssertions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductStoreSteps extends BaseSteps {

    MiscellaneousSteps miscellaneousSteps = new MiscellaneousSteps(webDriver);
    ElementsSteps elementsSteps = new ElementsSteps(webDriver);
    HoverOverPage hoverOver = PageFactory.initElements(webDriver, HoverOverPage.class);

    static String NameInfo = new String("Juan");
    static String CountryInfo = new String("Mexico");
    static String CityInfo = new String("Mexico");
    static String CardInfo = new String("23481623949789");
    static String YearInfo = new String("2000");
    static String MonthInfo = new String("04");

    static Date date = new Date();
    static SimpleDateFormat day = new SimpleDateFormat("dd");
    static String formattedDay = day.format(date);
    static String DayFormat = new String(formattedDay);
    static SimpleDateFormat month = new SimpleDateFormat("MM");
    static String formattedMonth = month.format(date);
    static Integer MonthNumber = Integer.valueOf(formattedMonth)-1;
    static String MonthFormat = new String((MonthNumber.toString()));
    static SimpleDateFormat year = new SimpleDateFormat("yyyy");
    static String formattedYear = year.format(date);
    static String YearFormat = new String(formattedYear);
    static String DateInfoAux = new String(DayFormat+"/"+MonthFormat+"/"+YearFormat);

    public ProductStoreSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateHome() {
        miscellaneousSteps.scrollToElement(hoverOver.getHome());
        hoverOver.getHome().click();
        sleepFor(1000);
    }

    public void categoriesVerification(Wait<WebDriver> wait) {
        miscellaneousSteps.scrollToElement(hoverOver.getCategoryPhones());
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getCategoryPhones()))));
        CustomAssertions.isTextEqual((hoverOver.getCategoryPhones().getText()), "Phones");

        miscellaneousSteps.scrollToElement(hoverOver.getCategoryLaptops());
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getCategoryLaptops()))));
        CustomAssertions.isTextEqual((hoverOver.getCategoryLaptops().getText()), "Laptops");

        miscellaneousSteps.scrollToElement(hoverOver.getCategoryMonitors());
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getCategoryMonitors()))));
        CustomAssertions.isTextEqual((hoverOver.getCategoryMonitors().getText()), "Monitors");
    }

    public void homeProductVerification(Wait<WebDriver> wait) {
        miscellaneousSteps.scrollToElement(hoverOver.getFirstDevice());
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getFirstDevice()))));
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getFirstDevice())))
                .getAttribute("innerText"), "Samsung galaxy s6");
    }

    public void productDetailsVerification(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getDeviceImg()))));
        getWebElement(hoverOver.getDeviceImg());
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getDeviceTitle())))
                .getAttribute("innerText"), "Samsung galaxy s6");
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getDevicePrice())))
                .getAttribute("innerText"), "$360 *includes tax");
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getDeviceDescription())))
                .getAttribute("innerText"), "The Samsung Galaxy S6 is powered by 1.5GHz octa-core "+
                "Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage"+
                        " cannot be expanded.");
        getWebElement(hoverOver.getAddProduct());
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getAddProduct())))
                .getAttribute("innerText"), "Add to cart");
    }

    public void addProductVerification(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getAddProduct()))));
        hoverOver.getAddProduct().click();
        sleepFor(1000);
        CustomAssertions.isTextEqual(elementsSteps.getNotificationText(), "Product added");
        elementsSteps.acknowledgeNotification();
    }

    public void cartVerification(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getCart()))));
        hoverOver.getCart().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getCartImg()))));
        getWebElement(hoverOver.getDeviceImg());
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getCartTitle())))
                .getAttribute("innerText"), "Samsung galaxy s6");
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getCartPrice())))
                .getAttribute("innerText"), "360");
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getCartDelete())))
                .getAttribute("innerText"), "Delete");
        hoverOver.getCartDelete().click();
        sleepFor(1000);
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getCartTotal())))
                .getAttribute("innerText"), "360");
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getCartPlaceOrder())))
                .getAttribute("innerText"), "Place Order");
    }

    public void placeOrderVerification(Wait<WebDriver> wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getCartPlaceOrder()))));
        hoverOver.getCartPlaceOrder().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getNameForm()))));
        hoverOver.getPurchaseBtn().click();
        sleepFor(1000);
        CustomAssertions.isTextEqual(elementsSteps.getNotificationText(),
                "Please fill out Name and Creditcard.");
        elementsSteps.acknowledgeNotification();
        sleepFor(1000);

        fillOrderInformation();
        hoverOver.getCloseBtn().click();
        sleepFor(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getCartPlaceOrder()))));
        hoverOver.getCartPlaceOrder().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getNameForm()))));
        //fillOrderInformation();
        hoverOver.getPurchaseBtn().click();
        sleepFor(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(getWebElement(hoverOver.getCompleteLogo()))));
        getWebElement(hoverOver.getCompleteLogo());
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getLblThanks())))
                .getAttribute("innerText"), "Thank you for your purchase!");
        String firstLine = IdStringLine(webDriver.findElement(
                By.xpath(getWebElement(hoverOver.getLblOrderInfo()))).getText());
        CustomAssertions.isTextEqual(webDriver.findElement(By.xpath(getWebElement(hoverOver.getLblOrderInfo())))
                .getText(), firstLine+System.lineSeparator()+"Amount: 360 USD"+
                System.lineSeparator()+"Card Number: "+CardInfo+System.lineSeparator()+"Name: "+NameInfo+
                System.lineSeparator()+"Date: "+ DateInfoAux);
        hoverOver.getAcknowledgeBtn().click();
        sleepFor(1000);
    }

    public void fillOrderInformation() {
        hoverOver.getNameForm().sendKeys(NameInfo);
        hoverOver.getCountryForm().sendKeys(CountryInfo);
        hoverOver.getCityForm().sendKeys(CityInfo);
        hoverOver.getCardForm().sendKeys(CardInfo);
        hoverOver.getMonthForm().sendKeys(MonthInfo);
        hoverOver.getYearForm().sendKeys(YearInfo);
    }

    public String IdStringLine(String args) {
        int j=0;

        for (int i=0 ; i < args.length() ; i++) {
            if (args.charAt(i) == System.lineSeparator().charAt(0)) {
                j = i;
                break;
            }
        }

        char [] filter = new char[j];
        for (int i=0 ; i < j ; i++) {
            filter[i] = args.charAt(i);
        }

        String result = new String(filter);

        return result;
    }
}
