package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//nav[contains(@class,'kitt-top-menu kitt-top-menu_icons kitt-top-menu_wide')]")
    WebElement mainMenu;

    @FindBy(xpath = "//li[contains(@class,'kitt-top-menu__item kitt-top-menu__item_first kitt-top-menu__item_opened')]//div[contains(@class,'kitt-top-menu__dropdown kitt-top-menu__dropdown_icons')]")
    WebElement subMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath(".//a[@aria-label='" + menuItem + "']")).click();
    }

    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath(".//a[contains(text(),'" + menuItem + "')]")).click();
    }


}
