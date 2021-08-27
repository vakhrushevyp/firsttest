package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutPage;
import io.qameta.allure.Step;

public class CheckoutSteps extends BaseSteps {

    @Step("выполнено нажатие на выпадающий список - Регион действия полиса")
    public void stepRegion() {
        new CheckoutPage(driver).region.click();
    }

    @Step("выбран регион {0}")
    public void stepRegionSelect(String regionSelectItem) {
        new CheckoutPage(driver).selectRegion(regionSelectItem);
    }

    @Step("выбрана сумма страховой защиты {0}")
    public void stepSelectInsuranceAmount(String selectInsuranceAmountItem) {
        new CheckoutPage(driver).selectInsuranceAmount(selectInsuranceAmountItem);
    }

    @Step("выполнено нажатие кнопки - Оформить")
    public void stepCheckoutButton() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(new CheckoutPage(driver).CheckoutBtn)).click();
    }


}
