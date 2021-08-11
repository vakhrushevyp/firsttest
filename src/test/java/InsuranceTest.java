import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;




public class InsuranceTest {
    WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        String baseUrl = "https://www.rgs.ru/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void testInsurance(){
    driver.findElement(By.xpath("//a[@class='hidden-xs'][contains(text(),'Меню')]")).click();
    driver.findElement(By.xpath("//a[@class='hidden-xs'][contains(text(),'Здоровье')]")).click();
    driver.findElement(By.xpath("//a[contains(text(),'Добровольное медицинское страхование (ДМС)')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 30,1000);
        WebElement sentBtn = driver.findElement(By.xpath("//a[contains(text(),'Отправить заявку')]"));
        wait.until(ExpectedConditions.visibilityOf(sentBtn)).click();
        WebElement title = driver.findElement(By.xpath("//b[@data-bind='text: options.title']"));
        wait.until(ExpectedConditions.visibilityOf(title)).click();

        assertEquals( "Проверка заголовка","Заявка на добровольное медицинское страхование", title.getText());

        fillField(By.name("LastName"), "Иванов") ;
        fillField(By.name("FirstName"), "Иван") ;
        fillField(By.name("MiddleName"), "Иванович") ;

        new Select(driver.findElement(By.xpath("//select[@name='Region']"))).selectByVisibleText("Москва");

        fillField(By.name("Comment"),"Autotest");
        fillField(By.name("Email"),"1234567");

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Отправить')]")).click();

        WebElement validationErrorText = driver.findElement(By.xpath("//*[text()='Эл. почта']/..//span[@class='validation-error-text']"));
        wait.until(ExpectedConditions.visibilityOf(validationErrorText));

        assertEquals("Введите адрес электронной почты",
                driver.findElement(By.xpath("//*[text()='Эл. почта']/..//span[@class='validation-error-text']")).getText());


        assertEquals( "Ошибка почта","Иванов",
                driver.findElement(By.name("LastName")).getAttribute("value"));
        assertEquals( "Ошибка почта","Иван",
                driver.findElement(By.name("FirstName")).getAttribute("value"));
        assertEquals( "Ошибка почта","Иванович",
                driver.findElement(By.name("MiddleName")).getAttribute("value"));




    }

    public void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);

    }


    @After
    public void afterTest(){
        driver.quit();
    }

}
