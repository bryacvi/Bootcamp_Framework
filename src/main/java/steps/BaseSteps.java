package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseSteps {
    WebDriver webDriver;
    Actions customActions;
    JavascriptExecutor js;
    Select customSelect;


    public BaseSteps (WebDriver webDriver) {
        this.webDriver = webDriver;
        this.customActions = new Actions(webDriver);
        js = (JavascriptExecutor) webDriver;
    }

    public void navigateToURL(String url) {
        webDriver.get(url);
    }

    public void dragWebElement(WebElement draggable, WebElement droppable) {
        System.out.println("Action is being performed");
        customActions
                .dragAndDrop(draggable, droppable)
                .perform();
    }

    public void hoverOverWebElement(WebElement hoverable) {
        customActions
                .moveToElement(hoverable)
                .perform();
    }

    public void scrollToWebElement(WebElement scrollTo) {
        if (webDriver instanceof FirefoxDriver) {
            System.out.println("Scrolling in Firefox");
            sleepFor(1000);
            js.executeScript("arguments[0].scrollIntoView(true);", scrollTo);
        }
        if (webDriver instanceof ChromeDriver) {
            System.out.println("Scrolling in Chrome");
            customActions
                    .scrollToElement(scrollTo);
                    //.perform();
        }
    }

    public String getElementText(WebElement elementToGetText) {
        return elementToGetText.getText();
    }

    public String getWebElement(WebElement elementToGet) {
        String original;
        original = elementToGet.toString();
        char [] filter = new char[getWebElementLength(elementToGet)-1];
        int j = 0;

        for(int i = (original.length()-getWebElementLength(elementToGet)); i < original.length()-1 ; i++){
            filter[j] = original.charAt(i);
            j++;
        }

        String expected = new String(filter);
        return expected;
    }

    public int getWebElementLength(WebElement elementToGet) {
        String original;
        original = elementToGet.toString();
        int i = 0, j = 0;
        for (; i < original.length()-2; i++) {
            if(original.charAt(i) == ':') j = i+2;
        }
        return ((original.length())-j);
    }

    public int getWebElementPosition(WebElement elementToGet) {
        String original;
        original = elementToGet.toString();
        for (int i = 0; i < original.length(); i++) {
            if(original.charAt(i) == '>') return ((original.length()+2)-i);
        }
        return 0;
    }

    public void selectFromDropDownByValue(WebElement dropDown, String value) {
        customSelect = new Select(dropDown);
        customSelect.selectByValue(value);
    }

    public void selectFromDropDownByText(WebElement dropDown, String text) {
        System.out.println("Selecting by Visible Text");
        customSelect = new Select(dropDown);
        customSelect.selectByVisibleText(text);
    }

    public void selectFromDropDownByIndex(WebElement dropDown, int index) {
        customSelect = new Select(dropDown);
        customSelect.selectByIndex(index);
    }

    public String getDropDownSelectedOption(WebElement dropDown) {
        customSelect = new Select(dropDown);
        return customSelect
                .getFirstSelectedOption()
                .getText();
    }

    public void sleepFor(long millis) {
        try {
            Thread.sleep(millis);
            System.out.println("Waiting for "+millis+"ms");
        } catch (InterruptedException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String extractStringFromLine(String str, int line) {
        int finalPointer=0, Separators=0, initialPointer=0, length = 0;

        for (int i=0 ; i < str.length() ; i++) {
            if (str.charAt(i) == System.lineSeparator().charAt(0)) {
                initialPointer = finalPointer+1;
                finalPointer = i;
                Separators++;
                if (line == Separators) break;
            }
            else if(i == (str.length())-1) {
                initialPointer = finalPointer+1;
                finalPointer = i+1;
                Separators++;
            }
        }

        length = finalPointer-initialPointer;

        if((line == Separators) && (line == 1)) {
            char [] filter = new char[length+1];

            if (line == 1) for (int i=0 ; i < length+1 ; i++) filter[i] = str.charAt(i);

            else for (int i=0 ; i < length ; i++) filter[i] = str.charAt(i+initialPointer);

            String result = new String(filter);
            return result;
        }

        else if((line == Separators) && (line != 1)) {
            char [] filter = new char[length];

            for (int i=0 ; i < length ; i++) filter[i] = str.charAt(i+initialPointer);

            String result = new String(filter);
            return result;
        }

        return null;
    }

}
