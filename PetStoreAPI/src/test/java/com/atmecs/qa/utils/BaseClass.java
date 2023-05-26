package com.atmecs.qa.utils;

import io.restassured.module.jsv.JsonSchemaValidationException;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;

import static com.atmecs.qa.utils.StatusCodeVerifier.logger;


public class BaseClass {
    public static void validateSchema(Response response, String filePath) {
        try {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(filePath)));
            logger.info("Schema validation is executed successfully");
        } catch (JsonSchemaValidationException jsonSchemaValidationException) {
            logger.error("schema validation is not executed" + jsonSchemaValidationException);
        } catch (Exception exception) { //not required
            logger.error("schema validation is not executed" + exception);
        }

    }
}
