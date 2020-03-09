package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

//    By productTitle = By.xpath("//div[@class='ui-pdp']//h1[@class='ui-pdp-title']");
    By productTitle = By.xpath("//h1[contains(@class,'item-title__primary')]");
    By productPrice = By.xpath("//fieldset[contains(@class,'item-price')]/span[contains(@class,'price-tag')]/span[contains(@class,'price-tag-fraction')]");

    public String getProductDetailsTitle () {
        waitVisibility(productTitle);
        return driver.findElement(productTitle).getText();
    }
    public String getProductDetailsPrice () {
        waitVisibility(productPrice);
        return driver.findElement(productPrice).getText();
    }
}
