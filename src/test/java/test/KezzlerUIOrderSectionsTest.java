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
import pages.orders.sections.*;
import pages.orders.validation.KezzlerUINewValidationGroupPage;
import pages.orders.validation.KezzlerUIValidationGroupsPage;
import pages.orders.validation.KezzlerUIValidationResponcePage;
import pages.orders.validation.KezzlerUINewValidationResponcePage;
import utils.Sleep;
import utils.WaitForElement;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KezzlerUIOrderSectionsTest {

    static WebDriver driver;
    static KezzlerUILoginPage objLoginPage;
    static KezzlerUIRollActivatorPage objRollActivatorPage;
    private static WaitForElement wait = new WaitForElement();
    KezzlerUISectionsPage objSectionsPage;
    KezzlerUISectionPage objSectionPage;
    KezzlerUINewSectionPage objNewSectionPage;
    KezzlerUICodesPage objCodesPage;
    KezzlerUIEditOrderPage objOrderEditPage;
    KezzlerUIMainMenu objMainMenu;
    KezzlerUIOrdersPage objOrdersPage;
    KezzlerUIOrderPage objOrderPage;
    KezzlerUICreateProductPage objCreateProductPage;
    KezzlerUIProductsPage objProductsPage;
    KezzlerUIMetadataPage objMetadataPage;
    KezzlerUICreateMetadataPage objCreateMetadataPage;
    KezzlerUIEditOrderPage objEditOrderPage;
    KezzlerUIMessagesPage objMessagesPage;
    KezzlerUIValidationGroupsPage objValidationGroupsPage;
    KezzlerUIValidationResponcePage objValidationResponcePage;
    KezzlerUINewValidationResponcePage objNewValidationResponcePage;
    KezzlerUINewValidationGroupPage objNewValidationGroupPage;
    KezzlerUISectionMetadataPage objSectionMetadataPage;


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
    String testNotes = "Notes for test";
    String startIndex="1";
    String endIndex="10";
    String startDate="October 16 2016";
    String endDate="October 26 2016";
    String kezzlerCodeStart="123456";
    String kezzlerCodeEnd="123456";
    String message="testMesssageGroup";
    String group="testMesssageGroup";

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "GeckoDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://core.dev.kezzler.net/#/security/login");
        objLoginPage = new KezzlerUILoginPage(driver, wait);
        objLoginPage.loginToKezzlerUI("ivanmalamen", "7JyzfqZs");
        objRollActivatorPage = new KezzlerUIRollActivatorPage(driver, wait);
        CreateNewProduct();
        CreateMetadata();
        CreateNewSectionedOrder();
        objOrderPage = new KezzlerUIOrderPage(driver, wait, "", "");
        objOrderPage.clickOrderSectionsButton();
        Sleep.sleep(1000);

    }

    @Test()
    public void test1CheckSectionsPage() {
        objSectionsPage = new KezzlerUISectionsPage(driver,wait,"","");
        Assert.assertTrue(objSectionsPage.checkSectionsPage());
    }

    @Test()
    public void test2CheckNewSectionPage() {
        objSectionsPage = new KezzlerUISectionsPage(driver,wait,"","");
        objSectionsPage.clickNewSectionButton();
        Sleep.sleep(1000);
        objNewSectionPage = new KezzlerUINewSectionPage(driver,wait,"","","","","","","","","");
        Assert.assertTrue(objNewSectionPage.checkNewSectionPage());
    }

    @Test()
    public void test3CreateBasicSection() {
        objSectionsPage = new KezzlerUISectionsPage(driver,wait,productName,schemaName);
        objSectionsPage.clickNewSectionButton();
        Sleep.sleep(1000);
        objNewSectionPage = new KezzlerUINewSectionPage(driver,wait,productName,schemaName, testNotes, startIndex,
                endIndex, startDate, endDate,kezzlerCodeStart,kezzlerCodeEnd);
        objNewSectionPage.enterStartIndex();
        Sleep.sleep(1000);
        objNewSectionPage.enterEndIndex();
        Sleep.sleep(1000);
        objNewSectionPage.clickSaveButton();
        Sleep.sleep(3000);
        objSectionPage = new KezzlerUISectionPage(driver,wait,productName,schemaName);
        Assert.assertTrue(objSectionPage.checkCreatedBasicSection());

    }

    @Test()
    public void test4CreateProductSchemaNotesSection() {
        objSectionsPage = new KezzlerUISectionsPage(driver,wait,productName,schemaName);
        objSectionsPage.clickNewSectionButton();
        Sleep.sleep(1000);
        objNewSectionPage = new KezzlerUINewSectionPage(driver,wait,productName,schemaName, testNotes, startIndex,
                endIndex, startDate, endDate,kezzlerCodeStart,kezzlerCodeEnd);
        objNewSectionPage.enterStartIndex();
        Sleep.sleep(1000);
        objNewSectionPage.enterEndIndex();
        Sleep.sleep(1000);
        objNewSectionPage.selectProductName();
        Sleep.sleep(1000);
        objNewSectionPage.selectSchemaName();
        Sleep.sleep(1000);
        objNewSectionPage.enterNotes();
        Sleep.sleep(1000);
        objNewSectionPage.clickSaveButton();
        Sleep.sleep(3000);
        objSectionPage = new KezzlerUISectionPage(driver,wait,productName,schemaName);
        Assert.assertTrue(objSectionPage.checkAddedSectionProductSchemaNotes());

    }

    @Test()
    public void test5CreateActivationLimitSection() {
        objSectionsPage = new KezzlerUISectionsPage(driver,wait,productName,schemaName);
        objSectionsPage.clickNewSectionButton();
        Sleep.sleep(1000);
        objNewSectionPage = new KezzlerUINewSectionPage(driver,wait,productName,schemaName, testNotes, startIndex,
                endIndex, startDate, endDate,kezzlerCodeStart,kezzlerCodeEnd);
        objNewSectionPage.enterStartIndex();
        Sleep.sleep(1000);
        objNewSectionPage.enterEndIndex();
        Sleep.sleep(1000);
        objNewSectionPage.selectProductName();
        Sleep.sleep(1000);
        objNewSectionPage.selectSchemaName();
        Sleep.sleep(1000);
        objNewSectionPage.enterNotes();
        Sleep.sleep(1000);
        objNewSectionPage.checkActivationCheckbox();
        Sleep.sleep(1000);
        objNewSectionPage.enterStartDate();
        Sleep.sleep(1000);
        objNewSectionPage.enterEndDate();
        Sleep.sleep(1000);
        objNewSectionPage.checkLimitCheckbox();
        Sleep.sleep(1000);
        objNewSectionPage.checkLimitCheckbox();
        Sleep.sleep(1000);
        objNewSectionPage.clickSaveButton();
        Sleep.sleep(3000);
        objSectionPage = new KezzlerUISectionPage(driver,wait,productName,schemaName);
        Assert.assertTrue(objSectionPage.checkAddedSectionActivationLimit());

    }

    @Ignore
    @Test()
    public void test6CreateKezzlerCodeSection() {
        objSectionsPage = new KezzlerUISectionsPage(driver,wait,productName,schemaName);
        objSectionsPage.clickNewSectionButton();
        Sleep.sleep(1000);
        objNewSectionPage = new KezzlerUINewSectionPage(driver,wait,productName,schemaName, testNotes, startIndex,
                endIndex, startDate, endDate,kezzlerCodeStart,kezzlerCodeEnd);
        objNewSectionPage.clickStartIndexButton();
        Sleep.sleep(1000);
        objNewSectionPage.switchToActiveFrame();
        Sleep.sleep(1000);
        objNewSectionPage.enterKezzlerStartIndex();
        Sleep.sleep(1000);
        objNewSectionPage.clickFramePickButton();
        Sleep.sleep(2000);
        objNewSectionPage.switchToActiveFrame();
        objNewSectionPage.clickEndIndexButton();
        Sleep.sleep(1000);
        objNewSectionPage.switchToActiveFrame();
        Sleep.sleep(1000);
        objNewSectionPage.enterKezzlerEndIndex();
        Sleep.sleep(1000);
        objNewSectionPage.clickFramePickButton();
        Sleep.sleep(2000);
        objNewSectionPage.switchToActiveFrame();
        objNewSectionPage.clickSaveButton();
        objSectionPage = new KezzlerUISectionPage(driver,wait,productName,schemaName);
        Assert.assertTrue(objSectionPage.checkCreatedBasicSection());

    }

    @Test()
    public void test7CheckSectionMessage() {
        objSectionsPage = new KezzlerUISectionsPage(driver,wait,productName,schemaName);
        objSectionsPage.clickNewSectionButton();
        Sleep.sleep(1000);
        objNewSectionPage = new KezzlerUINewSectionPage(driver,wait,productName,schemaName, testNotes, startIndex,
                endIndex, startDate, endDate,kezzlerCodeStart,kezzlerCodeEnd);
        objNewSectionPage.enterStartIndex();
        Sleep.sleep(1000);
        objNewSectionPage.enterEndIndex();
        Sleep.sleep(1000);
        objNewSectionPage.clickSaveButton();
        Sleep.sleep(3000);
        objSectionPage = new KezzlerUISectionPage(driver,wait,productName,schemaName);
        objSectionPage.clickMessagesButton();
        objMessagesPage = new KezzlerUIMessagesPage(driver, wait, message,group);
        Assert.assertTrue(objMessagesPage.checkMessagePage());

    }

    @Test()
    public void test8CheckSectionMetadata() {
        objSectionsPage = new KezzlerUISectionsPage(driver,wait,productName,schemaName);
        objSectionsPage.clickNewSectionButton();
        Sleep.sleep(1000);
        objNewSectionPage = new KezzlerUINewSectionPage(driver,wait,productName,schemaName, testNotes, startIndex,
                endIndex, startDate, endDate,kezzlerCodeStart,kezzlerCodeEnd);
        objNewSectionPage.enterStartIndex();
        Sleep.sleep(1000);
        objNewSectionPage.enterEndIndex();
        Sleep.sleep(1000);
        objNewSectionPage.clickSaveButton();
        Sleep.sleep(3000);
        objSectionPage = new KezzlerUISectionPage(driver,wait,productName,schemaName);
        objSectionPage.clickMetadataButton();
        objSectionMetadataPage = new KezzlerUISectionMetadataPage(driver, wait);
        Assert.assertTrue(objSectionMetadataPage.checkSectionMetadataPage());

    }


    @Test()
    public void test9CheckSectionGoTo() {
        objSectionsPage = new KezzlerUISectionsPage(driver,wait,productName,schemaName);
        objSectionsPage.clickGoToSectionButton();
        Sleep.sleep(1000);
        Assert.assertTrue(objSectionsPage.checkSectionsGoTo());


    }

    @Test()
    public void test10CheckSectionGoTo() {
        objSectionsPage = new KezzlerUISectionsPage(driver,wait,productName,schemaName);
        objSectionsPage.clickGoToSectionButton();
        Sleep.sleep(1000);
        Assert.assertTrue(objSectionsPage.checkSectionsGoTo());


    }



    @After
    public void kill() {

        driver.close();
        driver.quit();
    }

    public void CreateNewProduct() {
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
    }

    public void CreateNewSectionedOrder(){
        objMainMenu = new KezzlerUIMainMenu(driver, wait);
        objMainMenu.clickSerialization();
        Sleep.sleep(1000);
        objMainMenu.clickOrders();
        Sleep.sleep(1000);
        Random random = new Random();
        String orderName = "testOrder" + Integer.toString(random.nextInt());
        objOrdersPage = new KezzlerUIOrdersPage(driver, wait, orderName);
        objOrdersPage.clickNewOrder();
        Sleep.sleep(1000);
        objOrdersPage.switchToActiveFrame();
        Sleep.sleep(1000);
        Assert.assertTrue(objOrdersPage.getNewOrderFrameTitle().toLowerCase().contains("new order"));
        objOrdersPage.enterNewOrderFrameName();
        Sleep.sleep(1000);
        objOrdersPage.checkNewOrderFrameSectioned();
        Sleep.sleep(1000);
        objOrdersPage.clickNewOrderFrameCreate();
        Sleep.sleep(1000);
        objOrdersPage.switchToActiveFrame();
        Sleep.sleep(1000);
        objOrdersPage.clickOrdersOrderName();
        Sleep.sleep(1000);

    }

    public void CreateMetadata() {
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
    }


}
