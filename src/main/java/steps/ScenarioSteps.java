package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import pages.CheckoutPage;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    TravelSteps travelSteps = new TravelSteps();
    CheckoutSteps checkoutSteps = new CheckoutSteps();
    FormingSteps formingSteps = new FormingSteps();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран вид страхования - \"(.*)\"$")
    public void stepSelectTypeInsurance(String menuItem) {
        mainSteps.stepSelectSubMenu(menuItem);
    }

    @When("^выполнено нажатие на кнопку - Оформить онлайн$")
    public void stepCheckoutOnlineButton() {
        travelSteps.stepCheckoutOnlineButton();
    }

    @When("^выполнено нажатие на выпадающий список - Регион действия полиса$")
    public void stepRegion() {
        checkoutSteps.stepRegion();
    }

    @When("^выбран регион - \"(.*)\"$")
    public void stepSelectRegion (String regionSelectItem) {
        checkoutSteps.stepRegionSelect(regionSelectItem);
    }

    @When("^выбрана сумма страховой защиты - \"(.*)\"$")
    public void stepSelectInsuranceAmount(String selectInsuranceAmountItem) {
        checkoutSteps.stepSelectInsuranceAmount(selectInsuranceAmountItem);
    }

    @When("^выполнено нажатие кнопки - Оформить$")
    public void stepCheckoutButton() {
        checkoutSteps.stepCheckoutButton();
    }

    @When("заполняются поля:")
    public void stepFillFields(DataTable fields) {
        fields.asMap(String.class, String.class).forEach(
                (k, v)-> formingSteps.stepFillField(k,v));

    }


}