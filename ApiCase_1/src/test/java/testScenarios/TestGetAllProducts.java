package testScenarios;

import framework.Requests;
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

    @Test
    public void verifyGetAllProducts(){
        Response response = requests.getAllProducts();
        Root allProducts = response.getBody().as(Root.class);

        Assert.assertEquals(response.getStatusCode(),200,"OK");
        Assert.assertNotNull(allProducts,"Products is not empty");

    }

}
