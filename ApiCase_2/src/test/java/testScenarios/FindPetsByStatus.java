package testScenarios;

import framework.Requests;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
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

    @Step("Get available status pets")
    @Description("This test is getting available pets and verify")
    @Test(priority = 0)
    public void verifyGetAvailablePets() {
        Pets[] petsAvailable = requests.getAvailablePets();

        Assert.assertNotNull(petsAvailable, "Pet list is not empty");
        Assert.assertEquals(petsAvailable[0].getStatus(), "available", "Status is correct");
    }

    @Step("Get pending status pets")
    @Description("This test is getting pending pets and verify")
    @Test(priority = 1)
    public void verifyGetPendingPets() {
        Pets[] petsPending = requests.getPendingPets();

        Assert.assertNotNull(petsPending, "Pet list is not empty");
        Assert.assertEquals(petsPending[0].getStatus(), "pending", "Status is correct");
    }


    @Step("Get sold pets status")
    @Description("This test is getting sold pets and verify")
    @Test(priority = 1)
    public void verifyGetSoldPets() {
        Pets[] petsSold = requests.getSoldPets();

        Assert.assertNotNull(petsSold, "Pet list is not empty");
        Assert.assertEquals(petsSold[0].getStatus(), "sold", "Status is correct");
    }
}
