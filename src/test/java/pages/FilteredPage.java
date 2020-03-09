package pages;

import framework.BasePage;
import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilteredPage extends BasePage {

    public FilteredPage(WebDriver driver) {
        super(driver);
    }

    //Generate a random number between 1
    int x = (int) (1 + Math.random() * 50);
    //System.out.println(x);
    String randomProductXpath = "//section[@id='results-section']/ol[@id='searchResults']/li[" + x + "]";
    String randomProductTitleXpath = randomProductXpath + "/div[1]/div[2]/div[1]/h2[1]/a[1]/span[@class='main-title']";
    String randomProductPriceXpath = randomProductXpath + "/div[1]/div[2]/div[1]/div[1]/div[1]/span[@class='price__fraction']";

    By filterTitle = By.xpath("//h1[contains(@class,'breadcrumb__title')]");
    By quantityResults = By.xpath("//div[contains(@class,'quantity-results')]");
    By ubicacionCapitalFederal = By.xpath("//span[contains(@class,'filter-name')][contains(text(),'Capital Federal')]");
    By randomProduct = By.xpath(randomProductXpath);
    By randomProductTitle = By.xpath(randomProductTitleXpath);
    By randomProductPrice = By.xpath(randomProductPriceXpath);

    public String getFilterTitleText () {
        waitVisibility(filterTitle);
        return driver.findElement(filterTitle).getText();
    }

    public String getQuantityResults () {
        waitVisibility(quantityResults);
        return driver.findElement(quantityResults).getText();
    }

    public void filterByUbicacionCapitalFederal () {
        waitVisibility(ubicacionCapitalFederal);
        driver.findElement(ubicacionCapitalFederal).click();
    }

    public void clickOnRandomProduct () {
        waitVisibility(randomProductTitle);
        driver.findElement(randomProductTitle).click();
    }

    public String getRandomProductTitle () {
        waitVisibility(randomProductTitle);
        return driver.findElement(randomProductTitle).getText();
    }

    public String getRandomProductPrice () {
        waitVisibility(randomProductPrice);
        return driver.findElement(randomProductPrice).getText();
    }

}
