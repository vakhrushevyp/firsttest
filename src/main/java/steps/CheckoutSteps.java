package steps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutPage;
import io.qameta.allure.Step;

public class CheckoutSteps {

    @Step("выполнено нажатие на выпадающий список - Регион действия полиса")
    public void stepRegion() {
        new CheckoutPage().region.click();
    }

    @Step("выбран регион {0}")
    public void stepRegionSelect(String regionSelectItem) {
        new CheckoutPage().selectRegion(regionSelectItem);
    }

    @Step("выбрана сумма страховой защиты {0}")
    public void stepSelectInsuranceAmount(String selectInsuranceAmountItem) {
        new CheckoutPage().selectInsuranceAmount(selectInsuranceAmountItem);
    }

    @Step("выполнено нажатие кнопки - Оформить")
    public void stepCheckoutButton() {
       new WebDriverWait(BaseSteps.getDriver(), 30, 1000)
        .until(ExpectedConditions.elementToBeClickable(new CheckoutPage().CheckoutBtn)).click();
    }


}
