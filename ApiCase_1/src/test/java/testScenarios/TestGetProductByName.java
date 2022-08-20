package testScenarios;

import framework.Requests;
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

    @Test
    public void verifyGetProductByName(){
        Response response = requests.getProductByName("apple");
        Root product = response.getBody().as(Root.class);

        Assert.assertEquals(response.getStatusCode(),200,"OK");
        Assert.assertNotNull(product,"Product is not empty");
        Assert.assertEquals(product.getData().get(0).getName(),"apple","Products is correct");
    }
}
