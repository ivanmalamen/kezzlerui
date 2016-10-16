package pages.orders.products;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitForElement;

import java.util.List;

public class KezzlerUIProductMetadataPage {
    WebDriver driver;
    WaitForElement wait;
    By productMetadataTitle = By.xpath("//h1[@class='page-header ng-scope']");
    By productMetadataList = By.xpath("//td[@data-title-text='Name']");
    By productMetadataNewSchemaButton = By.xpath("//a[@id='create-product-schema-button']");
    String productSchemaName;

    public KezzlerUIProductMetadataPage(WebDriver driver, WaitForElement wait, String productSchemaName) {
        this.driver = driver;
        this.wait = wait;
        this.productSchemaName = productSchemaName;
    }

    public void clickProductMetadataNewSchemaButton() {
        wait.isElementLoaded(productMetadataNewSchemaButton, this.driver);
        driver.findElement(productMetadataNewSchemaButton).click();
    }

    public boolean checkProductMetadataPage() {
        wait.isElementLoaded(productMetadataNewSchemaButton, this.driver);
        if (driver.findElement(productMetadataNewSchemaButton).getText().toLowerCase().equals("new product metadata schema")) {
            return true;
        }
        return false;
    }

    public boolean checkProductAddedSchema() {
        wait.isElementLoaded(productMetadataList, this.driver);
        List<WebElement> names = driver.findElements(productMetadataList);
        for (WebElement name : names) {
            String text = "";
            try {
                text = name.getText();
            } catch (Exception e) {
            }
            if (text.equals(productSchemaName)) {
                return true;
            }
        }
        return false;
    }


}
