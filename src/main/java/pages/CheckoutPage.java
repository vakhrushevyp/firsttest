package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(),'Страхование путешественников')]")
    WebElement titleCheckoutPage;

    @FindBy(xpath = "//div[@class='form-control__value']")
    public WebElement region;

    @FindBy(xpath = "//ul[@role='menu']")
    WebElement regionSelect;

    @FindBy(xpath = "//fieldset[@class='no-offset non-border']//div[@class='row']")
    WebElement insuranceAmount;

    @FindBy(xpath = "//button[contains(text(),'Оформить')]")
    public WebElement CheckoutBtn;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 30, 1000))
                .until(ExpectedConditions.visibilityOf(titleCheckoutPage));
        this.driver = driver;
    }

    public void selectRegion(String regionSelectItem) {
        regionSelect.findElement(By.xpath(".//a[contains(text(),'" + regionSelectItem + "')]")).click();
    }

    public void selectInsuranceAmount(String selectInsuranceAmountItem) {
        insuranceAmount.findElement(By.xpath(".//h3[contains(text(),'" + selectInsuranceAmountItem + "')]")).click();
    }


}
