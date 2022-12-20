package steps;

import org.openqa.selenium.WebDriver;

public class ElementsSteps extends BaseSteps {

    public ElementsSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitle() {
        return  webDriver.getTitle();
    }

    public String getNotificationText() {
        return  webDriver.switchTo().alert().getText();
    }

    public void acknowledgeNotification() {
        sleepFor(1000);
        webDriver.switchTo().alert().accept();
    }

    public void dismissNotification() { webDriver.switchTo().alert().dismiss(); }
}
