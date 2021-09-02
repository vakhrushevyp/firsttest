package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class FormingPage {



    @FindBy(xpath = "//div[@class='col-4 step-element active']")
    WebElement title2CheckoutPage;

    @FindBy(id = "surname_vzr_ins_0")
    public WebElement surname_vzr_ins_0;

    @FindBy(id = "name_vzr_ins_0")
    public WebElement name_vzr_ins_0;

    @FindBy(id = "birthDate_vzr_ins_0")
    public WebElement birthDate_vzr_ins_0;

    @FindBy(xpath = "//form-control-label[@title='Гражданство']//div[@class='form-group form-group_label-fill']")
    public WebElement citizenship;

    @FindBy(id = "person_lastName")
    public WebElement person_lastName;

    @FindBy(id = "person_firstName")
    public WebElement person_firstName;

    @FindBy(id = "person_middleName")
    public WebElement person_middleName;

    @FindBy(id = "person_birthDate")
    public WebElement person_birthDate;

    @FindBy(id = "passportSeries")
    public WebElement passportSeries;

    @FindBy(id = "passportNumber")
    public WebElement passportNumber;

    @FindBy(id = "documentDate")
    public WebElement documentDate;

    @FindBy(id = "documentIssue")
    public WebElement documentIssue;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    public WebElement proceed;

    @FindBy(xpath = "//body//app//fieldset[4]")
    public WebElement contacts;

    public FormingPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        new WebDriverWait(BaseSteps.getDriver(), 30, 1000).until(ExpectedConditions.visibilityOf(title2CheckoutPage));
    }


    public void fillField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }


    public String contactsAssert(String contactsAssertText) {
        return contacts.findElement(By.xpath("//span[contains(text(),'" + contactsAssertText + "')]")).getText();

    }


    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия латиницей":
                fillField(surname_vzr_ins_0, value);
                break;
            case "Имя латиницей":
                fillField(name_vzr_ins_0, value);
                break;
            case "Дата рождения загран":
                fillField(birthDate_vzr_ins_0, value);
                break;
            case "Фамилия":
                fillField(person_lastName, value);
                break;
            case "Имя":
                fillField(person_firstName, value);
                break;
            case "Отчество":
                fillField(person_middleName, value);
                break;
            case "Дата рождения":
                fillField(person_birthDate, value);
                break;
            case "Паспорт серия":
                fillField(passportSeries, value);
                break;
            case "Паспорт номер":
                fillField(passportNumber, value);
                break;
            case "Паспорт дата":
                fillField(documentDate, value);
                break;
            case "Паспорт выдан":
                fillField(documentIssue, value);
                break;
            default:
                throw new AssertionError("Поле " + fieldName + "не объявлено на странице");

        }

    }

    public String  getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия латиницей":
                return surname_vzr_ins_0.getAttribute("value");
            case "Имя латиницей":
                return name_vzr_ins_0.getAttribute("value");
            case "Дата рождения загран":
                return birthDate_vzr_ins_0.getAttribute("value");
            case "Фамилия":
                return person_lastName.getAttribute("value");
            case "Имя":
                return person_firstName.getAttribute("value");
            case "Отчество":
                return person_middleName.getAttribute("value");
            case "Дата рождения":
                return person_birthDate.getAttribute("value");
            case "Паспорт серия":
                return passportSeries.getAttribute("value");
            case "Паспорт номер":
                return passportNumber.getAttribute("value");
            case "Паспорт дата":
                return documentDate.getAttribute("value");
            case "Паспорт выдан":
                return documentIssue.getAttribute("value");

        }
        throw new AssertionError("Поле не объявлено на странице");

    }
}
