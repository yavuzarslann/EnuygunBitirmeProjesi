package testScenarios;

import framework.Requests;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.Pets;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdatePetInStore {
    Requests requests;

    @BeforeClass
    public void setup() {
        requests = new Requests();
    }

    @Step("Update a pet in the store with form data")
    @Description("This test is updating a pet posting parameters and verify")
    @Test
    public void verifyUpdatePetInStore() {
        Response response = requests.updatePetInStore();

        //to get id of updated pet
        JsonPath getOrderJson =  response.jsonPath();
        String id = getOrderJson.get("message").toString();

        Pets pet = requests.getPetById(id).getBody().as(Pets.class);

        Assert.assertEquals(getOrderJson.get("code").toString(),"200");
        Assert.assertEquals(pet.getName(),"Ahmet");

    }
}
