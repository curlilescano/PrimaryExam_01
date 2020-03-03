package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

//    By categoriasLink = By.className("nav-menu-categories-link");
    By categoriasLink = By.linkText("Categorías");
    By hogarYElectrodomesticos = By.linkText("Hogar y Electrodomésticos");
    By climatizacion = By.linkText("Climatización");

    public void goToCategoriasLink () {
        //waitVisibility(categoriasLink);
        driver.findElement(categoriasLink).click();
    }
    public void mouseOverHogarYElectrodomesticos() {
        driver.findElement(hogarYElectrodomesticos).click();
    }
    public void goToClimatizacion () {
        driver.findElement(climatizacion).click();
    }

}
