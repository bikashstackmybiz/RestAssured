package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetWishlistWithAuth {

    @Test
    public void addCart(){
        RestAssured.baseURI =("https://qa-api.top-doc.com");
        RequestSpecification request = RestAssured.given();
//	        JSONObject requestParams = new J
        String str = "{\r\n"
                + "    \"phone\": 7507378068,\r\n"
                + "    \"loginType\": \"DIRECT\",\r\n"
                + "    \"password\": \"pass1234\",\r\n"
                + "    \"email\": \"\",\r\n"
                + "    \"userRole\": \"LEARNER\"\r\n"
                + "}";

        request.body(str);

        request.contentType(ContentType.JSON);

        Response a = request.given().post("/userservice/api/v1/login");

        System.out.println(a.getStatusCode());

        String token = a.getBody().jsonPath().get("data.token");
        System.out.println(token);
        RequestSpecification request1 = RestAssured.given();
        request1.header("Authorization",token);

        Response b = request1.given().get("/ecommerceservice/api/v1/wishlist");

        System.out.println(b.getStatusCode());


        System.out.println(""+b.getBody().jsonPath().get("message"));



    }

}
