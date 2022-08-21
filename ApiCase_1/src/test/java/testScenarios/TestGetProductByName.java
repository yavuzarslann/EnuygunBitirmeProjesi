package testScenarios;

import framework.Requests;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.Root;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestGetProductByName {
    Requests requests;

    @BeforeClass
    public void setup() {
        requests = new Requests();
    }

    @Step("Get product by name")
    @Description("This test is getting a product by name and verify")
    @Test
    public void verifySuccessfulGetProductByName(){
        Response response = requests.getProductByName("apple");
        Root product = response.getBody().as(Root.class);

        Assert.assertEquals(response.getStatusCode(),200,"OK");
        Assert.assertNotNull(product,"Product is not empty");
        Assert.assertEquals(product.getData().get(0).getName(),"apple","Products is correct");
    }

    @Step("Get product by invalid name")
    @Description("This test verifies get product with invalid name")
    @Test
    public void verifyGetProductByInvalidName(){
        Response response = requests.getProductByName("supercar");

        Assert.assertEquals(response.getStatusCode(),404,"Product not found");
    }

    @Step("Get product by name with invalid url")
    @Description("This test verifies get product by name with invalid url")
    @Test
    public void verifyGetProductByInvalidUrl(){
        Response response = requests.getProductByNameInvalidUrl("apple");

        Assert.assertEquals(response.getStatusCode(),400,"Invalid URL");
    }
}
