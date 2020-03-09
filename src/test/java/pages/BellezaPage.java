package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BellezaPage extends BasePage {
    public BellezaPage(WebDriver driver) {
        super(driver);
    }

    By perfumesLink = By.xpath("//h3[contains(text(),'FRAGANCIAS')]");

    public void clickOnPerfumesLink () {driver.findElement(perfumesLink).click();}

}
