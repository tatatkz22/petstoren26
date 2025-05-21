package page;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import config.ConfigManager;
import io.restassured.RestAssured;

public class PetPage {

     public PetPage() {
        // Set the base URI from config file
        RestAssured.baseURI = ConfigManager.getInstance().getBaseUrl();
        System.out.println("Base URI set in PetPage: " + RestAssured.baseURI);
    }
    
    public Response addPet(String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/pet");
    }

    public Response getPetById(long petId) {
        return given()
                .pathParam("petId", petId)
                .when()
                .get("/pet/{petId}");
    }

    public Response deletePet(long petId) {
        return given()
                .pathParam("petId", petId)
                .when()
                .delete("/pet/{petId}");
    }
}
