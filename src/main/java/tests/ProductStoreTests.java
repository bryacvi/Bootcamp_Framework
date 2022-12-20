package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import steps.*;
import org.testng.annotations.Test;
import pageobjects.HoverOverPage;

public class ProductStoreTests extends BaseTest {
    ElementsSteps elementsSteps = new ElementsSteps(driver);
    MiscellaneousSteps miscellaneousSteps = new MiscellaneousSteps(driver);
    ProductStoreSteps productStoreSteps = new ProductStoreSteps(driver);
    HoverOverPage hoverOver = PageFactory.initElements(driver, HoverOverPage.class);

    @Test(groups = "ProjectSuite")
    public void TestURLisCorrect () {
        productStoreSteps.navigateHome();
        String expectedURL = "https://www.demoblaze.com/index.html";
        String actualURL = driver.getCurrentUrl();

        CustomAssertions.isURLValid(expectedURL, actualURL);
    }

    @Test(groups = "ProjectSuite")
    public void TestTitleisCorrect () {
        productStoreSteps.navigateHome();
        String expectedTitle = "STORE";
        String actualTitle = elementsSteps.getTitle();

        CustomAssertions.isURLValid(expectedTitle, actualTitle);
    }

    @Test(testName = "SRS-12111", description = "Testing Displayed Categories ",groups = "ProjectSuite")
    public void TestDisplayedCategories () {
        Wait<WebDriver> wait = miscellaneousSteps.startDriverWait(50, 200);
        productStoreSteps.navigateHome();
        productStoreSteps.categoriesVerification(wait);

        System.out.println("Test Passed!");
    }

    @Test(testName = "SRS-12120", description = "Testing Displayed Products Information ",groups = "ProjectSuite")
    public void TestDisplayedProducts () {
        Wait<WebDriver> wait = miscellaneousSteps.startDriverWait(50, 200);
        productStoreSteps.navigateHome();
        productStoreSteps.homeProductVerification(wait);
        hoverOver.getFirstDevice().click();
        productStoreSteps.productDetailsVerification(wait);

        System.out.println("Test Passed!");
    }

    @Test(testName = "SRS-12121", description = "Testing Addition of Products",groups = "ProjectSuite")
    public void TestProductAdditions () {
        Wait<WebDriver> wait = miscellaneousSteps.startDriverWait(50, 200);
        productStoreSteps.navigateHome();
        productStoreSteps.homeProductVerification(wait);
        hoverOver.getFirstDevice().click();
        productStoreSteps.addProductVerification(wait);

        System.out.println("Test Passed!");
    }

    @Test(testName = "SRS-12130", description = "Testing Displayed Products Cart",groups = "ProjectSuite")
    public void TestDisplayedCart () {
        Wait<WebDriver> wait = miscellaneousSteps.startDriverWait(50, 200);
        productStoreSteps.navigateHome();
        productStoreSteps.homeProductVerification(wait);
        hoverOver.getFirstDevice().click();
        productStoreSteps.addProductVerification(wait);
        hoverOver.getAddProduct().click();
        elementsSteps.acknowledgeNotification();
        productStoreSteps.navigateHome();
        productStoreSteps.cartVerification(wait);
        productStoreSteps.placeOrderVerification(wait);

        System.out.println("Test Passed!");
    }
}