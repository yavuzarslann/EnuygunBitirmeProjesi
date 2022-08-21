package testScenarios;

import framework.Requests;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.Root;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestGetAllProducts {
    Requests requests;

    @BeforeClass
    public void setup() {
        requests = new Requests();
    }

    @Step("Get all product")
    @Description("This test is getting all products in market and verify")
    @Test
    public void verifySuccessfulGetAllProducts(){
        Response response = requests.getAllProducts();
        Root allProducts = response.getBody().as(Root.class);

        Assert.assertEquals(response.getStatusCode(),200,"OK");
        Assert.assertNotNull(allProducts,"Products is not empty");

    }

}
