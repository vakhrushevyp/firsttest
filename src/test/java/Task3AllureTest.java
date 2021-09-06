
import org.junit.Ignore;
import org.junit.Test;
import steps.*;


import java.util.HashMap;

public class Task3AllureTest extends BaseSteps {


    @Test
    @Ignore
    public void textInsurance() {
        MainSteps mainSteps = new MainSteps();
        TravelSteps travelSteps = new TravelSteps();
        CheckoutSteps checkoutSteps = new CheckoutSteps();
        FormingSteps formingSteps = new FormingSteps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия латиницей", "Ivanov");
        testData.put("Имя латиницей", "Ivan");
        testData.put("Дата рождения загран", "18.04.1994");
        testData.put("Фамилия", "Иванов");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Иванович");
        testData.put("Дата рождения", "18.04.1994");
        testData.put("Паспорт серия", "1234");
        testData.put("Паспорт номер", "123456");
        testData.put("Паспорт дата", "20.04.2014");
        testData.put("Паспорт выдан", "Тестовым ОВД тестового города");

        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Путешествия");
        travelSteps.stepCheckoutOnlineButton();

        checkoutSteps.stepRegion();
        checkoutSteps.stepRegionSelect("Шенген и страны Совета Европы, кроме РФ");
        checkoutSteps.stepSelectInsuranceAmount("Минимальная");

        checkoutSteps.stepCheckoutButton();

        formingSteps.stepFillFields(testData);

        formingSteps.checkFillFields(testData);
        formingSteps.stepProceedButton();


    }


}
