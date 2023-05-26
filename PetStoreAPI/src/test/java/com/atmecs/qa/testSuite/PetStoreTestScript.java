package com.atmecs.qa.testSuite;

import com.atmecs.qa.api.HTTPMethods;
import com.atmecs.qa.utils.BaseClass;
import com.atmecs.qa.utils.Endpoints;
import com.atmecs.qa.utils.StatusCode;
import com.atmecs.qa.utils.StatusCodeVerifier;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.atmecs.qa.api.HTTPMethods.getPetById;
import static com.atmecs.qa.api.HTTPMethods.getPetByStatus;
import static com.atmecs.qa.utils.Endpoints.getByIdEndPoint;
import static com.atmecs.qa.utils.Endpoints.getByStatusEndPoint;
import static constants.Constants.*;
import static constants.FilePathConstants.*;

public class PetStoreTestScript {
    Response response;
    public static Logger logger = Logger.getLogger(PetStoreTestScript.class);
    HTTPMethods httpMethods = new HTTPMethods();
    Endpoints endPoints = new Endpoints();
    BaseClass base = new BaseClass();

    @Test(groups = {"end-to-end","POST"}, priority = 1)
    public void postPetImage(){
        try{
            response = httpMethods.postPetImage(endPoints.postendPoint,"petId",PET_ID, file);

         String value=response.getBody().jsonPath().getString("message");
            System.out.println("Image uploaded: "+value.contains("dog2.jpg"));
           logger.info(response.getStatusCode());
          logger.info(response.asPrettyString());
          logger.info(response.body());
            base.validateSchema(response, postjsonPath);
           Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getStatusCode());
           StatusCodeVerifier.verifySuccessStatusCode(response.statusCode());
        }catch(Exception exception){
            logger.info("Exception occurred: " +exception);
        }
    }

@Test(groups = {"end-to-end","GET"}, priority = 2)
    public void getPetStoreById() {
        try {
            System.setProperty("{id}",PET_ID);
            getByIdEndPoint = getByIdEndPoint + System.getProperty("{id}");
             response = getPetById(getByIdEndPoint);
             logger.info(response.asPrettyString());
            // base.validateSchema(response,getIdjsonPath);
            StatusCodeVerifier.verifySuccessStatusCode(response.statusCode());
            Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getStatusCode());
        } catch (Exception exception) {
            logger.info("Exception occurred: " + exception);
        }
    }
    @Test(groups = {"end-to-end","GET"}, priority = 3)
    public void getPetStoreByStatus() {
        try {
            response = getPetByStatus(getByStatusEndPoint,QUERY_PARAMS_KEY, QUERY_PARAMS_VALUE);
            logger.info(response.asPrettyString());
            logger.info(response.body());
            logger.info(response.getStatusCode());
           logger.info(response.headers());
           //base.validateSchema(response, pendingStatusjsonPath);
            StatusCodeVerifier.verifySuccessStatusCode(response.statusCode());
            Assert.assertEquals(response.getStatusCode(), StatusCode.OK.getStatusCode());
        } catch (Exception exception) {
            logger.info("Exception occurred: " + exception);
        }
    }
}
