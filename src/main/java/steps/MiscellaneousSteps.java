package steps;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class MiscellaneousSteps extends BaseSteps{

    public MiscellaneousSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public void dragDivIntoDiv(WebElement draggable, WebElement container) {
        System.out.println("Dragging yellow div and dropping into red div");
        dragWebElement(draggable, container);
    }

    public void scrollToElement(WebElement element) {
        System.out.println("Scrolling to element");
        scrollToWebElement(element);
    }

    public void selectSearchEngine(WebElement element, String text) {
        System.out.println("Attempting to select option: " + text);
        selectFromDropDownByText(element, text);
    }

    public void selectSearchEngineByIndex(WebElement element, int index) {
        System.out.println("Attempting to select by index: " + index);
        selectFromDropDownByIndex(element, index);
    }

    public String getSelectedSearchEngine(WebElement element) {
        return getDropDownSelectedOption(element);
    }

    public Wait<WebDriver> startDriverWait(long seconds, long millis) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(millis)).ignoring(NoSuchElementException.class);
        return wait;
    }
}
