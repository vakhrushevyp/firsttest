import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import static org.junit.Assert.assertEquals;

public class Task1Test extends BaseSteps {

    @Test
    @Ignore
    public void testSberbank() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[@aria-label='Страхование']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Путешествия')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 30, 1000);
        WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(title));
        assertEquals("Проверка заголовка", "Страхование путешественников", title.getText());
        driver.findElement(By.xpath("//span[@class='kitt-button__text'][contains(text(),'Оформить онлайн')]")).click();

        WebElement title2 = driver.findElement(By.xpath("//h2[contains(text(),'Страхование путешественников')]"));
        wait.until(ExpectedConditions.visibilityOf(title2));

        driver.findElement(By.xpath("//div[@class='form-control__value']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Шенген и страны Совета Европы, кроме РФ')]")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Необходимый минимум для оплаты медицинской помощи ')]")).click();

        WebElement title3 = driver.findElement(By.xpath("//button[contains(text(),'Оформить')]"));
        wait.until(ExpectedConditions.elementToBeClickable(title3)).click();

        WebElement title4 = driver.findElement(By.xpath("//div[@class='col-4 step-element active']"));
        wait.until(ExpectedConditions.visibilityOf(title4));

        fillField(By.id("surname_vzr_ins_0"), "Ivanov");
        fillField(By.id("name_vzr_ins_0"), "Ivan");
        fillField(By.id("birthDate_vzr_ins_0"), "18041994");
        driver.findElement(By.xpath("//label[contains(text(),'гражданин РФ')]")).click();
        fillField(By.id("person_lastName"), "Иванов");
        fillField(By.id("person_firstName"), "Иван");
        fillField(By.id("person_middleName"), "Иванович");
        fillField(By.id("person_birthDate"), "18041994");
        fillField(By.id("passportSeries"), "1234");
        fillField(By.id("passportSeries"), "1234");
        fillField(By.id("passportNumber"), "123456");
        fillField(By.id("documentDate"), "20042014");
        fillField(By.id("documentIssue"), "Тестовым ОВД тестового города");
        fillField(By.id("documentIssue"), "Тестовым ОВД тестового города");

        assertEquals("Ошибка в surname_vzr_ins_0", "Ivanov",
                driver.findElement(By.id("surname_vzr_ins_0")).getAttribute("value"));
        assertEquals("Ошибка в name_vzr_ins_0", "Ivan",
                driver.findElement(By.id("name_vzr_ins_0")).getAttribute("value"));
        assertEquals("Ошибка в birthDate_vzr_ins_0", "18.04.1994",
                driver.findElement(By.id("birthDate_vzr_ins_0")).getAttribute("value"));
        assertEquals("Ошибка в person_lastName", "Иванов",
                driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Ошибка в person_firstName", "Иван",
                driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("Ошибка в person_middleName", "Иванович",
                driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("Ошибка в person_birthDate", "18.04.1994",
                driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("Ошибка в passportSeries", "1234",
                driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("Ошибка в passportNumber", "123456",
                driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("Ошибка в documentDate", "20.04.2014",
                driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("Ошибка в documentIssue", "Тестовым ОВД тестового города",
                driver.findElement(By.id("documentIssue")).getAttribute("value"));


        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();

        assertEquals("Поле не заполнено.",
                driver.findElement(By.xpath("//span[contains(text(),'Поле не заполнено.')]")).getText());

    }
}
