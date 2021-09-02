package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class TravelPage {

    @FindBy(xpath = "//span[@class='kitt-button__text'][contains(text(),'Оформить онлайн')]")
    public WebElement checkoutOnline;

    public TravelPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
         new WebDriverWait(BaseSteps.getDriver(), 30, 1000)
        .until(ExpectedConditions.visibilityOf(checkoutOnline));
    }


}
