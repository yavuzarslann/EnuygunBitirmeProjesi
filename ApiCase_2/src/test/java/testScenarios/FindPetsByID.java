package testScenarios;

import framework.Requests;
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
