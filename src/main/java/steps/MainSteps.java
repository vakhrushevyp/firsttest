package steps;

import pages.MainPage;
import io.qameta.allure.Step;

public class MainSteps extends BaseSteps {

    @Step("выбран пункт меню {0}")
    public void stepSelectMainMenu (String menuItem) {
        new MainPage(driver).selectMainMenu(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void stepSelectSubMenu (String menuItem) {
        new MainPage(driver).selectSubMenu(menuItem);
    }


}
