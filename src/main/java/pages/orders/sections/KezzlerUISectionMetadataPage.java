package pages.orders.sections;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.WaitForElement;

public class KezzlerUISectionMetadataPage {
    WebDriver driver;
    WaitForElement wait;
    By sectionMetadataTitle = By.xpath("//a[contains(.,'Edit Section')]");

    public KezzlerUISectionMetadataPage(WebDriver driver, WaitForElement wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean checkSectionMetadataPage() {
        wait.isElementLoaded(sectionMetadataTitle, this.driver);
        if (driver.findElement(sectionMetadataTitle).getText().toLowerCase().equals("edit section")) {
            return true;
        }
        return false;
    }




}
