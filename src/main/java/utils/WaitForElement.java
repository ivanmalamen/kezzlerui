package utils;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.*;

public class WaitForElement {

    public void isElementLoaded(By selector, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }
}
