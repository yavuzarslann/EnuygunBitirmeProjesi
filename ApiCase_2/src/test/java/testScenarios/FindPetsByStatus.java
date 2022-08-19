package testScenarios;

import framework.Requests;
import model.Pets;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindPetsByStatus {
    Requests requests;

    @BeforeClass
    public void setup() {
        requests = new Requests();
    }

    @Test(priority = 0)
    public void verifyGetAvailablePets() {
        Pets[] petsAvailable = requests.getAvailablePets();

        Assert.assertNotNull(petsAvailable, "Pet list is not empty");
        Assert.assertEquals(petsAvailable[0].getStatus(), "available", "Status is correct");
    }

    @Test(priority = 1)
    public void verifyGetPendingPets() {
        Pets[] petsPending = requests.getPendingPets();

        Assert.assertNotNull(petsPending, "Pet list is not empty");
        Assert.assertEquals(petsPending[0].getStatus(), "pending", "Status is correct");
    }

    @Test(priority = 1)
    public void verifyGetSoldPets() {
        Pets[] petsSold = requests.getSoldPets();

        Assert.assertNotNull(petsSold, "Pet list is not empty");
        Assert.assertEquals(petsSold[0].getStatus(), "sold", "Status is correct");
    }
}
