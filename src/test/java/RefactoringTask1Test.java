import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutPage;
import pages.FormingPage;
import pages.MainPage;
import pages.TravelPage;

import static org.junit.Assert.assertEquals;

public class RefactoringTask1Test extends BaseTest {

    @Test
    public void newTestSberbank() {

        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Путешествия");
        new TravelPage(driver).checkoutOnline.click();
        new CheckoutPage(driver).region.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectRegion("Шенген и страны Совета Европы, кроме РФ");
        checkoutPage.selectInsuranceAmount("Минимальная");
        Wait<WebDriver> wait = new WebDriverWait(driver, 30, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.CheckoutBtn)).click();
        checkoutPage.CheckoutBtn.click();
        FormingPage formingPage = new FormingPage(driver);
        formingPage.fillField("Фамилия латиницей", "Ivanov");
        formingPage.fillField("Имя латиницей", "Ivan");
        formingPage.fillField("Дата рождения загран", "18041994");
        formingPage.selectCitizenship("гражданин РФ");
        formingPage.fillField("Фамилия", "Иванов");
        formingPage.fillField("Имя", "Иван");
        formingPage.fillField("Отчество", "Иванович");
        formingPage.fillField("Дата рождения", "18041994");
        formingPage.fillField("Паспорт серия", "1234");
        formingPage.fillField("Паспорт номер", "123456");
        formingPage.fillField("Паспорт дата", "20042014");
        formingPage.fillField("Паспорт выдан", "Тестовым ОВД тестового города");

        assertEquals("Ошибка в surname_vzr_ins_0", "Ivanov",
                formingPage.surname_vzr_ins_0.getAttribute("value"));
        assertEquals("Ошибка в name_vzr_ins_0", "Ivan",
                formingPage.name_vzr_ins_0.getAttribute("value"));
        assertEquals("Ошибка в birthDate_vzr_ins_0", "18.04.1994",
                formingPage.birthDate_vzr_ins_0.getAttribute("value"));
        assertEquals("Ошибка в person_lastName", "Иванов",
                formingPage.person_lastName.getAttribute("value"));
        assertEquals("Ошибка в person_firstName", "Иван",
                formingPage.person_firstName.getAttribute("value"));
        assertEquals("Ошибка в person_middleName", "Иванович",
                formingPage.person_middleName.getAttribute("value"));
        assertEquals("Ошибка в person_birthDate", "18.04.1994",
                formingPage.person_birthDate.getAttribute("value"));
        assertEquals("Ошибка в passportSeries", "1234",
                formingPage.passportSeries.getAttribute("value"));
        assertEquals("Ошибка в passportNumber", "123456",
                formingPage.passportNumber.getAttribute("value"));
        assertEquals("Ошибка в documentDate", "20.04.2014",
                formingPage.documentDate.getAttribute("value"));
        assertEquals("Ошибка в documentIssue", "Тестовым ОВД тестового города",
                formingPage.documentIssue.getAttribute("value"));

        formingPage.proceed.click();

        assertEquals("Поле не заполнено.",
                formingPage.contactsAssert("Поле не заполнено."));

    }

}
