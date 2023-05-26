package com.atmecs.qa.api;

import com.atmecs.qa.testSuite.PetStoreTestScript;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static constants.FilePathConstants.imagePath;
import static io.restassured.RestAssured.*;

import org.apache.log4j.Logger;

import java.io.File;

public class HTTPMethods {
public Logger logger =Logger.getLogger(PetStoreTestScript.class);
    public static Response postPetImage(String URI,String key,String value,File file){

        return given()
                .multiPart(file).pathParam( key,value)
                .log().all()
                .post(URI);
    }
    public static Response getPetById(String URI){// rename
        return given()
                //.multiPart(file)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .get(URI);
    }
    public static Response getPetByStatus(String URI, String key, String value){
        return given()
                .queryParam(key, value)
                .contentType(ContentType.JSON)
                .log().all().get(URI);
    }


}
