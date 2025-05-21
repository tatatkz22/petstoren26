package base;

import config.ConfigManager;
import io.cucumber.java.Before;
import io.restassured.RestAssured;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class TestBase {

    private static final Logger logger = LogManager.getLogger(TestBase.class);

    @Before
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = ConfigManager.getInstance().getBaseUrl();

        logger.info("Base URI set to: {}", RestAssured.baseURI);
    }
}
