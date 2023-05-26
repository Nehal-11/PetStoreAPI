package com.atmecs.qa.dto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test
public class TestBuildDTO {
    public void testdto() throws JsonProcessingException {

String[] pets = {"Dog", "Cat"};
        for (String pet : pets){

        }
//Pets[] petPayload =new Pets[pets.length];
//        for (int index = 0; index <pets.length ; index++) {
//petPayload[index] = Pets.builder().dog("dog").cat("cat").build();
//        }
        Address addressPayload = Address.builder().permanentAddress("USA").currentAddress("AU").build();
        TestBuild buildData = TestBuild.builder().name("Test").mobile("12345678").Boolean(true).address(addressPayload).pets(Arrays.asList(pets)).build();
        ObjectMapper mapper =new ObjectMapper();
String finalData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(buildData);
System.out.println("final test data: " +finalData);
    }
}
