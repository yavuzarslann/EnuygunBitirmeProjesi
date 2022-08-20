package framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Product;
import model.Root;

import static io.restassured.RestAssured.given;

public class Requests {
    Response response;
    private static final String BASE_URL = ConfigManager.initialize_Properties().get("base_url").toString();

    public Requests() {
        RestAssured.baseURI = BASE_URL;
    }

    public Response getAllProducts() {
        this.response = given()
                .header("Content-Type", "application/json")
                .get(Endpoints.GET_ALL_PRODUCTS)
                .then()
                .statusCode(200)
                .extract().response();
        return response;
    }

    public Response getProductByName(String name){
        this.response = given()
                .header("Content-Type", "application/json")
                .pathParam("name", name)
                .get(Endpoints.GET_PRODUCT_BY_NAME)
                .then()
                .statusCode(200)
                .extract().response();
        return response;
    }

    public Response addProduct() throws JsonProcessingException {
        Product product = new Product();
        product.setName("banana");
        product.setPrice(23);
        product.setStock(50);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(product);

        response = given()
                .header("Content-Type", "application/json")
                .body(jsonString)
                .when()
                .post(Endpoints.ADD_PRODUCT)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();
        return response;
    }

}
