package testScenarios;

import com.fasterxml.jackson.core.JsonProcessingException;
import framework.Requests;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.Root;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddProduct {
    Requests requests;

    @BeforeClass
    public void setup() {
        requests = new Requests();
    }

    @Step("Add product to store")
    @Description("This test is adding product to market with posting parameter and verify")
    @Test
    public void verifySuccessfulAddProduct() throws JsonProcessingException {
        Response response = requests.addProduct();

        Response responseByName = requests.getProductByName("banana");
        Root productByName = responseByName.getBody().as(Root.class);

        Assert.assertEquals(response.getStatusCode(),200,"OK");
        Assert.assertEquals(productByName.getData().get(0).getName(),"apple","Products is correct");

    }

    @Step("Add product with invalid body")
    @Description("This test verifies invalid adding product with empty body")
    @Test
    public void verifyInvalidAddProduct(){
        Response response = requests.addProductInvalid();

        Assert.assertEquals(response.getStatusCode(),400,"Invalid product");
    }

}
