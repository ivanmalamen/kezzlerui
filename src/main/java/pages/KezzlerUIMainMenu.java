package pages;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

public class KezzlerUIMainMenu {
    WebDriver driver;
    WaitForElement wait;
    By mainSerializationMenu = By.xpath("//a[contains(.,' Serialization ')]");
    By mainSerializationMenuOrdersItem = By.xpath("//a[@id='kcengine-menu-orders']");
    By mainSerializationMenuProductsItem = By.xpath("//a[@id='kcengine-menu-product']");
    By mainSerializationMenuMetadataItem = By.xpath("//a[@id='kcengine-menu-metadata-schema']");
    By mainSerializationMenuProductMetadataItem = By.xpath("//a[@id='kcengine-menu-product-schemas']");
    By mainSerializationMenuValidationItem = By.xpath("//a[@id='kcengine-menu-ati']");
    By mainSerializationMenuValidationGroupsItem = By.xpath("//a[@id='kcengine-menu-ati-group']");


    public KezzlerUIMainMenu(WebDriver driver, WaitForElement wait){
        this.driver = driver;
        this.wait = wait;

    }

    public void clickValidationGroups (){
        wait.isElementLoaded(mainSerializationMenuValidationGroupsItem, this.driver);
        driver.findElement(mainSerializationMenuValidationGroupsItem).click();
    }

    public void clickValidation (){
        wait.isElementLoaded(mainSerializationMenuValidationItem, this.driver);
        driver.findElement(mainSerializationMenuValidationItem).click();
    }

    public void clickSerialization (){
        wait.isElementLoaded(mainSerializationMenu, this.driver);
        driver.findElement(mainSerializationMenu).click();
    }

    public void clickOrders (){
        wait.isElementLoaded(mainSerializationMenuOrdersItem, this.driver);
        driver.findElement(mainSerializationMenuOrdersItem).click();
    }

    public void clickProducts (){
        wait.isElementLoaded(mainSerializationMenuProductsItem, this.driver);
        driver.findElement(mainSerializationMenuProductsItem).click();
    }
    public void clickMetadata (){
        wait.isElementLoaded(mainSerializationMenuMetadataItem, this.driver);
        driver.findElement(mainSerializationMenuMetadataItem).click();
    }

    public void clickProductMetadata (){
        wait.isElementLoaded(mainSerializationMenuProductMetadataItem, this.driver);
        driver.findElement(mainSerializationMenuProductMetadataItem).click();
    }




}
