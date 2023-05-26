package com.atmecs.qa.utils;

public class Endpoints {
    static FileReader fileReader = new FileReader();

    public static String BaseURL() {
        return fileReader.getAttribute("BaseURL"); //BaseURL
    }
    //public static String BaseURL  = "https://petstore.swagger.io";
    public static String postendPoint = BaseURL() + "/v2/pet/{petId}/uploadImage"; //post upload pet image

    public static String getByIdEndPoint = BaseURL() + "/v2/pet/"; //get pet by id

    public static String getByStatusEndPoint = BaseURL() + "/v2/pet/findByStatus"; //get pet by status(sold or pending)

    public static void main(String[] args) {
        System.out.println(getByIdEndPoint);
    }
}


