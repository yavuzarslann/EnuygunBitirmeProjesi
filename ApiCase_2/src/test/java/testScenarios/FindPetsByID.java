package testScenarios;

import framework.Requests;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import model.Pets;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindPetsByID {
    Requests requests;

    @BeforeClass
    public void setup() {
        requests = new Requests();
    }

    @Step("Get pet by id")
    @Description("This test is getting the third pet from available pets and verify")
    @Test
    public void verifyGetPetById(){
        String id = requests.getAvailablePets()[2].getId();

        Pets[] petsAvailable = requests.getAvailablePets();

        Pets pet = requests.getPetById(id).getBody().as(Pets.class);

        System.out.println(petsAvailable[2]);
        System.out.println(pet);

        Assert.assertNotNull(pet);
        Assert.assertEquals(petsAvailable[2],pet);

    }
}
