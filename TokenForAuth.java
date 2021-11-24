package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;


public class TokenForAuth {
    @BeforeTest
    public Object getToken(){
        RestAssured.baseURI = ("https://qa-api.top-doc.com");
        RequestSpecification request = RestAssured.given();
        JSONObject loginCred = new JSONObject();
        loginCred.put("email","");
        loginCred.put("loginType","DIRECT");
        loginCred.put("password","pass1234");
        loginCred.put("phone","7507378068");
        loginCred.put("userRole","LEARNER");
        request.header("Content-Type", "application/json");
        request.body(loginCred.toString());
        Response response = request.post("/userservice/api/v1/login");
        String tokenGenrated = response.getBody().jsonPath().get("data.token");
        return tokenGenrated;
    }

}
