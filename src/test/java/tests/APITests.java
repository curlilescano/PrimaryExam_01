package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITests {

    String searchFor = "teclado";
    int pagingLimit = 50;
    private Response res;
    private JsonPath jp;
    private String randomID;
    private String titleFromSearch;
    private String titleFromProduct;
    private String priceFromSearch;
    private String priceFromProduct;
    private String acceptsMPSearch;
    private String acceptsMPProduct;
    private String currencySearch;
    private String currencyProduct;
    private String freeShippingSearch;
    private String freeShippingProduct;


    @Test(priority = 1)
    public void mlSearch() {
        //Response res =
        given()
                .contentType(ContentType.JSON)
                .baseUri("https://api.mercadolibre.com/")
                .basePath("sites/MLA/search")
                .queryParam("q", searchFor)
                .when()
                .get("/")
                .then()
                .statusCode(200)
                .body("paging.total", greaterThanOrEqualTo(85000))
                .body("paging.limit", equalTo(pagingLimit))
                .body("results.id.size()", lessThanOrEqualTo(pagingLimit));
    }

    @Test(priority = 2)
    public void mlSearchTwo () {
        Response res =
                given()
                        .contentType(ContentType.JSON)
                        .baseUri("https://api.mercadolibre.com/")
                        .basePath("sites/MLA/search")
                        .queryParam("q", searchFor)
                        .when()
                        .get("/");
        String json = res.asString();
        JsonPath jp = new JsonPath(json);
        List<String> searchIDs = jp.get("results.id");
//        System.out.println(getRandomElement(searchIDs));
        randomID = getRandomElement(searchIDs);
        titleFromSearch = jp.param("randomID", randomID).get("results.findAll { it.id==randomID}.title").toString();
//        System.out.println(titleFromSearch);
        priceFromSearch = jp.param("randomID", randomID).get("results.findAll { it.id==randomID}.price").toString();
        acceptsMPSearch = jp.param("randomID", randomID).get("results.findAll { it.id==randomID}.accepts_mercadopago").toString();
        currencySearch = jp.param("randomID", randomID).get("results.findAll { it.id==randomID}.currency_id").toString();
        freeShippingSearch = jp.param("randomID", randomID).get("results.findAll { it.id==randomID}.shipping.free_shipping").toString();
    }

    @Test (priority = 3)
    public void mlSearchThree() {

        Response res =
            given()
                .contentType(ContentType.JSON)
                .baseUri("https://api.mercadolibre.com/")
                .basePath("items")
//                .pathParam("product id", randomID)
            .when()
                 .get("/"+randomID);
        String json = res.asString();
        JsonPath jp = new JsonPath(json);
        titleFromProduct = "[" + jp.get("title") +"]";
        Assert.assertEquals(titleFromProduct,titleFromSearch);
        priceFromProduct = "[" + jp.get("price") +"]";
        Assert.assertEquals(priceFromProduct,priceFromSearch);
        acceptsMPProduct = "[" + jp.get("accepts_mercadopago") +"]";
        Assert.assertEquals(acceptsMPProduct,acceptsMPSearch);
        currencyProduct = "[" + jp.get("currency_id") +"]";
        Assert.assertEquals(currencySearch,currencyProduct);
        freeShippingProduct = "[" + jp.get("shipping.free_shipping") +"]";
        Assert.assertEquals(freeShippingProduct,freeShippingSearch);



    }

    public String getRandomElement (List<String> searchIDs) {
        Random rand = new Random();
        return searchIDs.get(rand.nextInt(searchIDs.size()));
    }


}