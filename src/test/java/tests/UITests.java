package tests;

import config.Configuration;
import framework.BasePage;
import framework.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class UITests extends BaseTest {
    HomePage objHomePage;
    BasePage objBasePage;

    public void goToHomePage () {
        driver.get(Configuration.getURL());
    }

    @BeforeTest
    public void setupUITest(){
        objHomePage = new HomePage(getDriver());
    }

    @Test
    public void searchClimatizacion() {
        goToHomePage();

        objHomePage.goToCategoriasLink();
        objHomePage.mouseOverHogarYElectrodomesticos();
        objHomePage.goToClimatizacion();
    }
}
