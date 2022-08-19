package framework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Pets;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class Requests {
    Response response;
    private static final String BASE_URL = ConfigManager.initialize_Properties().get("base_url").toString();

    public Requests() {
        RestAssured.baseURI = BASE_URL;
    }

    public Response getPetsByStatus(String status) {
        this.response = given()
                .header("Content-Type", "application/json")
                .get(status)
                .then()
                .statusCode(200)
                .extract().response();
        return response;
    }

    public Pets[] getAvailablePets() {
        Response response = getPetsByStatus(Endpoints.FIND_PETS_BY_STATUS_AVAILABLE);

        Pets[] pets = response.getBody().as(Pets[].class);

        return pets;
    }

    public Pets[] getPendingPets() {
        Response response = getPetsByStatus(Endpoints.FIND_PETS_BY_STATUS_PENDING);

        Pets[] pets = response.getBody().as(Pets[].class);

        return pets;
    }

    public Pets[] getSoldPets() {
        Response response = getPetsByStatus(Endpoints.FIND_PETS_BY_STATUS_SOLD);

        Pets[] pets = response.getBody().as(Pets[].class);

        return pets;
    }

    public Response getPetById(String id) {

        this.response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", id)
                .get(Endpoints.FIND_PET_BY_ID)
                .then()
                .statusCode(200)
                .extract().response();

        return response;
    }

    public Response updatePetInStore() {
        String id = getAvailablePets()[2].getId();

        Pets pet = new Pets();
        pet.setId(id);
        pet.setName("Ahmet");
        pet.setStatus("sold");

        response = given()
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .pathParam("id",pet.getId())
                .formParam("id",pet.getId())
                .formParam("name",pet.getName())
                .formParam("status",pet.getStatus())
                .when()
                .post(Endpoints.UPDATE_PET_IN_THE_STORE)
                .then()
                .statusCode(200)
                .extract().response();

        return response;
    }

    public Response deletePet(String id){

        this.response = given()
                .pathParam("id",id)
                .when()
                .delete(Endpoints.DELETE_A_PET)
                .then()
                .statusCode(200)
                .extract().response();

        return response;
    }
}
