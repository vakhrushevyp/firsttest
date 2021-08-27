package steps;

import pages.TravelPage;
import io.qameta.allure.Step;

public class TravelSteps extends BaseSteps {

    @Step ("выполнено нажатие на кнопку - Оформить онлайн")
    public void stepCheckoutOnlineButton () {
        new TravelPage(driver).checkoutOnline.click();

    }


}
