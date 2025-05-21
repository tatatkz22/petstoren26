package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigManager {

    private static final Logger logger = LogManager.getLogger(ConfigManager.class);

    private static ConfigManager config;
    private final String BASE_URL = "https://petstore.swagger.io/v2/";

    private ConfigManager() {
        logger.info("ConfigManager initialized.");
    }

    public static ConfigManager getInstance() {
        if (config == null) {
            config = new ConfigManager();
            logger.debug("Created new ConfigManager instance.");
        }
        return config;
    }

    public String getBaseUrl() {
        logger.info("Returning Base URL: {}", BASE_URL);
        return BASE_URL;
    }
}
