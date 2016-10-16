package pages.orders.metadata;

/**
 * Created by admin on 10/15/2016.
 */

import utils.WaitForElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class KezzlerUIMetadataPage {
    WebDriver driver;
    WaitForElement wait;
    By metadataTitle = By.xpath("//i[@class='fa fa-kz-metadata']");
    By metadataList = By.xpath("//td[@data-title-text='Name']");
    By metadataNewSchemaButton = By.xpath("//a[@id='create-metadata-schema-button']");
    By metadata100Button = By.xpath("//button[contains(.,' 100 ')]");
    String schemaName;

    public KezzlerUIMetadataPage(WebDriver driver, WaitForElement wait, String schemaName){
        this.driver = driver;
        this.wait = wait;
        this.schemaName = schemaName;
    }

    public void clickMetadataNewSchemaButton (){
        wait.isElementLoaded(metadataNewSchemaButton, this.driver);
        driver.findElement(metadataNewSchemaButton).click();
    }

    public boolean checkMetadataPage(){
        wait.isElementLoaded(metadataNewSchemaButton, this.driver);
        if (driver.findElement(metadataNewSchemaButton).getText().toLowerCase().equals("new metadata schema")){
            return true;
        }
        return false;
    }

    public boolean checkAddedSchema() {
        wait.isElementLoaded(metadataList, this.driver);
        List<WebElement> names = driver.findElements(metadataList);
        for (WebElement name : names) {
            String text ="";
            try {
                text = name.getText();
            }
            catch (Exception e)
            {}
            if (text.equals(schemaName)) {
                return true;
            }
        }
        return false;
    }

    public void clickMetadata100Button (){
        wait.isElementLoaded(metadata100Button, this.driver);
        driver.findElement(metadata100Button).click();
    }

}
