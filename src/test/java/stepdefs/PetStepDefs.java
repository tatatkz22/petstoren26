package stepdefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import page.PetPage;
import org.junit.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class PetStepDefs {
    private static final Logger logger = LogManager.getLogger(PetStepDefs.class);
    private PetPage petPage = new PetPage();
    private Response response;
    private long createdPetId;

    @Given("I add a new pet")
    public void i_add_a_new_pet() {
        String body = "{ \"id\": 123456789, \"name\": \"Fluffy\", \"status\": \"available\" }";
        
      
        logger.info("Adding a new pet with body: {}", body);
        ExtentCucumberAdapter.addTestStepLog("REQUEST (Add Pet):\n" + body);
        
        response = petPage.addPet(body);
        createdPetId = response.jsonPath().getLong("id");
        
      
        logger.debug("Response: {}", response.asString());
        ExtentCucumberAdapter.addTestStepLog("RESPONSE (Add Pet):\n" + 
            "Status: " + response.getStatusCode() + "\n" +
            "Body: " + response.asPrettyString());
        
        Assert.assertEquals(200, response.getStatusCode());
    }

    @When("I fetch the pet by ID")
    public void i_fetch_the_pet_by_id() {
        logger.info("Fetching pet by ID: {}", createdPetId);
        ExtentCucumberAdapter.addTestStepLog("REQUEST (Get Pet):\nGET /pet/" + createdPetId);
        
        response = petPage.getPetById(createdPetId);
        
        logger.debug("Fetch response: {}", response.asString());
        ExtentCucumberAdapter.addTestStepLog("RESPONSE (Get Pet):\n" +
            "Status: " + response.getStatusCode() + "\n" +
            "Body: " + response.asPrettyString());
    }

    @Then("The pet details should be returned")
    public void the_pet_details_should_be_returned() {
        String petName = response.jsonPath().getString("name");
        
       
        ExtentCucumberAdapter.addTestStepLog("ASSERTION:\n" +
            "Expected: Fluffy\n" +
            "Actual: " + petName);
            
        Assert.assertEquals("Fluffy", petName);
    }

    @When("I delete the pet")
    public void i_delete_the_pet() {
        logger.info("Deleting pet with ID: {}", createdPetId);
        ExtentCucumberAdapter.addTestStepLog("REQUEST (Delete Pet):\nDELETE /pet/" + createdPetId);
        
        response = petPage.deletePet(createdPetId);
        
        logger.debug("Delete response: {}", response.asString());
        ExtentCucumberAdapter.addTestStepLog("RESPONSE (Delete Pet):\n" +
            "Status: " + response.getStatusCode() + "\n" +
            "Body: " + response.asPrettyString());
    }

    @Then("The pet should be deleted")
    public void the_pet_should_be_deleted() {
        ExtentCucumberAdapter.addTestStepLog("VERIFY DELETION:\n" +
            "Expected Status: 200\n" +
            "Actual Status: " + response.getStatusCode());
            
        Assert.assertEquals(200, response.getStatusCode());
    }
}