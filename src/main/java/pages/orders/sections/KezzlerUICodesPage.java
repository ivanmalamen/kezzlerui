package pages.orders.sections;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CodeGen;
import utils.WaitForElement;

import java.io.*;
import java.util.List;


public class KezzlerUICodesPage {
    WebDriver driver;
    WaitForElement wait;
    String size;
    String codeName;
    String file;
    String uploadScript;
    By codesTopUpButton = By.xpath("//button[@id='codes-top-up-button']");
    By codesUploadButton = By.xpath("//button[@ng-click='uploadModal.open();']");
    By codesTopUpFrame = By.className("modal-dialog");
    By codesTopUpFrameTopUpButton = By.xpath("//button[@id='top-up-button']");
    By codesTopUpFrameAdvancedButton = By.xpath("//button[@id='advanced-button']");
    By codesTopUpFramePairCheckbox = By.xpath("//input[@type='checkbox']");
    By codesTopUpFrameSizeInput = By.xpath("//input[@id='top-up-size-input']");
    By codesTopUpFrameNameInput = By.xpath("//input[@id='generate-codes-name-input']");
    By codesUploadFrameBrowseButton = By.xpath("//input[@id='uploadFileName']");
    By codesUploadFrameUploadButton = By.xpath("//button[@ng-click='upload(file)']");
    By codesCheckCodeFrameIndexInput = By.xpath("//input[@id='check-code-index-input']");
    By codesCheckCodeFrameGetCodeButton = By.xpath("//button[@id='get-code-button']");
    By codesCheckCodeFrameImage = By.xpath("//canvas[@ng-hide='image']");
    By codesCheckCodeButton = By.xpath("//button[@id='check-code-button']");
    By codesBackButton = By.xpath("//a[@id='breadcrumb-order-id']");
    By codesTable = By.xpath("//div[@class='container ng-scope']");
    By codesTableAdministrative = By.xpath("//span[contains(.,'administrative')]");
    By codesTableConsumer = By.xpath("//span[contains(.,'consumer')]");
    By codesTableUpload = By.xpath("//td[contains(.,'x, length -1')]");
    By codesTableDownloadButton = By.xpath("//i[@class='fa fa-cloud-download']");
    By codesTableStatusButton = By.xpath("//button[@id='edit-code-status-button']");
    By codesTableTopUpButton = By.xpath("//button[@ng-click='topUpModal.open(e);']");

    public KezzlerUICodesPage(WebDriver driver, WaitForElement wait, String size, String codeName, String file, String uploadScript) {
        this.driver = driver;
        this.wait = wait;
        this.size = size;
        this.codeName = codeName;
        this.file = file;
        this.uploadScript = uploadScript;
    }

    public void clickTopUpButton() {
        wait.isElementLoaded(codesTopUpButton, this.driver);
        driver.findElement(codesTopUpButton).click();
    }

    public void clickUploadButton() {
        wait.isElementLoaded(codesUploadButton, this.driver);
        driver.findElement(codesUploadButton).click();
    }

    public void clickBackButton() {
        wait.isElementLoaded(codesBackButton, this.driver);
        driver.findElement(codesBackButton).click();
    }

    public void clickUploadFrameBrowseButton() {
        wait.isElementLoaded(codesUploadFrameBrowseButton, this.driver);
        driver.findElement(codesUploadFrameBrowseButton).click();

    }

    public void runUploadFrameUploadScript() {
        File objFile = new File(file + "\\codeUpload.csv");
        File objScript = new File(uploadScript);
        String filePath = objFile.getAbsolutePath();
        String scriptPath = objScript.getAbsolutePath();

        try {
            ProcessBuilder builder = new ProcessBuilder(scriptPath, '"' + filePath + '"');
            Process p = builder.start();
            p.wait();
        } catch (Exception ie) {
        }
    }

    public void generateUploadCodeCSV() {
        CodeGen gen = new CodeGen();
        String code = gen.generate();
        File codeFile = new File(file + "\\codeUpload.csv");
        String codeFilePath = codeFile.getAbsolutePath();
        try {
            FileOutputStream is = new FileOutputStream(codeFilePath);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(code);
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickUploadFrameUploadButton() {
        wait.isElementLoaded(codesUploadFrameUploadButton, this.driver);
        driver.findElement(codesUploadFrameUploadButton).click();
    }

    public void switchToActiveFrame() {
        driver.switchTo().activeElement();
    }

    public void enterTopUpFrameSize() {
        wait.isElementLoaded(codesTopUpFrameSizeInput, this.driver);
        driver.findElement(codesTopUpFrameSizeInput).sendKeys(size);
    }

    public void enterTopUpFrameName() {
        wait.isElementLoaded(codesTopUpFrameNameInput, this.driver);
        driver.findElement(codesTopUpFrameNameInput).sendKeys(codeName);
    }

    public void checkTopUpFramePairCheckbox() {
        wait.isElementLoaded(codesTopUpFramePairCheckbox, this.driver);
        driver.findElement(codesTopUpFramePairCheckbox).click();
    }

    public void clickTopUpFrameTopUpButton() {
        wait.isElementLoaded(codesTopUpFrameTopUpButton, this.driver);
        driver.findElement(codesTopUpFrameTopUpButton).click();
    }

    public void clickTopUpFrameAdvancedButton() {
        wait.isElementLoaded(codesTopUpFrameAdvancedButton, this.driver);
        driver.findElement(codesTopUpFrameAdvancedButton).click();
    }

    public boolean checkCodesPage() {
        wait.isElementLoaded(codesTopUpButton, this.driver);
        if (driver.findElement(codesTopUpButton).getText().toLowerCase().equals("top-up")) {
            return true;
        }
        return false;
    }

    public boolean checkAddedCode() {
        wait.isElementLoaded(codesTable, this.driver);
        WebElement table = driver.findElement(codesTable);
        List<WebElement> names = table.findElements(By.xpath("//tr[@class='ng-scope']"));
        for (WebElement name : names) {
            List<WebElement> values = name.findElements(By.xpath("//td[@class='ng-binding']"));
            for (WebElement value : values) {
                String text = "";
                try {
                    text = value.getText();
                } catch (Exception ie) {
                }
                if (codeName.equals(text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkAddedAdministrativeCode() {
        wait.isElementLoaded(codesTable, this.driver);
        try {
            driver.findElement(codesTableAdministrative);
            driver.findElement(codesTableConsumer);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }

    public boolean checkUploadedCode() {
        wait.isElementLoaded(codesTable, this.driver);
        try {
            driver.findElement(codesTableUpload);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }

    public void enterCheckCodeFrameIndex() {
        wait.isElementLoaded(codesCheckCodeFrameIndexInput, this.driver);
        driver.findElement(codesCheckCodeFrameIndexInput).sendKeys("1");
    }

    public void clickCheckCodeFrameGetCodeButton() {
        wait.isElementLoaded(codesCheckCodeFrameGetCodeButton, this.driver);
        driver.findElement(codesCheckCodeFrameGetCodeButton).click();
    }

    public void clickCheckCodeButton() {
        wait.isElementLoaded(codesCheckCodeButton, this.driver);
        driver.findElement(codesCheckCodeButton).click();
    }

    public boolean checkGeneratedQR() {
        wait.isElementLoaded(codesCheckCodeFrameImage, this.driver);
        try {
            driver.findElement(codesCheckCodeFrameImage);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }

    public void clickTableDownloadButton() {
        wait.isElementLoaded(codesTableDownloadButton, this.driver);
        driver.findElement(codesTableDownloadButton).click();
    }

    public void clickTableStatusButton() {
        wait.isElementLoaded(codesTableStatusButton, this.driver);
        driver.findElement(codesTableStatusButton).click();
    }

    public void clickTableTopUpButton() {
        wait.isElementLoaded(codesTableTopUpButton, this.driver);
        driver.findElement(codesTableTopUpButton).click();
    }
}
