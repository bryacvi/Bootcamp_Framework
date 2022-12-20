package steps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pageobjects.DragDropExamplePage;
import pageobjects.DropDownExamplePage;
import pageobjects.HoverOverPage;
import org.openqa.selenium.By;

import java.time.Duration;

public class MiscellaneousSteps extends BaseSteps{

    DragDropExamplePage w3SchoolsDragDrop = PageFactory.initElements(webDriver, DragDropExamplePage.class);
    HoverOverPage hoverOverExample = PageFactory.initElements(webDriver, HoverOverPage.class);
    DropDownExamplePage dropDownExamplePage = PageFactory.initElements(webDriver, DropDownExamplePage.class);

    public MiscellaneousSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public void dragDivIntoDiv() {
        System.out.println("Dragging yellow div and dropping into red div");
        dragWebElement(w3SchoolsDragDrop.getDivDraggable(), w3SchoolsDragDrop.getDivContainer());
    }

    public void scrollToElement(WebElement element) {
        System.out.println("Scrolling to element");
        scrollToWebElement(element);
    }

    public void selectSearchEngine(String text) {
        System.out.println("Attempting to select option: " + text);
        selectFromDropDownByText(dropDownExamplePage.getDropDownFirst(), text);
    }

    public void selectSearchEngineByIndex(int index) {
        System.out.println("Attempting to select by index: " + index);
        selectFromDropDownByIndex(dropDownExamplePage.getDropDownFirst(), index);
    }

    public String getSelectedSearchEngine() {
        return getDropDownSelectedOption(dropDownExamplePage.getDropDownFirst());
    }

    public Wait<WebDriver> startDriverWait(long seconds, long millis) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(millis)).ignoring(NoSuchElementException.class);
        return wait;
    }
}
