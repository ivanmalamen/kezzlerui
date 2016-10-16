package test;

/**
 * Created by admin on 10/15/2016.
 */

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;
import pages.orders.metadata.KezzlerUICreateMetadataPage;
import pages.orders.metadata.KezzlerUIMetadataPage;
import pages.orders.orders.KezzlerUIEditOrderPage;
import pages.orders.orders.KezzlerUIOrderPage;
import pages.orders.orders.KezzlerUIOrdersPage;
import pages.orders.products.KezzlerUICreateProductPage;
import pages.orders.products.KezzlerUIProductsPage;
import utils.Sleep;
import utils.WaitForElement;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KezzlerUIOrderConnectTest {

    static WebDriver driver;
    static KezzlerUILoginPage objLoginPage;
    static KezzlerUIRollActivatorPage objRollActivatorPage;
    private static WaitForElement wait = new WaitForElement();
    KezzlerUIMainMenu objMainMenu;
    KezzlerUIOrdersPage objOrdersPage;
    KezzlerUIOrderPage objOrderPage;
    KezzlerUICreateProductPage objCreateProductPage;
    KezzlerUIProductsPage objProductsPage;
    KezzlerUIMetadataPage objMetadataPage;
    KezzlerUICreateMetadataPage objCreateMetadataPage;
    KezzlerUIEditOrderPage objEditOrderPage;
    Random random = new Random();
    String productName = "TestProduct" + Integer.toString(random.nextInt());
    String alias = "TestAlias" + Integer.toString(random.nextInt());
    String GTIN = "000123456789012";
    String productID = Integer.toString(random.nextInt());
    String schemaName = "TestProductSchema" + Integer.toString(random.nextInt());
    String schemaDefiniation = "{\n" +
            "  \"type\" : \"object\",\n" +
            "  \"id\" : \"urn:jsonschema:com:kezzler:ssp:kcengine:ws:XmlSetDefaultMetadataSchemaRequest\",\n" +
            "  \"properties\" : {\n" +
            "    \"name\" : {\n" +
            "      \"type\" : \"string\"\n" +
            "    }\n" +
            "  }\n" +
            "}";


    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "GeckoDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://core.dev.kezzler.net/#/security/login");
        objLoginPage = new KezzlerUILoginPage(driver, wait);
        Sleep.sleep(1000);
        objLoginPage.loginToKezzlerUI("ivanmalamen", "7JyzfqZs");
    }


    @Test()
    public void test1ProductsPageAppear() {
        objMainMenu = new KezzlerUIMainMenu(driver, wait);
        objMainMenu.clickSerialization();
        Sleep.sleep(1000);
        objMainMenu.clickProducts();
        Sleep.sleep(1000);
        objProductsPage = new KezzlerUIProductsPage(driver, wait, "");
        Assert.assertTrue(objProductsPage.checkProductsPage());
    }

    @Test()
    public void test2CreateNewProduct() {
        objMainMenu = new KezzlerUIMainMenu(driver, wait);
        objMainMenu.clickSerialization();
        Sleep.sleep(1000);
        objMainMenu.clickProducts();
        Sleep.sleep(1000);
        objProductsPage = new KezzlerUIProductsPage(driver, wait, productName);
        objProductsPage.clickProductsNewProductButton();
        Sleep.sleep(1000);
        objCreateProductPage = new KezzlerUICreateProductPage(driver, wait, productName, alias, GTIN, productID);
        Assert.assertTrue(objCreateProductPage.checkCreateProductPage());
        objCreateProductPage.enterCreateProductProductName();
        Sleep.sleep(1000);
        objCreateProductPage.enterCreateProductProductAlias();
        Sleep.sleep(1000);
        objCreateProductPage.enterCreateProductProductGTIN();
        Sleep.sleep(1000);
        objCreateProductPage.enterCreateProductProductID();
        Sleep.sleep(1000);
        objCreateProductPage.clickCreateProductSaveButton();
        Sleep.sleep(1000);
        objProductsPage.clickProducts100Button();
        Sleep.sleep(1000);
        Assert.assertTrue(objProductsPage.checkAddedProduct());
    }

    @Test()
    public void test3ProductMetadataAppear() {
        objMainMenu = new KezzlerUIMainMenu(driver, wait);
        objMainMenu.clickSerialization();
        Sleep.sleep(1000);
        objMainMenu.clickMetadata();
        Sleep.sleep(1000);
        objMetadataPage = new KezzlerUIMetadataPage(driver, wait, "");
        Assert.assertTrue(objMetadataPage.checkMetadataPage());
    }

    @Test()
    public void test4CreateMetadata() {
        objMainMenu = new KezzlerUIMainMenu(driver, wait);
        objMainMenu.clickSerialization();
        Sleep.sleep(1000);
        objMainMenu.clickMetadata();
        Sleep.sleep(1000);
        objMetadataPage = new KezzlerUIMetadataPage(driver, wait, schemaName);
        objMetadataPage.clickMetadataNewSchemaButton();
        objCreateMetadataPage = new KezzlerUICreateMetadataPage(driver, wait, schemaName, schemaDefiniation);
        Assert.assertTrue(objCreateMetadataPage.checkCreateSchemaPage());
        objCreateMetadataPage.enterCreateSchemaSchemaName();
        Sleep.sleep(1000);
        objCreateMetadataPage.enterCreateSchemaSchemaDefinition();
        Sleep.sleep(1000);
        objCreateMetadataPage.clickCreateSchemaSaveButton();
        Sleep.sleep(1000);
        objMetadataPage.clickMetadata100Button();
        Sleep.sleep(1000);
        Assert.assertTrue(objMetadataPage.checkAddedSchema());
    }


    @Test()
    public void test5AddProductMetadataAndSchemaToOrder() {
        objMainMenu = new KezzlerUIMainMenu(driver, wait);
        objMainMenu.clickSerialization();
        Sleep.sleep(1000);
        objMainMenu.clickOrders();
        Sleep.sleep(1000);
        objOrdersPage = new KezzlerUIOrdersPage(driver, wait, "");
        String orderName = objOrdersPage.getRandomOrderName();
        objOrdersPage = new KezzlerUIOrdersPage(driver, wait, orderName);
        objOrdersPage.clickOrdersOrderName();
        Sleep.sleep(1000);
        objOrderPage = new KezzlerUIOrderPage(driver, wait, productName, schemaName);
        Sleep.sleep(1000);
        Assert.assertTrue(objOrderPage.checkOrderProduct());
        Assert.assertTrue(objOrderPage.checkOrderProductSchema());
    }

    @After
    public void kill() {
        driver.quit();
    }

}
