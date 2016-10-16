package pages.orders.sections;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

public class KezzlerUISectionPage {
    WebDriver driver;
    WaitForElement wait;
    By sectionEditButton = By.xpath("//a[@title='Edit']");
    By sectionRemoveButton = By.xpath("//a[@class='btn btn-danger']");
    By sectionMessagesButton = By.xpath("//a[@title='Validation messages']");
    By sectionMetadataButton = By.xpath("//a[contains(@kz-restrict-disable,'READER')]");
    By sectionTable = By.xpath("//h3[contains(.,' Section details')]");
    By sectionActivation = By.xpath("//label[contains(.,'Enabled')]");
    By sectionActivationTable = By.xpath("//h3[contains(.,' Activation')]");
    By sectionActivationLimit = By.xpath("//label[contains(.,'Validations limit')]");
    By sectionTableProduct = By.xpath("//span[@ng-show='section.product']");
    String productName;
    String testNotes;

    public KezzlerUISectionPage(WebDriver driver, WaitForElement wait, String productName, String testNotes) {
        this.driver = driver;
        this.wait = wait;
        this.productName = productName;
        this.testNotes = testNotes;
    }

    public boolean checkSectionPage() {
        wait.isElementLoaded(sectionRemoveButton, this.driver);
        if (driver.findElement(sectionRemoveButton).getText().toLowerCase().equals("new metadata schema")) {
            return true;
        }
        return false;
    }

    public void clickMessagesButton() {
        wait.isElementLoaded(sectionMessagesButton, this.driver);
        driver.findElement(sectionMessagesButton).click();
    }

    public void clickMetadataButton() {
        wait.isElementLoaded(sectionMetadataButton, this.driver);
        driver.findElement(sectionMetadataButton).click();
    }

    public void clickEditButton() {
        wait.isElementLoaded(sectionEditButton, this.driver);
        driver.findElement(sectionEditButton).click();
    }

    public void clickRemoveButton() {
        wait.isElementLoaded(sectionRemoveButton, this.driver);
        driver.findElement(sectionRemoveButton).click();
    }

    public boolean checkCreatedBasicSection() {
        By sectionsTableComment = By.xpath("//label[contains(.,'End index')]");
        wait.isElementLoaded(sectionTable, this.driver);
        try {
            driver.findElement(sectionsTableComment);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }

    public boolean checkAddedSectionProductSchemaNotes() {

        wait.isElementLoaded(sectionTable, this.driver);
        try {
            driver.findElement(sectionTableProduct);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }

    public boolean checkAddedSectionActivationLimit() {
        wait.isElementLoaded(sectionActivationTable, this.driver);
        try {
            driver.findElement(sectionActivation);
            driver.findElement(sectionActivationLimit);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }


}
