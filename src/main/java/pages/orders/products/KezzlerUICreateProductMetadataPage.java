package pages.orders.products;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

public class KezzlerUICreateProductMetadataPage {
    WebDriver driver;
    WaitForElement wait;
    String productSchemaName;
    String productSchemaDefinition;
    By createProductSchemaTitle = By.xpath("//h1[@class='page-header ng-binding ng-scope']");
    By createProductSchemaSchemaNameInput = By.xpath("//input[@id='name-input']");
    By createProductSchemaSchemaDefinitionInput = By.xpath("//textarea[@id='schema-definition-input']");
    By createProductSchemaSaveButton = By.xpath("//button[@id='save-button']");


    public KezzlerUICreateProductMetadataPage(WebDriver driver, WaitForElement wait, String productSchemaName, String productSchemaDefinition) {
        this.driver = driver;
        this.wait = wait;
        this.productSchemaName = productSchemaName;
        this.productSchemaDefinition = productSchemaDefinition;
    }

    public boolean checkCreateProductSchemaPage() {
        wait.isElementLoaded(createProductSchemaSaveButton, this.driver);
        if (driver.findElement(createProductSchemaSaveButton).getText().toLowerCase().equals("save")) {
            return true;
        }
        return false;
    }

    public void enterCreateProductSchemaSchemaName() {
        wait.isElementLoaded(createProductSchemaSchemaNameInput, this.driver);
        driver.findElement(createProductSchemaSchemaNameInput).sendKeys(productSchemaName);
    }

    public void enterCreateProductSchemaSchemaDefinition() {
        wait.isElementLoaded(createProductSchemaSchemaDefinitionInput, this.driver);
        driver.findElement(createProductSchemaSchemaDefinitionInput).sendKeys(productSchemaDefinition);
    }

    public void clickCreateProductSchemaSaveButton() {
        wait.isElementLoaded(createProductSchemaSaveButton, this.driver);
        driver.findElement(createProductSchemaSaveButton).click();
    }


}
