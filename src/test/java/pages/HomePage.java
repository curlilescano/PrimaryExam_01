package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

//    By categoriasLink = By.className("nav-menu-categories-link");
    By categoriasLink = By.linkText("Categorías");
    By hogarYElectrodomesticos = By.linkText("Hogar y Electrodomésticos");
    By climatizacion = By.linkText("Climatización");
    By tecnologia = By.linkText("Tecnología");
    By celulares = By.linkText("Celulares y Smartphones");
    By belleza = By.linkText("Belleza y Cuidado Personal");
    By verMasCategorias = By.linkText("Ver más categorías");
    By juguetes = By.linkText("Juguetes y Bebés");
    By cuarto = By.linkText("Cuarto del Bebé");



    Actions act = new Actions(driver);

    public void goToCategoriasLink () {
        waitVisibility(categoriasLink);
        act.moveToElement(driver.findElement(categoriasLink)).perform();
    }

    public void hoverOverHogarYElec () {
        waitVisibility(hogarYElectrodomesticos);
        act.moveToElement(driver.findElement(hogarYElectrodomesticos)).perform();
    }

    public void goToClimatizacion () {
        waitVisibility(climatizacion);
        driver.findElement(climatizacion).click();
    }

    public void hoverOverTecnologia () {
        waitVisibility(tecnologia);
        act.moveToElement(driver.findElement(tecnologia)).perform();
    }

    public void goToCelulares () {
        waitVisibility(celulares);
        driver.findElement(celulares).click();
    }

    public void clickOnBelleza () {
        waitVisibility(belleza);
        driver.findElement(belleza).click();
    }
    public void clickOnVerMasCategorias() {
        waitVisibility(verMasCategorias);
        driver.findElement(verMasCategorias).click();
    }

    public void hoverOverJuguetesYBebes () {
        waitVisibility(juguetes);
        act.moveToElement(driver.findElement(juguetes)).perform();
    }

    public void goToCuartoDelBebe () {
        waitVisibility(cuarto);
        driver.findElement(cuarto).click();
    }


}
