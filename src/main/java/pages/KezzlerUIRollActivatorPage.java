package pages;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

public class KezzlerUIRollActivatorPage {
    WebDriver driver;
    WaitForElement wait;
    By homePageName = By.xpath("//p[@class='text-muted']");

    public KezzlerUIRollActivatorPage(WebDriver driver, WaitForElement wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean checkRollActivatorPage() {
        wait.isElementLoaded(homePageName, this.driver);
        if (driver.findElement(homePageName).getText().toLowerCase().contains("you can find a roll")) {
            return true;
        }
        return false;
    }
}
