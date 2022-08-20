package testScenarios;

import com.fasterxml.jackson.core.JsonProcessingException;
import framework.Requests;
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

    @Test
    public void verifyAddProduct() throws JsonProcessingException {
        Response response = requests.addProduct();

        Response responseByName = requests.getProductByName("banana");
        Root productByName = responseByName.getBody().as(Root.class);

        Assert.assertEquals(response.getStatusCode(),200,"OK");
        Assert.assertEquals(productByName.getData().get(0).getName(),"apple","Products is correct");

    }

}
