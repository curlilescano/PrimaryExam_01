package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriasAllPage extends BasePage {

    public CategoriasAllPage(WebDriver driver) {
        super(driver);
    }

    By industriaTextil = By.linkText("Industria Textil");

    public void clickOnIndustriaTextil () {
        driver.findElement(industriaTextil).click();
    }
}
