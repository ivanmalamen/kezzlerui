package pages.orders.products;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

public class KezzlerUICreateProductPage {
    WebDriver driver;
    WaitForElement wait;
    String productName;
    String alias;
    String GTIN;
    String productID;
    By createProductTitle = By.xpath("//h1[@class='page-header ng-binding ng-scope']");
    By createProductProductNameInput = By.xpath("//input[@id='productName-input']");
    By createProductAliasInput = By.xpath("//input[@id='alias-input']");
    By createProductGTINInput = By.xpath("//input[@id='gtin-input']");
    By createProductProductIDInput = By.xpath("//input[@id='productId-input']");
    By createProductSaveButton = By.xpath("//button[@id='save-button']");


    public KezzlerUICreateProductPage(WebDriver driver, WaitForElement wait, String productName, String alias,
                                      String GTIN, String productID) {
        this.driver = driver;
        this.wait = wait;
        this.productName = productName;
        this.alias = alias;
        this.GTIN = GTIN;
        this.productID = productID;
    }


    public String getCreateProductTitle() {
        wait.isElementLoaded(createProductTitle, this.driver);
        return driver.findElement(createProductTitle).getText();
    }

    public boolean checkCreateProductPage() {
        wait.isElementLoaded(createProductSaveButton, this.driver);
        if (driver.findElement(createProductSaveButton).getText().toLowerCase().equals("save")) {
            return true;
        }
        return false;
    }

    public void enterCreateProductProductName() {
        wait.isElementLoaded(createProductProductNameInput, this.driver);
        driver.findElement(createProductProductNameInput).sendKeys(productName);
    }

    public void enterCreateProductProductAlias() {
        wait.isElementLoaded(createProductAliasInput, this.driver);
        driver.findElement(createProductAliasInput).sendKeys(alias);
    }

    public void enterCreateProductProductGTIN() {
        wait.isElementLoaded(createProductGTINInput, this.driver);
        driver.findElement(createProductGTINInput).sendKeys(GTIN);
    }

    public void enterCreateProductProductID() {
        wait.isElementLoaded(createProductProductIDInput, this.driver);
        driver.findElement(createProductProductIDInput).sendKeys(productID);
    }

    public void clickCreateProductSaveButton() {
        wait.isElementLoaded(createProductSaveButton, this.driver);
        driver.findElement(createProductSaveButton).click();
    }


}
