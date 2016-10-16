package pages.orders.sections;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

public class KezzlerUISectionsPage {
    WebDriver driver;
    WaitForElement wait;
    By sectionsGoToSectionButton = By.xpath("//button[@ng-click='gotoSectionDialogOpen()']");
    By sectionsNewSectionButton = By.xpath("//a[contains(.,' New section')]");
    By sectionsFrameGoToButton = By.xpath("//button[@ng-click='goto(code, id)']");
    By sectionsTable = By.xpath("//h3[contains(.,' Section details')]");
    String productName;
    String testNotes;

    public KezzlerUISectionsPage(WebDriver driver, WaitForElement wait, String productName, String testNotes) {
        this.driver = driver;
        this.wait = wait;
        this.productName = productName;
        this.testNotes = testNotes;
    }

    public boolean checkSectionsPage() {
        wait.isElementLoaded(sectionsNewSectionButton, this.driver);
        if (driver.findElement(sectionsNewSectionButton).getText().toLowerCase().equals("new metadata schema")) {
            return true;
        }
        return false;
    }

    public boolean checkSectionsGoTo() {
        wait.isElementLoaded(sectionsFrameGoToButton, this.driver);
        if (driver.findElement(sectionsFrameGoToButton).getText().toLowerCase().equals("go to section")) {
            return true;
        }
        return false;
    }

    public void clickGoToSectionButton() {
        wait.isElementLoaded(sectionsGoToSectionButton, this.driver);
        driver.findElement(sectionsGoToSectionButton).click();
    }

    public void clickNewSectionButton() {
        wait.isElementLoaded(sectionsNewSectionButton, this.driver);
        driver.findElement(sectionsNewSectionButton).click();
    }


}
