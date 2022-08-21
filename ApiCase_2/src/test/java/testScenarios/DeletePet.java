package testScenarios;

import framework.Requests;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePet {
    Requests requests;

    @BeforeClass
    public void setup() {
        requests = new Requests();
    }

    @Step("Delete pet by id")
    @Description("This test is deleting first pet in sold status and verify")
    @Test
    public void verifyDeletePet(){
        String id = requests.getSoldPets()[0].getId();

        Response response = requests.deletePet(id);

        JsonPath getOrderJson =  response.jsonPath();

        String deletedID = getOrderJson.get("message").toString();

        Assert.assertEquals(getOrderJson.get("code").toString(),"200");

    }
}
