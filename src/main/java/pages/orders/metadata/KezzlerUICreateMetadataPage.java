package pages.orders.metadata;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;


public class KezzlerUICreateMetadataPage {
    WebDriver driver;
    WaitForElement wait;
    String schemaName;
    String schemaDefinition;
    By createSchemaTitle = By.xpath("//h1[@class='page-header ng-binding ng-scope']");
    By createSchemaSchemaNameInput = By.xpath("//input[@id='schemaName-input']");
    By createSchemaSchemaDefinitionInput = By.xpath("//textarea[@id='schema-input']");
    By createSchemaSaveButton = By.xpath("//button[@id='save-button']");


    public KezzlerUICreateMetadataPage(WebDriver driver, WaitForElement wait, String schemaName, String schemaDefinition) {
        this.driver = driver;
        this.wait = wait;
        this.schemaName = schemaName;
        this.schemaDefinition = schemaDefinition;
    }


    public boolean checkCreateSchemaPage() {
        wait.isElementLoaded(createSchemaSaveButton, this.driver);
        if (driver.findElement(createSchemaSaveButton).getText().toLowerCase().equals("save")) {
            return true;
        }
        return false;
    }

    public void enterCreateSchemaSchemaName() {
        wait.isElementLoaded(createSchemaSchemaNameInput, this.driver);
        driver.findElement(createSchemaSchemaNameInput).sendKeys(schemaName);
    }

    public void enterCreateSchemaSchemaDefinition() {
        wait.isElementLoaded(createSchemaSchemaDefinitionInput, this.driver);
        driver.findElement(createSchemaSchemaDefinitionInput).sendKeys(schemaDefinition);
    }

    public void clickCreateSchemaSaveButton() {
        wait.isElementLoaded(createSchemaSaveButton, this.driver);
        driver.findElement(createSchemaSaveButton).click();
    }


}
