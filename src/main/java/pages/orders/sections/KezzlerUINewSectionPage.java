package pages.orders.sections;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.WaitForElement;

public class KezzlerUINewSectionPage {
    WebDriver driver;
    WaitForElement wait;
    By newSectionStartIndexInput = By.xpath("//input[@id='startIndex']");
    By newSectionStartIndexButton = By.xpath("//button[@ng-click=\"pickCode('startIndex']\"");
    By newSectionEndIndexButton = By.xpath("//button[@ng-click=\"pickCode('endIndex']\"");
    By newSectionEndIndexInput = By.xpath("//input[@id='endIndex']");
    By newSectionNotesInput = By.xpath("//textarea[@ng-model='section.comment']");
    By newSectionProductList = By.xpath("//select[@ng-model='section.product.productId']");
    By newSectionSchemaList = By.xpath("//select[@id='metadataSchema']");
    By newSectionActivationCheckbox = By.xpath("//input[@ng-model='section.enabled']");
    By newSectionLimitCheckbox = By.xpath("//input[@ng-checked='limitedValidations']");
    By newSectionStartDateInput = By.xpath("//input[@id='from']");
    By newSectionEndDateInput = By.xpath("//input[@id='to']");
    By newSectionFramePickedCodeInput = By.xpath("//input[@ng-model='pickedCode']");
    By newSectionFramePickButton = By.xpath("//button[@ng-click='pick()']");
    By newSectionSaveButton = By.xpath("//button[@ng-click='save()']");
    String productName;
    String schemaName;
    String testNotes;
    String startIndex;
    String endIndex;
    String startDate;
    String endDate;
    String kezzlerCodeStart;
    String kezzlerCodeEnd;

    public KezzlerUINewSectionPage(WebDriver driver, WaitForElement wait, String productName,String schemaName,
                                   String testNotes, String startIndex, String endIndex,  String startDate, String endDate,
                                   String kezzlerCodeStart, String kezzlerCodeEnd)
                                    {
        this.driver = driver;
        this.wait = wait;
        this.productName = productName;
        this.schemaName = schemaName;
        this.testNotes = testNotes;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.startDate = startDate;
        this.endDate = endDate;
        this.kezzlerCodeStart = kezzlerCodeStart;
        this.kezzlerCodeEnd = kezzlerCodeEnd;
    }

    public boolean checkNewSectionPage() {
        wait.isElementLoaded(newSectionSaveButton, this.driver);
        if (driver.findElement(newSectionSaveButton).getText().toLowerCase().equals("save")) {
            return true;
        }
        return false;
    }

    public void switchToActiveFrame() {
        driver.switchTo().activeElement();
    }

    public void clickSaveButton() {
        wait.isElementLoaded(newSectionSaveButton, this.driver);
        driver.findElement(newSectionSaveButton).click();
    }

    public void clickStartIndexButton() {
        wait.isElementLoaded(newSectionStartIndexButton, this.driver);
        driver.findElement(newSectionStartIndexButton).click();
    }

    public void clickEndIndexButton() {
        wait.isElementLoaded(newSectionEndIndexButton, this.driver);
        driver.findElement(newSectionEndIndexButton).click();
    }

    public void clickFramePickButton() {
        wait.isElementLoaded(newSectionFramePickButton, this.driver);
        driver.findElement(newSectionFramePickButton).click();
    }


    public void checkActivationCheckbox() {
        wait.isElementLoaded(newSectionActivationCheckbox, this.driver);
        driver.findElement(newSectionActivationCheckbox).click();
    }

    public void checkLimitCheckbox() {
        wait.isElementLoaded(newSectionLimitCheckbox, this.driver);
        driver.findElement(newSectionLimitCheckbox).click();
    }

    public void enterStartIndex() {
        wait.isElementLoaded(newSectionStartIndexInput, this.driver);
        driver.findElement(newSectionStartIndexInput).sendKeys(startIndex);
    }

    public void enterEndIndex() {
        wait.isElementLoaded(newSectionEndIndexInput, this.driver);
        driver.findElement(newSectionEndIndexInput).sendKeys(endIndex);
    }

    public void enterKezzlerEndIndex() {
        wait.isElementLoaded(newSectionFramePickedCodeInput, this.driver);
        driver.findElement(newSectionFramePickedCodeInput).sendKeys(kezzlerCodeEnd);
    }

    public void enterKezzlerStartIndex() {
        wait.isElementLoaded(newSectionFramePickedCodeInput, this.driver);
        driver.findElement(newSectionFramePickedCodeInput).sendKeys(kezzlerCodeStart);
    }

    public void enterNotes() {
        wait.isElementLoaded(newSectionNotesInput, this.driver);
        driver.findElement(newSectionNotesInput).sendKeys(testNotes);
    }

    public void enterStartDate() {
        wait.isElementLoaded(newSectionStartDateInput, this.driver);
        driver.findElement(newSectionStartDateInput).sendKeys(startDate);
    }

    public void enterEndDate() {
        wait.isElementLoaded(newSectionEndDateInput, this.driver);
        driver.findElement(newSectionEndDateInput).sendKeys(endDate);
    }

    public void selectProductName() {
        wait.isElementLoaded(newSectionProductList, this.driver);
        Select select = new Select(driver.findElement(newSectionProductList));
        select.selectByVisibleText(productName);
    }

    public void selectSchemaName() {
        wait.isElementLoaded(newSectionSchemaList, this.driver);
        Select select = new Select(driver.findElement(newSectionSchemaList));
        select.selectByVisibleText(schemaName);
    }





}
