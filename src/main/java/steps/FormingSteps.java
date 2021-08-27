package steps;

import pages.FormingPage;
import io.qameta.allure.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class FormingSteps extends BaseSteps {

    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new FormingPage(driver).fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new FormingPage(driver).getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("заполняются поля")
    public void stepFillFields(HashMap<String, String> fields){
        fields.forEach(this::stepFillField);
    }

    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach((k, v)-> checkFillField(k,v));
    }
    @Step("Нажатие кнопки Продолжить")
    public void stepProceedButton(){
        new FormingPage(driver).proceed.click();
    }

    @Step("Отображение ошибки в контактных данных")
    public void stepContactsAssert (){
        new FormingPage(driver).contactsAssert("Поле не заполнено.");
    }

}
