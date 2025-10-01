package util;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class elementHelper {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    propertiesFactory propertiesFactory = new propertiesFactory();

    public elementHelper(RemoteWebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(propertiesFactory.getWait()));
    }

    public void click(By by) {
        scrollElement(by).click();
    }

    public void clearText(By by){
        scrollElement(by).clear();
    }
    public void sendKey(By by, String text) {
        scrollElement(by).sendKeys(text);
    }

    public String getText(By by) {
        String text = scrollElement(by).getText();
        return text;
    }


    public void checkElementPresence(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void checkElementAttribute(By by, String attr, String expectedValue) {
       /* WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        System.out.println(element);
        System.out.println(element.getAttribute("class"));
        Object aa=executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element);
        System.out.println(aa.toString());
        System.out.println(driver.findElement(by).getAttribute(attr));
        wait.until(ExpectedConditions.attributeToBe(by,attr,expectedValue));*/
    }

    public WebElement scrollElement(By by) {
        checkElementPresence(by);
        WebElement element = driver.findElement(by);
        //actions.moveToElement(element).build().perform();
        return element;
    }

    public void clickElementWithText(By by, String text) {
        List<WebElement> buttons = driver.findElements(by);
        for (WebElement element : buttons) {
            if (element.getText().equals(text)) {
                element.click();
            }

        }
    }

    public static String generateRandomUsername(int length, String username) {
        String characters = "0123456789";
        StringBuilder randomString = new StringBuilder(length);
        Random random = new Random();
        randomString.append(username);
        for (int i = 0; i < length - username.length(); i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }
        return randomString.toString();
    }
    public static String generateRandomDoorname(int length, String username) {
        String characters = "0123456789";
        StringBuilder randomString = new StringBuilder(length);
        Random random = new Random();
        randomString.append(username);
        for (int i = 0; i < length - username.length(); i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }
        return randomString.toString();
    }

    public void swipeLeft(By by) {
        WebElement element = driver.findElement(by);
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        int screenWidth = driver.manage().window().getSize().getWidth();
        int scrollDistance = screenWidth / 2;
        touchAction.longPress(PointOption.point(element.getLocation().getX(), element.getLocation().getY()))
                .moveTo(PointOption.point(element.getLocation().getX() - scrollDistance, element.getLocation().getY()))
                .release()
                .perform();
    }


    // Metin öğesindeki metin içeriğini kontrol etmek için bir yöntem
    public boolean checkText(By by, String expectedText) {
        checkElementPresence(by);
        WebElement element = driver.findElement(by);  // Metin öğesini bul
        String actualText = element.getText();  // Metin öğesinden metin içeriğini al
        return actualText.equals(expectedText);  // Metin içeriği ile beklenen metni karşılaştır ve sonucu döndür
    }
}
