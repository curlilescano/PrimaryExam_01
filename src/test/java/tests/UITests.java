package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import config.Configuration;
import framework.BasePage;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BellezaPage;
import pages.CategoriasAllPage;
import pages.FilteredPage;
import pages.HomePage;
import pages.ProductDetailsPage;

public class UITests extends BaseTest {
    HomePage objHomePage;
    BasePage objBasePage;
    FilteredPage objFilteredPage;
    BellezaPage objBellezaPage;
    CategoriasAllPage objCategoriasAllPage;
    ProductDetailsPage objProductDetailsPage;

    public void goToHomePage () {
        driver.get(Configuration.getURL());
    }

    @BeforeTest
    public void setupUITest(){
        objHomePage = new HomePage(getDriver());
        objFilteredPage = new FilteredPage(getDriver());
        objBellezaPage = new BellezaPage(getDriver());
        objCategoriasAllPage = new CategoriasAllPage(getDriver());
        objProductDetailsPage = new ProductDetailsPage(getDriver());
    }

    @Test
    public void filterClimatizacion() {
        goToHomePage();
        objHomePage.goToCategoriasLink();
        objHomePage.hoverOverHogarYElec();
        objHomePage.goToClimatizacion();
        Assert.assertEquals(objFilteredPage.getFilterTitleText(),"Climatización");
        Assert.assertTrue(objFilteredPage.getQuantityResults() != null);
    }

    @Test
    public void filterCelulares() {
        goToHomePage();
        objHomePage.goToCategoriasLink();
        objHomePage.hoverOverTecnologia();
        objHomePage.goToCelulares();
        Assert.assertEquals(objFilteredPage.getFilterTitleText(),"Celulares y Smartphones");
        Assert.assertTrue(objFilteredPage.getQuantityResults() != null);
    }

    @Test
    public void filterPerfumes() {
        goToHomePage();
        objHomePage.goToCategoriasLink();
        objHomePage.clickOnBelleza();
        objBellezaPage.clickOnPerfumesLink();
        Assert.assertEquals(objFilteredPage.getFilterTitleText(),"Perfumes Nuevo");
        Assert.assertTrue(objFilteredPage.getQuantityResults() != null);
    }

    @Test
    public void filterIndustriaTextil() {
        goToHomePage();
        objHomePage.goToCategoriasLink();
        objHomePage.clickOnVerMasCategorias();
        objCategoriasAllPage.clickOnIndustriaTextil();
        Assert.assertEquals(objFilteredPage.getFilterTitleText(),"Industria Textil");
        Assert.assertTrue(objFilteredPage.getQuantityResults() != null);
    }

    @Test
    public void filterCuartoDelBebe() {
        goToHomePage();
        objHomePage.goToCategoriasLink();
        objHomePage.hoverOverJuguetesYBebes();
        objHomePage.goToCuartoDelBebe();
        Assert.assertEquals(objFilteredPage.getFilterTitleText(),"Cuarto del Bebé");
        Assert.assertTrue(objFilteredPage.getQuantityResults() != null);
    }

    @Test (priority = 6)
    public void compareProductDetails () {
        goToHomePage();
        objHomePage.goToCategoriasLink();
        objHomePage.hoverOverJuguetesYBebes();
        objHomePage.goToCuartoDelBebe();
        objFilteredPage.filterByUbicacionCapitalFederal();
        String productTitle = objFilteredPage.getRandomProductTitle();
        String productPrice = objFilteredPage.getRandomProductPrice();
        objFilteredPage.clickOnRandomProduct();
        Assert.assertEquals(productTitle,objProductDetailsPage.getProductDetailsTitle());
        Assert.assertEquals(productPrice,objProductDetailsPage.getProductDetailsPrice());
    }

}
